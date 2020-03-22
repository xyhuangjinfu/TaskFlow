package cn.hjf.taskflow.execute;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.hjf.taskflow.core.Task;

/**
 * 执行Task的对象，被放到线程池中执行。
 * <p>
 * 每个TaskRunnable应该只被放进执行队列一次，除非任务被取消。
 */
class TaskRunnable implements Runnable {

    private final Task mTask;
    private final Session mSession;
    private Map<Long, Object> mParamMap = new HashMap<>();

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
    public synchronized boolean addParam(long preTaskId, Object param) {
        mParamMap.put(preTaskId, param);
        return mParamMap.size() == mTask.getPreList().size();
    }

    @Override
    public void run() {
        internalRun();
    }

    private void internalRun() {
        if (mSession.isCanceled()) {
            TaskRunnablePool.remove(mSession);
            return;
        }

        try {
            Object result = runTask();
            if (isEndTask()) {
                mSession.onFinish(result, null);
            }
        } catch (Exception e) {
            mSession.onFinish(null, e);
        }
    }

    private Object runTask() throws Exception {
        //准备参数，需要注意参数的传递顺序
        List<Task> preTaskList = mTask.getPreList();
        Object[] params = new Object[preTaskList.size()];
        for (int i = 0; i < params.length; i++) {
            params[i] = mParamMap.get((preTaskList.get(i)).getId());
        }

        //执行任务
        Object result = mTask.process(params);

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

    /**
     * 是否是最后一个Task
     *
     * @return
     */
    private boolean isEndTask() {
        return mTask.getNextList().isEmpty();
    }
}
