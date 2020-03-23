package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

abstract class CompoundFunc<R> extends AbsFunc<R> {

    @NonNull
    private final IFunc mStart;
    @NonNull
    private final IFunc mEnd;

    public CompoundFunc(@NonNull IFunc start, @NonNull IFunc end) {
        mStart = start;
        mEnd = end;
    }

    @NonNull
    public IFunc getStart() {
        return mStart;
    }

    @NonNull
    public IFunc getEnd() {
        return mEnd;
    }

    @Override
    public String toString() {
        return "CompoundFunc{" +
                "mStart=" + mStart +
                ", mEnd=" + mEnd +
                '}';
    }
}
