package cn.hjf.taskflow.util;

class FuncTask9 extends FuncTask {

    public FuncTask9(Func9 func) {
        super(func);
    }

    @Override
    public Object process(Object... params) throws Exception {
        CheckParamUtil.checkParameterCount(getName(), 9, params);
        return ((Func9) mFunc).process(params[0], params[1], params[2], params[3], params[4], params[5], params[6], params[7], params[8]);
    }
}
