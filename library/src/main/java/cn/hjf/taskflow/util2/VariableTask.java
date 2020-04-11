package cn.hjf.taskflow.util2;

import cn.hjf.taskflow.core.Task;

abstract class VariableTask extends Task {
    protected Variable mVariable;

    public VariableTask(Variable variable) {
        super();
        mVariable = variable;
    }
}
