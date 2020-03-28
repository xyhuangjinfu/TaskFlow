package cn.hjf.taskflow.util;

import androidx.annotation.Nullable;

public abstract class Func1<P, R> extends Func<R> implements IFunc1<P, R> {

    public Func1() {
    }

    public Func1(String name) {
        super(name);
    }

    @Nullable
    protected abstract R process(P p) throws Throwable;
}
