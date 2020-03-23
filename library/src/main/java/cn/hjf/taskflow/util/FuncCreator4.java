package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

public abstract class FuncCreator4<P1, P2, P3, P4, R> extends FuncCreator<R> implements IFunc4<P1, P2, P3, P4, R> {

    public FuncCreator4() {
    }

    public FuncCreator4(String name) {
        super(name);
    }

    @NonNull
    protected abstract IFunc createFunc(P1 p, P2 p2, P3 p3, P4 p4);
}
