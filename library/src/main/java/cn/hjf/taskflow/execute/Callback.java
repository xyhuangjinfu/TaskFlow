package cn.hjf.taskflow.execute;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * The callback of the result of the task execute.
 *
 * @param <T>
 */
public interface Callback<T> {
    void onComplete(@Nullable T t);

    void onError(@NonNull Throwable e);
}
