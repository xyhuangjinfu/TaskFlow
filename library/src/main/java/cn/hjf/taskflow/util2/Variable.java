package cn.hjf.taskflow.util2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import cn.hjf.taskflow.core.Task;
import cn.hjf.taskflow.execute.Callback;
import cn.hjf.taskflow.execute.Engine;

public class Variable<T> {

    //create from invoke a method
    @NonNull
    private final Variable[] mParameters;
    private final Method mMethod;

    //create from raw value
    private final T mValue;

    @NonNull
    private final Scope mScope;

    /**
     * ***************************************************************************************************************
     * <p>
     * ***************************************************************************************************************
     */

    Variable(@NonNull Scope scope, T value) {
        this(scope, value, null, null);
    }

    Variable(@NonNull Scope scope, @NonNull Method method, @NonNull Variable... parameters) {
        this(scope, null, method, parameters);
    }

    private Variable(@NonNull Scope scope, T value, Method method, Variable... parameters) {
        mScope = scope;
        mValue = value;
        mMethod = method;
        mParameters = parameters == null ? new Variable[0] : parameters;
    }

    /**
     * ***************************************************************************************************************
     * <p>
     * ***************************************************************************************************************
     */

    public void read(VariableReceiver<T> receiver) {
        Task task = mScope.createTask(this);
        Engine.execute(task, new Callback() {
            @Override
            public void onComplete(@Nullable Object o) {
                receiver.onValue((T) o);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                receiver.onError(e);
            }
        });
    }

    /**
     * ***************************************************************************************************************
     * <p>
     * ***************************************************************************************************************
     */

    Variable[] getParameters() {
        return mParameters;
    }

    Method getMethod() {
        return mMethod;
    }

    T getValue() {
        return mValue;
    }

    boolean isRawValueVariable() {
        return mMethod == null;
    }
}
