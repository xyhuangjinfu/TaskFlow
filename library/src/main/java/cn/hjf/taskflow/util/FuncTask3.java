package cn.hjf.taskflow.util;

import cn.hjf.taskflow.core.Task;

class FuncTask3 extends Task {

    private final Func3 mFunc;

    public FuncTask3(Func3 func) {
        super(func.getName());
        mFunc = func;
        func.setAttached(true);
    }

    @Override
    public Object process(Object... params) throws Exception {
        if (params.length != 3) {
            return mFunc.process(null, null, null);
        }
        return mFunc.process(params[0], params[1], params[2]);
    }
}
