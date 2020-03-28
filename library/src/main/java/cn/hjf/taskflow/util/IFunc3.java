package cn.hjf.taskflow.util;

import androidx.annotation.Nullable;

import cn.hjf.taskflow.execute.Callback;
import cn.hjf.taskflow.execute.Session;

public interface IFunc3<P1, P2, P3, R> extends IFunc<R> {

    default Session execute(Callback<R> callback, @Nullable P1 p1, @Nullable P2 p2, @Nullable P3 p3) {
        IFunc.checkFunc(this);
        return IFunc.doExecute(this, callback, p1, p2, p3);
    }
}
