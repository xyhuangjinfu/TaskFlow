package cn.hjf.taskflow.util;

import java.util.HashSet;
import java.util.Set;

import cn.hjf.taskflow.graph.GraphVisitor;
import cn.hjf.taskflow.graph.OnVisitListener;

class RealFuncGraphBuilder {

    private IFunc mStart;
    private IFunc mEnd;
    private Set<IFunc> mJoinedFuncSet = new HashSet<>();
    private Set<IFunc> mFuncSet = new HashSet<>();

    public IFunc[] getStartAndEnd() {
        IFunc[] startAndEnd = findStartAndEnd();
        mStart = startAndEnd[0];
        mEnd = startAndEnd[1];

        checkConnected(mStart, mEnd);

        return new IFunc[]{mStart, mEnd};
    }

    /**
     * ***************************************************************************************************************
     * <p>
     * ***************************************************************************************************************
     */

    private IFunc[] findStartAndEnd() {
        IFunc start = null;
        IFunc end = null;

        for (IFunc func : mFuncSet) {
            if (func.getPreList().isEmpty()) {
                if (start == null) {
                    start = func;
                } else {
                    throw new RuntimeException("more than one start func, 1:" + start + ", 2:" + func);
                }
            }

            if (func.getNextList().isEmpty()) {
                if (end == null) {
                    end = func;
                } else {
                    throw new RuntimeException("more than one end func, 1:" + end + ", 2:" + func);
                }
            }
        }

        if (start == null) {
            throw new RuntimeException("can not found start func");
        }

        if (end == null) {
            throw new RuntimeException("can not found end func");
        }

        return new IFunc[]{start, end};
    }

    private void checkConnected(IFunc start, final IFunc end) {
        GraphVisitor.bfsForward(start, new OnVisitListener<IFunc>() {
            private boolean connected = false;

            @Override
            public void onStart() {

            }

            @Override
            public void visit(IFunc o) {
                if (o == end) {
                    connected = true;
                }
            }

            @Override
            public void onComplete() {
                if (!connected) {
                    throw new RuntimeException("start func not yet connected to end func");
                }
            }
        });
    }

    /**
     * ***************************************************************************************************************
     * //
     * ***************************************************************************************************************
     */

    public void addFunc(IFunc func) {
        mFuncSet.add(func);
    }

    public <R1, R> void joinTo(IFunc<R1> f1, IFunc1<R1, R> joinTo) {
        checkNotJoined(joinTo);

        mJoinedFuncSet.add(joinTo);

        joinTo.after(f1);

        mFuncSet.add(f1);
        mFuncSet.add(joinTo);
    }

    public <R1, R2, R> void joinTo(IFunc<R1> f1, IFunc<R2> f2, IFunc2<R1, R2, R> joinTo) {
        checkNotJoined(joinTo);

        mJoinedFuncSet.add(joinTo);

        joinTo.after(f1);
        joinTo.after(f2);

        mFuncSet.add(f1);
        mFuncSet.add(f2);
        mFuncSet.add(joinTo);
    }

    public <R1, R2, R3, R> void joinTo(IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3, IFunc3<R1, R2, R3, R> joinTo) {
        checkNotJoined(joinTo);

        mJoinedFuncSet.add(joinTo);

        joinTo.after(f1);
        joinTo.after(f2);
        joinTo.after(f3);

        mFuncSet.add(f1);
        mFuncSet.add(f2);
        mFuncSet.add(f3);
        mFuncSet.add(joinTo);
    }

    public <R1, R2, R3, R4, R> void joinTo(IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3, IFunc<R4> f4, IFunc4<R1, R2, R3, R4, R> joinTo) {
        checkNotJoined(joinTo);

        mJoinedFuncSet.add(joinTo);

        joinTo.after(f1);
        joinTo.after(f2);
        joinTo.after(f3);
        joinTo.after(f4);

        mFuncSet.add(f1);
        mFuncSet.add(f2);
        mFuncSet.add(f3);
        mFuncSet.add(f4);
        mFuncSet.add(joinTo);
    }

    public <R1, R2, R3, R4, R5, R> void joinTo(IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3, IFunc<R4> f4, IFunc<R5> f5, IFunc5<R1, R2, R3, R4, R5, R> joinTo) {
        checkNotJoined(joinTo);

        mJoinedFuncSet.add(joinTo);

        joinTo.after(f1);
        joinTo.after(f2);
        joinTo.after(f3);
        joinTo.after(f4);
        joinTo.after(f5);

        mFuncSet.add(f1);
        mFuncSet.add(f2);
        mFuncSet.add(f3);
        mFuncSet.add(f4);
        mFuncSet.add(f5);
        mFuncSet.add(joinTo);
    }

