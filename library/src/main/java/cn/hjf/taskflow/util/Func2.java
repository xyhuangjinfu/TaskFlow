package cn.hjf.taskflow.util;

import androidx.annotation.Nullable;

public abstract class Func2<P1, P2, R> extends Func<R> implements IFunc2<P1, P2, R> {

    public Func2() {
    }

    public Func2(String name) {
        super(name);
    }

    @Nullable
    protected abstract R process(@Nullable P1 p1, @Nullable P2 p2) throws Throwable;
}
