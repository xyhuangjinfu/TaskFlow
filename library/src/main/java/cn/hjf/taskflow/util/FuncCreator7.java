package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

public abstract class FuncCreator7<P1, P2, P3, P4, P5, P6, P7, R> extends FuncCreator<R> implements IFunc7<P1, P2, P3, P4, P5, P6, P7, R> {

    public FuncCreator7() {
    }

    public FuncCreator7(String name) {
        super(name);
    }

    @NonNull
    protected abstract IFunc createFunc(P1 p, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7);
}
