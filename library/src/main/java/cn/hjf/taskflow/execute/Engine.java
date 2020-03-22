package cn.hjf.taskflow.execute;

import androidx.annotation.NonNull;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cn.hjf.taskflow.core.Task;
import cn.hjf.taskflow.graph.GraphPrinter;
import cn.hjf.taskflow.graph.GraphVisitor;
import cn.hjf.taskflow.graph.OnVisitListener;

public class Engine {

    private static ExecutorService sExecutorService = Executors.newCachedThreadPool();

    /**
     * 执行任务图
     *
     * @param task
     * @param callback
     * @return
     */
    public static Session execute(@NonNull Task task, @NonNull Callback callback) {
        checkTaskGraph(task);

        Session session = new Session(callback);
        sExecutorService.submit(new TaskRunnable(session, task));
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

    private static void checkTaskGraph(@NonNull final Task task) {
        GraphPrinter.printForward(task);
        GraphPrinter.printBackward(GraphVisitor.findEnd(task));

        GraphVisitor.bfsForward(task, new OnVisitListener<Task>() {
            private Task end = null;

            @Override
            public void onStart() {

            }

            @Override
            public void visit(Task t) {
                if (t.getNextList().isEmpty()) {
                    if (end == null) {
                        end = t;
                    } else {
                        throw new IllegalArgumentException("task : " + task + " have more than one end task");
                    }
                }
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
