package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

import cn.hjf.taskflow.core.Task;

class CreateFuncTaskN extends CreateFuncTask {

    public CreateFuncTaskN(FuncCreatorN funcCreator) {
        super(funcCreator);
    }

    @NonNull
    @Override
    public Task createTask(Object... params) {
        IFunc start = ((FuncCreatorN) mFuncCreator).createFunc(params);
        Task task = TaskTransfer.create(start);
        return task;
    }
}
