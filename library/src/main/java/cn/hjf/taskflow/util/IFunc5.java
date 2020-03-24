package cn.hjf.taskflow.util;

import cn.hjf.taskflow.execute.Callback;
import cn.hjf.taskflow.execute.Session;

public interface IFunc5<P1, P2, P3, P4, P5, R> extends IFunc<R> {

    default Session execute(Callback<R> callback, P1 p1, P2 p2, P3 p3, P4 p4, P5 p5) {
        IFunc.checkFunc(this);
        return IFunc.doExecute(this, callback, p1, p2, p3, p4, p5);
    }
}
