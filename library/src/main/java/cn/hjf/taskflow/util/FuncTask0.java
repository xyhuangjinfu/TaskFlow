package cn.hjf.taskflow.util;

class FuncTask0 extends FuncTask {

    public FuncTask0(Func0 func) {
        super(func);
    }

    @Override
    public Object process(Object... params) throws Exception {
        CheckParamUtil.checkParameterCount(getName(), 0, params);
        return ((Func0) mFunc).process();
    }
}
