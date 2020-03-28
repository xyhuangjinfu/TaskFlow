package cn.hjf.taskflow.util;

import androidx.annotation.Nullable;

public abstract class Func4<P1, P2, P3, P4, R> extends Func<R> implements IFunc4<P1, P2, P3, P4, R> {

    public Func4() {
    }

    public Func4(String name) {
        super(name);
    }

    @Nullable
    protected abstract R process(P1 p1, P2 p2, P3 p3, P4 p4) throws Throwable;
}
