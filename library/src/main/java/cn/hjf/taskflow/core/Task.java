package cn.hjf.taskflow.core;

import androidx.annotation.NonNull;

import java.util.concurrent.atomic.AtomicLong;

import cn.hjf.taskflow.graph.AbsVertex;

/**
 * 用来被执行的最小单元，每个Task的属性：
 * 1、[0...N]个输入。
 * 2、有且仅有1个输出。
 * <p>
 * Task之间可以被连接，前一个Task的输出成为后一个Task的输入，多个Task连接后，成为一张Task图。
 * 一个合法的Task图的属性：
 * 1、仅有1个 start 任务。
 * 2、仅有1个 end 任务。
 * 3、有向无环图。
 * <p>
 * 一个Task图可以作为一个组合任务，与其他Task进行连接，形成更大的任务图。
 * Task图的输入由 start 节点接收，输出由 end 节点输出。
 * <p>
 * Task图的表示方式，使用start节点表示：
 * 1、t1->t2->t3，使用t1表示整个任务图。
 * 2、t1，使用t1表示整个单节点任务图。
 */
public abstract class Task extends AbsVertex<Task> {

    private static final AtomicLong sIdGenerator = new AtomicLong(0);

    private final long mId;
    private final String mName;

    public Task() {
        mId = sIdGenerator.getAndIncrement();
        mName = "Task-" + mId;
    }

    public Task(String name) {
        mId = sIdGenerator.getAndIncrement();
        mName = name;
    }

    public long getId() {
        return mId;
    }

    /**
     * ***************************************************************************************************************
     * <p>
     * ***************************************************************************************************************
     */
    @Override
    public String toString() {
        return "Task{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                '}';
    }
/**
 * ***************************************************************************************************************
 * //
 * ***************************************************************************************************************
 */

    /**
     * 覆写该方法来指定该Task的执行逻辑
     *
     * @param params 输入参数列表
     * @return
     * @throws Exception
     */
    @NonNull
    public abstract Object process(Object... params) throws Exception;
}
