package cn.hjf.taskflow.util;

class CompoundFunc8<P1, P2, P3, P4, P5, P6, P7, P8, R> extends CompoundFunc<R> implements IFunc8<P1, P2, P3, P4, P5, P6, P7, P8, R> {

    public CompoundFunc8(IFunc8<P1, P2, P3, P4, P5, P6, P7, P8, ?> start, IFunc<R> end) {
        super(start, end);
    }
}
