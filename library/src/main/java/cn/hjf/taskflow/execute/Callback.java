package cn.hjf.taskflow.execute;

/**
 * Task执行的结果回调对象
 *
 * @param <T>
 */
public interface Callback<T> {
    void onComplete(T o);

    void onError(Throwable e);
}
