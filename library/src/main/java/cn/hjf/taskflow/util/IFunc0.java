package cn.hjf.taskflow.util;

import cn.hjf.taskflow.execute.Callback;
import cn.hjf.taskflow.execute.Session;

public interface IFunc0<R> extends IFunc<R> {

    default Session execute(Callback<R> callback) {
        IFunc.checkFunc(this);
        return IFunc.doExecute(this, callback);
    }
}
