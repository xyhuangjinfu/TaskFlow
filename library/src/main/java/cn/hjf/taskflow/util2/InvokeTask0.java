package cn.hjf.taskflow.util2;

import androidx.annotation.Nullable;

final class InvokeTask0 extends VariableTask {

    public InvokeTask0(Variable variable) {
        super(variable);
    }

    @Nullable
    @Override
    public Object process(Object... params) throws Throwable {
        Method0 m = (Method0) mVariable.getMethod();
        return m.execute();
    }
}
