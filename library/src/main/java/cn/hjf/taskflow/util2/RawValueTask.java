package cn.hjf.taskflow.util2;

import androidx.annotation.Nullable;

final class RawValueTask extends VariableTask {

    public RawValueTask(Variable variable) {
        super(variable);
    }

    @Nullable
    @Override
    public Object process(Object... params) throws Throwable {
        return mVariable.getValue();
    }
}
