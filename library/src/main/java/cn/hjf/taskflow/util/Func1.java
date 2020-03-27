package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

public abstract class Func1<P, R> extends Func<R> implements IFunc1<P, R> {

    public Func1() {
    }

    public Func1(String name) {
        super(name);
    }

    @NonNull
    protected abstract R process(P p) throws Throwable;
}
