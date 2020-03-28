package cn.hjf.taskflow.util;

import androidx.annotation.Nullable;

class FuncTask4 extends FuncTask {

    public FuncTask4(Func4 func) {
        super(func);
    }

    @Nullable
    @Override
    public Object process(Object... params) throws Throwable {
        CheckParamUtil.checkParameterCount(getName(), 4, params);
        return ((Func4) mFunc).process(params[0], params[1], params[2], params[3]);
    }
}
