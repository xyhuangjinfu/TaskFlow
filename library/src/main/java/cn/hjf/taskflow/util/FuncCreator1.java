package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

public abstract class FuncCreator1<P1, R> extends Func<R> implements IFunc1<P1, R> {

    public FuncCreator1() {
    }

    public FuncCreator1(String name) {
        super(name);
    }

    @NonNull
    protected R process(P1 p) throws Exception {
        IFunc[] startAndEnd = createFunc(p);
        return null;
    }

    protected abstract IFunc[] createFunc(P1 p);
}
