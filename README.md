# TaskFlow
TaskFlow is a Task manager framework for android.

Most of the time of develop android application, we process our data in background Thread and then draw on Views in Main Thread.

TaskFlow split your huge data process work into some small data process work, and then compose them into a task graph, and then run this graph in background Thread, when the task graph completed or some exception happened, it will delivery the result to Main Thread.

Those small data process work can be reused later, you can reuse them to compose a renew task graph.

Tasks in the task graph will be run parallel or serial which depend on the dependencies of tasks.

We define our graph, which contains only one start node, only one end node, directed acyclic graph.



# Usage
## Core Module
#### 1、create a task.
Each task have zero to infinite input, and only one output, it should be seen from the method of task.
```
        Task task = new Task() {
            @NonNull
            @Override
            public Object process(Object... params) throws Exception {
                //do everything you want, either network request or disk file access.
                return null;
            }
        };
```

#### 2、execute single task and get the handler.
This `task` run in background Thread, but `Callback` run in Main Thread.
```
        Session session = Engine.execute(task, new Callback() {
            @Override
            public void onComplete(Object o) {
            }

            @Override
            public void onError(Throwable e) {
            }
        });
```
#### 3、cancel the task.
When cancel a task, we cannot stop a running task, but those pending task will not be run.

This is some different from RxJava, which is unsubscribe, so those work still run util complete.
```
        session.cancel();
```
#### 4、create a complex task graph.
If we have a function, we have a userName, and query user info include userId by this userName, and query friend list by userId, finally we display the user info and friend list.

That is, we have three tasks, `queryUserInfo`, `queryFriendList` and `mergeData`.
```
        Task queryUserInfo = new Task() {
            @NonNull
            @Override
            public Object process(Object... params) throws Exception {
                return new UserInfo();
            }
        };
        Task queryFriendList = new Task() {
            @NonNull
            @Override
            public Object process(Object... params) throws Exception {
                return new ArrayList<Friend>();
            }
        };
        Task mergeData = new Task() {
            @NonNull
            @Override
            public Object process(Object... params) throws Exception {
                //params[0] is UserInfo
                //params[1] is List<Friend>
                return null;
            }
        };

        Task start = queryUserInfo;
        queryFriendList.after(queryUserInfo);
        //notice the order
        mergeData.after(queryUserInfo);
        mergeData.after(queryFriendList);
        
        Engine.execute(start, new Callback() {
            @Override
            public void onComplete(Object o) {
            }

            @Override
            public void onError(Throwable e) {
            }
        });
```
*Notice, when we merge user info and friend list into merge data, it is order sensitive, in above case, params\[0\] is UserInfo because mergeData and queryUserInfo linked firstly.*

In addition to primitive operator `before`, we also provide anther primitive operator `after`, they are semantically opposite.



## Extend Module, Utils
Above are the most basic of this framework, theoretically you can build any logic for your data process work, but you can find that it's difficult to build a graph, something as parameters's numbers, types, the valid of a graph, etc... so we provide some util to resolve those problems.

#### 5、use Func instead Task.
`task` is typeless，the only one type is `Object`, when in runtime we can check those problems, but `Func` provide the generic type.

`Func0` means it have zero input, `Func1` means one input, and so on.

Finally some util can transfer a `Func` graph into a `Task` graph, which can be executed by `Engine`.

Below we create a `Func` which receive a `String` type parameter and output a `Integer` result.
```
        Func1<String, Integer> f = new Func1<String, Integer>() {
            @NonNull
            @Override
            protected Integer process(String s) throws Exception {
                return Integer.valueOf(s);
            }
        };
```
#### 6、use graph builder to build graph.
Build a graph corresponding to chapter 4.
```
        Func1<String, UserInfo> queryUserInfo = new Func1<String, UserInfo>() {
            @NonNull
            @Override
            protected UserInfo process(String s) throws Exception {
                return new UserInfo();
            }
        };
        Func1<UserInfo, List<Friend>> queryFriendList = new Func1<UserInfo, List<Friend>>() {
            @NonNull
            @Override
            protected List<Friend> process(UserInfo v) throws Exception {
                return new ArrayList<Friend>();
            }
        };
        Func2<UserInfo, List<Friend>, SearchData> mergeData = new Func2<UserInfo, List<Friend>, SearchData>() {
            @NonNull
            @Override
            protected SearchData process(UserInfo u, List<Friend> l) throws Exception {
                return new SearchData();
            }
        };

        Func funcGraph = new FuncGraphBuilder()
                .joinTo(queryUserInfo, queryFriendList)
                .joinTo(queryUserInfo, queryFriendList, mergeData)
                .create();
```
Use `FuncGraphBuilder` to build graph, finally when `create`, it will check it's a valid graph now. the definition of `joinTo` is:
```
joinTo(f1, f2, f3, f4,....,fn-1, fn)
```
equals:
```
fn.after(f1);
fn.after(f2);
fn.after(f3);
.....
fn.after(fn-1);
```
Because we need to check parameter's type, number and order of the input, so we choose the input point to build our graph, so every node should be joined only once. When you are coding, the order of multiple `joinTo` have no matter.

#### 7、create task graph from func graph.
```
        Task task = new TaskBuilder().create(funcGraph);
```

