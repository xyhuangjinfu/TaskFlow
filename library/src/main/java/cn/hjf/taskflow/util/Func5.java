package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

public abstract class Func5<P1, P2, P3, P4, P5, R> extends Func<R> implements IFunc5<P1, P2, P3, P4, P5, R> {

    public Func5() {
    }

    public Func5(String name) {
        super(name);
    }

    @NonNull
    protected abstract R process(P1 p, P2 p2, P3 p3, P4 p4, P5 p5) throws Exception;
}
