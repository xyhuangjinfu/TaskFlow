package cn.hjf.taskflow.graph;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class GraphVisitor {

    public static <E extends IVertex> E findEnd(E start) {
        final List<E> result = new ArrayList<>();

        dfsForward(start, new OnVisitListener<E>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onVisit(E e) {
                if (e.getNextList().isEmpty()) {
                    result.add(e);
                }
            }

            @Override
            public void onComplete() {

            }

            @Override
            public boolean stop() {
                return !result.isEmpty();
            }
        });

        return result.get(0);
    }

    /**
     * ***************************************************************************************************************
     * //
     * ***************************************************************************************************************
     */

    public static <E extends IVertex> void dfsForward(E start, OnVisitListener<E> onVisitListener) {
        AdjacentGetter<E> forwardAdjacentGetter = new AdjacentGetter<E>() {
            @NonNull
            @Override
            public List<E> getAdjacent(E vertex) {
                return vertex.getNextList();
            }
        };

        dfs(start, onVisitListener, forwardAdjacentGetter, new HashSet<E>(), 0);
    }

    public static <E extends IVertex> void dfsBackward(E end, OnVisitListener<E> onVisitListener) {
        AdjacentGetter<E> backwardAdjacentGetter = new AdjacentGetter<E>() {
            @NonNull
            @Override
            public List<E> getAdjacent(E vertex) {
                return vertex.getPreList();
            }
        };

        dfs(end, onVisitListener, backwardAdjacentGetter, new HashSet<E>(), 0);
    }

    private static <E extends IVertex> void dfs(E vertex, OnVisitListener<E> onVisitListener, AdjacentGetter<E> adjacentGetter, Set<E> visited, int deep) {
        if (deep == 0) {
            if (onVisitListener != null) {
                onVisitListener.onStart();
            }
        }

        if (vertex == null) {
            return;
        }

        visited.add(vertex);
        if (onVisitListener != null) {
            onVisitListener.onVisit(vertex);
        }

        List<E> adjList = adjacentGetter.getAdjacent(vertex);
        for (E adj : adjList) {
            if (onVisitListener != null) {
                if (onVisitListener.stop()) {
                    return;
                }
            }
            if (!visited.contains(adj)) {
                dfs(adj, onVisitListener, adjacentGetter, visited, deep + 1);
            }
        }

        if (deep == 0) {
            if (onVisitListener != null) {
                onVisitListener.onComplete();
            }
        }
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

    private static <E extends IVertex> void bfs(E startNode, OnVisitListener<E> onVisitListener, AdjacentGetter<E> adjacentGetter) {
        Queue<E> queue = new LinkedList<>();
        queue.add(startNode);

        Set<E> viewedOrQueuedSet = new HashSet<>();

        if (onVisitListener != null) {
            onVisitListener.onStart();
        }

        while (!queue.isEmpty()) {
            E v = queue.poll();
            viewedOrQueuedSet.add(v);

            if (onVisitListener != null) {
                onVisitListener.onVisit(v);
            }

            if (onVisitListener != null) {
                if (onVisitListener.stop()) {
                    break;
                }
            }

            for (E next : adjacentGetter.getAdjacent(v)) {
                if (!viewedOrQueuedSet.contains(next)) {
                    queue.add(next);
                    viewedOrQueuedSet.add(next);
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
