package cn.hjf.taskflow.util2;

public interface Method2<P1, P2, R> extends Method {
    R execute(P1 p1, P2 p2);
}
