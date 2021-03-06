package cn.hjf.taskflow.util;

import androidx.annotation.Nullable;

class FuncTask7 extends FuncTask {

    public FuncTask7(Func7 func) {
        super(func);
    }

    @Nullable
    @Override
    public Object process(Object... params) throws Throwable {
        CheckParamUtil.checkParameterCount(getName(), 7, params);
        return ((Func7) mFunc).process(params[0], params[1], params[2], params[3], params[4], params[5], params[6]);
    }
}
