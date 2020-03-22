package cn.hjf.taskflow.graph;

import android.util.Log;

import java.util.List;

public final class GraphPrinter {

    private static final String TAG = "GraphPrinter";

    public static <E extends IVertex> void printForward(E start) {
        Log.e(TAG, "-----------------------------------------------------------------------");
        GraphVisitor.bfsForward(start, new OnVisitListener<E>() {
            @Override
            public void onStart() {

            }

            @Override
            public void visit(E t) {
                List<E> list = t.getNextList();
                for (E nextTask : list) {
                    Log.e(TAG, t + " -> " + nextTask);
                }
            }

            @Override
            public void onComplete() {

            }
        });
    }

    public static <E extends IVertex> void printBackward(E end) {
        Log.e(TAG, "-----------------------------------------------------------------------");
        GraphVisitor.bfsBackward(end, new OnVisitListener<E>() {
            @Override
            public void onStart() {

            }

            @Override
            public void visit(E t) {
                List<E> list = t.getNextList();
                for (E nextTask : list) {
                    Log.e(TAG, t + " -> " + nextTask);
                }
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
