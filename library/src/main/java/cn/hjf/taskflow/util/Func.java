package cn.hjf.taskflow.util;

import java.util.concurrent.atomic.AtomicLong;

abstract class Func<R> extends AbsFunc<R> {

    private static final AtomicLong sAtomicLong = new AtomicLong(0);

    private final long mId;
    private final String mName;
    private boolean mAttached;

    public Func() {
        this(null);
    }

    public Func(String name) {
        mId = sAtomicLong.getAndIncrement();
        mName = name == null ? "Func-" + mId : name;
    }

    boolean isAttached() {
        return mAttached;
    }

    void setAttached(boolean attached) {
        mAttached = attached;
    }

    public String getName() {
        return mName;
    }

    public long getId() {
        return mId;
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
