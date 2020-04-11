package cn.hjf.taskflow.util2;

import androidx.annotation.Nullable;

final class InvokeTask2 extends VariableTask {

    public InvokeTask2(Variable variable) {
        super(variable);
    }

    @Nullable
    @Override
    public Object process(Object... params) throws Throwable {
        Method2 m = (Method2) mVariable.getMethod();
        return m.execute(params[0], params[1]);
    }
}
