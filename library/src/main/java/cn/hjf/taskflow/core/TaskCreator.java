package cn.hjf.taskflow.core;

import androidx.annotation.NonNull;

public abstract class TaskCreator extends Task {

    public TaskCreator() {
        super();
    }

    public TaskCreator(String name) {
        super(name);
    }

    @NonNull
    @Override
    public Object process(Object... params) throws Exception {
        return createTask(params);
    }

    @NonNull
    protected abstract Task[] createTask(Object... params);
}
