package cn.hjf.taskflow.util;

import androidx.annotation.Nullable;

public abstract class Func8<P1, P2, P3, P4, P5, P6, P7, P8, R> extends Func<R> implements IFunc8<P1, P2, P3, P4, P5, P6, P7, P8, R> {

    public Func8() {
    }

    public Func8(String name) {
        super(name);
    }

    @Nullable
    protected abstract R process(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7, P8 p8) throws Throwable;
}
