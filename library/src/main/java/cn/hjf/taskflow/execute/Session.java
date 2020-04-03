package cn.hjf.taskflow.execute;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Session {

    private volatile boolean mCanceled = false;
    private final CallbackRunnable mCallbackRunnable;
    private boolean mIsFinished = false;
    private Lock mFinishLock = new ReentrantLock();

    public Session(Callback callback) {
        mCallbackRunnable = new CallbackRunnable(callback);
    }

    public void cancel() {
        mCanceled = true;
    }

    boolean isCanceled() {
        return mCanceled;
    }

    void onFinish(Object result, Throwable error) {
        mFinishLock.lock();
        try {
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
        } finally {
            mFinishLock.unlock();
        }
    }
}
