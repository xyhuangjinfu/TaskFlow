package cn.hjf.taskflow.util;

class FuncTask8 extends FuncTask {

    public FuncTask8(Func8 func) {
        super(func);
    }

    @Override
    public Object process(Object... params) throws Exception {
        CheckParamUtil.checkParameterCount(getName(), 8, params);
        return ((Func8) mFunc).process(params[0], params[1], params[2], params[3], params[4], params[5], params[6], params[7]);
    }
}
