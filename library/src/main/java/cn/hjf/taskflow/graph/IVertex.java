package cn.hjf.taskflow.graph;

import androidx.annotation.NonNull;

import java.util.List;

/**
 * A graph vertex, which can be linked with other vertex.
 *
 * @param <E>
 */
public interface IVertex<E extends IVertex> {

    /**
     * This vertex is before of next vertex.
     *
     * @param next next vertex of this vertex.
     */
    void before(E next);

    /**
     * This vertex is after of previous vertex.
     *
     * @param pre previous vertex of this vertex.
     */
    void after(E pre);

    void setPreList(@NonNull List<E> preList);

    @NonNull
    List<E> getPreList();

    void setNextList(@NonNull List<E> nextList);

    @NonNull
    List<E> getNextList();
}
