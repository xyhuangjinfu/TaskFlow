package cn.hjf.taskflow.util;

public class CompoundFuncBuilder0<R> extends CompoundFuncBuilderQ {

    public CompoundFuncBuilder0(IFunc0 start) {
        super(start);
    }

    public CompoundFunc0<R> create() {
        IFunc[] startAndEnd = mGraphBuilder.getStartAndEnd();
        IFunc0 start = (IFunc0) startAndEnd[0];
        IFunc<R> end = (IFunc<R>) startAndEnd[1];
        return new CompoundFunc0<>(start, end);
    }

//    /**
//     * ***************************************************************************************************************
//     * //
//     * ***************************************************************************************************************
//     */
//
//    public <P> CompoundFuncBuilder2 addEnd(IFunc1<P, R> end, IFunc<P> pre1) {
//        return this;
//    }
//
//    public <P1, P2> CompoundFuncBuilder2 addEnd(IFunc2<P1, P2, R> end, IFunc<P1> pre1, IFunc<P2> pre2) {
//        return this;
//    }
//
//    public <P1, P2, P3> CompoundFuncBuilder2 addEnd(IFunc3<P1, P2, P3, R> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3) {
//        return this;
//    }
//
//    public <P1, P2, P3, P4> CompoundFuncBuilder2 addEnd(IFunc4<P1, P2, P3, P4, R> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4) {
//        return this;
//    }
//
//    public <P1, P2, P3, P4, P5> CompoundFuncBuilder2 addEnd(IFunc5<P1, P2, P3, P4, P5, R> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5) {
//        return this;
//    }
//
//    public <P1, P2, P3, P4, P5, P6> CompoundFuncBuilder2 addEnd(IFunc6<P1, P2, P3, P4, P5, P6, R> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6) {
//        return this;
//    }
//
//    public <P1, P2, P3, P4, P5, P6, P7> CompoundFuncBuilder2 addEnd(IFunc7<P1, P2, P3, P4, P5, P6, P7, R> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6, IFunc<P7> pre7) {
//        return this;
//    }
//
//    public <P1, P2, P3, P4, P5, P6, P7, P8> CompoundFuncBuilder2 addEnd(IFunc8<P1, P2, P3, P4, P5, P6, P7, P8, R> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6, IFunc<P7> pre7, IFunc<P8> pre8) {
//        return this;
//    }
//
//    public <P1, P2, P3, P4, P5, P6, P7, P8, P9> CompoundFuncBuilder2 addEnd(IFunc9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6, IFunc<P7> pre7, IFunc<P8> pre8, IFunc<P9> pre9) {
//        return this;
//    }
//
//    public <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> CompoundFuncBuilder2 addEnd(IFunc10<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, R> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6, IFunc<P7> pre7, IFunc<P8> pre8, IFunc<P9> pre9, IFunc<P10> pre10) {
//        return this;
//    }
//
//    public CompoundFuncBuilder2 addEnd(IFuncN<R> end, IFunc... preFuncs) {
//        return this;
//    }
//
//    /**
//     * ***************************************************************************************************************
//     * //
//     * ***************************************************************************************************************
//     */
//
//    public <P> CompoundFuncBuilder2 addNormal(IFunc1<P, ?> end, IFunc<P> pre1) {
//        return this;
//    }
//
//    public <P1, P2> CompoundFuncBuilder2 addNormal(IFunc2<P1, P2, ?> end, IFunc<P1> pre1, IFunc<P2> pre2) {
//        return this;
//    }
//
//    public <P1, P2, P3> CompoundFuncBuilder2 addNormal(IFunc3<P1, P2, P3, ?> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3) {
//        return this;
//    }
//
//    public <P1, P2, P3, P4> CompoundFuncBuilder2 addNormal(IFunc4<P1, P2, P3, P4, ?> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4) {
//        return this;
//    }
//
//    public <P1, P2, P3, P4, P5> CompoundFuncBuilder2 addNormal(IFunc5<P1, P2, P3, P4, P5, ?> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5) {
//        return this;
//    }
//
//    public <P1, P2, P3, P4, P5, P6> CompoundFuncBuilder2 addNormal(IFunc6<P1, P2, P3, P4, P5, P6, ?> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6) {
//        return this;
//    }
//
//    public <P1, P2, P3, P4, P5, P6, P7> CompoundFuncBuilder2 addNormal(IFunc7<P1, P2, P3, P4, P5, P6, P7, ?> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6, IFunc<P7> pre7) {
//        return this;
//    }
//
//    public <P1, P2, P3, P4, P5, P6, P7, P8> CompoundFuncBuilder2 addNormal(IFunc8<P1, P2, P3, P4, P5, P6, P7, P8, ?> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6, IFunc<P7> pre7, IFunc<P8> pre8) {
//        return this;
//    }
//
//    public <P1, P2, P3, P4, P5, P6, P7, P8, P9> CompoundFuncBuilder2 addNormal(IFunc9<P1, P2, P3, P4, P5, P6, P7, P8, P9, ?> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6, IFunc<P7> pre7, IFunc<P8> pre8, IFunc<P9> pre9) {
//        return this;
//    }
//
//    public <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> CompoundFuncBuilder2 addNormal(IFunc10<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, ?> end, IFunc<P1> pre1, IFunc<P2> pre2, IFunc<P3> pre3, IFunc<P4> pre4, IFunc<P5> pre5, IFunc<P6> pre6, IFunc<P7> pre7, IFunc<P8> pre8, IFunc<P9> pre9, IFunc<P10> pre10) {
//        return this;
//    }
//
//    public CompoundFuncBuilder2 addNormal(IFuncN<R> end, IFunc... preFuncs) {
//        return this;
//    }
}
