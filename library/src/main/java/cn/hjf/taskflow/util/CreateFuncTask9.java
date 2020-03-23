package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

import cn.hjf.taskflow.core.Task;

class CreateFuncTask9 extends CreateFuncTask {

    public CreateFuncTask9(FuncCreator9 funcCreator) {
        super(funcCreator);
    }

    @NonNull
    @Override
    public Task createTask(Object... params) {
        IFunc start = ((FuncCreator9) mFuncCreator).createFunc(params[0], params[1], params[2], params[3], params[4], params[5], params[6], params[7], params[8]);
        Task task = TaskGraphTransfer.create(start);
        return task;
    }
}
