package cn.hjf.taskflow.util;

import androidx.annotation.Nullable;

class FuncTask3 extends FuncTask {

    public FuncTask3(Func3 func) {
        super(func);
    }

    @Nullable
    @Override
    public Object process(Object... params) throws Throwable {
        CheckParamUtil.checkParameterCount(getName(), 3, params);
        return ((Func3) mFunc).process(params[0], params[1], params[2]);
    }
}
