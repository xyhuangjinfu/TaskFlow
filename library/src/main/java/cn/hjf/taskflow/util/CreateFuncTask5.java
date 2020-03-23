package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

import cn.hjf.taskflow.core.Task;

class CreateFuncTask5 extends CreateFuncTask {

    public CreateFuncTask5(FuncCreator5 funcCreator) {
        super(funcCreator);
    }

    @NonNull
    @Override
    public Task createTask(Object... params) {
        IFunc start = ((FuncCreator5) mFuncCreator).createFunc(params[0], params[1], params[2], params[3], params[4]);
        Task task = TaskTransfer.create(start);
        return task;
    }
}
