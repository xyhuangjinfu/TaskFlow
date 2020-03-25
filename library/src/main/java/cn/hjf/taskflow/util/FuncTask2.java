package cn.hjf.taskflow.util;

class FuncTask2 extends FuncTask {

    public FuncTask2(Func2 func) {
        super(func);
    }

    @Override
    public Object process(Object... params) throws Exception {
        CheckParamUtil.checkParameterCount(getName(), 2, params);
        return ((Func2) mFunc).process(params[0], params[1]);
    }
}
