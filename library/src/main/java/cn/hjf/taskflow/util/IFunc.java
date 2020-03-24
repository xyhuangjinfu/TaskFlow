package cn.hjf.taskflow.util;

import cn.hjf.taskflow.core.Task;
import cn.hjf.taskflow.execute.Callback;
import cn.hjf.taskflow.execute.Engine;
import cn.hjf.taskflow.execute.Session;
import cn.hjf.taskflow.graph.IVertex;

public interface IFunc<R> extends IVertex<IFunc> {

    static void checkFunc(IFunc func) {
        if (!func.getNextList().isEmpty()) {
            throw new IllegalArgumentException("func can not have next");
        }
    }

    static Session doExecute(IFunc func, Callback callback, Object... params) {
        Task task = TaskGraphTransfer.create(func);
        return Engine.execute(task, callback, params);
    }
}
