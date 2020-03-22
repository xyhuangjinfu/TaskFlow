package cn.hjf.taskflow.util;

import cn.hjf.taskflow.core.Task;
import cn.hjf.taskflow.execute.Callback;
import cn.hjf.taskflow.execute.Engine;
import cn.hjf.taskflow.execute.Session;

public final class TaskFlow {

    public static TaskFlow create() {
        return new TaskFlow();
    }

    /**
     * ***************************************************************************************************************
     * //
     * ***************************************************************************************************************
     */

    private RealFuncGraphBuilder mRealBuilder = new RealFuncGraphBuilder();

    private TaskFlow() {
    }

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

    public <R1, R> TaskFlow joinTo(IFunc<R1> f1, IFunc1<R1, R> joinTo) {
        mRealBuilder.joinTo(f1, joinTo);
        return this;
    }

    public <R1, R2, R> TaskFlow joinTo(IFunc<R1> f1, IFunc<R2> f2, IFunc2<R1, R2, R> joinTo) {
        mRealBuilder.joinTo(f1, f2, joinTo);
        return this;
    }

    public <R1, R2, R3, R> TaskFlow joinTo(IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3, IFunc3<R1, R2, R3, R> joinTo) {
        mRealBuilder.joinTo(f1, f2, f3, joinTo);
        return this;
    }

    public <R1, R2, R3, R4, R> TaskFlow joinTo(IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3, IFunc<R4> f4, IFunc4<R1, R2, R3, R4, R> joinTo) {
        mRealBuilder.joinTo(f1, f2, f3, f4, joinTo);
        return this;
    }

    public <R1, R2, R3, R4, R5, R> TaskFlow joinTo(IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3, IFunc<R4> f4, IFunc<R5> f5, IFunc5<R1, R2, R3, R4, R5, R> joinTo) {
        mRealBuilder.joinTo(f1, f2, f3, f4, f5, joinTo);
        return this;
    }

    public <R1, R2, R3, R4, R5, R6, R> TaskFlow joinTo(IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3, IFunc<R4> f4, IFunc<R5> f5, IFunc<R6> f6, IFunc6<R1, R2, R3, R4, R5, R6, R> joinTo) {
        mRealBuilder.joinTo(f1, f2, f3, f4, f5, f6, joinTo);
        return this;
    }

    public <R1, R2, R3, R4, R5, R6, R7, R> TaskFlow joinTo(IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3, IFunc<R4> f4, IFunc<R5> f5, IFunc<R6> f6, IFunc<R7> f7, IFunc7<R1, R2, R3, R4, R5, R6, R7, R> joinTo) {
        mRealBuilder.joinTo(f1, f2, f3, f4, f5, f6, f7, joinTo);
        return this;
    }

    public <R1, R2, R3, R4, R5, R6, R7, R8, R> TaskFlow joinTo(IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3, IFunc<R4> f4, IFunc<R5> f5, IFunc<R6> f6, IFunc<R7> f7, IFunc<R8> f8, IFunc8<R1, R2, R3, R4, R5, R6, R7, R8, R> joinTo) {
        mRealBuilder.joinTo(f1, f2, f3, f4, f5, f6, f7, f8, joinTo);
        return this;
    }

    public <R1, R2, R3, R4, R5, R6, R7, R8, R9, R> TaskFlow joinTo(IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3, IFunc<R4> f4, IFunc<R5> f5, IFunc<R6> f6, IFunc<R7> f7, IFunc<R8> f8, IFunc<R9> f9, IFunc9<R1, R2, R3, R4, R5, R6, R7, R8, R9, R> joinTo) {
        mRealBuilder.joinTo(f1, f2, f3, f4, f5, f6, f7, f8, f9, joinTo);
        return this;
    }

    public <R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R> TaskFlow joinTo(IFunc<R1> f1, IFunc<R2> f2, IFunc<R3> f3, IFunc<R4> f4, IFunc<R5> f5, IFunc<R6> f6, IFunc<R7> f7, IFunc<R8> f8, IFunc<R9> f9, IFunc<R10> f10, IFunc10<R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R> joinTo) {
        mRealBuilder.joinTo(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, joinTo);
        return this;
    }

    /**
     * ***************************************************************************************************************
     * <p>
     * ***************************************************************************************************************
     */

    public <T> Session execute(Callback<T> callback) {
        FuncGraphBuilder funcGraphBuilder = new FuncGraphBuilder(mRealBuilder);
        IFunc func = funcGraphBuilder.create();
        Task startTask = new TaskCreator().create(func);
        return Engine.execute(startTask, callback);
    }

    /**
     * ***************************************************************************************************************
     * <p>
     * ***************************************************************************************************************
     */

    public <R1> TaskFlow link(IFunc1<?, R1> f1, IFunc1<R1, ?> f2) {
        mRealBuilder.joinTo(f1, f2);

        return this;
    }

