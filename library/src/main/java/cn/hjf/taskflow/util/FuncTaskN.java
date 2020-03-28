package cn.hjf.taskflow.util;

import androidx.annotation.Nullable;

class FuncTaskN extends FuncTask {

    public FuncTaskN(FuncN func) {
        super(func);
    }

    @Nullable
    @Override
    public Object process(Object... params) throws Throwable {
        return ((FuncN) mFunc).process(params);
    }
}
