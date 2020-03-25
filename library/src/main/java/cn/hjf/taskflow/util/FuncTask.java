package cn.hjf.taskflow.util;

import cn.hjf.taskflow.core.Task;

abstract class FuncTask extends Task {

    protected final Func mFunc;

    public FuncTask(Func func) {
        super(func.getName());
        mFunc = func;
        func.setAttached(true);
    }

    @Override
    public String toString() {
        return "FuncTask{" +
                "mName='" + mName + '\'' +
                ", mId=" + mId +
                '}';
    }
}
