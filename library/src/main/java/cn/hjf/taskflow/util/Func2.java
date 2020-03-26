package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

public abstract class Func2<P1, P2, R> extends Func<R> implements IFunc2<P1, P2, R> {

    public Func2() {
    }

    public Func2(String name) {
        super(name);
    }

    @NonNull
    protected abstract R process(P1 p1, P2 p2) throws Exception;
}
