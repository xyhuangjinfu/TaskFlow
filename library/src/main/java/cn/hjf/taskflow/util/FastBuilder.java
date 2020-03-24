package cn.hjf.taskflow.util;

public class FastBuilder {

    public static <RS, R1, RE> IFunc0<RE> union(IFunc0<RS> start, IFunc1<R1, RE> end, IFunc1<RS, R1> f1) {
        CompoundFuncBuilder0<RE> b = new CompoundFuncBuilder0<>(start);
        b.addEnd(end, f1);
        b.addNormal(f1, start);
        return b.create();
    }

    public static <RS, R1, R2, RE> IFunc0<RE> union(IFunc0<RS> start, IFunc2<R1, R2, RE> end, IFunc1<RS, R1> f1, IFunc1<RS, R2> f2) {
        CompoundFuncBuilder0<RE> b = new CompoundFuncBuilder0<>(start);
        b.addEnd(end, f1, f2);
        b.addNormal(f1, start);
        b.addNormal(f2, start);
        return b.create();
    }

    public static <RS, R1, R2, R3, RE> IFunc0<RE> union(IFunc0<RS> start, IFunc3<R1, R2, R3, RE> end, IFunc1<RS, R1> f1, IFunc1<RS, R2> f2, IFunc1<RS, R3> f3) {
        CompoundFuncBuilder0<RE> b = new CompoundFuncBuilder0<>(start);
        b.addEnd(end, f1, f2, f3);
        b.addNormal(f1, start);
        b.addNormal(f2, start);
        b.addNormal(f3, start);
        return b.create();
    }

    public static <RS, R1, R2, R3, R4, RE> IFunc0<RE> union(IFunc0<RS> start, IFunc4<R1, R2, R3, R4, RE> end, IFunc1<RS, R1> f1, IFunc1<RS, R2> f2, IFunc1<RS, R3> f3, IFunc1<RS, R4> f4) {
        CompoundFuncBuilder0<RE> b = new CompoundFuncBuilder0<>(start);
        b.addEnd(end, f1, f2, f3, f4);
        b.addNormal(f1, start);
        b.addNormal(f2, start);
        b.addNormal(f3, start);
        b.addNormal(f4, start);
        return b.create();
    }

    public static <RS, R1, R2, R3, R4, R5, RE> IFunc0<RE> union(IFunc0<RS> start, IFunc5<R1, R2, R3, R4, R5, RE> end, IFunc1<RS, R1> f1, IFunc1<RS, R2> f2, IFunc1<RS, R3> f3, IFunc1<RS, R4> f4, IFunc1<RS, R5> f5) {
        CompoundFuncBuilder0<RE> b = new CompoundFuncBuilder0<>(start);
        b.addEnd(end, f1, f2, f3, f4, f5);
        b.addNormal(f1, start);
        b.addNormal(f2, start);
        b.addNormal(f3, start);
        b.addNormal(f4, start);
        b.addNormal(f5, start);
        return b.create();
    }

    /**
     * ***************************************************************************************************************
     * <p>
     * ***************************************************************************************************************
     */

    public static <P, RS, R1, RE> IFunc1<P, RE> union(IFunc1<P, RS> start, IFunc1<R1, RE> end, IFunc1<RS, R1> f1) {
        CompoundFuncBuilder1<P, RE> b = new CompoundFuncBuilder1<>(start);
        b.addEnd(end, f1);
        b.addNormal(f1, start);
        return b.create();
    }

    public static <P, RS, R1, R2, RE> IFunc1<P, RE> union(IFunc1<P, RS> start, IFunc2<R1, R2, RE> end, IFunc1<RS, R1> f1, IFunc1<RS, R2> f2) {
        CompoundFuncBuilder1<P, RE> b = new CompoundFuncBuilder1<>(start);
        b.addEnd(end, f1, f2);
        b.addNormal(f1, start);
        b.addNormal(f2, start);
        return b.create();
    }