    public <R1, R2> TaskFlow link(IFunc1<?, R1> f1, IFunc1<R1, R2> f2, IFunc1<R2, ?> f3) {
        mRealBuilder.joinTo(f1, f2);
        mRealBuilder.joinTo(f2, f3);

        return this;
    }

    public <R1, R2, R3> TaskFlow link(IFunc1<?, R1> f1, IFunc1<R1, R2> f2, IFunc1<R2, R3> f3, IFunc1<R3, ?> f4) {
        mRealBuilder.joinTo(f1, f2);
        mRealBuilder.joinTo(f2, f3);
        mRealBuilder.joinTo(f3, f4);

        return this;
    }

    public <R1, R2, R3, R4> TaskFlow link(IFunc1<?, R1> f1, IFunc1<R1, R2> f2, IFunc1<R2, R3> f3, IFunc1<R3, R4> f4, IFunc1<R4, ?> f5) {
        mRealBuilder.joinTo(f1, f2);
        mRealBuilder.joinTo(f2, f3);
        mRealBuilder.joinTo(f3, f4);
        mRealBuilder.joinTo(f4, f5);

        return this;
    }

    public <R1, R2, R3, R4, R5> TaskFlow link(IFunc1<?, R1> f1, IFunc1<R1, R2> f2, IFunc1<R2, R3> f3, IFunc1<R3, R4> f4, IFunc1<R4, R5> f5, IFunc1<R5, ?> f6) {
        mRealBuilder.joinTo(f1, f2);
        mRealBuilder.joinTo(f2, f3);
        mRealBuilder.joinTo(f3, f4);
        mRealBuilder.joinTo(f4, f5);
        mRealBuilder.joinTo(f5, f6);

        return this;
    }

    public <R1, R2, R3, R4, R5, R6> TaskFlow link(IFunc1<?, R1> f1, IFunc1<R1, R2> f2, IFunc1<R2, R3> f3, IFunc1<R3, R4> f4, IFunc1<R4, R5> f5, IFunc1<R5, R6> f6, IFunc1<R6, ?> f7) {
        mRealBuilder.joinTo(f1, f2);
        mRealBuilder.joinTo(f2, f3);
        mRealBuilder.joinTo(f3, f4);
        mRealBuilder.joinTo(f4, f5);
        mRealBuilder.joinTo(f5, f6);
        mRealBuilder.joinTo(f6, f7);

        return this;
    }

    public <R1, R2, R3, R4, R5, R6, R7> TaskFlow link(IFunc1<?, R1> f1, IFunc1<R1, R2> f2, IFunc1<R2, R3> f3, IFunc1<R3, R4> f4, IFunc1<R4, R5> f5, IFunc1<R5, R6> f6, IFunc1<R6, R7> f7, IFunc1<R7, ?> f8) {
        mRealBuilder.joinTo(f1, f2);
        mRealBuilder.joinTo(f2, f3);
        mRealBuilder.joinTo(f3, f4);
        mRealBuilder.joinTo(f4, f5);
        mRealBuilder.joinTo(f5, f6);
        mRealBuilder.joinTo(f6, f7);
        mRealBuilder.joinTo(f7, f8);

        return this;
    }

    public <R1, R2, R3, R4, R5, R6, R7, R8> TaskFlow link(IFunc1<?, R1> f1, IFunc1<R1, R2> f2, IFunc1<R2, R3> f3, IFunc1<R3, R4> f4, IFunc1<R4, R5> f5, IFunc1<R5, R6> f6, IFunc1<R6, R7> f7, IFunc1<R7, R8> f8, IFunc1<R8, ?> f9) {
        mRealBuilder.joinTo(f1, f2);
        mRealBuilder.joinTo(f2, f3);
        mRealBuilder.joinTo(f3, f4);
        mRealBuilder.joinTo(f4, f5);
        mRealBuilder.joinTo(f5, f6);
        mRealBuilder.joinTo(f6, f7);
        mRealBuilder.joinTo(f7, f8);
        mRealBuilder.joinTo(f8, f9);

        return this;
    }

    public <R1, R2, R3, R4, R5, R6, R7, R8, R9> TaskFlow link(IFunc1<?, R1> f1, IFunc1<R1, R2> f2, IFunc1<R2, R3> f3, IFunc1<R3, R4> f4, IFunc1<R4, R5> f5, IFunc1<R5, R6> f6, IFunc1<R6, R7> f7, IFunc1<R7, R8> f8, IFunc1<R8, R9> f9, IFunc1<R9, ?> f10) {
        mRealBuilder.joinTo(f1, f2);
        mRealBuilder.joinTo(f2, f3);
        mRealBuilder.joinTo(f3, f4);
        mRealBuilder.joinTo(f4, f5);
        mRealBuilder.joinTo(f5, f6);
        mRealBuilder.joinTo(f6, f7);
        mRealBuilder.joinTo(f7, f8);
        mRealBuilder.joinTo(f8, f9);
        mRealBuilder.joinTo(f9, f10);

        return this;
    }
}

