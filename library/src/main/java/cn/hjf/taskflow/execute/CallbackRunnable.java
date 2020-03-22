package cn.hjf.taskflow.execute;

import android.os.Handler;
import android.os.Looper;

/**
 * 执行结果回调的任务，应该只被放进队列一次
 */
class CallbackRunnable implements Runnable {

    private final Callback mCallback;
    private Object mResult;
    private Throwable mError;

    public CallbackRunnable(Callback callback) {
        mCallback = callback;
    }

    public void setData(Object result, Throwable error) {
        mResult = result;
        mError = error;
    }

    @Override
    public void run() {
        if (mCallback != null) {
            if (mError == null) {
                mCallback.onComplete(mResult);
            } else {
                mCallback.onError(mError);
            }
        }
    }

    /**
     * ***************************************************************************************************************
     * <p>
     * ***************************************************************************************************************
     */

    private static Handler sMainHandler = new Handler(Looper.getMainLooper());

    public static void finishOnMainThread(CallbackRunnable callbackRunnable) {
        sMainHandler.post(callbackRunnable);
    }
}
