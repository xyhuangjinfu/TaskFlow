package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

import cn.hjf.taskflow.core.Task;

class CreateFuncTask0 extends CreateFuncTask {

    public CreateFuncTask0(FuncCreator0 funcCreator) {
        super(funcCreator);
    }

    @NonNull
    @Override
    public Task createTask(Object... params) {
        IFunc start = ((FuncCreator0) mFuncCreator).createFunc();
        Task task = cn.hjf.taskflow.util.TaskCreator.create(start);
        return task;
    }
}
