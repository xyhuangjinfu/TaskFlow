package cn.hjf.taskflow.util;

import cn.hjf.taskflow.core.Task;
import cn.hjf.taskflow.execute.Callback;
import cn.hjf.taskflow.execute.Engine;
import cn.hjf.taskflow.execute.Session;

public final class TaskFlow<R> {

    /**
     * ***************************************************************************************************************
     * //
     * ***************************************************************************************************************
     */

    private GraphBuilder mRealBuilder = new GraphBuilder();

    /**
     * ***************************************************************************************************************
     * //
     * ***************************************************************************************************************
     */

    public TaskFlow only(IFunc func) {
        mRealBuilder.addFunc(func);
        return this;
    }

    /**
     * ***************************************************************************************************************
     * //
     * ***************************************************************************************************************
     */

    public <R1> TaskFlow<R> joinTo(IFunc1<R1, ?> joinTo, IFunc<R1> f1) {
        mRealBuilder.joinTo(joinTo, f1);
        return this;
    }

    public <R1, R2> TaskFlow<R> joinTo(IFunc2<R1, R2, ?> joinTo, IFunc<R1> f1, IFunc<R2> f2) {
        mRealBuilder.joinTo(joinTo, f1, f2);
        return this;
    }

    public <R1, R2, R3> TaskFlow<R> joinTo(IFunc3<R1, R2, R3, ?> joinTo, IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3) {
        mRealBuilder.joinTo(joinTo, f1, f2, f3);
        return this;
    }

    public <R1, R2, R3, R4> TaskFlow<R> joinTo(IFunc4<R1, R2, R3, R4, ?> joinTo, IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3, IFunc<R4> f4) {
        mRealBuilder.joinTo(joinTo, f1, f2, f3, f4);
        return this;
    }

    public <R1, R2, R3, R4, R5> TaskFlow<R> joinTo(IFunc5<R1, R2, R3, R4, R5, ?> joinTo, IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3, IFunc<R4> f4, IFunc<R5> f5) {
        mRealBuilder.joinTo(joinTo, f1, f2, f3, f4, f5);
        return this;
    }

    public <R1, R2, R3, R4, R5, R6> TaskFlow<R> joinTo(IFunc6<R1, R2, R3, R4, R5, R6, ?> joinTo, IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3, IFunc<R4> f4, IFunc<R5> f5, IFunc<R6> f6) {
        mRealBuilder.joinTo(joinTo, f1, f2, f3, f4, f5, f6);
        return this;
    }

    public <R1, R2, R3, R4, R5, R6, R7> TaskFlow<R> joinTo(IFunc7<R1, R2, R3, R4, R5, R6, R7, ?> joinTo, IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3, IFunc<R4> f4, IFunc<R5> f5, IFunc<R6> f6, IFunc<R7> f7) {
        mRealBuilder.joinTo(joinTo, f1, f2, f3, f4, f5, f6, f7);
        return this;
    }

    public <R1, R2, R3, R4, R5, R6, R7, R8> TaskFlow<R> joinTo(IFunc8<R1, R2, R3, R4, R5, R6, R7, R8, ?> joinTo, IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3, IFunc<R4> f4, IFunc<R5> f5, IFunc<R6> f6, IFunc<R7> f7, IFunc<R8> f8) {
        mRealBuilder.joinTo(joinTo, f1, f2, f3, f4, f5, f6, f7, f8);
        return this;
    }

    public <R1, R2, R3, R4, R5, R6, R7, R8, R9> TaskFlow<R> joinTo(IFunc9<R1, R2, R3, R4, R5, R6, R7, R8, R9, ?> joinTo, IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3, IFunc<R4> f4, IFunc<R5> f5, IFunc<R6> f6, IFunc<R7> f7, IFunc<R8> f8, IFunc<R9> f9) {
        mRealBuilder.joinTo(joinTo, f1, f2, f3, f4, f5, f6, f7, f8, f9);
        return this;
    }

    public <R1, R2, R3, R4, R5, R6, R7, R8, R9, R10> TaskFlow<R> joinTo(IFunc10<R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, ?> joinTo, IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3, IFunc<R4> f4, IFunc<R5> f5, IFunc<R6> f6, IFunc<R7> f7, IFunc<R8> f8, IFunc<R9> f9, IFunc<R10> f10) {
        mRealBuilder.joinTo(joinTo, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10);
        return this;
    }

    public TaskFlow<R> joinTo(IFuncN joinTo, IFunc... funcs) {
        mRealBuilder.joinTo(joinTo, funcs);
        return this;
    }

    /**
     * ***************************************************************************************************************
     * <p>
     * ***************************************************************************************************************
     */

