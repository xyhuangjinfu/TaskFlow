package cn.hjf.taskflow.util;

import java.util.HashSet;
import java.util.Set;

import cn.hjf.taskflow.graph.GraphVisitor;
import cn.hjf.taskflow.graph.OnVisitListener;

class GraphBuilder {

    private Set<IFunc> mLinkedFuncSet = new HashSet<>();
    private Set<IFunc> mFuncSet = new HashSet<>();

    public IFunc[] getStartAndEnd() {
        IFunc[] startAndEnd = findStartAndEnd();
        IFunc start = startAndEnd[0];
        IFunc end = startAndEnd[1];

        checkConnected(start, end);

        return new IFunc[]{start, end};
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

    /**
     * ***************************************************************************************************************
     * //
     * ***************************************************************************************************************
     */

    public void addLink(IFunc0 func, IFunc<Void> preFunc) {
        checkNotLinked(func);

        mLinkedFuncSet.add(func);

        func.after(preFunc);

        mFuncSet.add(preFunc);
        mFuncSet.add(func);
    }

    public <R> void addLink(IFunc1<R, ?> func, IFunc<R> preFunc) {
        checkNotLinked(func);

        mLinkedFuncSet.add(func);

        func.after(preFunc);

        mFuncSet.add(preFunc);
        mFuncSet.add(func);
    }

    public <R1, R2> void addLink(IFunc2<R1, R2, ?> func, IFunc<R1> preFunc1, IFunc<R2> preFunc2) {
        checkNotLinked(func);

        mLinkedFuncSet.add(func);

        func.after(preFunc1);
        func.after(preFunc2);

        mFuncSet.add(preFunc1);
        mFuncSet.add(preFunc2);
        mFuncSet.add(func);
    }

    public <R1, R2, R3> void addLink(IFunc3<R1, R2, R3, ?> func, IFunc<R1> preFunc1, IFunc<R2> preFunc2, IFunc<R3> preFunc3) {
        checkNotLinked(func);

        mLinkedFuncSet.add(func);

        func.after(preFunc1);
        func.after(preFunc2);
        func.after(preFunc3);

        mFuncSet.add(preFunc1);
        mFuncSet.add(preFunc2);
        mFuncSet.add(preFunc3);
        mFuncSet.add(func);
    }

    public <R1, R2, R3, R4> void addLink(IFunc4<R1, R2, R3, R4, ?> func, IFunc<R1> preFunc1, IFunc<R2> preFunc2, IFunc<R3> preFunc3, IFunc<R4> preFunc4) {
        checkNotLinked(func);

        mLinkedFuncSet.add(func);

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

    public <R1, R2, R3, R4, R5> void addLink(IFunc5<R1, R2, R3, R4, R5, ?> func, IFunc<R1> preFunc1, IFunc<R2> preFunc2, IFunc<R3> preFunc3, IFunc<R4> preFunc4, IFunc<R5> preFunc5) {
        checkNotLinked(func);

        mLinkedFuncSet.add(func);

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

    public <R1, R2, R3, R4, R5, R6> void addLink(IFunc6<R1, R2, R3, R4, R5, R6, ?> func, IFunc<R1> preFunc1, IFunc<R2> preFunc2, IFunc<R3> preFunc3, IFunc<R4> preFunc4, IFunc<R5> preFunc5, IFunc<R6> preFunc6) {
        checkNotLinked(func);

        mLinkedFuncSet.add(func);

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

    public <R1, R2, R3, R4, R5, R6, R7> void addLink(IFunc7<R1, R2, R3, R4, R5, R6, R7, ?> func, IFunc<R1> preFunc1, IFunc<R2> preFunc2, IFunc<R3> preFunc3, IFunc<R4> preFunc4, IFunc<R5> preFunc5, IFunc<R6> preFunc6, IFunc<R7> preFunc7) {
        checkNotLinked(func);

        mLinkedFuncSet.add(func);

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

    public <R1, R2, R3, R4, R5, R6, R7, R8> void addLink(IFunc8<R1, R2, R3, R4, R5, R6, R7, R8, ?> func, IFunc<R1> preFunc1, IFunc<R2> preFunc2, IFunc<R3> preFunc3, IFunc<R4> preFunc4, IFunc<R5> preFunc5, IFunc<R6> preFunc6, IFunc<R7> preFunc7, IFunc<R8> preFunc8) {
        checkNotLinked(func);

        mLinkedFuncSet.add(func);

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

    public <R1, R2, R3, R4, R5, R6, R7, R8, R9> void addLink(IFunc9<R1, R2, R3, R4, R5, R6, R7, R8, R9, ?> func, IFunc<R1> preFunc1, IFunc<R2> preFunc2, IFunc<R3> preFunc3, IFunc<R4> preFunc4, IFunc<R5> preFunc5, IFunc<R6> preFunc6, IFunc<R7> preFunc7, IFunc<R8> preFunc8, IFunc<R9> preFunc9) {
        checkNotLinked(func);

        mLinkedFuncSet.add(func);

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

    public <R1, R2, R3, R4, R5, R6, R7, R8, R9, R10> void addLink(IFunc10<R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, ?> func, IFunc<R1> preFunc1, IFunc<R2> preFunc2, IFunc<R3> preFunc3, IFunc<R4> preFunc4, IFunc<R5> preFunc5, IFunc<R6> preFunc6, IFunc<R7> preFunc7, IFunc<R8> preFunc8, IFunc<R9> preFunc9, IFunc<R10> preFunc10) {
        checkNotLinked(func);

        mLinkedFuncSet.add(func);

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

    public void addLink(IFuncN func, IFunc... preFuncs) {
        checkNotLinked(func);

        mLinkedFuncSet.add(func);

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

    private void checkNotLinked(IFunc func) {
        if (mLinkedFuncSet.contains(func)) {
            throw new IllegalArgumentException("func can not be linked more than one time, func:" + func + " already be linked");
        }
    }
}
