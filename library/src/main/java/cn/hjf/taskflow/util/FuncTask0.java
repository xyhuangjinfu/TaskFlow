package cn.hjf.taskflow.util;

import cn.hjf.taskflow.core.Task;

class FuncTask0 extends Task {

    private final Func0 mFunc;

    public FuncTask0(Func0 func) {
        super(func.getName());
        mFunc = func;
        func.setAttached(true);
    }

    @Override
    public Object process(Object... params) throws Exception {
        return mFunc.process();
    }
}
