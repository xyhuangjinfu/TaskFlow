package cn.hjf.taskflow.util;

class FuncTask6 extends FuncTask {

    public FuncTask6(Func6 func) {
        super(func);
    }

    @Override
    public Object process(Object... params) throws Exception {
        CheckParamUtil.checkParameterCount(getName(), 6, params);
        return ((Func6) mFunc).process(params[0], params[1], params[2], params[3], params[4], params[5]);
    }
}
