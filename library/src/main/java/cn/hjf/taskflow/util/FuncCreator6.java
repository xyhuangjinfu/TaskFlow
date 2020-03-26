package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

public abstract class FuncCreator6<P1, P2, P3, P4, P5, P6, R> extends FuncCreator<R> implements IFunc6<P1, P2, P3, P4, P5, P6, R> {

    public FuncCreator6() {
    }

    public FuncCreator6(String name) {
        super(name);
    }

    @NonNull
    protected abstract IFunc createFunc(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6);
}
