package cn.hjf.taskflow.util;

import androidx.annotation.Nullable;

public abstract class Func6<P1, P2, P3, P4, P5, P6, R> extends Func<R> implements IFunc6<P1, P2, P3, P4, P5, P6, R> {

    public Func6() {
    }

    public Func6(String name) {
        super(name);
    }

    @Nullable
    protected abstract R process(@Nullable P1 p1, @Nullable P2 p2, @Nullable P3 p3, @Nullable P4 p4, @Nullable P5 p5, @Nullable P6 p6) throws Throwable;
}
