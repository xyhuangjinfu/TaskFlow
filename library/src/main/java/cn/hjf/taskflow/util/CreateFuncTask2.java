package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

import cn.hjf.taskflow.core.Task;

class CreateFuncTask2 extends CreateFuncTask {

    public CreateFuncTask2(FuncCreator2 funcCreator) {
        super(funcCreator);
    }

    @NonNull
    @Override
    public Task createTask(Object... params) {
        CheckParamUtil.checkParameterCount(getName(), 2, params);
        IFunc start = ((FuncCreator2) mFuncCreator).createFunc(params[0], params[1]);
        Task task = TaskGraphTransfer.create(start);
        return task;
    }
}
