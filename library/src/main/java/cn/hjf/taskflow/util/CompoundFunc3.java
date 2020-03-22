package cn.hjf.taskflow.util;

class CompoundFunc3<P1, P2, P3, R> extends CompoundFunc<R> implements IFunc3<P1, P2, P3, R> {

    public CompoundFunc3(IFunc3<P1, P2, P3, ?> start, IFunc<R> end) {
        super(start, end);
    }
}
