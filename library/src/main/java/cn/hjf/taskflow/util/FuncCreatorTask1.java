package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

import cn.hjf.taskflow.core.Task;
import cn.hjf.taskflow.core.TaskCreator;
import cn.hjf.taskflow.graph.GraphVisitor;

class FuncCreatorTask1 extends TaskCreator {

    private final FuncCreator1 mFuncCreator;

    public FuncCreatorTask1(FuncCreator1 funcCreator) {
        super(funcCreator.getName());
        mFuncCreator = funcCreator;
        funcCreator.setAttached(true);
    }

    @NonNull
    @Override
    protected Task createTask(Object... params) {
        IFunc[] startAndEnd = mFuncCreator.createFunc(params[0]);
        Task task = cn.hjf.taskflow.util.TaskCreator.create(startAndEnd[0]);
        return task;
    }
}
