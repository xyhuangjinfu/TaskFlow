package cn.hjf.taskflow.util;

class CompoundFunc6<P1, P2, P3, P4, P5, P6, R> extends CompoundFunc<R> implements IFunc6<P1, P2, P3, P4, P5, P6, R> {

    public CompoundFunc6(IFunc6<P1, P2, P3, P4, P5, P6, ?> start, IFunc<R> end) {
        super(start, end);
    }
}
