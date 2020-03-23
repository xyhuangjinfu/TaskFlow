package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

public abstract class FuncCreator1<P, R> extends FuncCreator<R> implements IFunc1<P, R> {

    public FuncCreator1() {
    }

    public FuncCreator1(String name) {
        super(name);
    }

    @NonNull
    protected abstract IFunc createFunc(P p);
}
