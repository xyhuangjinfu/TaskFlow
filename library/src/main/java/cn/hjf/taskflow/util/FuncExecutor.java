package cn.hjf.taskflow.util;

import cn.hjf.taskflow.core.Task;
import cn.hjf.taskflow.execute.Callback;
import cn.hjf.taskflow.execute.Engine;
import cn.hjf.taskflow.execute.Session;

public final class FuncExecutor {

    public static Session execute(IFunc0 f, Callback callback) {
        return doExecute(f, callback);
    }

    public static <P> Session execute(IFunc1<P, ?> f, Callback callback, P p) {
        return doExecute(f, callback, p);
    }

    public static <P1, P2> Session execute(IFunc2<P1, P2, ?> f, Callback callback, P1 p1, P2 p2) {
        return doExecute(f, callback, p1, p2);
    }

    public static <P1, P2, P3> Session execute(IFunc3<P1, P2, P3, ?> f, Callback callback, P1 p1, P2 p2, P3 p3) {
        return doExecute(f, callback, p1, p2, p3);
    }

    public static <P1, P2, P3, P4> Session execute(IFunc4<P1, P2, P3, P4, ?> f, Callback callback, P1 p1, P2 p2, P3 p3, P4 p4) {
        return doExecute(f, callback, p1, p2, p3, p4);
    }

    public static <P1, P2, P3, P4, P5> Session execute(IFunc5<P1, P2, P3, P4, P5, ?> f, Callback callback, P1 p1, P2 p2, P3 p3, P4 p4, P5 p5) {
        return doExecute(f, callback, p1, p2, p3, p4, p5);
    }

    public static <P1, P2, P3, P4, P5, P6> Session execute(IFunc6<P1, P2, P3, P4, P5, P6, ?> f, Callback callback, P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6) {
        return doExecute(f, callback, p1, p2, p3, p4, p5, p6);
    }

    public static <P1, P2, P3, P4, P5, P6, P7> Session execute(IFunc7<P1, P2, P3, P4, P5, P6, P7, ?> f, Callback callback, P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7) {
        return doExecute(f, callback, p1, p2, p3, p4, p5, p6, p7);
    }

    public static <P1, P2, P3, P4, P5, P6, P7, P8> Session execute(IFunc8<P1, P2, P3, P4, P5, P6, P7, P8, ?> f, Callback callback, P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7, P8 p8) {
        return doExecute(f, callback, p1, p2, p3, p4, p5, p6, p7, p8);
    }

    public static <P1, P2, P3, P4, P5, P6, P7, P8, P9> Session execute(IFunc9<P1, P2, P3, P4, P5, P6, P7, P8, P9, ?> f, Callback callback, P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7, P8 p8, P9 p9) {
        return doExecute(f, callback, p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    public static <P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> Session execute(IFunc10<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, ?> f, Callback callback, P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7, P8 p8, P9 p9, P10 p10) {
        return doExecute(f, callback, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
    }

    public static Session execute(IFuncN f, Callback callback, Object... params) {
        return doExecute(f, callback, params);
    }

    /**
     * ***************************************************************************************************************
     * //
     * ***************************************************************************************************************
     */

    private static Session doExecute(IFunc f, Callback callback, Object... params) {
        Task task = TaskTransfer.create(f);
        return Engine.execute(task, callback, params);
    }
}
