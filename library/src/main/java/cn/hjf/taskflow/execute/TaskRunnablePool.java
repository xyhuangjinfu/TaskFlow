package cn.hjf.taskflow.execute;

import java.util.HashMap;
import java.util.Map;

import cn.hjf.taskflow.core.Task;

/**
 * Each TaskRunnable instance, need to stay here to wait parameters from it's parent, when all parameters complete, it will be remove from here.
 */
class TaskRunnablePool {

    private static Map<Session, Map<Long, TaskRunnable>> sTaskRunnableMap = new HashMap<>();

    public static synchronized TaskRunnable getOrCreate(Session session, Task task) {
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
    }

    public static synchronized void remove(Session session, Task task) {
        Map<Long, TaskRunnable> map = sTaskRunnableMap.get(session);
        map.remove(task.getId());

        if (map.isEmpty()) {
            sTaskRunnableMap.remove(session);
        }
    }

    public static synchronized void remove(Session session) {
        sTaskRunnableMap.remove(session);
    }
}
