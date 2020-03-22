package cn.hjf.taskflow.graph;

import androidx.annotation.NonNull;

import java.util.List;

public interface IVertex<E extends IVertex> {

    void before(E next);

    void after(E pre);

    @NonNull
    List<E> getPreList();

    @NonNull
    List<E> getNextList();
}
