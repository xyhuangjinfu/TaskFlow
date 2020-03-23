package cn.hjf.taskflow.execute;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.hjf.taskflow.core.Task;
import cn.hjf.taskflow.core.TaskCreator;
import cn.hjf.taskflow.graph.GraphVisitor;

/**
 * 执行Task的对象，被放到线程池中执行。
 * <p>
 * 每个TaskRunnable应该只被放进执行队列一次，除非任务被取消。
 */
class TaskRunnable implements Runnable {

    private final Task mTask;
    private final Session mSession;
    private Map<Long, Object> mParamMap = new HashMap<>();
    private Object[] mParams;

    public TaskRunnable(Session session, Task task) {
        mTask = task;
        mSession = session;
    }

    /**
     * 父节点执行完成后，向子节点添加自己的执行结果，以便子节点后续执行。
     *
     * @param preTaskId
     * @param param
     * @return 当该task所有参数齐了，返回true，否则返回false
     */
    private synchronized boolean addParam(long preTaskId, Object param) {
        mParamMap.put(preTaskId, param);
        return mParamMap.size() == mTask.getPreList().size();
    }

    /**
     * set all params together, when params is not null, {@link TaskRunnable#addParam(long, Object)} will not work.
     *
     * @param params
     */
    public synchronized void setParams(Object[] params) {
        mParams = params;
    }

    @Override
    public void run() {
        internalRun();
    }

    /**
     * ***************************************************************************************************************
     * //
     * ***************************************************************************************************************
     */

    private void internalRun() {
        final boolean isEndTask = isEndTask();

        if (mSession.isCanceled()) {
            TaskRunnablePool.remove(mSession);
            return;
        }

        try {
            Object result = runTask();
            if (isEndTask) {
                mSession.onFinish(result, null);
            }
        } catch (Exception e) {
            mSession.onFinish(null, e);
        }
    }

    private Object runTask() throws Exception {
        //prepare params, order sensitive
        if (mParams == null) {
            List<Task> preTaskList = mTask.getPreList();
            mParams = new Object[preTaskList.size()];
            for (int i = 0; i < mParams.length; i++) {
                mParams[i] = mParamMap.get((preTaskList.get(i)).getId());
            }
        }

        if (mTask instanceof TaskCreator) {
            return runTaskCreator();
        } else {
            return runNormalTask();
        }
    }

    private Object runNormalTask() throws Exception {
        //执行任务
        Object result = mTask.process(mParams);

        //操作子任务
        for (Task nextTask : mTask.getNextList()) {
            TaskRunnable nextTaskRunnable = TaskRunnablePool.getOrCreate(mSession, nextTask);

            boolean paramsReady = nextTaskRunnable.addParam(mTask.getId(), result);
            if (paramsReady) {
                //参数完备，从参数等待区移除
                TaskRunnablePool.remove(mSession, nextTask);

                //做一次取消状态检测
                if (!mSession.isCanceled()) {
                    Engine.execute(nextTaskRunnable);
                } else {
                    TaskRunnablePool.remove(mSession);
                }
            }
        }

        return result;
    }

    private Object runTaskCreator() throws Exception {
        Object result = (mTask).process(mParams);
        Task start = (Task) result;
        Task end = GraphVisitor.findEnd(start);

        //每一个子节点变更父节点为end
        List<Task> nextList = mTask.getNextList();
        for (Task nextTask : nextList) {
            List<Task> preListOfNextList = nextTask.getPreList();
            int index = preListOfNextList.indexOf(mTask);
            preListOfNextList.remove(index);
            preListOfNextList.add(index, end);
        }
        //end引用当前节点的所有子节点
        end.setNextList(mTask.getNextList());
        mTask.getNextList().clear();

        //run start
        TaskRunnable startTaskRunnable = TaskRunnablePool.getOrCreate(mSession, start);
        startTaskRunnable.setParams(mParams);
        TaskRunnablePool.remove(mSession, start);

        //做一次取消状态检测
        if (!mSession.isCanceled()) {
            Engine.execute(startTaskRunnable);
        } else {
            TaskRunnablePool.remove(mSession);
        }

        return null;
    }

    /**
     * ***************************************************************************************************************
     *
     * ***************************************************************************************************************
     */

    /**
     * 是否是最后一个Task
     *
     * @return
     */
    private boolean isEndTask() {
        if (mTask instanceof TaskCreator) {
            return false;
        }
        return mTask.getNextList().isEmpty();
    }
}
