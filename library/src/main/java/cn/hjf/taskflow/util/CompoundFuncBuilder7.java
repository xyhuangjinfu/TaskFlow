package cn.hjf.taskflow.util;

public class CompoundFuncBuilder7<Param1, Param2, Param3, Param4, Param5, Param6, Param7, Return> extends AbsCompoundFuncBuilder {

    public CompoundFuncBuilder7(IFunc7<Param1, Param2, Param3, Param4, Param5, Param6, Param7, ?> start) {
        super(start);
    }

    /**
     * ***************************************************************************************************************
     * //
     * ***************************************************************************************************************
     */

    public CompoundFunc7<Param1, Param2, Param3, Param4, Param5, Param6, Param7, Return> create() {
        IFunc[] startAndEnd = mGraphBuilder.getStartAndEnd();
        IFunc7<Param1, Param2, Param3, Param4, Param5, Param6, Param7, ?> start = (IFunc7<Param1, Param2, Param3, Param4, Param5, Param6, Param7, ?>) startAndEnd[0];
        IFunc<Return> end = (IFunc<Return>) startAndEnd[1];
        return new CompoundFunc7<>(start, end);
    }

    /**
     * ***************************************************************************************************************
     * //
     * ***************************************************************************************************************
     */

    public <P> CompoundFuncBuilder7<Param1, Param2, Param3, Param4, Param5, Param6, Param7, Return> addEnd(IFunc1<P, Return> end, IFunc<P> pre1) {
        checkEnd();
        mGraphBuilder.joinTo(end, pre1);
        return this;
    }

    public <P1, P2> CompoundFuncBuilder7<Param1, Param2, Param3, Param4, Param5, Param6, Param7, Return> addEnd(IFunc2<P1, P2, Return> end, IFunc<P1> pre1, IFunc<P2> pre2) {
        checkEnd();
        mGraphBuilder.joinTo(end, pre1, pre2);
        return this;
    }

    public <P1, P2, P3> CompoundFuncBuilder7<Param1, Param2, Param3, Param4, Param5, Param6, Param7, Return> addEnd(IFunc3<P1, P2, P3, Return> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3) {
        checkEnd();
        mGraphBuilder.joinTo(end, pre1, pre2, pre3);
        return this;
    }

    public <P1, P2, P3, P4> CompoundFuncBuilder7<Param1, Param2, Param3, Param4, Param5, Param6, Param7, Return> addEnd(IFunc4<P1, P2, P3, P4, Return> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4) {
        checkEnd();
        mGraphBuilder.joinTo(end, pre1, pre2, pre3, pre4);
        return this;
    }

    public <P1, P2, P3, P4, P5> CompoundFuncBuilder7<Param1, Param2, Param3, Param4, Param5, Param6, Param7, Return> addEnd(IFunc5<P1, P2, P3, P4, P5, Return> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5) {
        checkEnd();
        mGraphBuilder.joinTo(end, pre1, pre2, pre3, pre4, pre5);
        return this;
    }

    public <P1, P2, P3, P4, P5, P6> CompoundFuncBuilder7<Param1, Param2, Param3, Param4, Param5, Param6, Param7, Return> addEnd(IFunc6<P1, P2, P3, P4, P5, P6, Return> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6) {
        checkEnd();
        mGraphBuilder.joinTo(end, pre1, pre2, pre3, pre4, pre5, pre6);
        return this;
    }

    public <P1, P2, P3, P4, P5, P6, P7> CompoundFuncBuilder7<Param1, Param2, Param3, Param4, Param5, Param6, Param7, Return> addEnd(IFunc7<P1, P2, P3, P4, P5, P6, P7, Return> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6, IFunc<P7> pre7) {
        checkEnd();
        mGraphBuilder.joinTo(end, pre1, pre2, pre3, pre4, pre5, pre6, pre7);
        return this;
    }

    public <P1, P2, P3, P4, P5, P6, P7, P8> CompoundFuncBuilder7<Param1, Param2, Param3, Param4, Param5, Param6, Param7, Return> addEnd(IFunc8<P1, P2, P3, P4, P5, P6, P7, P8, Return> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6, IFunc<P7> pre7, IFunc<P8> pre8) {
        checkEnd();
        mGraphBuilder.joinTo(end, pre1, pre2, pre3, pre4, pre5, pre6, pre7, pre8);
        return this;
    }

    public <P1, P2, P3, P4, P5, P6, P7, P8, P9> CompoundFuncBuilder7<Param1, Param2, Param3, Param4, Param5, Param6, Param7, Return> addEnd(IFunc9<P1, P2, P3, P4, P5, P6, P7, P8, P9, Return> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6, IFunc<P7> pre7, IFunc<P8> pre8, IFunc<P9> pre9) {
        checkEnd();
        mGraphBuilder.joinTo(end, pre1, pre2, pre3, pre4, pre5, pre6, pre7, pre8, pre9);
        return this;
    }

