package cn.hjf.taskflow.execute;

import java.util.HashMap;
import java.util.Map;

import cn.hjf.taskflow.core.Task;

/**
 * 在TaskRunnable创建好后，需要等待各个父节点执行成功后传递参数，参数齐了之后会被送走执行。
 * 在等待参数装配的这段时间，在这里暂存。
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
