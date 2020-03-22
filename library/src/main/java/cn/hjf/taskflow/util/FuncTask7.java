package cn.hjf.taskflow.util;

import cn.hjf.taskflow.core.Task;

class FuncTask7 extends Task {

    private final Func7 mFunc;

    public FuncTask7(Func7 func) {
        super(func.getName());
        mFunc = func;
        func.setAttached(true);
    }

    @Override
    public Object process(Object... params) throws Exception {
        if (params.length != 7) {
            return mFunc.process(null, null, null, null, null, null, null);
        }
        return mFunc.process(params[0], params[1], params[2], params[3], params[4], params[5], params[6]);
    }
}
