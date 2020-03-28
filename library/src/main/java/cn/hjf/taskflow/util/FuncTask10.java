package cn.hjf.taskflow.util;

import androidx.annotation.Nullable;

class FuncTask10 extends FuncTask {

    public FuncTask10(Func10 func) {
        super(func);
    }

    @Nullable
    @Override
    public Object process(Object... params) throws Throwable {
        CheckParamUtil.checkParameterCount(getName(), 10, params);
        return ((Func10) mFunc).process(params[0], params[1], params[2], params[3], params[4], params[5], params[6], params[7], params[8], params[9]);
    }
}
