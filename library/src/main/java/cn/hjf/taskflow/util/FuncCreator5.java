package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

public abstract class FuncCreator5<P1, P2, P3, P4, P5, R> extends FuncCreator<R> implements IFunc5<P1, P2, P3, P4, P5, R> {

    public FuncCreator5() {
    }

    public FuncCreator5(String name) {
        super(name);
    }

    @NonNull
    protected abstract IFunc createFunc(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5);
}
