package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

import cn.hjf.taskflow.core.Task;

class CreateFuncTask8 extends CreateFuncTask {

    public CreateFuncTask8(FuncCreator8 funcCreator) {
        super(funcCreator);
    }

    @NonNull
    @Override
    public Task createTask(Object... params) {
        IFunc start = ((FuncCreator8) mFuncCreator).createFunc(params[0], params[1], params[2], params[3], params[4], params[5], params[6], params[7]);
        Task task = TaskCreator.create(start);
        return task;
    }
}
