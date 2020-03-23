package cn.hjf.taskflow.util;

import cn.hjf.taskflow.core.Task;
import cn.hjf.taskflow.execute.Callback;
import cn.hjf.taskflow.execute.Engine;
import cn.hjf.taskflow.execute.Session;

public final class FuncExecutor {

    public static <R> Session execute(IFunc0<R> f, Callback<R> callback) {
        checkFunc(f);
        return doExecute(f, callback);
    }

    public static <P, R> Session execute(IFunc1<P, R> f, Callback<R> callback, P p) {
        checkFunc(f);
        return doExecute(f, callback, p);
    }

    public static <P1, P2, R> Session execute(IFunc2<P1, P2, R> f, Callback<R> callback, P1 p1, P2 p2) {
        checkFunc(f);
        return doExecute(f, callback, p1, p2);
    }

    public static <P1, P2, P3, R> Session execute(IFunc3<P1, P2, P3, R> f, Callback<R> callback, P1 p1, P2 p2, P3 p3) {
        checkFunc(f);
        return doExecute(f, callback, p1, p2, p3);
    }

    public static <P1, P2, P3, P4, R> Session execute(IFunc4<P1, P2, P3, P4, R> f, Callback<R> callback, P1 p1, P2 p2, P3 p3, P4 p4) {
        checkFunc(f);
        return doExecute(f, callback, p1, p2, p3, p4);
    }

    public static <P1, P2, P3, P4, P5, R> Session execute(IFunc5<P1, P2, P3, P4, P5, R> f, Callback<R> callback, P1 p1, P2 p2, P3 p3, P4 p4, P5 p5) {
        checkFunc(f);
        return doExecute(f, callback, p1, p2, p3, p4, p5);
    }

    public static <P1, P2, P3, P4, P5, P6, R> Session execute(IFunc6<P1, P2, P3, P4, P5, P6, R> f, Callback<R> callback, P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6) {
        checkFunc(f);
        return doExecute(f, callback, p1, p2, p3, p4, p5, p6);
    }

    public static <P1, P2, P3, P4, P5, P6, P7, R> Session execute(IFunc7<P1, P2, P3, P4, P5, P6, P7, R> f, Callback<R> callback, P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7) {
        checkFunc(f);
        return doExecute(f, callback, p1, p2, p3, p4, p5, p6, p7);
    }

    public static <P1, P2, P3, P4, P5, P6, P7, P8, R> Session execute(IFunc8<P1, P2, P3, P4, P5, P6, P7, P8, R> f, Callback<R> callback, P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7, P8 p8) {
        checkFunc(f);
        return doExecute(f, callback, p1, p2, p3, p4, p5, p6, p7, p8);
    }

    public static <P1, P2, P3, P4, P5, P6, P7, P8, P9, R> Session execute(IFunc9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R> f, Callback<R> callback, P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7, P8 p8, P9 p9) {
        checkFunc(f);
        return doExecute(f, callback, p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    public static <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, R> Session execute(IFunc10<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, R> f, Callback<R> callback, P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7, P8 p8, P9 p9, P10 p10) {
        checkFunc(f);
        return doExecute(f, callback, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
    }

    public static <R> Session execute(IFuncN<R> f, Callback<R> callback, Object... params) {
        checkFunc(f);
        return doExecute(f, callback, params);
    }

    /**
     * ***************************************************************************************************************
     * //
     * ***************************************************************************************************************
     */

    private static void checkFunc(IFunc func) {
        if (!func.getNextList().isEmpty()) {
            throw new IllegalArgumentException("func can not have next");
        }
    }

    private static Session doExecute(IFunc f, Callback callback, Object... params) {
        Task task = TaskTransfer.create(f);
        return Engine.execute(task, callback, params);
    }
}
