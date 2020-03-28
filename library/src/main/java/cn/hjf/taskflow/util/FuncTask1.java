package cn.hjf.taskflow.util;

import androidx.annotation.Nullable;

class FuncTask1 extends FuncTask {

    public FuncTask1(Func1 func) {
        super(func);
    }

    @Nullable
    @Override
    public Object process(Object... params) throws Throwable {
        CheckParamUtil.checkParameterCount(getName(), 1, params);
        return ((Func1) mFunc).process(params[0]);
    }
}
