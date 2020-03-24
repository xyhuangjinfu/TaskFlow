package cn.hjf.taskflow.util;

import cn.hjf.taskflow.execute.Callback;
import cn.hjf.taskflow.execute.Session;

public interface IFunc7<P1, P2, P3, P4, P5, P6, P7, R> extends IFunc<R> {

    default Session execute(Callback<R> callback, P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7) {
        IFunc.checkFunc(this);
        return IFunc.doExecute(this, callback, p1, p2, p3, p4, p5, p6, p7);
    }
}
