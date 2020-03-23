package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

public abstract class FuncCreator0<R> extends FuncCreator<R> implements IFunc0<R> {

    public FuncCreator0() {
    }

    public FuncCreator0(String name) {
        super(name);
    }

    @NonNull
    protected abstract IFunc createFunc();
}
