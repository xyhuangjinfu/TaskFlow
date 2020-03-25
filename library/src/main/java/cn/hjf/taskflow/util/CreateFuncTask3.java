package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

import cn.hjf.taskflow.core.Task;

class CreateFuncTask3 extends CreateFuncTask {

    public CreateFuncTask3(FuncCreator3 funcCreator) {
        super(funcCreator);
    }

    @NonNull
    @Override
    public Task createTask(Object... params) {
        CheckParamUtil.checkParameterCount(getName(), 3, params);
        IFunc start = ((FuncCreator3) mFuncCreator).createFunc(params[0], params[1], params[2]);
        Task task = TaskGraphTransfer.create(start);
        return task;
    }
}