    public IFunc<R> create() {
        DeprecatedCompoundFuncBuilder funcGraphBuilder = new DeprecatedCompoundFuncBuilder(mRealBuilder);
        IFunc func = funcGraphBuilder.create();
        return func;
    }

    /**
     * ***************************************************************************************************************
     * <p>
     * ***************************************************************************************************************
     */

//    public <T> Session execute(Callback<T> callback) {
//        FuncGraphBuilder funcGraphBuilder = new FuncGraphBuilder(mRealBuilder);
//        IFunc func = funcGraphBuilder.create();
//        Task startTask = new TaskCreator().create(func);
//        return Engine.execute(startTask, callback);
//    }
    public static <R> Session execute(IFunc<R> func, Callback<R> callback) {
        if (func instanceof IFunc0) {
            return execute((IFunc0) func, callback);
        }

        throw new IllegalArgumentException("unsupported func type : " + func.getClass().getName());
    }

    public static <R> Session execute(IFunc0<R> func, Callback<R> callback) {
        Task startTask = getTask(func);
        return Engine.execute(startTask, callback);
    }

    public static <P, R> Session execute(IFunc1<P, R> func, Callback<R> callback, P p) {
        Task startTask = getTask(func);
        return Engine.execute(startTask, callback, p);
    }

    public static <P1, P2, R> Session execute(IFunc2<P1, P2, R> func, Callback<R> callback, P1 p1, P2 p2) {
        Task startTask = getTask(func);
        return Engine.execute(startTask, callback, p1, p2);
    }

    public static <P1, P2, P3, R> Session execute(IFunc3<P1, P2, P3, R> func, Callback<R> callback, P1 p1, P2 p2, P3 p3) {
        Task startTask = getTask(func);
        return Engine.execute(startTask, callback, p1, p2, p3);
    }

    public static <P1, P2, P3, P4, R> Session execute(IFunc4<P1, P2, P3, P4, R> func, Callback<R> callback, P1 p1, P2 p2, P3 p3, P4 p4) {
        Task startTask = getTask(func);
        return Engine.execute(startTask, callback, p1, p2, p3, p4);
    }

    public static <P1, P2, P3, P4, P5, R> Session execute(IFunc5<P1, P2, P3, P4, P5, R> func, Callback<R> callback, P1 p1, P2 p2, P3 p3, P4 p4, P5 p5) {
        Task startTask = getTask(func);
        return Engine.execute(startTask, callback, p1, p2, p3, p4, p5);
    }

    public static <P1, P2, P3, P4, P5, P6, R> Session execute(IFunc6<P1, P2, P3, P4, P5, P6, R> func, Callback<R> callback, P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6) {
        Task startTask = getTask(func);
        return Engine.execute(startTask, callback, p1, p2, p3, p4, p5, p6);
    }

    public static <P1, P2, P3, P4, P5, P6, P7, R> Session execute(IFunc7<P1, P2, P3, P4, P5, P6, P7, R> func, Callback<R> callback, P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7) {
        Task startTask = getTask(func);
        return Engine.execute(startTask, callback, p1, p2, p3, p4, p5, p6, p7);
    }

    public static <P1, P2, P3, P4, P5, P6, P7, P8, R> Session execute(IFunc8<P1, P2, P3, P4, P5, P6, P7, P8, R> func, Callback<R> callback, P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7, P8 p8) {
        Task startTask = getTask(func);
        return Engine.execute(startTask, callback, p1, p2, p3, p4, p5, p6, p7, p8);
    }