    public <R1, R2, R3, R4, R5, R6, R> void joinTo(IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3, IFunc<R4> f4, IFunc<R5> f5, IFunc<R6> f6, IFunc6<R1, R2, R3, R4, R5, R6, R> joinTo) {
        checkNotJoined(joinTo);

        mJoinedFuncSet.add(joinTo);

        joinTo.after(f1);
        joinTo.after(f2);
        joinTo.after(f3);
        joinTo.after(f4);
        joinTo.after(f5);
        joinTo.after(f6);

        mFuncSet.add(f1);
        mFuncSet.add(f2);
        mFuncSet.add(f3);
        mFuncSet.add(f4);
        mFuncSet.add(f5);
        mFuncSet.add(f6);
        mFuncSet.add(joinTo);
    }

    public <R1, R2, R3, R4, R5, R6, R7, R> void joinTo(IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3, IFunc<R4> f4, IFunc<R5> f5, IFunc<R6> f6, IFunc<R7> f7, IFunc7<R1, R2, R3, R4, R5, R6, R7, R> joinTo) {
        checkNotJoined(joinTo);

        mJoinedFuncSet.add(joinTo);

        joinTo.after(f1);
        joinTo.after(f2);
        joinTo.after(f3);
        joinTo.after(f4);
        joinTo.after(f5);
        joinTo.after(f6);
        joinTo.after(f7);

        mFuncSet.add(f1);
        mFuncSet.add(f2);
        mFuncSet.add(f3);
        mFuncSet.add(f4);
        mFuncSet.add(f5);
        mFuncSet.add(f6);
        mFuncSet.add(f7);
        mFuncSet.add(joinTo);
    }

    public <R1, R2, R3, R4, R5, R6, R7, R8, R> void joinTo(IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3, IFunc<R4> f4, IFunc<R5> f5, IFunc<R6> f6, IFunc<R7> f7, IFunc<R8> f8, IFunc8<R1, R2, R3, R4, R5, R6, R7, R8, R> joinTo) {
        checkNotJoined(joinTo);

        mJoinedFuncSet.add(joinTo);

        joinTo.after(f1);
        joinTo.after(f2);
        joinTo.after(f3);
        joinTo.after(f4);
        joinTo.after(f5);
        joinTo.after(f6);
        joinTo.after(f7);
        joinTo.after(f8);

        mFuncSet.add(f1);
        mFuncSet.add(f2);
        mFuncSet.add(f3);
        mFuncSet.add(f4);
        mFuncSet.add(f5);
        mFuncSet.add(f6);
        mFuncSet.add(f7);
        mFuncSet.add(f8);
        mFuncSet.add(joinTo);
    }

    public <R1, R2, R3, R4, R5, R6, R7, R8, R9, R> void joinTo(IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3, IFunc<R4> f4, IFunc<R5> f5, IFunc<R6> f6, IFunc<R7> f7, IFunc<R8> f8, IFunc<R9> f9, IFunc9<R1, R2, R3, R4, R5, R6, R7, R8, R9, R> joinTo) {
        checkNotJoined(joinTo);

        mJoinedFuncSet.add(joinTo);

        joinTo.after(f1);
        joinTo.after(f2);
        joinTo.after(f3);
        joinTo.after(f4);
        joinTo.after(f5);
        joinTo.after(f6);
        joinTo.after(f7);
        joinTo.after(f8);
        joinTo.after(f9);

        mFuncSet.add(f1);
        mFuncSet.add(f2);
        mFuncSet.add(f3);
        mFuncSet.add(f4);
        mFuncSet.add(f5);
        mFuncSet.add(f6);
        mFuncSet.add(f7);
        mFuncSet.add(f8);
        mFuncSet.add(f9);
        mFuncSet.add(joinTo);
    }

    public <R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R> void joinTo(IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3, IFunc<R4> f4, IFunc<R5> f5, IFunc<R6> f6, IFunc<R7> f7, IFunc<R8> f8, IFunc<R9> f9, IFunc<R10> f10, IFunc10<R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R> joinTo) {
        checkNotJoined(joinTo);

        mJoinedFuncSet.add(joinTo);

        joinTo.after(f1);
        joinTo.after(f2);
        joinTo.after(f3);
        joinTo.after(f4);
        joinTo.after(f5);
        joinTo.after(f6);
        joinTo.after(f7);
        joinTo.after(f8);
        joinTo.after(f9);
        joinTo.after(f10);

        mFuncSet.add(f1);
        mFuncSet.add(f2);
        mFuncSet.add(f3);
        mFuncSet.add(f4);
        mFuncSet.add(f5);
        mFuncSet.add(f6);
        mFuncSet.add(f7);
        mFuncSet.add(f8);
        mFuncSet.add(f9);
        mFuncSet.add(f10);
        mFuncSet.add(joinTo);
    }

    /**
     * ***************************************************************************************************************
     * <p>
     * ***************************************************************************************************************
     */

    private void checkNotJoined(IFunc func) {
        if (mJoinedFuncSet.contains(func)) {
            throw new IllegalArgumentException("func can not be joined to more than one time, func:" + func);
        }
    }
}
