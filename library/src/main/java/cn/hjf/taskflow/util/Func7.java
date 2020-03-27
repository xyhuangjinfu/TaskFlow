package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

public abstract class Func7<P1, P2, P3, P4, P5, P6, P7, R> extends Func<R> implements IFunc7<P1, P2, P3, P4, P5, P6, P7, R> {

    public Func7() {
    }

    public Func7(String name) {
        super(name);
    }

    @NonNull
    protected abstract R process(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7) throws Throwable;
}
