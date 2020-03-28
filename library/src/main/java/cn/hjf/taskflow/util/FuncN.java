package cn.hjf.taskflow.util;

import androidx.annotation.Nullable;

public abstract class FuncN<R> extends Func<R> implements IFuncN<R> {

    public FuncN() {
    }

    public FuncN(String name) {
        super(name);
    }

    @Nullable
    protected abstract R process(Object... params) throws Throwable;
}
