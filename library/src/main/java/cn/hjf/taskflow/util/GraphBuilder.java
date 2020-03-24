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

    public <R> void addFunc(IFunc1<R, ?> func, IFunc<R> preFunc) {
        checkNotJoined(func);

        mJoinedFuncSet.add(func);

        func.after(preFunc);

        mFuncSet.add(preFunc);
        mFuncSet.add(func);
    }

    public <R1, R2> void addFunc(IFunc2<R1, R2, ?> func, IFunc<R1> preFunc1, IFunc<R2> preFunc2) {
        checkNotJoined(func);

        mJoinedFuncSet.add(func);

        func.after(preFunc1);
        func.after(preFunc2);

        mFuncSet.add(preFunc1);
        mFuncSet.add(preFunc2);
        mFuncSet.add(func);
    }

    public <R1, R2, R3> void addFunc(IFunc3<R1, R2, R3, ?> func, IFunc<R1> preFunc1, IFunc<R2> preFunc2, IFunc<R3> preFunc3) {
        checkNotJoined(func);

        mJoinedFuncSet.add(func);

        func.after(preFunc1);
        func.after(preFunc2);
        func.after(preFunc3);

        mFuncSet.add(preFunc1);
        mFuncSet.add(preFunc2);
        mFuncSet.add(preFunc3);
        mFuncSet.add(func);
    }

    public <R1, R2, R3, R4> void addFunc(IFunc4<R1, R2, R3, R4, ?> func, IFunc<R1> preFunc1, IFunc<R2> preFunc2, IFunc<R3> preFunc3, IFunc<R4> preFunc4) {
        checkNotJoined(func);

        mJoinedFuncSet.add(func);

        func.after(preFunc1);
        func.after(preFunc2);
        func.after(preFunc3);
        func.after(preFunc4);

        mFuncSet.add(preFunc1);
        mFuncSet.add(preFunc2);
        mFuncSet.add(preFunc3);
        mFuncSet.add(preFunc4);
        mFuncSet.add(func);
    }

    public <R1, R2, R3, R4, R5> void addFunc(IFunc5<R1, R2, R3, R4, R5, ?> func, IFunc<R1> preFunc1, IFunc<R2> preFunc2, IFunc<R3> preFunc3, IFunc<R4> preFunc4, IFunc<R5> preFunc5) {
        checkNotJoined(func);

        mJoinedFuncSet.add(func);

        func.after(preFunc1);
        func.after(preFunc2);
        func.after(preFunc3);
        func.after(preFunc4);
        func.after(preFunc5);

        mFuncSet.add(preFunc1);
        mFuncSet.add(preFunc2);
        mFuncSet.add(preFunc3);
        mFuncSet.add(preFunc4);
        mFuncSet.add(preFunc5);
        mFuncSet.add(func);
    }

    public <R1, R2, R3, R4, R5, R6> void addFunc(IFunc6<R1, R2, R3, R4, R5, R6, ?> func, IFunc<R1> preFunc1, IFunc<R2> preFunc2, IFunc<R3> preFunc3, IFunc<R4> preFunc4, IFunc<R5> preFunc5, IFunc<R6> preFunc6) {
        checkNotJoined(func);

        mJoinedFuncSet.add(func);

        func.after(preFunc1);
        func.after(preFunc2);
        func.after(preFunc3);
        func.after(preFunc4);
        func.after(preFunc5);
        func.after(preFunc6);

        mFuncSet.add(preFunc1);
        mFuncSet.add(preFunc2);
        mFuncSet.add(preFunc3);
        mFuncSet.add(preFunc4);
        mFuncSet.add(preFunc5);
        mFuncSet.add(preFunc6);
        mFuncSet.add(func);
    }

    public <R1, R2, R3, R4, R5, R6, R7> void addFunc(IFunc7<R1, R2, R3, R4, R5, R6, R7, ?> func, IFunc<R1> preFunc1, IFunc<R2> preFunc2, IFunc<R3> preFunc3, IFunc<R4> preFunc4, IFunc<R5> preFunc5, IFunc<R6> preFunc6, IFunc<R7> preFunc7) {
        checkNotJoined(func);

        mJoinedFuncSet.add(func);

        func.after(preFunc1);
        func.after(preFunc2);
        func.after(preFunc3);
        func.after(preFunc4);
        func.after(preFunc5);
        func.after(preFunc6);
        func.after(preFunc7);

        mFuncSet.add(preFunc1);
        mFuncSet.add(preFunc2);
        mFuncSet.add(preFunc3);
        mFuncSet.add(preFunc4);
        mFuncSet.add(preFunc5);
        mFuncSet.add(preFunc6);
        mFuncSet.add(preFunc7);
        mFuncSet.add(func);
    }

    public <R1, R2, R3, R4, R5, R6, R7, R8> void addFunc(IFunc8<R1, R2, R3, R4, R5, R6, R7, R8, ?> func, IFunc<R1> preFunc1, IFunc<R2> preFunc2, IFunc<R3> preFunc3, IFunc<R4> preFunc4, IFunc<R5> preFunc5, IFunc<R6> preFunc6, IFunc<R7> preFunc7, IFunc<R8> preFunc8) {
        checkNotJoined(func);

        mJoinedFuncSet.add(func);

        func.after(preFunc1);
        func.after(preFunc2);
        func.after(preFunc3);
        func.after(preFunc4);
        func.after(preFunc5);
        func.after(preFunc6);
        func.after(preFunc7);
        func.after(preFunc8);

        mFuncSet.add(preFunc1);
        mFuncSet.add(preFunc2);
        mFuncSet.add(preFunc3);
        mFuncSet.add(preFunc4);
        mFuncSet.add(preFunc5);
        mFuncSet.add(preFunc6);
        mFuncSet.add(preFunc7);
        mFuncSet.add(preFunc8);
        mFuncSet.add(func);
    }

    public <R1, R2, R3, R4, R5, R6, R7, R8, R9> void addFunc(IFunc9<R1, R2, R3, R4, R5, R6, R7, R8, R9, ?> func, IFunc<R1> preFunc1, IFunc<R2> preFunc2, IFunc<R3> preFunc3, IFunc<R4> preFunc4, IFunc<R5> preFunc5, IFunc<R6> preFunc6, IFunc<R7> preFunc7, IFunc<R8> preFunc8, IFunc<R9> preFunc9) {
        checkNotJoined(func);

        mJoinedFuncSet.add(func);

        func.after(preFunc1);
        func.after(preFunc2);
        func.after(preFunc3);
        func.after(preFunc4);
        func.after(preFunc5);
        func.after(preFunc6);
        func.after(preFunc7);
        func.after(preFunc8);
        func.after(preFunc9);

        mFuncSet.add(preFunc1);
        mFuncSet.add(preFunc2);
        mFuncSet.add(preFunc3);
        mFuncSet.add(preFunc4);
        mFuncSet.add(preFunc5);
        mFuncSet.add(preFunc6);
        mFuncSet.add(preFunc7);
        mFuncSet.add(preFunc8);
        mFuncSet.add(preFunc9);
        mFuncSet.add(func);
    }

    public <R1, R2, R3, R4, R5, R6, R7, R8, R9, R10> void addFunc(IFunc10<R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, ?> func, IFunc<R1> preFunc1, IFunc<R2> preFunc2, IFunc<R3> preFunc3, IFunc<R4> preFunc4, IFunc<R5> preFunc5, IFunc<R6> preFunc6, IFunc<R7> preFunc7, IFunc<R8> preFunc8, IFunc<R9> preFunc9, IFunc<R10> preFunc10) {
        checkNotJoined(func);

        mJoinedFuncSet.add(func);

        func.after(preFunc1);
        func.after(preFunc2);
        func.after(preFunc3);
        func.after(preFunc4);
        func.after(preFunc5);
        func.after(preFunc6);
        func.after(preFunc7);
        func.after(preFunc8);
        func.after(preFunc9);
        func.after(preFunc10);

        mFuncSet.add(preFunc1);
        mFuncSet.add(preFunc2);
        mFuncSet.add(preFunc3);
        mFuncSet.add(preFunc4);
        mFuncSet.add(preFunc5);
        mFuncSet.add(preFunc6);
        mFuncSet.add(preFunc7);
        mFuncSet.add(preFunc8);
        mFuncSet.add(preFunc9);
        mFuncSet.add(preFunc10);
        mFuncSet.add(func);
    }

    public void addFunc(IFuncN func, IFunc... preFuncs) {
        checkNotJoined(func);

        mJoinedFuncSet.add(func);

        for (IFunc f : preFuncs) {
            func.after(f);
            mFuncSet.add(f);
        }

        mFuncSet.add(func);
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
