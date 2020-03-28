package cn.hjf.taskflow.util;

import androidx.annotation.Nullable;

public abstract class Func10<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, R> extends Func<R> implements IFunc10<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, R> {

    public Func10() {
    }

    public Func10(String name) {
        super(name);
    }

    @Nullable
    protected abstract R process(@Nullable P1 p1, @Nullable P2 p2, @Nullable P3 p3, @Nullable P4 p4, @Nullable P5 p5, @Nullable P6 p6, @Nullable P7 p7, @Nullable P8 p8, @Nullable P9 p9, @Nullable P10 p10) throws Throwable;
}
