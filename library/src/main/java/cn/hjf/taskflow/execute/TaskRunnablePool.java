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

    private static Lock sLock = new ReentrantLock();
    private static Map<Session, Map<Long, TaskRunnable>> sTaskRunnableMap = new HashMap<>();

    public static TaskRunnable getOrCreate(Session session, Task task) {
        sLock.lock();
        try {
            TaskRunnable r;

            if (sTaskRunnableMap.containsKey(session)) {
                Map<Long, TaskRunnable> map = sTaskRunnableMap.get(session);
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

                sTaskRunnableMap.put(session, map);
            }

            return r;
        } finally {
            sLock.unlock();
        }
    }

    public static void remove(Session session, Task task) {
        sLock.lock();
        try {
            if (!sTaskRunnableMap.containsKey(session)) {
                return;
            }

            Map<Long, TaskRunnable> map = sTaskRunnableMap.get(session);
            map.remove(task.getId());

            if (map.isEmpty()) {
                sTaskRunnableMap.remove(session);
            }
        } finally {
            sLock.unlock();
        }
    }

    public static void remove(Session session) {
        sLock.lock();
        try {
            sTaskRunnableMap.remove(session);
        } finally {
            sLock.unlock();
        }
    }
}