    public static <P, RS, R1, R2, R3, RE> IFunc1<P, RE> union(IFunc1<P, RS> start, IFunc3<R1, R2, R3, RE> end, IFunc1<RS, R1> f1, IFunc1<RS, R2> f2, IFunc1<RS, R3> f3) {
        CompoundFuncBuilder1<P, RE> b = new CompoundFuncBuilder1<>(start);
        b.addEnd(end, f1, f2, f3);
        b.addNormal(f1, start);
        b.addNormal(f2, start);
        b.addNormal(f3, start);
        return b.create();
    }

    public static <P, RS, R1, R2, R3, R4, RE> IFunc1<P, RE> union(IFunc1<P, RS> start, IFunc4<R1, R2, R3, R4, RE> end, IFunc1<RS, R1> f1, IFunc1<RS, R2> f2, IFunc1<RS, R3> f3, IFunc1<RS, R4> f4) {
        CompoundFuncBuilder1<P, RE> b = new CompoundFuncBuilder1<>(start);
        b.addEnd(end, f1, f2, f3, f4);
        b.addNormal(f1, start);
        b.addNormal(f2, start);
        b.addNormal(f3, start);
        b.addNormal(f4, start);
        return b.create();
    }

    public static <P, RS, R1, R2, R3, R4, R5, RE> IFunc1<P, RE> union(IFunc1<P, RS> start, IFunc5<R1, R2, R3, R4, R5, RE> end, IFunc1<RS, R1> f1, IFunc1<RS, R2> f2, IFunc1<RS, R3> f3, IFunc1<RS, R4> f4, IFunc1<RS, R5> f5) {
        CompoundFuncBuilder1<P, RE> b = new CompoundFuncBuilder1<>(start);
        b.addEnd(end, f1, f2, f3, f4, f5);
        b.addNormal(f1, start);
        b.addNormal(f2, start);
        b.addNormal(f3, start);
        b.addNormal(f4, start);
        b.addNormal(f5, start);
        return b.create();
    }

    /**
     * ***************************************************************************************************************
     * <p>
     * ***************************************************************************************************************
     */

    public static <P1, P2, RS, R1, RE> IFunc2<P1, P2, RE> union(IFunc2<P1, P2, RS> start, IFunc1<R1, RE> end, IFunc1<RS, R1> f1) {
        CompoundFuncBuilder2<P1, P2, RE> b = new CompoundFuncBuilder2<>(start);
        b.addEnd(end, f1);
        b.addNormal(f1, start);
        return b.create();
    }

    public static <P1, P2, RS, R1, R2, RE> IFunc2<P1, P2, RE> union(IFunc2<P1, P2, RS> start, IFunc2<R1, R2, RE> end, IFunc1<RS, R1> f1, IFunc1<RS, R2> f2) {
        CompoundFuncBuilder2<P1, P2, RE> b = new CompoundFuncBuilder2<>(start);
        b.addEnd(end, f1, f2);
        b.addNormal(f1, start);
        b.addNormal(f2, start);
        return b.create();
    }

    public static <P1, P2, RS, R1, R2, R3, RE> IFunc2<P1, P2, RE> union(IFunc2<P1, P2, RS> start, IFunc3<R1, R2, R3, RE> end, IFunc1<RS, R1> f1, IFunc1<RS, R2> f2, IFunc1<RS, R3> f3) {
        CompoundFuncBuilder2<P1, P2, RE> b = new CompoundFuncBuilder2<>(start);
        b.addEnd(end, f1, f2, f3);
        b.addNormal(f1, start);
        b.addNormal(f2, start);
        b.addNormal(f3, start);
        return b.create();
    }

    public static <P1, P2, RS, R1, R2, R3, R4, RE> IFunc2<P1, P2, RE> union(IFunc2<P1, P2, RS> start, IFunc4<R1, R2, R3, R4, RE> end, IFunc1<RS, R1> f1, IFunc1<RS, R2> f2, IFunc1<RS, R3> f3, IFunc1<RS, R4> f4) {
        CompoundFuncBuilder2<P1, P2, RE> b = new CompoundFuncBuilder2<>(start);
        b.addEnd(end, f1, f2, f3, f4);
        b.addNormal(f1, start);
        b.addNormal(f2, start);
        b.addNormal(f3, start);
        b.addNormal(f4, start);
        return b.create();
    }

