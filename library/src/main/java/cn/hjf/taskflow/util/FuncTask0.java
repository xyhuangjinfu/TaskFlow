package cn.hjf.taskflow.util;

import androidx.annotation.Nullable;

class FuncTask0 extends FuncTask {

    public FuncTask0(Func0 func) {
        super(func);
    }

    @Nullable
    @Override
    public Object process(Object... params) throws Throwable {
        CheckParamUtil.checkParameterForIFunc0(getName(), params);
        return ((Func0) mFunc).process();
    }
}
