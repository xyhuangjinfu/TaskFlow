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



## extend module, utils
上面描述了这个框架的最基本构建，理论上，你可以构建出你想要的任意数据流处理逻辑，但是你应该能发现，构建一个复杂的任务流，难度很大，包括但不限于 参数个数及类型的安全、连接原语的细粒度、任务图的合法性（单顶点有向无环）检查。所以我们提供了工具包，来解决相应的问题。

#### 5、使用Func来替代Task：
`task`是无类型的，输入输出全是`Object`类型，只有在运行时才能检测出类型和个数问题，`func`体系提供了泛型机制。

`Func0`代表0个输入，`Func1`代表1个输入，以此类推。目前我们框架内部内置最大支持`9`个。如果有极个别需求超出限制，使用`Task`机制。

最终会有工具把`Func`图转换为`Task`图，然后可以被引擎执行。

创建一个接收一个`String`，返回一个`Integer`的`Func`：
```
        Func1<String, Integer> f = new Func1<String, Integer>() {
            @NonNull
            @Override
            protected Integer process(String s) throws Exception {
                return Integer.valueOf(s);
            }
        };
```
#### 6、使用图构建工具来构建图：
之前我们使用`before`或者`after`原语来构建任务图，`Func`体系也有一样的原语来构建`Func`图。但我们一般不使用，因为我们无法保证构建出一张合法图，所以我们提供了图构建工具。

构建一个查词框任务图：
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
        Func1<Vocab, Favorite> fetchFavorite = new Func1<Vocab, Favorite>() {
            @NonNull
            @Override
            protected Favorite process(Vocab v) throws Exception {
                return new Favorite();
            }
        };
        Func3<Vocab, Example, Favorite, SearchData> mergeData = new Func3<Vocab, Example, Favorite, SearchData>() {
            @NonNull
            @Override
            protected SearchData process(Vocab vocab, Example example, Favorite favorite) throws Exception {
                return new SearchData();
            }
        };

        Func funcGraph = new FuncGraphBuilder()
                .joinTo(fetchVocab, fetchExample)
                .joinTo(fetchVocab, fetchFavorite)
                .joinTo(fetchVocab, fetchExample, fetchFavorite, mergeData)
                .create();
```
使用`FuncGraphBuilder`来构建图，最后`create`的时候，会做图的合法性检查。`joinTo`语义为：
```
joinTo(f1, f2, f3, f4,....,fn-1, fn)
```
等价于：
```
fn.after(f1);
fn.after(f2);
fn.after(f3);
.....
fn.after(fn-1);
```
因为需要做参数类型、个数、顺序的检查，所以我们选择了输入点来实现该功能，所以每个节点只能被 `joinTo` `1`次，编码时，多个`joinTo`的顺序没有实际意义，不影响数据流向。

#### 7、使用Func图来构建Task图：
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
