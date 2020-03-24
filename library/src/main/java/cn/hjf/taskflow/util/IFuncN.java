package cn.hjf.taskflow.util;

import cn.hjf.taskflow.execute.Callback;
import cn.hjf.taskflow.execute.Session;

public interface IFuncN<R> extends IFunc<R> {

    default Session execute(Callback<R> callback, Object... params) {
        IFunc.checkFunc(this);
        return IFunc.doExecute(this, callback, params);
    }
}
