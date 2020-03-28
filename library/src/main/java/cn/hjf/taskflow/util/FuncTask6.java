package cn.hjf.taskflow.util;

import androidx.annotation.Nullable;

class FuncTask6 extends FuncTask {

    public FuncTask6(Func6 func) {
        super(func);
    }

    @Nullable
    @Override
    public Object process(Object... params) throws Throwable {
        CheckParamUtil.checkParameterCount(getName(), 6, params);
        return ((Func6) mFunc).process(params[0], params[1], params[2], params[3], params[4], params[5]);
    }
}
