package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

import cn.hjf.taskflow.core.Task;

class CreateFuncTask7 extends CreateFuncTask {

    public CreateFuncTask7(FuncCreator7 funcCreator) {
        super(funcCreator);
    }

    @NonNull
    @Override
    public Task createTask(Object... params) {
        IFunc start = ((FuncCreator7) mFuncCreator).createFunc(params[0], params[1], params[2], params[3], params[4], params[5], params[6]);
        Task task = TaskTransfer.create(start);
        return task;
    }
}
