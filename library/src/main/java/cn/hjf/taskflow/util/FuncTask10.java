package cn.hjf.taskflow.util;

import cn.hjf.taskflow.core.Task;

class FuncTask10 extends Task {

    private final Func10 mFunc;

    public FuncTask10(Func10 func) {
        super(func.getName());
        mFunc = func;
        func.setAttached(true);
    }

    @Override
    public Object process(Object... params) throws Exception {
        if (params.length != 10) {
            return mFunc.process(null, null, null, null, null, null, null, null, null, null);
        }
        return mFunc.process(params[0], params[1], params[2], params[3], params[4], params[5], params[6], params[7], params[8], params[9]);
    }
}
