package cn.hjf.taskflow.graph;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public abstract class AbsVertex<E extends IVertex> implements IVertex<E> {

    private List<E> mNextList = new ArrayList<>();
    private List<E> mPreList = new ArrayList<>();

    @Override
    public void before(E next) {
        next.getPreList().add(this);
        this.getNextList().add(next);
    }

    @Override
    public void after(E pre) {
        pre.getNextList().add(this);
        this.getPreList().add(pre);
    }

    @Override
    public void setPreList(@NonNull List<E> preList) {
        mPreList.clear();
        mPreList.addAll(preList);
    }

    @NonNull
    @Override
    public List<E> getPreList() {
        return mPreList;
    }

    @Override
    public void setNextList(@NonNull List<E> nextList) {
        mNextList.clear();
        mNextList.addAll(nextList);
    }

    @NonNull
    @Override
    public List<E> getNextList() {
        return mNextList;
    }
}
