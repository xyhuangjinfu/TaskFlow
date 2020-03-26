package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

public abstract class Func9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R> extends Func<R> implements IFunc9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R> {

    public Func9() {
    }

    public Func9(String name) {
        super(name);
    }

    @NonNull
    protected abstract R process(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7, P8 p8, P9 p9) throws Exception;
}
