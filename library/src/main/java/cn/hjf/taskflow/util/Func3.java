package cn.hjf.taskflow.util;

import androidx.annotation.Nullable;

public abstract class Func3<P1, P2, P3, R> extends Func<R> implements IFunc3<P1, P2, P3, R> {

    public Func3() {
    }

    public Func3(String name) {
        super(name);
    }

    @Nullable
    protected abstract R process(@Nullable P1 p1, @Nullable P2 p2, @Nullable P3 p3) throws Throwable;
}
