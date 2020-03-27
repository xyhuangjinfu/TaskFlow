package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

public abstract class Func6<P1, P2, P3, P4, P5, P6, R> extends Func<R> implements IFunc6<P1, P2, P3, P4, P5, P6, R> {

    public Func6() {
    }

    public Func6(String name) {
        super(name);
    }

    @NonNull
    protected abstract R process(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6) throws Throwable;
}
