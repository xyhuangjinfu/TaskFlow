package cn.hjf.taskflow.util;

public class CompoundFuncBuilderN<Return> extends CompoundFuncBuilder {

    public CompoundFuncBuilderN(IFuncN start) {
        super(start);
    }

    /**
     * ***************************************************************************************************************
     * //
     * ***************************************************************************************************************
     */

    public IFuncN<Return> create() {
        if (!mHaveEnd) {
            throw new RuntimeException("must call addEnd() once before call cerate()");
        }
        IFunc[] startAndEnd = mGraphBuilder.getStartAndEnd();
        IFuncN start = (IFuncN) startAndEnd[0];
        IFunc<Return> end = (IFunc<Return>) startAndEnd[1];
        return new CompoundFuncN<>(start, end);
    }

    /**
     * ***************************************************************************************************************
     * //
     * ***************************************************************************************************************
     */

    public CompoundFuncBuilderN<Return> addEnd(IFunc0<Return> end, IFunc<Void> pre1) {
        checkEnd(end);
        mGraphBuilder.addLink(end, pre1);
        return this;
    }

    public <P> CompoundFuncBuilderN<Return> addEnd(IFunc1<P, Return> end, IFunc<P> pre1) {
        checkEnd(end);
        mGraphBuilder.addLink(end, pre1);
        return this;
    }

    public <P1, P2> CompoundFuncBuilderN<Return> addEnd(IFunc2<P1, P2, Return> end, IFunc<P1> pre1, IFunc<P2> pre2) {
        checkEnd(end);
        mGraphBuilder.addLink(end, pre1, pre2);
        return this;
    }

    public <P1, P2, P3> CompoundFuncBuilderN<Return> addEnd(IFunc3<P1, P2, P3, Return> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3) {
        checkEnd(end);
        mGraphBuilder.addLink(end, pre1, pre2, pre3);
        return this;
    }

    public <P1, P2, P3, P4> CompoundFuncBuilderN<Return> addEnd(IFunc4<P1, P2, P3, P4, Return> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4) {
        checkEnd(end);
        mGraphBuilder.addLink(end, pre1, pre2, pre3, pre4);
        return this;
    }

    public <P1, P2, P3, P4, P5> CompoundFuncBuilderN<Return> addEnd(IFunc5<P1, P2, P3, P4, P5, Return> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5) {
        checkEnd(end);
        mGraphBuilder.addLink(end, pre1, pre2, pre3, pre4, pre5);
        return this;
    }

    public <P1, P2, P3, P4, P5, P6> CompoundFuncBuilderN<Return> addEnd(IFunc6<P1, P2, P3, P4, P5, P6, Return> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6) {
        checkEnd(end);
        mGraphBuilder.addLink(end, pre1, pre2, pre3, pre4, pre5, pre6);
        return this;
    }

    public <P1, P2, P3, P4, P5, P6, P7> CompoundFuncBuilderN<Return> addEnd(IFunc7<P1, P2, P3, P4, P5, P6, P7, Return> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6, IFunc<P7> pre7) {
        checkEnd(end);
        mGraphBuilder.addLink(end, pre1, pre2, pre3, pre4, pre5, pre6, pre7);
        return this;
    }

    public <P1, P2, P3, P4, P5, P6, P7, P8> CompoundFuncBuilderN<Return> addEnd(IFunc8<P1, P2, P3, P4, P5, P6, P7, P8, Return> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6, IFunc<P7> pre7, IFunc<P8> pre8) {
        checkEnd(end);
        mGraphBuilder.addLink(end, pre1, pre2, pre3, pre4, pre5, pre6, pre7, pre8);
        return this;
    }

    public <P1, P2, P3, P4, P5, P6, P7, P8, P9> CompoundFuncBuilderN<Return> addEnd(IFunc9<P1, P2, P3, P4, P5, P6, P7, P8, P9, Return> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6, IFunc<P7> pre7, IFunc<P8> pre8, IFunc<P9> pre9) {
        checkEnd(end);
        mGraphBuilder.addLink(end, pre1, pre2, pre3, pre4, pre5, pre6, pre7, pre8, pre9);
        return this;
    }

    public <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> CompoundFuncBuilderN<Return> addEnd(IFunc10<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, Return> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6, IFunc<P7> pre7, IFunc<P8> pre8, IFunc<P9> pre9, IFunc<P10> pre10) {
        checkEnd(end);
        mGraphBuilder.addLink(end, pre1, pre2, pre3, pre4, pre5, pre6, pre7, pre8, pre9, pre10);
        return this;
    }

