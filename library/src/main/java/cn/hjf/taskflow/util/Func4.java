package cn.hjf.taskflow.util;

import androidx.annotation.Nullable;

public abstract class Func4<P1, P2, P3, P4, R> extends Func<R> implements IFunc4<P1, P2, P3, P4, R> {

    public Func4() {
    }

    public Func4(String name) {
        super(name);
    }

    @Nullable
    protected abstract R process(@Nullable P1 p1, @Nullable P2 p2, @Nullable P3 p3, @Nullable P4 p4) throws Throwable;
}
