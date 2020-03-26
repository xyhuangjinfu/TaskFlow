package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

public abstract class FuncCreator2<P1, P2, R> extends FuncCreator<R> implements IFunc2<P1, P2, R> {

    public FuncCreator2() {
    }

    public FuncCreator2(String name) {
        super(name);
    }

    @NonNull
    protected abstract IFunc createFunc(P1 p1, P2 p2);
}