    public CompoundFuncBuilderN<Return> addEnd(IFuncN<Return> end, IFunc... preFuncs) {
        checkEnd(end);
        mGraphBuilder.addLink(end, preFuncs);
        return this;
    }

    /**
     * ***************************************************************************************************************
     * //
     * ***************************************************************************************************************
     */

    public CompoundFuncBuilderN<Return> addNormal(IFunc0 func, IFunc<Void> pre1) {
        checkNormal(func);
        mGraphBuilder.addLink(func, pre1);
        return this;
    }

    public <P> CompoundFuncBuilderN<Return> addNormal(IFunc1<P, ?> func, IFunc<P> pre1) {
        checkNormal(func);
        mGraphBuilder.addLink(func, pre1);
        return this;
    }

    public <P1, P2> CompoundFuncBuilderN<Return> addNormal(IFunc2<P1, P2, ?> func, IFunc<P1> pre1, IFunc<P2> pre2) {
        checkNormal(func);
        mGraphBuilder.addLink(func, pre1, pre2);
        return this;
    }

    public <P1, P2, P3> CompoundFuncBuilderN<Return> addNormal(IFunc3<P1, P2, P3, ?> func, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3) {
        checkNormal(func);
        mGraphBuilder.addLink(func, pre1, pre2, pre3);
        return this;
    }

    public <P1, P2, P3, P4> CompoundFuncBuilderN<Return> addNormal(IFunc4<P1, P2, P3, P4, ?> func, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4) {
        checkNormal(func);
        mGraphBuilder.addLink(func, pre1, pre2, pre3, pre4);
        return this;
    }

    public <P1, P2, P3, P4, P5> CompoundFuncBuilderN<Return> addNormal(IFunc5<P1, P2, P3, P4, P5, ?> func, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5) {
        checkNormal(func);
        mGraphBuilder.addLink(func, pre1, pre2, pre3, pre4, pre5);
        return this;
    }

    public <P1, P2, P3, P4, P5, P6> CompoundFuncBuilderN<Return> addNormal(IFunc6<P1, P2, P3, P4, P5, P6, ?> func, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6) {
        checkNormal(func);
        mGraphBuilder.addLink(func, pre1, pre2, pre3, pre4, pre5, pre6);
        return this;
    }

    public <P1, P2, P3, P4, P5, P6, P7> CompoundFuncBuilderN<Return> addNormal(IFunc7<P1, P2, P3, P4, P5, P6, P7, ?> func, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6, IFunc<P7> pre7) {
        checkNormal(func);
        mGraphBuilder.addLink(func, pre1, pre2, pre3, pre4, pre5, pre6, pre7);
        return this;
    }

    public <P1, P2, P3, P4, P5, P6, P7, P8> CompoundFuncBuilderN<Return> addNormal(IFunc8<P1, P2, P3, P4, P5, P6, P7, P8, ?> func, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6, IFunc<P7> pre7, IFunc<P8> pre8) {
        checkNormal(func);
        mGraphBuilder.addLink(func, pre1, pre2, pre3, pre4, pre5, pre6, pre7, pre8);
        return this;
    }

    public <P1, P2, P3, P4, P5, P6, P7, P8, P9> CompoundFuncBuilderN<Return> addNormal(IFunc9<P1, P2, P3, P4, P5, P6, P7, P8, P9, ?> func, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6, IFunc<P7> pre7, IFunc<P8> pre8, IFunc<P9> pre9) {
        checkNormal(func);
        mGraphBuilder.addLink(func, pre1, pre2, pre3, pre4, pre5, pre6, pre7, pre8, pre9);
        return this;
    }

    public <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> CompoundFuncBuilderN<Return> addNormal(IFunc10<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, ?> func, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6, IFunc<P7> pre7, IFunc<P8> pre8, IFunc<P9> pre9, IFunc<P10> pre10) {
        checkNormal(func);
        mGraphBuilder.addLink(func, pre1, pre2, pre3, pre4, pre5, pre6, pre7, pre8, pre9, pre10);
        return this;
    }

    public CompoundFuncBuilderN<Return> addNormal(IFuncN func, IFunc... preFuncs) {
        checkNormal(func);
        mGraphBuilder.addLink(func, preFuncs);
        return this;
    }
}
