package cn.hjf.taskflow.execute;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import cn.hjf.taskflow.core.Task;

/**
 * Each TaskRunnable instance, need to stay here to wait parameters from it's parent, when all parameters complete, it will be remove from here.
 */
class TaskRunnablePool {

    private static TaskRunnablePool sInstance = new TaskRunnablePool();

    public static TaskRunnablePool getInstance() {
        return sInstance;
    }

    private Lock mLock = new ReentrantLock();
    private Map<Session, Map<Long, TaskRunnable>> mTaskRunnableMap = new HashMap<>();

    public TaskRunnable getOrCreate(Session session, Task task) {
        mLock.lock();
        try {
            TaskRunnable r;

            if (mTaskRunnableMap.containsKey(session)) {
                Map<Long, TaskRunnable> map = mTaskRunnableMap.get(session);
                if (map.containsKey(task.getId())) {
                    r = map.get(task.getId());
                } else {
                    r = new TaskRunnable(session, task);
                    map.put(task.getId(), r);
                }
            } else {
                Map<Long, TaskRunnable> map = new HashMap<>();
                r = new TaskRunnable(session, task);
                map.put(task.getId(), r);

                mTaskRunnableMap.put(session, map);
            }

            return r;
        } finally {
            mLock.unlock();
        }
    }

    public void remove(Session session, Task task) {
        mLock.lock();
        try {
            if (!mTaskRunnableMap.containsKey(session)) {
                return;
            }

            Map<Long, TaskRunnable> map = mTaskRunnableMap.get(session);
            map.remove(task.getId());

            if (map.isEmpty()) {
                mTaskRunnableMap.remove(session);
            }
        } finally {
            mLock.unlock();
        }
    }

    public void remove(Session session) {
        mLock.lock();
        try {
            mTaskRunnableMap.remove(session);
        } finally {
            mLock.unlock();
        }
    }
}
