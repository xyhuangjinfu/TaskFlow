package cn.hjf.taskflow.graph;

public interface OnVisitListener<E> {
    void onStart();

    void visit(E e);

    void onComplete();
}
