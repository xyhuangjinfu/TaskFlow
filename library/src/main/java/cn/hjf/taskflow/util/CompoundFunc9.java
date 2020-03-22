package cn.hjf.taskflow.util;

class CompoundFunc9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R> extends CompoundFunc<R> implements IFunc9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R> {

    public CompoundFunc9(IFunc9<P1, P2, P3, P4, P5, P6, P7, P8, P9, ?> start, IFunc<R> end) {
        super(start, end);
    }
}
