package cn.hjf.taskflow.util2;

import androidx.annotation.Nullable;

final class InvokeTask3 extends VariableTask {

    public InvokeTask3(Variable variable) {
        super(variable);
    }

    @Nullable
    @Override
    public Object process(Object... params) throws Throwable {
        Method3 m = (Method3) mVariable.getMethod();
        return m.execute(params[0], params[1], params[2]);
    }
}
