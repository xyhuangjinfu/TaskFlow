package cn.hjf.taskflow.util;

import java.util.concurrent.atomic.AtomicLong;

abstract class Func<R> extends AbsFunc<R> {

    static AtomicLong sAtomicLong = new AtomicLong(0);

    private boolean mAttached;
    private long mId;
    private String mName;

    public Func() {
        mId = sAtomicLong.getAndIncrement();
        mName = "Func-" + mId;
    }

    public Func(String name) {
        mId = sAtomicLong.getAndIncrement();
        mName = name;
    }

    boolean isAttached() {
        return mAttached;
    }

    void setAttached(boolean attached) {
        mAttached = attached;
    }

    String getName() {
        return mName;
    }

    @Override
    public String toString() {
        return "Func{" +
                "mAttached=" + mAttached +
                ", mId=" + mId +
                ", mName='" + mName + '\'' +
                '}';
    }
}
