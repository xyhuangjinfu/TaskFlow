package cn.hjf.taskflow.util;

class FuncTaskN extends FuncTask {

    public FuncTaskN(FuncN func) {
        super(func);
    }

    @Override
    public Object process(Object... params) throws Exception {
        return ((FuncN) mFunc).process(params);
    }
}
