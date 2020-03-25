package cn.hjf.taskflow.execute;

public class Session {

    private volatile boolean mCanceled = false;
    private final CallbackRunnable mCallbackRunnable;
    private boolean mIsFinished = false;

    public Session(Callback callback) {
        mCallbackRunnable = new CallbackRunnable(callback);
    }

    public void cancel() {
        mCanceled = true;
    }

    boolean isCanceled() {
        return mCanceled;
    }

    synchronized void onFinish(Object result, Throwable error) {
        //check cancel status before execute callback.
        if (mCanceled) {
            return;
        }

        if (mIsFinished) {
            return;
        }
        mIsFinished = true;

        if (isCanceled()) {
            return;
        }

        mCallbackRunnable.setData(result, error);
        CallbackRunnable.finishOnMainThread(mCallbackRunnable);
    }
}
