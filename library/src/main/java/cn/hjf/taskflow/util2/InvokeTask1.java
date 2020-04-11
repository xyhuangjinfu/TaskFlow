package cn.hjf.taskflow.util2;

import androidx.annotation.Nullable;

final class InvokeTask1 extends VariableTask {

    public InvokeTask1(Variable variable) {
        super(variable);
    }

    @Nullable
    @Override
    public Object process(Object... params) throws Throwable {
        Method1 m = (Method1) mVariable.getMethod();
        return m.execute(params[0]);
    }
}
