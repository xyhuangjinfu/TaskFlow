package cn.hjf.taskflow.util;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.hjf.taskflow.core.Task;
import cn.hjf.taskflow.graph.GraphVisitor;
import cn.hjf.taskflow.graph.OnVisitListener;

/**
 * Utils to create task graph from func graph
 */
class TaskTransfer {

    /**
     * create task graph from func graph.
     *
     * @param func
     * @return
     */
    public static Task create(@NonNull IFunc func) {
        checkNonNull(func);

        //Expand func graph, because it may contain compound func, task graph and execute engine don't support compound structure.
        IFunc end = traverseAndExpand(func)[1];

        Task start = createTaskFromExpandFunc(end);

        return start;
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
                    Func[] newBound = expand((CompoundFunc) f);
                    //if start or end is compound structure, we need to re-point.
                    if (f == start) {
                        startAndEnd[0] = newBound[0];
                    }
                    if (f == end) {
                        startAndEnd[1] = newBound[1];
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

        //record this compound func's position in it's parents and disconnect them.
        List<IFunc> preList = iFunc.getPreList();
        for (IFunc pre : preList) {
            int index = pre.getNextList().indexOf(iFunc);
            pre.getNextList().remove(iFunc);
            preLinkMap.put(pre, index);
        }

        //record this compound func's position in it's children and disconnect them.
        List<IFunc> nextList = iFunc.getNextList();
        for (IFunc next : nextList) {
            int index = next.getPreList().indexOf(iFunc);
            next.getPreList().remove(iFunc);
            nextLinkMap.put(next, index);
        }

        //do expand
        Func[] newBound = traverseAndExpand(iFunc.getStart());

        //re-point start, to parents and children.
        IFunc newStart = newBound[0];
        for (Map.Entry<IFunc, Integer> e : preLinkMap.entrySet()) {
            IFunc pre = e.getKey();
            int index = e.getValue();
            pre.getNextList().add(index, newStart);
        }
        newStart.getPreList().addAll(iFunc.getPreList());
        iFunc.getPreList().clear();

        //re-point end, to parents and children.
        IFunc newEnd = newBound[1];
        for (Map.Entry<IFunc, Integer> e : nextLinkMap.entrySet()) {
            IFunc next = e.getKey();
            int index = e.getValue();
            next.getPreList().add(index, newEnd);
        }
        newEnd.getNextList().addAll(iFunc.getNextList());
        iFunc.getNextList().clear();

        return newBound;
    }

    /**
     * ***************************************************************************************************************
     * //
     * ***************************************************************************************************************
     */

    private static Task createTaskFromExpandFunc(@NonNull IFunc endFunc) {
        final Map<Func, Task> map = new HashMap<>();

        final Task[] start = new Task[1];

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
                    start[0] = task;
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

        return start[0];
    }

    private static Task getOrCreateTask(Map<Func, Task> map, Func func) {
        Task task = map.get(func);
        if (task == null) {
            task = TaskGenerator.create(func);
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
