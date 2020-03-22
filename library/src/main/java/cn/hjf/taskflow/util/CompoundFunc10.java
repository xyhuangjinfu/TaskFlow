package cn.hjf.taskflow.util;

class CompoundFunc10<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, R> extends CompoundFunc<R> implements IFunc10<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, R> {

    public CompoundFunc10(IFunc10<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, ?> start, IFunc<R> end) {
        super(start, end);
    }
}