    public static <P1, P2, RS, R1, R2, R3, R4, R5, RE> IFunc2<P1, P2, RE> union(IFunc2<P1, P2, RS> start, IFunc5<R1, R2, R3, R4, R5, RE> end, IFunc1<RS, R1> f1, IFunc1<RS, R2> f2, IFunc1<RS, R3> f3, IFunc1<RS, R4> f4, IFunc1<RS, R5> f5) {
        CompoundFuncBuilder2<P1, P2, RE> b = new CompoundFuncBuilder2<>(start);
        b.addEnd(end, f1, f2, f3, f4, f5);
        b.addNormal(f1, start);
        b.addNormal(f2, start);
        b.addNormal(f3, start);
        b.addNormal(f4, start);
        b.addNormal(f5, start);
        return b.create();
    }

    /**
     * ***************************************************************************************************************
     * <p>
     * ***************************************************************************************************************
     */

    public static <RS, RE> IFunc0<RE> link(IFunc0<RS> start, IFunc1<RS, RE> end) {
        CompoundFuncBuilder0<RE> b = new CompoundFuncBuilder0<>(start);
        b.addEnd(end, start);
        return b.create();
    }

    public static <RS, R1, RE> IFunc0<RE> link(IFunc0<RS> start, IFunc1<RS, R1> f1, IFunc1<R1, RE> end) {
        CompoundFuncBuilder0<RE> b = new CompoundFuncBuilder0<>(start);
        b.addEnd(end, f1);
        b.addNormal(f1, start);
        return b.create();
    }

    public static <RS, R1, R2, RE> IFunc0<RE> link(IFunc0<RS> start, IFunc1<RS, R1> f1, IFunc1<R1, R2> f2, IFunc1<R2, RE> end) {
        CompoundFuncBuilder0<RE> b = new CompoundFuncBuilder0<>(start);
        b.addEnd(end, f2);
        b.addNormal(f2, f1);
        b.addNormal(f1, start);
        return b.create();
    }

    public static <RS, R1, R2, R3, RE> IFunc0<RE> link(IFunc0<RS> start, IFunc1<RS, R1> f1, IFunc1<R1, R2> f2, IFunc1<R2, R3> f3, IFunc1<R3, RE> end) {
        CompoundFuncBuilder0<RE> b = new CompoundFuncBuilder0<>(start);
        b.addEnd(end, f3);
        b.addNormal(f3, f2);
        b.addNormal(f2, f1);
        b.addNormal(f1, start);
        return b.create();
    }

    public static <RS, R1, R2, R3, R4, RE> IFunc0<RE> link(IFunc0<RS> start, IFunc1<RS, R1> f1, IFunc1<R1, R2> f2, IFunc1<R2, R3> f3, IFunc1<R3, R4> f4, IFunc1<R4, RE> end) {
        CompoundFuncBuilder0<RE> b = new CompoundFuncBuilder0<>(start);
        b.addEnd(end, f4);
        b.addNormal(f4, f3);
        b.addNormal(f3, f2);
        b.addNormal(f2, f1);
        b.addNormal(f1, start);
        return b.create();
    }

    /**
     * ***************************************************************************************************************
     * <p>
     * ***************************************************************************************************************
     */

    public static <P, RS, RE> IFunc1<P, RE> link(IFunc1<P, RS> start, IFunc1<RS, RE> end) {
        CompoundFuncBuilder1<P, RE> b = new CompoundFuncBuilder1<>(start);
        b.addEnd(end, start);
        return b.create();
    }

    public static <P, RS, R1, RE> IFunc1<P, RE> link(IFunc1<P, RS> start, IFunc1<RS, R1> f1, IFunc1<R1, RE> end) {
        CompoundFuncBuilder1<P, RE> b = new CompoundFuncBuilder1<>(start);
        b.addEnd(end, f1);
        b.addNormal(f1, start);
        return b.create();
    }

