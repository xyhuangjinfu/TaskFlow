package cn.hjf.taskflow.util;

import cn.hjf.taskflow.core.Task;

class FuncTask1 extends Task {

    private final Func1 mFunc;

    public FuncTask1(Func1 func) {
        super(func.getName());
        mFunc = func;
        func.setAttached(true);
    }

    @Override
    public Object process(Object... params) throws Exception {
        if (params.length != 1) {
            return mFunc.process(null);
        }
        return mFunc.process(params[0]);
    }
}
