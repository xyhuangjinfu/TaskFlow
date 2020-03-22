package cn.hjf.taskflow.util;

class CompoundFunc0<R> extends CompoundFunc<R> implements IFunc0<R> {

    public CompoundFunc0(IFunc0 start, IFunc<R> end) {
        super(start, end);
    }
}
