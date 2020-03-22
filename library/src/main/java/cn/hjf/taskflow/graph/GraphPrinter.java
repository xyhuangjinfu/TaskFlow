package cn.hjf.taskflow.graph;

import android.util.Log;

import java.util.List;

public final class GraphPrinter {

    private static final String TAG = "GraphPrinter";

    public static <E extends IVertex> void printForward(E start) {
        Log.e(TAG, "printForward -----------------------------------------------------------------------");
        GraphVisitor.bfsForward(start, new OnVisitListener<E>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onVisit(E t) {
                List<E> list = t.getNextList();
                for (E nextTask : list) {
                    Log.e(TAG, t + " -> " + nextTask);
                }
            }

            @Override
            public void onComplete() {

            }

            @Override
            public boolean stop() {
                return false;
            }
        });
    }

    public static <E extends IVertex> void printBackward(E end) {
        Log.e(TAG, "printBackward -----------------------------------------------------------------------");
        GraphVisitor.bfsBackward(end, new OnVisitListener<E>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onVisit(E t) {
                List<E> list = t.getNextList();
                for (E nextTask : list) {
                    Log.e(TAG, t + " -> " + nextTask);
                }
            }

            @Override
            public void onComplete() {

            }

            @Override
            public boolean stop() {
                return false;
            }
        });
    }
}
