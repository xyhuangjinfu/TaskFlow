package cn.hjf.taskflow.util;

class CompoundFunc5<P1, P2, P3, P4, P5, R> extends CompoundFunc<R> implements IFunc5<P1, P2, P3, P4, P5, R> {

    public CompoundFunc5(IFunc5<P1, P2, P3, P4, P5, ?> start, IFunc<R> end) {
        super(start, end);
    }
}
