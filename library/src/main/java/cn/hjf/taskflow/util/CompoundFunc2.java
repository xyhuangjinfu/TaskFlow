package cn.hjf.taskflow.util;

class CompoundFunc2<P1, P2, R> extends CompoundFunc<R> implements IFunc2<P1, P2, R> {

    public CompoundFunc2(IFunc2<P1, P2, ?> start, IFunc<R> end) {
        super(start, end);
    }
}
