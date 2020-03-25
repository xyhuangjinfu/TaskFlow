package cn.hjf.taskflow.util;

class FuncTask4 extends FuncTask {

    public FuncTask4(Func4 func) {
        super(func);
    }

    @Override
    public Object process(Object... params) throws Exception {
        CheckParamUtil.checkParameterCount(getName(), 4, params);
        return ((Func4) mFunc).process(params[0], params[1], params[2], params[3]);
    }
}
