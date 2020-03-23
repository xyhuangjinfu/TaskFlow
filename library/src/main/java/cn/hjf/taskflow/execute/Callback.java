package cn.hjf.taskflow.execute;

/**
 * The callback of the result of the task execute.
 *
 * @param <T>
 */
public interface Callback<T> {
    void onComplete(T o);

    void onError(Throwable e);
}
