package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

public abstract class FuncCreator8<P1, P2, P3, P4, P5, P6, P7, P8, R> extends FuncCreator<R> implements IFunc8<P1, P2, P3, P4, P5, P6, P7, P8, R> {

    public FuncCreator8() {
    }

    public FuncCreator8(String name) {
        super(name);
    }

    @NonNull
    protected abstract IFunc createFunc(P1 p, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7, P8 p8);
}
