package cn.hjf.taskflow.execute;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import cn.hjf.taskflow.core.Task;
import cn.hjf.taskflow.core.TaskCreator;
import cn.hjf.taskflow.graph.GraphVisitor;

/**
 * Runnable to execute a task, will be execute in the thread pool.
 * <p>
 * Each TaskRunnable instance should only be submitted once.
 */
class TaskRunnable implements Runnable {

    private final Task mTask;
    private final Session mSession;
    private Map<Long, Object> mParamMap = new HashMap<>();
    private Object[] mParams;
    private Lock mParamLock = new ReentrantLock();

    public TaskRunnable(Session session, Task task) {
        mTask = task;
        mSession = session;
    }

    /**
     * When pre task complete, they add parameter into next task.
     *
     * @param preTaskId
     * @param param
     * @return when all parameters reay, return true.
     */
    private boolean addParam(long preTaskId, Object param) {
        mParamLock.lock();
        try {
            mParamMap.put(preTaskId, param);
            return mParamMap.size() == mTask.getPreList().size();
        } finally {
            mParamLock.unlock();
        }
    }

    /**
     * set all params together, when params is not null, {@link TaskRunnable#addParam(long, Object)} will not work.
     *
     * @param params
     */
    public void setParams(Object[] params) {
        mParamLock.lock();
        try {
            mParams = params;
        } finally {
            mParamLock.unlock();
        }
    }

    @Override
    public void run() {
        //check cancel status, avoid to run time-consuming process method.
        if (mSession.isCanceled()) {
            TaskRunnablePool.getInstance().remove(mSession);
            return;
        }

        internalRun();

        //check cancel status, avoid to some task add task runnable after other task cleared.
        if (mSession.isCanceled()) {
            TaskRunnablePool.getInstance().remove(mSession);
            return;
        }
    }

    /**
     * ***************************************************************************************************************
     * //
     * ***************************************************************************************************************
     */

    private void internalRun() {
        final boolean isEndTask = isEndTask();

        try {
            Object result = runTask();
            if (isEndTask) {
                mSession.onFinish(result, null);
            }
        } catch (Throwable e) {
            mSession.onFinish(null, e);
        }
    }

    private Object runTask() throws Throwable {
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

    private Object runNormalTask() throws Throwable {
        //do process
        Object result = mTask.process(mParams);

        //operate next tasks
        for (Task nextTask : mTask.getNextList()) {
            //check cancel status before create new task runnable.
            if (mSession.isCanceled()) {
                TaskRunnablePool.getInstance().remove(mSession);
                break;
            }

            TaskRunnable nextTaskRunnable = TaskRunnablePool.getInstance().getOrCreate(mSession, nextTask);

            boolean paramsReady = nextTaskRunnable.addParam(mTask.getId(), result);
            if (paramsReady) {
                //Params ready, remove from waiting area.
                TaskRunnablePool.getInstance().remove(mSession, nextTask);

                //check cancel status before execute task runnable.
                if (mSession.isCanceled()) {
                    TaskRunnablePool.getInstance().remove(mSession);
                    break;
                }

                Engine.execute(nextTaskRunnable);
            }
        }

        return result;
    }

    private Object runTaskCreator() throws Throwable {
        Task start = ((TaskCreator) mTask).createTask(mParams);
        Task end = GraphVisitor.findEnd(start);

        //relink all next tasks to new end task
        List<Task> nextList = mTask.getNextList();
        for (Task nextTask : nextList) {
            List<Task> preListOfNextTask = nextTask.getPreList();
            int index = preListOfNextTask.indexOf(mTask);
            preListOfNextTask.set(index, end);
        }
        //link end task to all next tasks
        end.setNextList(mTask.getNextList());
        mTask.getNextList().clear();

        //check cancel status before create task runnable.
        if (mSession.isCanceled()) {
            TaskRunnablePool.getInstance().remove(mSession);
            return null;
        }

        //run start
        TaskRunnable startTaskRunnable = TaskRunnablePool.getInstance().getOrCreate(mSession, start);
        startTaskRunnable.setParams(mParams);
        TaskRunnablePool.getInstance().remove(mSession, start);

        //check cancel status before execute task runnable.
        if (mSession.isCanceled()) {
            TaskRunnablePool.getInstance().remove(mSession);
            return null;
        }

        Engine.execute(startTaskRunnable);

        return null;
    }

    /**
     * ***************************************************************************************************************
     *
     * ***************************************************************************************************************
     */

    /**
     * check whether it is the last task.
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
