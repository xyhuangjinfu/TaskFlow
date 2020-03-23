package cn.hjf.taskflow.util;

public abstract class FuncCreator<R> extends Func<R> {

    public FuncCreator() {
    }

    public FuncCreator(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "FuncCreator{" +
                "mAttached=" + mAttached +
                ", mId=" + mId +
                ", mName='" + mName + '\'' +
                '}';
    }
}
