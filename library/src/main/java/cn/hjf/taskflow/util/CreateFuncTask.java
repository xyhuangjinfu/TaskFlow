package cn.hjf.taskflow.util;

import cn.hjf.taskflow.core.TaskCreator;

abstract class CreateFuncTask extends TaskCreator {

    protected final FuncCreator mFuncCreator;

    public CreateFuncTask(FuncCreator funcCreator) {
        super(funcCreator.getName());
        mFuncCreator = funcCreator;
        funcCreator.setAttached(true);
    }

    @Override
    public String toString() {
        return "CreateFuncTask{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                '}';
    }
}
