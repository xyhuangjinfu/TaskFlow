package cn.hjf.taskflow.util;

class CompoundFunc4<P1, P2, P3, P4, R> extends CompoundFunc<R> implements IFunc4<P1, P2, P3, P4, R> {

    public CompoundFunc4(IFunc4<P1, P2, P3, P4, ?> start, IFunc<R> end) {
        super(start, end);
    }
}
