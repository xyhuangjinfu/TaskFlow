package cn.hjf.taskflow.util;

import androidx.annotation.Nullable;

class FuncTask5 extends FuncTask {

    public FuncTask5(Func5 func) {
        super(func);
    }

    @Nullable
    @Override
    public Object process(Object... params) throws Throwable {
        CheckParamUtil.checkParameterCount(getName(), 5, params);
        return ((Func5) mFunc).process(params[0], params[1], params[2], params[3], params[4]);
    }
}
