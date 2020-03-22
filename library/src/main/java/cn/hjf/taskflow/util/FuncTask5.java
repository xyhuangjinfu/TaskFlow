package cn.hjf.taskflow.util;

import cn.hjf.taskflow.core.Task;

class FuncTask5 extends Task {

    private final Func5 mFunc;

    public FuncTask5(Func5 func) {
        super(func.getName());
        mFunc = func;
        func.setAttached(true);
    }

    @Override
    public Object process(Object... params) throws Exception {
        if (params.length != 5) {
            return mFunc.process(null, null, null, null, null);
        }
        return mFunc.process(params[0], params[1], params[2], params[3], params[4]);
    }
}
