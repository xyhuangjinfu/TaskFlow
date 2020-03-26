package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

public abstract class FuncCreator9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R> extends FuncCreator<R> implements IFunc9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R> {

    public FuncCreator9() {
    }

    public FuncCreator9(String name) {
        super(name);
    }

    @NonNull
    protected abstract IFunc createFunc(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7, P8 p8, P9 p9);
}
