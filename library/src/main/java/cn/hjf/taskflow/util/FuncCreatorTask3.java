package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

import cn.hjf.taskflow.core.Task;
import cn.hjf.taskflow.core.TaskCreator;
import cn.hjf.taskflow.graph.GraphVisitor;

class FuncCreatorTask3 extends TaskCreator {

    private final FuncCreator3 mFuncCreator;

    public FuncCreatorTask3(FuncCreator3 funcCreator) {
        super(funcCreator.getName());
        mFuncCreator = funcCreator;
        funcCreator.setAttached(true);
    }

    @NonNull
    @Override
    protected Task createTask(Object... params) {
        IFunc[] startAndEnd = mFuncCreator.createFunc(params[0], params[1], params[2]);
        Task task = cn.hjf.taskflow.util.TaskCreator.create(startAndEnd[0]);
        return task;
    }
}
