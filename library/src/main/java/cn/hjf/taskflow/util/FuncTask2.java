package cn.hjf.taskflow.util;

import cn.hjf.taskflow.core.Task;

class FuncTask2 extends Task {

    private final Func2 mFunc;

    public FuncTask2(Func2 func) {
        super(func.getName());
        mFunc = func;
        func.setAttached(true);
    }

    @Override
    public Object process(Object... params) throws Exception {
        if (params.length != 2) {
            return mFunc.process(null, null);
        }
        return mFunc.process(params[0], params[1]);
    }
}
