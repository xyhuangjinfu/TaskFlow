package cn.hjf.taskflow.execute;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cn.hjf.taskflow.core.Task;
import cn.hjf.taskflow.graph.GraphVisitor;
import cn.hjf.taskflow.graph.OnVisitListener;

/**
 * Engine to run the task graph.
 */
public class Engine {

    private static ExecutorService sExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);

    /**
     * Specify the ExecutorService you want to execute your tasks.
     *
     * @param executorService
     */
    public static void setExecutorService(ExecutorService executorService) {
        sExecutorService = executorService;
    }

    /**
     * Execute the task.
     *
     * @param task
     * @param callback
     * @param params   Parameters for start task.
     * @return
     */
    public static Session execute(@NonNull Task task, @NonNull Callback callback, Object... params) {
        checkTaskGraph(task);

        Session session = new Session(callback);
        TaskRunnable taskRunnable = new TaskRunnable(session, task);
        taskRunnable.setParams(params);
        sExecutorService.submit(taskRunnable);
        return session;
    }

    /**
     * package
     *
     * @param taskRunnable
     */
    static void execute(TaskRunnable taskRunnable) {
        sExecutorService.submit(taskRunnable);
    }

    /**
     * ***************************************************************************************************************
     * <p>
     * ***************************************************************************************************************
     */

    /**
     * Check the validation of the task.
     *
     * @param start
     */
    private static void checkTaskGraph(@NonNull final Task start) {
        List<Task> endList = getAllEndTask(start);
        if (endList.size() != 1) {
            throw new RuntimeException("start task " + start + " have wrong number of end tasks. " + endList);
        }

        Task end = endList.get(0);
        List<Task> startList = getAllStartTask(end);
        if (startList.size() != 1) {
            throw new RuntimeException("end task " + end + " have wrong number of start tasks. " + startList);
        }
    }

    /**
     * Return all end task
     *
     * @param start
     * @return
     */
    private static List<Task> getAllEndTask(@NonNull final Task start) {
        final List<Task> endList = new ArrayList<>();

        GraphVisitor.bfsForward(start, new OnVisitListener<Task>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onVisit(Task t) {
                if (t.getNextList().isEmpty()) {
                    endList.add(t);
                }
            }

            @Override
            public void onComplete() {

            }

            @Override
            public boolean stop() {
                return false;
            }
        });

        return endList;
    }

    /**
     * Return all start task
     *
     * @param end
     * @return
     */
    private static List<Task> getAllStartTask(@NonNull final Task end) {
        final List<Task> startList = new ArrayList<>();

        GraphVisitor.bfsBackward(end, new OnVisitListener<Task>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onVisit(Task t) {
                if (t.getPreList().isEmpty()) {
                    startList.add(t);
                }
            }

            @Override
            public void onComplete() {

            }

            @Override
            public boolean stop() {
                return false;
            }
        });

        return startList;
    }
}
