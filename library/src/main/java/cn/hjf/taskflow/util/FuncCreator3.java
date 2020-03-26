package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

public abstract class FuncCreator3<P1, P2, P3, R> extends FuncCreator<R> implements IFunc3<P1, P2, P3, R> {

    public FuncCreator3() {
    }

    public FuncCreator3(String name) {
        super(name);
    }

    @NonNull
    protected abstract IFunc createFunc(P1 p1, P2 p2, P3 p3);
}
