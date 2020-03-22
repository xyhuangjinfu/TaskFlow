package cn.hjf.taskflow.graph;

public interface OnVisitListener<E> {

    void onStart();

    void onVisit(E e);

    void onComplete();

    boolean stop();
}
