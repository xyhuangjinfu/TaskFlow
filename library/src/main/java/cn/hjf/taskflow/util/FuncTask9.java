package cn.hjf.taskflow.util;

import cn.hjf.taskflow.core.Task;

class FuncTask9 extends Task {

    private final Func9 mFunc;

    public FuncTask9(Func9 func) {
        super(func.getName());
        mFunc = func;
        func.setAttached(true);
    }

    @Override
    public Object process(Object... params) throws Exception {
        if (params.length != 9) {
            return mFunc.process(null, null, null, null, null, null, null, null, null);
        }
        return mFunc.process(params[0], params[1], params[2], params[3], params[4], params[5], params[6], params[7], params[8]);
    }
}
