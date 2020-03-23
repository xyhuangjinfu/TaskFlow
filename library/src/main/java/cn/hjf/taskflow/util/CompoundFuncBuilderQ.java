package cn.hjf.taskflow.util;

public class CompoundFuncBuilderQ {

    protected GraphBuilder mGraphBuilder = new GraphBuilder();

    protected IFunc mStart;
    protected IFunc mEnd;

    public CompoundFuncBuilderQ(IFunc start) {
        mStart = start;
        mGraphBuilder.addFunc(start);
    }

    /**
     * ***************************************************************************************************************
     * //
     * ***************************************************************************************************************
     */

    public <P> void addEnd(IFunc1<P, ?> end, IFunc<P> pre1) {
        mGraphBuilder.joinTo(end, pre1);
    }

    public <P1, P2> void addEnd(IFunc2<P1, P2, ?> end, IFunc<P1> pre1, IFunc<P2> pre2) {
        mGraphBuilder.joinTo(end, pre1, pre2);
    }

    public <P1, P2, P3> void addEnd(IFunc3<P1, P2, P3, ?> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3) {
        mGraphBuilder.joinTo(end, pre1, pre2, pre3);
    }

    public <P1, P2, P3, P4> void addEnd(IFunc4<P1, P2, P3, P4, ?> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4) {
        mGraphBuilder.joinTo(end, pre1, pre2, pre3, pre4);
    }

    public <P1, P2, P3, P4, P5> void addEnd(IFunc5<P1, P2, P3, P4, P5, ?> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5) {
        mGraphBuilder.joinTo(end, pre1, pre2, pre3, pre4, pre5);
    }

    public <P1, P2, P3, P4, P5, P6> void addEnd(IFunc6<P1, P2, P3, P4, P5, P6, ?> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6) {
        mGraphBuilder.joinTo(end, pre1, pre2, pre3, pre4, pre5, pre6);
    }

    public <P1, P2, P3, P4, P5, P6, P7> void addEnd(IFunc7<P1, P2, P3, P4, P5, P6, P7, ?> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6, IFunc<P7> pre7) {
        mGraphBuilder.joinTo(end, pre1, pre2, pre3, pre4, pre5, pre6, pre7);
    }

    public <P1, P2, P3, P4, P5, P6, P7, P8> void addEnd(IFunc8<P1, P2, P3, P4, P5, P6, P7, P8, ?> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6, IFunc<P7> pre7, IFunc<P8> pre8) {
        mGraphBuilder.joinTo(end, pre1, pre2, pre3, pre4, pre5, pre6, pre7, pre8);
    }

    public <P1, P2, P3, P4, P5, P6, P7, P8, P9> void addEnd(IFunc9<P1, P2, P3, P4, P5, P6, P7, P8, P9, ?> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6, IFunc<P7> pre7, IFunc<P8> pre8, IFunc<P9> pre9) {
        mGraphBuilder.joinTo(end, pre1, pre2, pre3, pre4, pre5, pre6, pre7, pre8, pre9);
    }

    public <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> void addEnd(IFunc10<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, ?> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6, IFunc<P7> pre7, IFunc<P8> pre8, IFunc<P9> pre9, IFunc<P10> pre10) {
        mGraphBuilder.joinTo(end, pre1, pre2, pre3, pre4, pre5, pre6, pre7, pre8, pre9, pre10);
    }

    public void addEnd(IFuncN<?> end, IFunc... preFuncs) {
        mGraphBuilder.joinTo(end, preFuncs);
    }

    /**
     * ***************************************************************************************************************
     * //
     * ***************************************************************************************************************
     */

    public <P> void addNormal(IFunc1<P, ?> end, IFunc<P> pre1) {
        mGraphBuilder.joinTo(end, pre1);
    }

    public <P1, P2> void addNormal(IFunc2<P1, P2, ?> end, IFunc<P1> pre1, IFunc<P2> pre2) {
        mGraphBuilder.joinTo(end, pre1, pre2);
    }

    public <P1, P2, P3> void addNormal(IFunc3<P1, P2, P3, ?> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3) {
        mGraphBuilder.joinTo(end, pre1, pre2, pre3);
    }

    public <P1, P2, P3, P4> void addNormal(IFunc4<P1, P2, P3, P4, ?> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4) {
        mGraphBuilder.joinTo(end, pre1, pre2, pre3, pre4);
    }

    public <P1, P2, P3, P4, P5> void addNormal(IFunc5<P1, P2, P3, P4, P5, ?> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5) {
        mGraphBuilder.joinTo(end, pre1, pre2, pre3, pre4, pre5);
    }

    public <P1, P2, P3, P4, P5, P6> void addNormal(IFunc6<P1, P2, P3, P4, P5, P6, ?> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6) {
        mGraphBuilder.joinTo(end, pre1, pre2, pre3, pre4, pre5, pre6);
    }

    public <P1, P2, P3, P4, P5, P6, P7> void addNormal(IFunc7<P1, P2, P3, P4, P5, P6, P7, ?> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6, IFunc<P7> pre7) {
        mGraphBuilder.joinTo(end, pre1, pre2, pre3, pre4, pre5, pre6, pre7);
    }

    public <P1, P2, P3, P4, P5, P6, P7, P8> void addNormal(IFunc8<P1, P2, P3, P4, P5, P6, P7, P8, ?> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6, IFunc<P7> pre7, IFunc<P8> pre8) {
        mGraphBuilder.joinTo(end, pre1, pre2, pre3, pre4, pre5, pre6, pre7, pre8);
    }

    public <P1, P2, P3, P4, P5, P6, P7, P8, P9> void addNormal(IFunc9<P1, P2, P3, P4, P5, P6, P7, P8, P9, ?> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6, IFunc<P7> pre7, IFunc<P8> pre8, IFunc<P9> pre9) {
        mGraphBuilder.joinTo(end, pre1, pre2, pre3, pre4, pre5, pre6, pre7, pre8, pre9);
    }

    public <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> void addNormal(IFunc10<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, ?> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6, IFunc<P7> pre7, IFunc<P8> pre8, IFunc<P9> pre9, IFunc<P10> pre10) {
        mGraphBuilder.joinTo(end, pre1, pre2, pre3, pre4, pre5, pre6, pre7, pre8, pre9, pre10);
    }

    public void addNormal(IFuncN end, IFunc... preFuncs) {
        mGraphBuilder.joinTo(end, preFuncs);
    }
}