#### 8、复合结构：
组装数据流不是一件简单的事，我们希望有一些数据流处理逻辑被组装好后，能够被复用，所以我们提供了`CompoundFunc`体系。

一个`CompoundFunc`实际上内部就是一个合法的图，他被当做一个复合节点使用，所以它的输入和输出属性与`Func`一致。复合结构的输入属性就是图中start节点的输入，输出就是end节点的输出。

运行时不存在复合结构，每一个`CompoundFunc`在步骤`7`中，都会被展开。

假设有一个复合结构，先获取例句信息，然后转成老的例句模型。
```
        Func1<Vocab, Example> fetchExample = new Func1<Vocab, Example>() {
            @NonNull
            @Override
            protected Example process(Vocab v) throws Exception {
                return new Example();
            }
        };
        Func1<Example, OldExample> transExample = new Func1<Example, OldExample>() {
            @NonNull
            @Override
            protected OldExample process(Example e) throws Exception {
                return new OldExample(e);
            }
        };

        CompoundFunc1<Vocab, OldExample> cf1 = (CompoundFunc1<Vocab, OldExample>) new CompoundFuncBuilder()
                .joinTo(fetchExample, transExample)
                .create();
```
`CompoundFunc`可以继续组成更大的图，带到第`6`节的例子，代码如下：
```
        Func1<String, Vocab> fetchVocab = new Func1<String, Vocab>() {
            @NonNull
            @Override
            protected Vocab process(String s) throws Exception {
                return new Vocab();
            }
        };
        Func1<Vocab, Example> fetchExample = new Func1<Vocab, Example>() {
            @NonNull
            @Override
            protected Example process(Vocab v) throws Exception {
                return new Example();
            }
        };
        Func1<Example, OldExample> transExample = new Func1<Example, OldExample>() {
            @NonNull
            @Override
            protected OldExample process(Example e) throws Exception {
                return new OldExample();
            }
        };

        CompoundFunc1<Vocab, OldExample> cf1 = (CompoundFunc1<Vocab, OldExample>) new CompoundFuncBuilder()
                .joinTo(fetchExample, transExample)
                .create();

        Func1<Vocab, Favorite> fetchFavorite = new Func1<Vocab, Favorite>() {
            @NonNull
            @Override
            protected Favorite process(Vocab v) throws Exception {
                return new Favorite();
            }
        };
        Func3<Vocab, OldExample, Favorite, SearchData> mergeData = new Func3<Vocab, OldExample, Favorite, SearchData>() {
            @NonNull
            @Override
            protected SearchData process(Vocab vocab, OldExample example, Favorite favorite) throws Exception {
                return new SearchData();
            }
        };

        Func funcGraph = new FuncGraphBuilder()
                .joinTo(fetchVocab, cf1)
                .joinTo(fetchVocab, fetchFavorite)
                .joinTo(fetchVocab, cf1, fetchFavorite, mergeData)
                .create();
```
因为`CompoundFunc`本质上是一个小规模的任务图，所以也是由`CompoundFuncBuilder`来创建，外部无法用其他方法实例化。

#### 9、更加简洁的写法：
上述一系列章节，把整个框架的结构、部件、工作流程及原理都剖析了一遍，所以偏向底层，如果每个需求都要写这么多数据处理和连接无关的代码，也是一种负担，所以我们还提供了一些封装度更高的工具。

在Func已经构建写好的情况下，写完连接信息后直接执行：
```
            Session session = TaskFlow.create()
                .joinTo(f1, f2)
                .joinTo(f2, f3_1)
                .joinTo(f2, f3_2)
                .joinTo(f3_1, f3_2, f4)
                .execute(new Callback<String>(){
                    @Override
                    public void onComplete(String o) {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }
                });
```

上面已经很简洁的写法，在某些场景下，可能依然过于繁琐，比如简单的链接、或者只有一个Func等。


执行只有`1`个任务的图，使用`only`方法：
```
        TaskFlow.create()
                .only(new Func0<Integer>() {
                    @NonNull
                    @Override
                    protected Integer process() throws Exception {
                        return 123;
                    }
                }).execute(new Callback<Integer>() {
            @Override
            public void onComplete(Integer o) {
            }

            @Override
            public void onError(Throwable e) {
            }
        });
```

执行一个简单的连接（每一个节点都只有一个前置节点），使用`link`方法：
```
        TaskFlow.create()
                .link(f1, f2, f3)
                .execute(new Callback() {
                    @Override
                    public void onComplete(Object o) {
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                });
```

执行简单的`join` + `link`结构，该结构是这样的，先把一些节点join在一起，然后后面跟一个连接，也就是`(f1, f2, f3, f4...)->(merge into f5)->(f6)->(f7).....`:
```
        TaskFlow.create()
                .joinTo(f1, f2, f3, f4, f5)
                .link(f5, f6, f7)
                .execute(new Callback() {
                    @Override
                    public void onComplete(Object o) {
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                });
```



***个人建议，如果不是只有一个任务的情况下，不要使用匿名对象，先把任务声明好，比如`fetchVocab`，然后再送去连接，这样的代码会更加清晰，易于理解和维护。***
