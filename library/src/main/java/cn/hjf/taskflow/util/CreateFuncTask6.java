package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

import cn.hjf.taskflow.core.Task;

class CreateFuncTask6 extends CreateFuncTask {

    public CreateFuncTask6(FuncCreator6 funcCreator) {
        super(funcCreator);
    }

    @NonNull
    @Override
    public Task createTask(Object... params) {
        IFunc start = ((FuncCreator6) mFuncCreator).createFunc(params[0], params[1], params[2], params[3], params[4], params[5]);
        Task task = TaskGraphTransfer.create(start);
        return task;
    }
}
