package cn.hjf.taskflow.util;

import java.util.Arrays;

import cn.hjf.taskflow.core.Task;

abstract class FuncTask extends Task {

    protected final Func mFunc;

    public FuncTask(Func func) {
        super(func.getName());
        mFunc = func;
        func.setAttached(true);
    }

    protected void checkParameterCount(int paramCount, Object... params) {
        if (params.length != paramCount) {
            throw new RuntimeException("parameter count error for " + getName() + ", need " + paramCount + " parameters, but received " + params.length + ", " + Arrays.toString(params));
        }
    }
}
