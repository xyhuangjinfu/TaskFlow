package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

public abstract class Func0<R> extends Func<R> implements IFunc0<R> {

    public Func0() {
    }

    public Func0(String name) {
        super(name);
    }

    @NonNull
    protected abstract R process() throws Throwable;
}
