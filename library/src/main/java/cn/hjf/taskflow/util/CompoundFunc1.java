package cn.hjf.taskflow.util;

class CompoundFunc1<P, R> extends CompoundFunc<R> implements IFunc1<P, R> {

    public CompoundFunc1(IFunc1<P, ?> start, IFunc<R> end) {
        super(start, end);
    }
}