    public static <P, RS, R1, R2, RE> IFunc1<P, RE> link(IFunc1<P, RS> start, IFunc1<RS, R1> f1, IFunc1<R1, R2> f2, IFunc1<R2, RE> end) {
        CompoundFuncBuilder1<P, RE> b = new CompoundFuncBuilder1<>(start);
        b.addEnd(end, f2);
        b.addNormal(f2, f1);
        b.addNormal(f1, start);
        return b.create();
    }

    public static <P, RS, R1, R2, R3, RE> IFunc1<P, RE> link(IFunc1<P, RS> start, IFunc1<RS, R1> f1, IFunc1<R1, R2> f2, IFunc1<R2, R3> f3, IFunc1<R3, RE> end) {
        CompoundFuncBuilder1<P, RE> b = new CompoundFuncBuilder1<>(start);
        b.addEnd(end, f3);
        b.addNormal(f3, f2);
        b.addNormal(f2, f1);
        b.addNormal(f1, start);
        return b.create();
    }

    public static <P, RS, R1, R2, R3, R4, RE> IFunc1<P, RE> link(IFunc1<P, RS> start, IFunc1<RS, R1> f1, IFunc1<R1, R2> f2, IFunc1<R2, R3> f3, IFunc1<R3, R4> f4, IFunc1<R4, RE> end) {
        CompoundFuncBuilder1<P, RE> b = new CompoundFuncBuilder1<>(start);
        b.addEnd(end, f4);
        b.addNormal(f4, f3);
        b.addNormal(f3, f2);
        b.addNormal(f2, f1);
        b.addNormal(f1, start);
        return b.create();
    }

    /**
     * ***************************************************************************************************************
     * <p>
     * ***************************************************************************************************************
     */

    public static <P1, P2, RS, RE> IFunc2<P1, P2, RE> link(IFunc2<P1, P2, RS> start, IFunc1<RS, RE> end) {
        CompoundFuncBuilder2<P1, P2, RE> b = new CompoundFuncBuilder2<>(start);
        b.addEnd(end, start);
        return b.create();
    }

    public static <P1, P2, RS, R1, RE> IFunc2<P1, P2, RE> link(IFunc2<P1, P2, RS> start, IFunc1<RS, R1> f1, IFunc1<R1, RE> end) {
        CompoundFuncBuilder2<P1, P2, RE> b = new CompoundFuncBuilder2<>(start);
        b.addEnd(end, f1);
        b.addNormal(f1, start);
        return b.create();
    }

    public static <P1, P2, RS, R1, R2, RE> IFunc2<P1, P2, RE> link(IFunc2<P1, P2, RS> start, IFunc1<RS, R1> f1, IFunc1<R1, R2> f2, IFunc1<R2, RE> end) {
        CompoundFuncBuilder2<P1, P2, RE> b = new CompoundFuncBuilder2<>(start);
        b.addEnd(end, f2);
        b.addNormal(f2, f1);
        b.addNormal(f1, start);
        return b.create();
    }

    public static <P1, P2, RS, R1, R2, R3, RE> IFunc2<P1, P2, RE> link(IFunc2<P1, P2, RS> start, IFunc1<RS, R1> f1, IFunc1<R1, R2> f2, IFunc1<R2, R3> f3, IFunc1<R3, RE> end) {
        CompoundFuncBuilder2<P1, P2, RE> b = new CompoundFuncBuilder2<>(start);
        b.addEnd(end, f3);
        b.addNormal(f3, f2);
        b.addNormal(f2, f1);
        b.addNormal(f1, start);
        return b.create();
    }

    public static <P1, P2, RS, R1, R2, R3, R4, RE> IFunc2<P1, P2, RE> link(IFunc2<P1, P2, RS> start, IFunc1<RS, R1> f1, IFunc1<R1, R2> f2, IFunc1<R2, R3> f3, IFunc1<R3, R4> f4, IFunc1<R4, RE> end) {
        CompoundFuncBuilder2<P1, P2, RE> b = new CompoundFuncBuilder2<>(start);
        b.addEnd(end, f4);
        b.addNormal(f4, f3);
        b.addNormal(f3, f2);
        b.addNormal(f2, f1);
        b.addNormal(f1, start);
        return b.create();
    }
}
