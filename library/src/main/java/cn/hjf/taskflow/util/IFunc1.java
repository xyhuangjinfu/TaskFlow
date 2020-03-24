package cn.hjf.taskflow.util;

import cn.hjf.taskflow.execute.Callback;
import cn.hjf.taskflow.execute.Session;

public interface IFunc1<P, R> extends IFunc<R> {

    default Session execute(Callback<R> callback, P p) {
        IFunc.checkFunc(this);
        return IFunc.doExecute(this, callback, p);
    }
}
