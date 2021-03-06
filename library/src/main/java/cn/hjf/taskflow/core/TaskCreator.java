package cn.hjf.taskflow.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * A special type task, which can create task or task graph at runtime. so it provide the ability to create tasks dynamic.
 * <p>
 * When at those situation that the number of tasks can be decided after do some calculate, this will be useful.
 */
public abstract class TaskCreator extends Task {

    public TaskCreator() {
        super();
    }

    public TaskCreator(String name) {
        super(name);
    }

    @Nullable
    @Override
    public final Object process(Object... params) throws Throwable {
        throw new UnsupportedOperationException("don't call process() method on TaskCreator, call createTask() instead.");
    }

    @Override
    public String toString() {
        return "TaskCreator{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                '}';
    }

    /**
     * Create task or task graph dynamically.
     *
     * @param params
     * @return
     */
    @NonNull
    public abstract Task createTask(Object... params);
}