    public static <P1, P2, P3, P4, P5, P6, P7, P8, P9, R> Session execute(IFunc9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R> func, Callback<R> callback, P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7, P8 p8, P9 p9) {
        Task startTask = getTask(func);
        return Engine.execute(startTask, callback, p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    public static <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, R> Session execute(IFunc10<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, R> func, Callback<R> callback, P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7, P8 p8, P9 p9, P10 p10) {
        Task startTask = getTask(func);
        return Engine.execute(startTask, callback, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
    }

    public static <R> Session execute(IFuncN<R> func, Callback<R> callback, Object... params) {
        Task startTask = getTask(func);
        return Engine.execute(startTask, callback, params);
    }

    private static Task getTask(IFunc func) {
        Task startTask = new TaskGraphTransfer().create(func);
        return startTask;
    }

    /**
     * ***************************************************************************************************************
     * <p>
     * ***************************************************************************************************************
     */

    public <R1> TaskFlow link(IFunc1<?, R1> f1, IFunc1<R1, ?> f2) {
        mRealBuilder.joinTo(f2, f1);

        return this;
    }

    public <R1, R2> TaskFlow link(IFunc1<?, R1> f1, IFunc1<R1, R2> f2, IFunc1<R2, ?> f3) {
        mRealBuilder.joinTo(f3, f2);
        mRealBuilder.joinTo(f2, f1);

        return this;
    }

    public <R1, R2, R3> TaskFlow link(IFunc1<?, R1> f1, IFunc1<R1, R2> f2, IFunc1<R2, R3> f3, IFunc1<R3, ?> f4) {
        mRealBuilder.joinTo(f4, f3);
        mRealBuilder.joinTo(f3, f2);
        mRealBuilder.joinTo(f2, f1);

        return this;
    }

    public <R1, R2, R3, R4> TaskFlow link(IFunc1<?, R1> f1, IFunc1<R1, R2> f2, IFunc1<R2, R3> f3, IFunc1<R3, R4> f4, IFunc1<R4, ?> f5) {
        mRealBuilder.joinTo(f5, f4);
        mRealBuilder.joinTo(f4, f3);
        mRealBuilder.joinTo(f3, f2);
        mRealBuilder.joinTo(f2, f1);

        return this;
    }

    public <R1, R2, R3, R4, R5> TaskFlow link(IFunc1<?, R1> f1, IFunc1<R1, R2> f2, IFunc1<R2, R3> f3, IFunc1<R3, R4> f4, IFunc1<R4, R5> f5, IFunc1<R5, ?> f6) {
        mRealBuilder.joinTo(f6, f5);
        mRealBuilder.joinTo(f5, f4);
        mRealBuilder.joinTo(f4, f3);
        mRealBuilder.joinTo(f3, f2);
        mRealBuilder.joinTo(f2, f1);

        return this;
    }

    public <R1, R2, R3, R4, R5, R6> TaskFlow link(IFunc1<?, R1> f1, IFunc1<R1, R2> f2, IFunc1<R2, R3> f3, IFunc1<R3, R4> f4, IFunc1<R4, R5> f5, IFunc1<R5, R6> f6, IFunc1<R6, ?> f7) {
        mRealBuilder.joinTo(f7, f6);
        mRealBuilder.joinTo(f6, f5);
        mRealBuilder.joinTo(f5, f4);
        mRealBuilder.joinTo(f4, f3);
        mRealBuilder.joinTo(f3, f2);
        mRealBuilder.joinTo(f2, f1);

        return this;
    }

    public <R1, R2, R3, R4, R5, R6, R7> TaskFlow link(IFunc1<?, R1> f1, IFunc1<R1, R2> f2, IFunc1<R2, R3> f3, IFunc1<R3, R4> f4, IFunc1<R4, R5> f5, IFunc1<R5, R6> f6, IFunc1<R6, R7> f7, IFunc1<R7, ?> f8) {
        mRealBuilder.joinTo(f8, f7);
        mRealBuilder.joinTo(f7, f6);
        mRealBuilder.joinTo(f6, f5);
        mRealBuilder.joinTo(f5, f4);
        mRealBuilder.joinTo(f4, f3);
        mRealBuilder.joinTo(f3, f2);
        mRealBuilder.joinTo(f2, f1);

        return this;
    }

    public <R1, R2, R3, R4, R5, R6, R7, R8> TaskFlow link(IFunc1<?, R1> f1, IFunc1<R1, R2> f2, IFunc1<R2, R3> f3, IFunc1<R3, R4> f4, IFunc1<R4, R5> f5, IFunc1<R5, R6> f6, IFunc1<R6, R7> f7, IFunc1<R7, R8> f8, IFunc1<R8, ?> f9) {
        mRealBuilder.joinTo(f9, f8);
        mRealBuilder.joinTo(f8, f7);
        mRealBuilder.joinTo(f7, f6);
        mRealBuilder.joinTo(f6, f5);
        mRealBuilder.joinTo(f5, f4);
        mRealBuilder.joinTo(f4, f3);
        mRealBuilder.joinTo(f3, f2);
        mRealBuilder.joinTo(f2, f1);

        return this;
    }

    public <R1, R2, R3, R4, R5, R6, R7, R8, R9> TaskFlow link(IFunc1<?, R1> f1, IFunc1<R1, R2> f2, IFunc1<R2, R3> f3, IFunc1<R3, R4> f4, IFunc1<R4, R5> f5, IFunc1<R5, R6> f6, IFunc1<R6, R7> f7, IFunc1<R7, R8> f8, IFunc1<R8, R9> f9, IFunc1<R9, ?> f10) {
        mRealBuilder.joinTo(f10, f9);
        mRealBuilder.joinTo(f9, f8);
        mRealBuilder.joinTo(f8, f7);
        mRealBuilder.joinTo(f7, f6);
        mRealBuilder.joinTo(f6, f5);
        mRealBuilder.joinTo(f5, f4);
        mRealBuilder.joinTo(f4, f3);
        mRealBuilder.joinTo(f3, f2);
        mRealBuilder.joinTo(f2, f1);

        return this;
    }
}

