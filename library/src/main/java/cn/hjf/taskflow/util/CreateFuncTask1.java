package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

import cn.hjf.taskflow.core.Task;

class CreateFuncTask1 extends CreateFuncTask {

    public CreateFuncTask1(FuncCreator1 funcCreator) {
        super(funcCreator);
    }

    @NonNull
    @Override
    public Task createTask(Object... params) {
        IFunc start = ((FuncCreator1) mFuncCreator).createFunc(params[0]);
        Task task = TaskGraphTransfer.create(start);
        return task;
    }
}
