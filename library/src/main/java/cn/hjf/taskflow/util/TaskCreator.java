package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.hjf.taskflow.core.Task;
import cn.hjf.taskflow.graph.GraphVisitor;
import cn.hjf.taskflow.graph.OnVisitListener;

class TaskCreator {

    /**
     * 从IFunc图构建对应的Task图
     *
     * @param func
     * @return
     */
    public static Task create(@NonNull IFunc func) {
        checkNonNull(func);

//        if (!func.getNextList().isEmpty()) {
//            throw new IllegalArgumentException("func is not a single node");
//        }

        //展开Func图（Func图中可能有复合Func）
        IFunc end = traverseAndExpand(func)[1];

        Task head = createTaskFromExpandFunc(end);

        return head;
    }

    /**
     * ***************************************************************************************************************
     * //
     * ***************************************************************************************************************
     */

    private static Func[] traverseAndExpand(@NonNull IFunc func) {
        checkNonNull(func);

        final IFunc start = func;
        final IFunc end = GraphVisitor.findEnd(func);

        final Func[] startAndEnd = new Func[2];
        if (start instanceof Func) {
            startAndEnd[0] = (Func) start;
        }
        if (end instanceof Func) {
            startAndEnd[1] = (Func) end;
        }

        GraphVisitor.bfsForward(start, new OnVisitListener<IFunc>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onVisit(IFunc f) {
                if (f instanceof CompoundFunc) {
                    Func[] newTerminal = expand((CompoundFunc) f);
                    //如果 start 或者 end 是 复合结构，需要重新指向
                    if (f == start) {
                        startAndEnd[0] = newTerminal[0];
                    }
                    if (f == end) {
                        startAndEnd[1] = newTerminal[1];
                    }
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

        return startAndEnd;
    }

    private static Func[] expand(CompoundFunc iFunc) {
        Map<IFunc, Integer> preLinkMap = new HashMap<>();
        Map<IFunc, Integer> nextLinkMap = new HashMap<>();

        //记录该组合节点在各父节点中的位置，断开父节点到该节点的引用
        List<IFunc> preList = iFunc.getPreList();
        for (IFunc pre : preList) {
            int index = pre.getNextList().indexOf(iFunc);
            pre.getNextList().remove(iFunc);
            preLinkMap.put(pre, index);
        }

        //记录该组合节点在各子节点中的位置，断开子节点到该节点的引用
        List<IFunc> nextList = iFunc.getNextList();
        for (IFunc next : nextList) {
            int index = next.getPreList().indexOf(iFunc);
            next.getPreList().remove(iFunc);
            nextLinkMap.put(next, index);
        }

        //展开该组合节点
        Func[] newTerminal = traverseAndExpand(iFunc.getStart());

        //把新start节点挂载到之前的父节点，并转移向父节点的引用
        IFunc newStart = newTerminal[0];
        for (Map.Entry<IFunc, Integer> e : preLinkMap.entrySet()) {
            IFunc pre = e.getKey();
            int index = e.getValue();
            pre.getNextList().add(index, newStart);
        }
        newStart.getPreList().addAll(iFunc.getPreList());
        iFunc.getPreList().clear();

        //把新end节点挂载到之前的子节点，并转移向子节点的引用
        IFunc newEnd = newTerminal[1];
        for (Map.Entry<IFunc, Integer> e : nextLinkMap.entrySet()) {
            IFunc next = e.getKey();
            int index = e.getValue();
            next.getPreList().add(index, newEnd);
        }
        newEnd.getNextList().addAll(iFunc.getNextList());
        iFunc.getNextList().clear();

        return newTerminal;
    }

    /**
     * ***************************************************************************************************************
     * //
     * ***************************************************************************************************************
     */

    public static Task createTaskFromExpandFunc(@NonNull IFunc endFunc) {
        final Map<Func, Task> map = new HashMap<>();

        final Task[] head = new Task[1];

        GraphVisitor.bfsBackward(endFunc, new OnVisitListener<IFunc>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onVisit(IFunc f) {
                if (!(f instanceof Func)) {
                    throw new RuntimeException("func type error " + f.getClass().getName());
                }

                Task task = getOrCreateTask(map, (Func) f);

                if (f.getPreList().isEmpty()) {
                    head[0] = task;
                }

                List<Func> preList = f.getPreList();
                for (Func pre : preList) {
                    task.after(getOrCreateTask(map, pre));
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

        return head[0];
    }

    private static Task getOrCreateTask(Map<Func, Task> map, Func func) {
        Task task = map.get(func);
        if (task == null) {
            task = FuncTaskCreator.create(func);
            map.put(func, task);
        }
        return task;
    }

    /**
     * ***************************************************************************************************************
     * <p>
     * ***************************************************************************************************************
     */

    private static void checkNonNull(IFunc func) {
        if (func == null) {
            throw new IllegalArgumentException("func not be null");
        }
    }
}
