package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

import cn.hjf.taskflow.core.Task;

class CreateFuncTask4 extends CreateFuncTask {

    public CreateFuncTask4(FuncCreator4 funcCreator) {
        super(funcCreator);
    }

    @NonNull
    @Override
    public Task createTask(Object... params) {
        IFunc start = ((FuncCreator4) mFuncCreator).createFunc(params[0], params[1], params[2], params[3]);
        Task task = TaskTransfer.create(start);
        return task;
    }
}
