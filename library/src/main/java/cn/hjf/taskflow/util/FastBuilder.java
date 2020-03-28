package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

public class FastBuilder {

    /**
     * ***************************************************************************************************************
     * //
     * ***************************************************************************************************************
     */

    public static <R1, RE> IFunc0<RE> unionWithoutStart(IFunc1<R1, RE> end, IFunc0<R1> f1) {
        final IFunc0<Void> start = new Func0<Void>() {
            @NonNull
            @Override
            protected Void process() throws Throwable {
                return null;
            }
        };
        CompoundFuncBuilder0<RE> b = new CompoundFuncBuilder0<>(start);
        b.addEnd(end, f1);
        b.addNormal(f1, start);
        return b.create();
    }

    public static <R1, R2, RE> IFunc0<RE> unionWithoutStart(IFunc2<R1, R2, RE> end, IFunc0<R1> f1, IFunc0<R2> f2) {
        final IFunc0<Void> start = new Func0<Void>() {
            @NonNull
            @Override
            protected Void process() throws Throwable {
                return null;
            }
        };
        CompoundFuncBuilder0<RE> b = new CompoundFuncBuilder0<>(start);
        b.addEnd(end, f1, f2);
        b.addNormal(f1, start);
        b.addNormal(f2, start);
        return b.create();
    }

    public static <R1, R2, R3, RE> IFunc0<RE> unionWithoutStart(IFunc3<R1, R2, R3, RE> end, IFunc0<R1> f1, IFunc0<R2> f2, IFunc0<R3> f3) {
        final IFunc0<Void> start = new Func0<Void>() {
            @NonNull
            @Override
            protected Void process() throws Throwable {
                return null;
            }
        };
        CompoundFuncBuilder0<RE> b = new CompoundFuncBuilder0<>(start);
        b.addEnd(end, f1, f2, f3);
        b.addNormal(f1, start);
        b.addNormal(f2, start);
        b.addNormal(f3, start);
        return b.create();
    }

    public static <R1, R2, R3, R4, RE> IFunc0<RE> unionWithoutStart(IFunc4<R1, R2, R3, R4, RE> end, IFunc0<R1> f1, IFunc0<R2> f2, IFunc0<R3> f3, IFunc0<R4> f4) {
        final IFunc0<Void> start = new Func0<Void>() {
            @NonNull
            @Override
            protected Void process() throws Throwable {
                return null;
            }
        };
        CompoundFuncBuilder0<RE> b = new CompoundFuncBuilder0<>(start);
        b.addEnd(end, f1, f2, f3, f4);
        b.addNormal(f1, start);
        b.addNormal(f2, start);
        b.addNormal(f3, start);
        b.addNormal(f4, start);
        return b.create();
    }

    public static <R1, R2, R3, R4, R5, RE> IFunc0<RE> unionWithoutStart(IFunc5<R1, R2, R3, R4, R5, RE> end, IFunc0<R1> f1, IFunc0<R2> f2, IFunc0<R3> f3, IFunc0<R4> f4, IFunc0<R5> f5) {
        final IFunc0<Void> start = new Func0<Void>() {
            @NonNull
            @Override
            protected Void process() throws Throwable {
                return null;
            }
        };
        CompoundFuncBuilder0<RE> b = new CompoundFuncBuilder0<>(start);
        b.addEnd(end, f1, f2, f3, f4, f5);
        b.addNormal(f1, start);
        b.addNormal(f2, start);
        b.addNormal(f3, start);
        b.addNormal(f4, start);
        b.addNormal(f5, start);
        return b.create();
    }

    public static <R1, R2, R3, R4, R5, R6, RE> IFunc0<RE> unionWithoutStart(IFunc6<R1, R2, R3, R4, R5, R6, RE> end, IFunc0<R1> f1, IFunc0<R2> f2, IFunc0<R3> f3, IFunc0<R4> f4, IFunc0<R5> f5, IFunc0<R6> f6) {
        final IFunc0<Void> start = new Func0<Void>() {
            @NonNull
            @Override
            protected Void process() throws Throwable {
                return null;
            }
        };
        CompoundFuncBuilder0<RE> b = new CompoundFuncBuilder0<>(start);
        b.addEnd(end, f1, f2, f3, f4, f5, f6);
        b.addNormal(f1, start);
        b.addNormal(f2, start);
        b.addNormal(f3, start);
        b.addNormal(f4, start);
        b.addNormal(f5, start);
        b.addNormal(f6, start);
        return b.create();
    }

