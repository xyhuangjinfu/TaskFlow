package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

public abstract class FuncCreator3<P1, P2, P3, R> extends Func<R> implements IFunc3<P1, P2, P3, R> {

    public FuncCreator3() {
    }

    public FuncCreator3(String name) {
        super(name);
    }

    @NonNull
    protected R process(P1 p, P2 p2, P3 p3) throws Exception {
        IFunc[] startAndEnd = createFunc(p, p2, p3);
        return null;
    }

    protected abstract IFunc[] createFunc(P1 p, P2 p2, P3 p3);
}
