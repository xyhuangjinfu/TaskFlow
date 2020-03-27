package cn.hjf.taskflow.util;

class FuncTask1 extends FuncTask {

    public FuncTask1(Func1 func) {
        super(func);
    }

    @Override
    public Object process(Object... params) throws Throwable {
        CheckParamUtil.checkParameterCount(getName(), 1, params);
        return ((Func1) mFunc).process(params[0]);
    }
}
