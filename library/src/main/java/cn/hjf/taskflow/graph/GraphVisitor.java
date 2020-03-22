package cn.hjf.taskflow.graph;

import androidx.annotation.NonNull;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class GraphVisitor {

    public static <E extends IVertex> E findEnd(E start) {
        E end = start;

        while (!start.getNextList().isEmpty()) {
            start = (E) start.getNextList().get(0);
            end = start;
        }

        return end;
    }

    /**
     * ***************************************************************************************************************
     * //
     * ***************************************************************************************************************
     */

    public static <E extends IVertex> void bfsForward(E start, OnVisitListener<E> onVisitListener) {
        AdjacentGetter<E> forwardAdjacentGetter = new AdjacentGetter<E>() {
            @NonNull
            @Override
            public List<E> getAdjacent(E vertex) {
                return vertex.getNextList();
            }
        };

        bfs(start, onVisitListener, forwardAdjacentGetter);
    }

    public static <E extends IVertex> void bfsBackward(E end, OnVisitListener<E> onVisitListener) {
        AdjacentGetter<E> backwardAdjacentGetter = new AdjacentGetter<E>() {
            @NonNull
            @Override
            public List<E> getAdjacent(E vertex) {
                return vertex.getPreList();
            }
        };

        bfs(end, onVisitListener, backwardAdjacentGetter);
    }

    /**
     * ***************************************************************************************************************
     * //
     * ***************************************************************************************************************
     */

    private static <E extends IVertex> void bfs(E startNode, OnVisitListener<E> onVisitListener, AdjacentGetter<E> adjacentGetter) {
        Queue<E> queue = new LinkedList<>();
        queue.add(startNode);

        Set<E> viewedSet = new HashSet<>();

        if (onVisitListener != null) {
            onVisitListener.onStart();
        }

        while (!queue.isEmpty()) {
            E v = queue.poll();
            viewedSet.add(v);

            if (onVisitListener != null) {
                onVisitListener.visit(v);
            }

            for (E next : adjacentGetter.getAdjacent(v)) {
                if (!queue.contains(next) && !viewedSet.contains(next)) {
                    queue.add(next);
                }
            }
        }

        if (onVisitListener != null) {
            onVisitListener.onComplete();
        }
    }

    /**
     * ***************************************************************************************************************
     * <p>
     * ***************************************************************************************************************
     */

    private interface AdjacentGetter<E extends IVertex> {
        @NonNull
        List<E> getAdjacent(E vertex);
    }
}
