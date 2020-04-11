package cn.hjf.taskflow.util2;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import cn.hjf.taskflow.core.Task;

public class Scope {

    private Set<Variable> mVariableSet = new HashSet<>();

    /**
     * ***************************************************************************************************************
     * <p>
     * ***************************************************************************************************************
     */

    Task createTask(Variable variable) {
        checkVariableDeclare(variable);

        Queue<Variable> queue = new LinkedList<>();
        queue.add(variable);
        Set<Variable> visitedOrQueuedSet = new HashSet<>();

        Set<Variable> valueVariableSet = new HashSet<>();

        Map<Variable, Task> variableTaskMap = new HashMap<>();

        while (!queue.isEmpty()) {
            Variable v = queue.poll();
            visitedOrQueuedSet.add(v);

            final Variable[] parameters = v.getParameters();

            if (parameters.length == 0) {
                valueVariableSet.add(v);
            }

            Task task = getOrCreateTask(variableTaskMap, v);
            for (Variable p : parameters) {
                task.after(getOrCreateTask(variableTaskMap, p));
            }

            for (Variable p : parameters) {
                if (!visitedOrQueuedSet.contains(p)) {
                    queue.add(p);
                    visitedOrQueuedSet.add(p);
                }
            }
        }

        List<Variable> valueVariableList = new ArrayList<>(valueVariableSet);
        if (valueVariableList.size() == 1) {
            Variable v = valueVariableList.get(0);
            return variableTaskMap.get(v);
        } else {
            Task task = new Task() {
                @Nullable
                @Override
                public Object process(Object... params) throws Throwable {
                    return null;
                }
            };
            for (Variable v : valueVariableList) {
                Task t = variableTaskMap.get(v);
                t.after(task);
            }
            return task;
        }
    }

    private Task getOrCreateTask(Map<Variable, Task> map, Variable variable) {
        Task task = map.get(variable);
        if (task == null) {
            task = newTask(variable);
            map.put(variable, task);
        }
        return task;
    }

    private Task newTask(Variable variable) {
        if (variable.isRawValueVariable()) {
            return new RawValueTask(variable);
        }

        Method method = variable.getMethod();
        if (method instanceof Method0) {
            return new InvokeTask0(variable);
        } else if (method instanceof Method1) {
            return new InvokeTask1(variable);
        } else if (method instanceof Method2) {
            return new InvokeTask2(variable);
        } else if (method instanceof Method3) {
            return new InvokeTask3(variable);
        }

        throw new IllegalArgumentException("Unknown method type");
    }

    /**
     * ***************************************************************************************************************
     * <p>
     * ***************************************************************************************************************
     */

    public <V> Variable<V> declareVariable(V v) {
        Variable<V> ret = new Variable<>(this, v);
        mVariableSet.add(ret);
        return ret;
    }

    /**
     * ***************************************************************************************************************
     * <p>
     * ***************************************************************************************************************
     */
    public <R> Variable<R> invokeMethod(Method0<R> method) {
        return invokeMethodInternal(method);
    }

    public <P, R> Variable<R> invokeMethod(Method1<P, R> method, Variable<P> param) {
        return invokeMethodInternal(method, param);
    }

    public <P1, P2, R> Variable<R> invokeMethod(Method2<P1, P2, R> method, Variable<P1> param1, Variable<P2> param2) {
        return invokeMethodInternal(method, param1, param2);
    }

    public <P1, P2, P3, R> Variable<R> invokeMethod(Method3<P1, P2, P3, R> method, Variable<P1> param1, Variable<P2> param2, Variable<P3> param3) {
        return invokeMethodInternal(method, param1, param2, param3);
    }

    /**
     * ***************************************************************************************************************
     * <p>
     * ***************************************************************************************************************
     */

    private Variable invokeMethodInternal(Method method, Variable... parameters) {
        checkVariableDeclare(parameters);

        Variable ret = new Variable<>(this, method, parameters);
        mVariableSet.add(ret);
        return ret;
    }

    private void checkVariableDeclare(Variable... variables) {
        for (Variable p : variables) {
            if (!mVariableSet.contains(p)) {
                throw new IllegalArgumentException("Variable not defined yet");
            }
        }
    }
}
