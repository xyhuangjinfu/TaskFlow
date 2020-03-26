package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

public abstract class Func10<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, R> extends Func<R> implements IFunc10<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, R> {

    public Func10() {
    }

    public Func10(String name) {
        super(name);
    }

    @NonNull
    protected abstract R process(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7, P8 p8, P9 p9, P10 p10) throws Exception;
}
