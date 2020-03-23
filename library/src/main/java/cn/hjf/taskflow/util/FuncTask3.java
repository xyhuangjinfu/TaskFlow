package cn.hjf.taskflow.util;

class FuncTask3 extends FuncTask {

    public FuncTask3(Func3 func) {
        super(func);
    }

    @Override
    public Object process(Object... params) throws Exception {
        checkParameterCount(3, params);
        return ((Func3) mFunc).process(params[0], params[1], params[2]);
    }
}
