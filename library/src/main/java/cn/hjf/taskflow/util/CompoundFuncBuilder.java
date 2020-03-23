package cn.hjf.taskflow.util;

public class CompoundFuncBuilder {

    private GraphBuilder mGraphBuilder;

    public CompoundFuncBuilder(GraphBuilder graphBuilder) {
        mGraphBuilder = graphBuilder;
    }

    public CompoundFuncBuilder() {
        mGraphBuilder = new GraphBuilder();
    }

    /**
     * ***************************************************************************************************************
     * //
     * ***************************************************************************************************************
     */

    public CompoundFunc create() {
        IFunc[] startAndEnd = mGraphBuilder.getStartAndEnd();

        IFunc start = startAndEnd[0];
        IFunc end = startAndEnd[1];

        if (start == end) {
            throw new RuntimeException("only one func don't need to create CompoundFunc");
        } else {
            return createCompoundFunc(start, end);
        }
    }

    private CompoundFunc createCompoundFunc(IFunc start, IFunc end) {
        if (start instanceof IFunc0) {
            return new CompoundFunc0((IFunc0) start, end);
        }
        if (start instanceof IFunc1) {
            return new CompoundFunc1((IFunc1) start, end);
        }
        if (start instanceof IFunc2) {
            return new CompoundFunc2((IFunc2) start, end);
        }
        if (start instanceof IFunc3) {
            return new CompoundFunc3((IFunc3) start, end);
        }
        if (start instanceof IFunc4) {
            return new CompoundFunc4((IFunc4) start, end);
        }
        if (start instanceof IFunc5) {
            return new CompoundFunc5((IFunc5) start, end);
        }
        if (start instanceof IFunc6) {
            return new CompoundFunc6((IFunc6) start, end);
        }
        if (start instanceof IFunc7) {
            return new CompoundFunc7((IFunc7) start, end);
        }
        if (start instanceof IFunc8) {
            return new CompoundFunc8((IFunc8) start, end);
        }
        if (start instanceof IFunc9) {
            return new CompoundFunc9((IFunc9) start, end);
        }
        if (start instanceof IFunc10) {
            return new CompoundFunc10((IFunc10) start, end);
        }
        if (start instanceof IFuncN) {
            return new CompoundFuncN((IFuncN) start, end);
        }

        throw new RuntimeException("no corresponding compound func type for " + start.getClass().getName());
    }

    /**
     * ***************************************************************************************************************
     * <p>
     * ***************************************************************************************************************
     */

    public <R1, R> CompoundFuncBuilder joinTo(IFunc1<R1, R> joinTo, IFunc<R1> f1) {
        mGraphBuilder.joinTo(joinTo, f1);
        return this;
    }

    public <R1, R2, R> CompoundFuncBuilder joinTo(IFunc2<R1, R2, R> joinTo, IFunc<R1> f1, IFunc<R2> f2) {
        mGraphBuilder.joinTo(joinTo, f1, f2);
        return this;
    }

    public <R1, R2, R3, R> CompoundFuncBuilder joinTo(IFunc3<R1, R2, R3, R> joinTo, IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3) {
        mGraphBuilder.joinTo(joinTo, f1, f2, f3);
        return this;
    }

    public <R1, R2, R3, R4, R> CompoundFuncBuilder joinTo(IFunc4<R1, R2, R3, R4, R> joinTo, IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3, IFunc<R4> f4) {
        mGraphBuilder.joinTo(joinTo, f1, f2, f3, f4);
        return this;
    }

    public <R1, R2, R3, R4, R5, R> CompoundFuncBuilder joinTo(IFunc5<R1, R2, R3, R4, R5, R> joinTo, IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3, IFunc<R4> f4, IFunc<R5> f5) {
        mGraphBuilder.joinTo(joinTo, f1, f2, f3, f4, f5);
        return this;
    }

    public <R1, R2, R3, R4, R5, R6, R> CompoundFuncBuilder joinTo(IFunc6<R1, R2, R3, R4, R5, R6, R> joinTo, IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3, IFunc<R4> f4, IFunc<R5> f5, IFunc<R6> f6) {
        mGraphBuilder.joinTo(joinTo, f1, f2, f3, f4, f5, f6);
        return this;
    }

    public <R1, R2, R3, R4, R5, R6, R7, R> CompoundFuncBuilder joinTo(IFunc7<R1, R2, R3, R4, R5, R6, R7, R> joinTo, IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3, IFunc<R4> f4, IFunc<R5> f5, IFunc<R6> f6, IFunc<R7> f7) {
        mGraphBuilder.joinTo(joinTo, f1, f2, f3, f4, f5, f6, f7);
        return this;
    }

    public <R1, R2, R3, R4, R5, R6, R7, R8, R> CompoundFuncBuilder joinTo(IFunc8<R1, R2, R3, R4, R5, R6, R7, R8, R> joinTo, IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3, IFunc<R4> f4, IFunc<R5> f5, IFunc<R6> f6, IFunc<R7> f7, IFunc<R8> f8) {
        mGraphBuilder.joinTo(joinTo, f1, f2, f3, f4, f5, f6, f7, f8);
        return this;
    }

    public <R1, R2, R3, R4, R5, R6, R7, R8, R9, R> CompoundFuncBuilder joinTo(IFunc9<R1, R2, R3, R4, R5, R6, R7, R8, R9, R> joinTo, IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3, IFunc<R4> f4, IFunc<R5> f5, IFunc<R6> f6, IFunc<R7> f7, IFunc<R8> f8, IFunc<R9> f9) {
        mGraphBuilder.joinTo(joinTo, f1, f2, f3, f4, f5, f6, f7, f8, f9);
        return this;
    }

    public <R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R> CompoundFuncBuilder joinTo(IFunc10<R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R> joinTo, IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3, IFunc<R4> f4, IFunc<R5> f5, IFunc<R6> f6, IFunc<R7> f7, IFunc<R8> f8, IFunc<R9> f9, IFunc<R10> f10) {
        mGraphBuilder.joinTo(joinTo, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10);
        return this;
    }

    public CompoundFuncBuilder joinTo(IFuncN joinTo, IFunc... funcs) {
        mGraphBuilder.joinTo(joinTo, funcs);
        return this;
    }
}
