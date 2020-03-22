package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

public abstract class FuncN<R> extends Func<R> implements IFuncN<R> {

    public FuncN() {
    }

    public FuncN(String name) {
        super(name);
    }

    @NonNull
    protected abstract R process(Object... params) throws Exception;
}
