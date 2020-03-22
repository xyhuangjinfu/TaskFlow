package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

public abstract class Func3<P1, P2, P3, R> extends Func<R> implements IFunc3<P1, P2, P3, R> {

    public Func3() {
    }

    public Func3(String name) {
        super(name);
    }

    @NonNull
    protected abstract R process(P1 p, P2 p2, P3 p3) throws Exception;
}
