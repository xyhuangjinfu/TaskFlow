package cn.hjf.taskflow.util;

import cn.hjf.taskflow.core.Task;

class FuncTask4 extends Task {

    private final Func4 mFunc;

    public FuncTask4(Func4 func) {
        super(func.getName());
        mFunc = func;
        func.setAttached(true);
    }

    @Override
    public Object process(Object... params) throws Exception {
        if (params.length != 4) {
            return mFunc.process(null, null, null, null);
        }
        return mFunc.process(params[0], params[1], params[2], params[3]);
    }
}
