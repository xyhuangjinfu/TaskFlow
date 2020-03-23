package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

public abstract class FuncCreatorN<R> extends FuncCreator<R> implements IFuncN<R> {

    public FuncCreatorN() {
    }

    public FuncCreatorN(String name) {
        super(name);
    }

    @NonNull
    protected abstract IFunc createFunc(Object... params);
}
