package cn.hjf.taskflow.util;

import androidx.annotation.Nullable;

import cn.hjf.taskflow.execute.Callback;
import cn.hjf.taskflow.execute.Session;

public interface IFunc9<P1, P2, P3, P4, P5, P6, P7, P8, P9, R> extends IFunc<R> {

    default Session execute(Callback<R> callback, @Nullable P1 p1, @Nullable P2 p2, @Nullable P3 p3, @Nullable P4 p4, @Nullable P5 p5, @Nullable P6 p6, @Nullable P7 p7, @Nullable P8 p8, @Nullable P9 p9) {
        IFunc.checkFunc(this);
        return IFunc.doExecute(this, callback, p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }
}
