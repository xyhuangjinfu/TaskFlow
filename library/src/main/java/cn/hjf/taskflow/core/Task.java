package cn.hjf.taskflow.core;

import androidx.annotation.NonNull;

import java.util.concurrent.atomic.AtomicLong;

import cn.hjf.taskflow.graph.AbsVertex;

/**
 * The smallest unit which can be executed. The attribute of every task are below:
 * 1.Number of input is [0...N], N is positive infinite.
 * 2.Number of output is 1.
 * <p>
 * Tasks can be composed to a task graph, when two task connect, the previous task's output become the next task's input,
 * the attribute of a valid graph are below:
 * 1.Have one start task, which receive input for this graph.
 * 2.Have one end task, which output the result for this graph.
 * 3.Directed acyclic graph.
 * <p>
 * We use the start task to express a graph, for example:
 * 1.t1 -> t2 -> t3, this graph is t1.
 * 2.t1, this is a single task, and of course it is a valid graph depend on the task graph's definition, this graph is also t1.
 * <p>
 * Tasks and Graphs can be composed to more larger Graphs.
 */
public abstract class Task extends AbsVertex<Task> {

    private static final AtomicLong sIdGenerator = new AtomicLong(0);

    protected final String mName;
    protected final long mId;

    public Task() {
        this(null);
    }

    public Task(String name) {
        mId = sIdGenerator.getAndIncrement();
        mName = name == null ? "Task-" + mId : name;
    }

    /**
     * ***************************************************************************************************************
     * //
     * ***************************************************************************************************************
     */

    public String getName() {
        return mName;
    }

    public long getId() {
        return mId;
    }

    /**
     * ***************************************************************************************************************
     * <p>
     * ***************************************************************************************************************
     */
    @Override
    public String toString() {
        return "Task{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                '}';
    }

    /**
     * ***************************************************************************************************************
     * //
     * ***************************************************************************************************************
     */

    /**
     * Override this method to do some work which will be executed when this task runs.
     *
     * @param params
     * @return
     * @throws Throwable
     */
    @NonNull
    public abstract Object process(Object... params) throws Throwable;
}
