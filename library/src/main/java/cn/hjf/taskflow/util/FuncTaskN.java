package cn.hjf.taskflow.util;

import cn.hjf.taskflow.core.Task;

class FuncTaskN extends Task {

    private final FuncN mFunc;

    public FuncTaskN(FuncN func) {
        super(func.getName());
        mFunc = func;
        func.setAttached(true);
    }

    @Override
    public Object process(Object... params) throws Exception {
        return mFunc.process(params);
    }
}
