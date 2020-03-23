package cn.hjf.taskflow.util;

import java.util.HashSet;
import java.util.Set;

import cn.hjf.taskflow.graph.GraphVisitor;
import cn.hjf.taskflow.graph.OnVisitListener;

class GraphBuilder {

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

    private void checkConnected(final IFunc start, final IFunc end) {
        GraphVisitor.dfsForward(start, new OnVisitListener<IFunc>() {
            private boolean connected = false;

            @Override
            public void onStart() {

            }

            @Override
            public void onVisit(IFunc o) {
                if (o == end) {
                    connected = true;
                }
            }

            @Override
            public void onComplete() {
                if (!connected) {
                    throw new RuntimeException("start func " + start + " not yet connected to end func " + end);
                }
            }

            @Override
            public boolean stop() {
                return connected;
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

    public <R> void joinTo(IFunc1<R, ?> joinTo, IFunc<R> f1) {
        checkNotJoined(joinTo);

        mJoinedFuncSet.add(joinTo);

        joinTo.after(f1);

        mFuncSet.add(f1);
        mFuncSet.add(joinTo);
    }

    public <R1, R2> void joinTo(IFunc2<R1, R2, ?> joinTo, IFunc<R1> f1, IFunc<R2> f2) {
        checkNotJoined(joinTo);

        mJoinedFuncSet.add(joinTo);

        joinTo.after(f1);
        joinTo.after(f2);

        mFuncSet.add(f1);
        mFuncSet.add(f2);
        mFuncSet.add(joinTo);
    }

    public <R1, R2, R3> void joinTo(IFunc3<R1, R2, R3, ?> joinTo, IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3) {
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

    public <R1, R2, R3, R4> void joinTo(IFunc4<R1, R2, R3, R4, ?> joinTo, IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3, IFunc<R4> f4) {
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

    public <R1, R2, R3, R4, R5> void joinTo(IFunc5<R1, R2, R3, R4, R5, ?> joinTo, IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3, IFunc<R4> f4, IFunc<R5> f5) {
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

    public <R1, R2, R3, R4, R5, R6> void joinTo(IFunc6<R1, R2, R3, R4, R5, R6, ?> joinTo, IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3, IFunc<R4> f4, IFunc<R5> f5, IFunc<R6> f6) {
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

    public <R1, R2, R3, R4, R5, R6, R7> void joinTo(IFunc7<R1, R2, R3, R4, R5, R6, R7, ?> joinTo, IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3, IFunc<R4> f4, IFunc<R5> f5, IFunc<R6> f6, IFunc<R7> f7) {
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

    public <R1, R2, R3, R4, R5, R6, R7, R8> void joinTo(IFunc8<R1, R2, R3, R4, R5, R6, R7, R8, ?> joinTo, IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3, IFunc<R4> f4, IFunc<R5> f5, IFunc<R6> f6, IFunc<R7> f7, IFunc<R8> f8) {
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

    public <R1, R2, R3, R4, R5, R6, R7, R8, R9> void joinTo(IFunc9<R1, R2, R3, R4, R5, R6, R7, R8, R9, ?> joinTo, IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3, IFunc<R4> f4, IFunc<R5> f5, IFunc<R6> f6, IFunc<R7> f7, IFunc<R8> f8, IFunc<R9> f9) {
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

    public <R1, R2, R3, R4, R5, R6, R7, R8, R9, R10> void joinTo(IFunc10<R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, ?> joinTo, IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3, IFunc<R4> f4, IFunc<R5> f5, IFunc<R6> f6, IFunc<R7> f7, IFunc<R8> f8, IFunc<R9> f9, IFunc<R10> f10) {
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

    public void joinTo(IFuncN joinTo, IFunc... funcs) {
        checkNotJoined(joinTo);

        mJoinedFuncSet.add(joinTo);

        for (IFunc f : funcs) {
            joinTo.after(f);
            mFuncSet.add(f);
        }

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