    /**
     * ***************************************************************************************************************
     * //
     * ***************************************************************************************************************
     */

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

    public static <RS, R1, R2, R3, R4, R5, R6, RE> IFunc0<RE> union(IFunc0<RS> start, IFunc6<R1, R2, R3, R4, R5, R6, RE> end, IFunc1<RS, R1> f1, IFunc1<RS, R2> f2, IFunc1<RS, R3> f3, IFunc1<RS, R4> f4, IFunc1<RS, R5> f5, IFunc1<RS, R6> f6) {
        CompoundFuncBuilder0<RE> b = new CompoundFuncBuilder0<>(start);
        b.addEnd(end, f1, f2, f3, f4, f5, f6);
        b.addNormal(f1, start);
        b.addNormal(f2, start);
        b.addNormal(f3, start);
        b.addNormal(f4, start);
        b.addNormal(f5, start);
        b.addNormal(f6, start);
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

    public static <P, RS, R1, R2, R3, R4, R5, R6, RE> IFunc1<P, RE> union(IFunc1<P, RS> start, IFunc6<R1, R2, R3, R4, R5, R6, RE> end, IFunc1<RS, R1> f1, IFunc1<RS, R2> f2, IFunc1<RS, R3> f3, IFunc1<RS, R4> f4, IFunc1<RS, R5> f5, IFunc1<RS, R6> f6) {
        CompoundFuncBuilder1<P, RE> b = new CompoundFuncBuilder1<>(start);
        b.addEnd(end, f1, f2, f3, f4, f5, f6);
        b.addNormal(f1, start);
        b.addNormal(f2, start);
        b.addNormal(f3, start);
        b.addNormal(f4, start);
        b.addNormal(f5, start);
        b.addNormal(f6, start);
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

    public static <P1, P2, RS, R1, R2, R3, R4, R5, R6, RE> IFunc2<P1, P2, RE> union(IFunc2<P1, P2, RS> start, IFunc6<R1, R2, R3, R4, R5, R6, RE> end, IFunc1<RS, R1> f1, IFunc1<RS, R2> f2, IFunc1<RS, R3> f3, IFunc1<RS, R4> f4, IFunc1<RS, R5> f5, IFunc1<RS, R6> f6) {
        CompoundFuncBuilder2<P1, P2, RE> b = new CompoundFuncBuilder2<>(start);
        b.addEnd(end, f1, f2, f3, f4, f5, f6);
        b.addNormal(f1, start);
        b.addNormal(f2, start);
        b.addNormal(f3, start);
        b.addNormal(f4, start);
        b.addNormal(f5, start);
        b.addNormal(f6, start);
        return b.create();
    }

    /**
     * ***************************************************************************************************************
     * <p>
     * ***************************************************************************************************************
     */

    public static <P1, P2, P3, RS, R1, RE> IFunc3<P1, P2, P3, RE> union(IFunc3<P1, P2, P3, RS> start, IFunc1<R1, RE> end, IFunc1<RS, R1> f1) {
        CompoundFuncBuilder3<P1, P2, P3, RE> b = new CompoundFuncBuilder3<>(start);
        b.addEnd(end, f1);
        b.addNormal(f1, start);
        return b.create();
    }

    public static <P1, P2, P3, RS, R1, R2, RE> IFunc3<P1, P2, P3, RE> union(IFunc3<P1, P2, P3, RS> start, IFunc2<R1, R2, RE> end, IFunc1<RS, R1> f1, IFunc1<RS, R2> f2) {
        CompoundFuncBuilder3<P1, P2, P3, RE> b = new CompoundFuncBuilder3<>(start);
        b.addEnd(end, f1, f2);
        b.addNormal(f1, start);
        b.addNormal(f2, start);
        return b.create();
    }

    public static <P1, P2, P3, RS, R1, R2, R3, RE> IFunc3<P1, P2, P3, RE> union(IFunc3<P1, P2, P3, RS> start, IFunc3<R1, R2, R3, RE> end, IFunc1<RS, R1> f1, IFunc1<RS, R2> f2, IFunc1<RS, R3> f3) {
        CompoundFuncBuilder3<P1, P2, P3, RE> b = new CompoundFuncBuilder3<>(start);
        b.addEnd(end, f1, f2, f3);
        b.addNormal(f1, start);
        b.addNormal(f2, start);
        b.addNormal(f3, start);
        return b.create();
    }

    public static <P1, P2, P3, RS, R1, R2, R3, R4, RE> IFunc3<P1, P2, P3, RE> union(IFunc3<P1, P2, P3, RS> start, IFunc4<R1, R2, R3, R4, RE> end, IFunc1<RS, R1> f1, IFunc1<RS, R2> f2, IFunc1<RS, R3> f3, IFunc1<RS, R4> f4) {
        CompoundFuncBuilder3<P1, P2, P3, RE> b = new CompoundFuncBuilder3<>(start);
        b.addEnd(end, f1, f2, f3, f4);
        b.addNormal(f1, start);
        b.addNormal(f2, start);
        b.addNormal(f3, start);
        b.addNormal(f4, start);
        return b.create();
    }

    public static <P1, P2, P3, RS, R1, R2, R3, R4, R5, RE> IFunc3<P1, P2, P3, RE> union(IFunc3<P1, P2, P3, RS> start, IFunc5<R1, R2, R3, R4, R5, RE> end, IFunc1<RS, R1> f1, IFunc1<RS, R2> f2, IFunc1<RS, R3> f3, IFunc1<RS, R4> f4, IFunc1<RS, R5> f5) {
        CompoundFuncBuilder3<P1, P2, P3, RE> b = new CompoundFuncBuilder3<>(start);
        b.addEnd(end, f1, f2, f3, f4, f5);
        b.addNormal(f1, start);
        b.addNormal(f2, start);
        b.addNormal(f3, start);
        b.addNormal(f4, start);
        b.addNormal(f5, start);
        return b.create();
    }

    public static <P1, P2, P3, RS, R1, R2, R3, R4, R5, R6, RE> IFunc3<P1, P2, P3, RE> union(IFunc3<P1, P2, P3, RS> start, IFunc6<R1, R2, R3, R4, R5, R6, RE> end, IFunc1<RS, R1> f1, IFunc1<RS, R2> f2, IFunc1<RS, R3> f3, IFunc1<RS, R4> f4, IFunc1<RS, R5> f5, IFunc1<RS, R6> f6) {
        CompoundFuncBuilder3<P1, P2, P3, RE> b = new CompoundFuncBuilder3<>(start);
        b.addEnd(end, f1, f2, f3, f4, f5, f6);
        b.addNormal(f1, start);
        b.addNormal(f2, start);
        b.addNormal(f3, start);
        b.addNormal(f4, start);
        b.addNormal(f5, start);
        b.addNormal(f6, start);
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

    public static <RS, R1, R2, R3, R4, R5, RE> IFunc0<RE> link(IFunc0<RS> start, IFunc1<RS, R1> f1, IFunc1<R1, R2> f2, IFunc1<R2, R3> f3, IFunc1<R3, R4> f4, IFunc1<R4, R5> f5, IFunc1<R5, RE> end) {
        CompoundFuncBuilder0<RE> b = new CompoundFuncBuilder0<>(start);
        b.addEnd(end, f5);
        b.addNormal(f5, f4);
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

    public static <P, RS, R1, R2, R3, R4, R5, RE> IFunc1<P, RE> link(IFunc1<P, RS> start, IFunc1<RS, R1> f1, IFunc1<R1, R2> f2, IFunc1<R2, R3> f3, IFunc1<R3, R4> f4, IFunc1<R4, R5> f5, IFunc1<R5, RE> end) {
        CompoundFuncBuilder1<P, RE> b = new CompoundFuncBuilder1<>(start);
        b.addEnd(end, f5);
        b.addNormal(f5, f4);
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

    public static <P1, P2, RS, R1, R2, R3, R4, R5, RE> IFunc2<P1, P2, RE> link(IFunc2<P1, P2, RS> start, IFunc1<RS, R1> f1, IFunc1<R1, R2> f2, IFunc1<R2, R3> f3, IFunc1<R3, R4> f4, IFunc1<R4, R5> f5, IFunc1<R5, RE> end) {
        CompoundFuncBuilder2<P1, P2, RE> b = new CompoundFuncBuilder2<>(start);
        b.addEnd(end, f5);
        b.addNormal(f5, f4);
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

    public static <P1, P2, P3, RS, RE> IFunc3<P1, P2, P3, RE> link(IFunc3<P1, P2, P3, RS> start, IFunc1<RS, RE> end) {
        CompoundFuncBuilder3<P1, P2, P3, RE> b = new CompoundFuncBuilder3<>(start);
        b.addEnd(end, start);
        return b.create();
    }

    public static <P1, P2, P3, RS, R1, RE> IFunc3<P1, P2, P3, RE> link(IFunc3<P1, P2, P3, RS> start, IFunc1<RS, R1> f1, IFunc1<R1, RE> end) {
        CompoundFuncBuilder3<P1, P2, P3, RE> b = new CompoundFuncBuilder3<>(start);
        b.addEnd(end, f1);
        b.addNormal(f1, start);
        return b.create();
    }

    public static <P1, P2, P3, RS, R1, R2, RE> IFunc3<P1, P2, P3, RE> link(IFunc3<P1, P2, P3, RS> start, IFunc1<RS, R1> f1, IFunc1<R1, R2> f2, IFunc1<R2, RE> end) {
        CompoundFuncBuilder3<P1, P2, P3, RE> b = new CompoundFuncBuilder3<>(start);
        b.addEnd(end, f2);
        b.addNormal(f2, f1);
        b.addNormal(f1, start);
        return b.create();
    }

    public static <P1, P2, P3, RS, R1, R2, R3, RE> IFunc3<P1, P2, P3, RE> link(IFunc3<P1, P2, P3, RS> start, IFunc1<RS, R1> f1, IFunc1<R1, R2> f2, IFunc1<R2, R3> f3, IFunc1<R3, RE> end) {
        CompoundFuncBuilder3<P1, P2, P3, RE> b = new CompoundFuncBuilder3<>(start);
        b.addEnd(end, f3);
        b.addNormal(f3, f2);
        b.addNormal(f2, f1);
        b.addNormal(f1, start);
        return b.create();
    }

    public static <P1, P2, P3, RS, R1, R2, R3, R4, RE> IFunc3<P1, P2, P3, RE> link(IFunc3<P1, P2, P3, RS> start, IFunc1<RS, R1> f1, IFunc1<R1, R2> f2, IFunc1<R2, R3> f3, IFunc1<R3, R4> f4, IFunc1<R4, RE> end) {
        CompoundFuncBuilder3<P1, P2, P3, RE> b = new CompoundFuncBuilder3<>(start);
        b.addEnd(end, f4);
        b.addNormal(f4, f3);
        b.addNormal(f3, f2);
        b.addNormal(f2, f1);
        b.addNormal(f1, start);
        return b.create();
    }

    public static <P1, P2, P3, RS, R1, R2, R3, R4, R5, RE> IFunc3<P1, P2, P3, RE> link(IFunc3<P1, P2, P3, RS> start, IFunc1<RS, R1> f1, IFunc1<R1, R2> f2, IFunc1<R2, R3> f3, IFunc1<R3, R4> f4, IFunc1<R4, R5> f5, IFunc1<R5, RE> end) {
        CompoundFuncBuilder3<P1, P2, P3, RE> b = new CompoundFuncBuilder3<>(start);
        b.addEnd(end, f5);
        b.addNormal(f5, f4);
        b.addNormal(f4, f3);
        b.addNormal(f3, f2);
        b.addNormal(f2, f1);
        b.addNormal(f1, start);
        return b.create();
    }
}