    public <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> CompoundFuncBuilder7<Param1, Param2, Param3, Param4, Param5, Param6, Param7, Return> addEnd(IFunc10<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, Return> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6, IFunc<P7> pre7, IFunc<P8> pre8, IFunc<P9> pre9, IFunc<P10> pre10) {
        checkEnd();
        mGraphBuilder.joinTo(end, pre1, pre2, pre3, pre4, pre5, pre6, pre7, pre8, pre9, pre10);
        return this;
    }

    public CompoundFuncBuilder7<Param1, Param2, Param3, Param4, Param5, Param6, Param7, Return> addEnd(IFuncN<Return> end, IFunc... preFuncs) {
        checkEnd();
        mGraphBuilder.joinTo(end, preFuncs);
        return this;
    }

    /**
     * ***************************************************************************************************************
     * //
     * ***************************************************************************************************************
     */

    public <P> CompoundFuncBuilder7<Param1, Param2, Param3, Param4, Param5, Param6, Param7, Return> addNormal(IFunc1<P, ?> end, IFunc<P> pre1) {
        mGraphBuilder.joinTo(end, pre1);
        return this;
    }

    public <P1, P2> CompoundFuncBuilder7<Param1, Param2, Param3, Param4, Param5, Param6, Param7, Return> addNormal(IFunc2<P1, P2, ?> end, IFunc<P1> pre1, IFunc<P2> pre2) {
        mGraphBuilder.joinTo(end, pre1, pre2);
        return this;
    }

    public <P1, P2, P3> CompoundFuncBuilder7<Param1, Param2, Param3, Param4, Param5, Param6, Param7, Return> addNormal(IFunc3<P1, P2, P3, ?> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3) {
        mGraphBuilder.joinTo(end, pre1, pre2, pre3);
        return this;
    }

    public <P1, P2, P3, P4> CompoundFuncBuilder7<Param1, Param2, Param3, Param4, Param5, Param6, Param7, Return> addNormal(IFunc4<P1, P2, P3, P4, ?> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4) {
        mGraphBuilder.joinTo(end, pre1, pre2, pre3, pre4);
        return this;
    }

    public <P1, P2, P3, P4, P5> CompoundFuncBuilder7<Param1, Param2, Param3, Param4, Param5, Param6, Param7, Return> addNormal(IFunc5<P1, P2, P3, P4, P5, ?> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5) {
        mGraphBuilder.joinTo(end, pre1, pre2, pre3, pre4, pre5);
        return this;
    }

    public <P1, P2, P3, P4, P5, P6> CompoundFuncBuilder7<Param1, Param2, Param3, Param4, Param5, Param6, Param7, Return> addNormal(IFunc6<P1, P2, P3, P4, P5, P6, ?> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6) {
        mGraphBuilder.joinTo(end, pre1, pre2, pre3, pre4, pre5, pre6);
        return this;
    }

    public <P1, P2, P3, P4, P5, P6, P7> CompoundFuncBuilder7<Param1, Param2, Param3, Param4, Param5, Param6, Param7, Return> addNormal(IFunc7<P1, P2, P3, P4, P5, P6, P7, ?> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6, IFunc<P7> pre7) {
        mGraphBuilder.joinTo(end, pre1, pre2, pre3, pre4, pre5, pre6, pre7);
        return this;
    }

    public <P1, P2, P3, P4, P5, P6, P7, P8> CompoundFuncBuilder7<Param1, Param2, Param3, Param4, Param5, Param6, Param7, Return> addNormal(IFunc8<P1, P2, P3, P4, P5, P6, P7, P8, ?> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6, IFunc<P7> pre7, IFunc<P8> pre8) {
        mGraphBuilder.joinTo(end, pre1, pre2, pre3, pre4, pre5, pre6, pre7, pre8);
        return this;
    }

    public <P1, P2, P3, P4, P5, P6, P7, P8, P9> CompoundFuncBuilder7<Param1, Param2, Param3, Param4, Param5, Param6, Param7, Return> addNormal(IFunc9<P1, P2, P3, P4, P5, P6, P7, P8, P9, ?> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6, IFunc<P7> pre7, IFunc<P8> pre8, IFunc<P9> pre9) {
        mGraphBuilder.joinTo(end, pre1, pre2, pre3, pre4, pre5, pre6, pre7, pre8, pre9);
        return this;
    }

    public <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> CompoundFuncBuilder7<Param1, Param2, Param3, Param4, Param5, Param6, Param7, Return> addNormal(IFunc10<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, ?> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6, IFunc<P7> pre7, IFunc<P8> pre8, IFunc<P9> pre9, IFunc<P10> pre10) {
        mGraphBuilder.joinTo(end, pre1, pre2, pre3, pre4, pre5, pre6, pre7, pre8, pre9, pre10);
        return this;
    }

    public CompoundFuncBuilder7<Param1, Param2, Param3, Param4, Param5, Param6, Param7, Return> addNormal(IFuncN end, IFunc... preFuncs) {
        mGraphBuilder.joinTo(end, preFuncs);
        return this;
    }
}
