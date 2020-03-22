package cn.hjf.taskflow.util;

class CompoundFunc7<P1, P2, P3, P4, P5, P6, P7, R> extends CompoundFunc<R> implements IFunc7<P1, P2, P3, P4, P5, P6, P7, R> {

    public CompoundFunc7(IFunc7<P1, P2, P3, P4, P5, P6, P7, ?> start, IFunc<R> end) {
        super(start, end);
    }
}
