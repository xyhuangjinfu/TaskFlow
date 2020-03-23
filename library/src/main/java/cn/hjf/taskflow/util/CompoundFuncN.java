package cn.hjf.taskflow.util;

class CompoundFuncN<R> extends CompoundFunc<R> implements IFuncN<R> {

    public CompoundFuncN(IFuncN<?> start, IFunc<R> end) {
        super(start, end);
    }
}
