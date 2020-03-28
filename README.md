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
            @Nullable
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
                return new SearchData((UserInfo) params[0], (List<Friend>) params[1]);
            }
        };

        Task start = queryUserInfo;
        queryFriendList.after(queryUserInfo);
        //notice the order
        mergeData.after(queryUserInfo);
        mergeData.after(queryFriendList);
        
        Engine.execute(start, new Callback() {
            @Override
            public void onComplete(@Nullable Object o) {
            }

            @Override
            public void onError(@NonNull Throwable e) {
            }
        });
```
*Notice, when we merge user info and friend list into merge data, it is order sensitive, in above case, params\[0\] is UserInfo because mergeData and queryUserInfo linked firstly.*

In addition to primitive operator `before`, we also provide anther primitive operator `after`, they are semantically opposite.



## Extend Module, Utils
Above are the most basic of this framework, theoretically you can build any logic for your data process work, but you can find that it's difficult to build a graph, something as parameters's numbers, types, the valid of a graph, etc... so we provide some util to resolve those problems.

#### 5、use Func instead Task.
`task` is typeless，the only one type is `Object`, when in runtime we can check those problems, but `IFunc` provide the generic type.

`IFunc0` means it have zero input, `IFunc1` means one input, and so on.

Finally some util can transfer a `IFunc` graph into a `Task` graph, which can be executed by `Engine`.

Below we create a `IFunc` which receive a `String` type parameter and output a `Integer` result.
```
        IFunc1<String, Integer> f = new Func1<String, Integer>() {
            @Nullable
            @Override
            protected Integer process(@Nullable String s) throws Exception {
                return Integer.valueOf(s);
            }
        };
```
#### 6、create compound func.
Build a compound func corresponding to chapter 4.
```
        IFunc1<String, UserInfo> queryUserInfo = new Func1<String, UserInfo>() {
            @Nullable
            @Override
            protected UserInfo process(@Nullable String s) throws Exception {
                return new UserInfo();
            }
        };
        IFunc1<UserInfo, List<Friend>> queryFriendList = new Func1<UserInfo, List<Friend>>() {
            @Nullable
            @Override
            protected List<Friend> process(@Nullable UserInfo v) throws Exception {
                return new ArrayList<Friend>();
            }
        };
        IFunc2<UserInfo, List<Friend>, SearchData> mergeData = new Func2<UserInfo, List<Friend>, SearchData>() {
            @Nullable
            @Override
            protected SearchData process(@Nullable UserInfo u, @Nullable List<Friend> l) throws Exception {
                return new SearchData(u, l);
            }
        };

        IFunc1<String, SearchData> funcGraph = new CompoundFuncBuilder1<String, SearchData>(queryUserInfo)
                .addNormal(queryFriendList, queryUserInfo)
                .addEnd(mergeData, queryUserInfo, queryFriendList)
                .create();
```
Use `CompoundFuncBuilder` series to build graph, number of `CompoundFuncBuilder` are the same of the number of `Func`, finally when `create`, it will check it's a valid graph now. the definition of `addNormal` or `addEnd` is:
```
addXxx(func, f1, f2, f3, f4,....,fn-1, fn)
```
equals:
```
func.after(f1);
func.after(f2);
func.after(f3);
.....
func.after(fn);
```
`addNormal` means add the normal func which neither start nor end and link it to it's pre funcs, `addEnd` means add the end func and link it to it's pre funcs.

Because we need to check parameter's type, number and order of the input, so we choose the input point to build our graph, so every node should be linked only once. When you are coding, the order of multiple `addXxx` have no matter.

#### 7、execute IFunc.
When you have a IFunc instance, you can direct execute it, for example:
```
        IFunc1<String, UserInfo> queryUserInfo = new Func1<String, UserInfo>() {
            @Nullable
            @Override
            protected UserInfo process(@Nullable String s) throws Exception {
                return new UserInfo();
            }
        };
        queryUserInfo.execute(new Callback<UserInfo>(){
            @Override
            public void onComplete(@Nullable Object o) {
            }

            @Override
            public void onError(@NonNull Throwable e) {
            }
        }, "");
        
        
        IFunc1<String, SearchData> funcGraph = new CompoundFuncBuilder1<String, SearchData>(queryUserInfo)
                .addNormal(queryFriendList, queryUserInfo)
                .addEnd(mergeData, queryUserInfo, queryFriendList)
                .create();
        funcGraph.execute(new Callback<SearchData>(){
            @Override
            public void onComplete(@Nullable Object o) {
            }

            @Override
            public void onError(@NonNull Throwable e) {
            }
        }, "");
```

#### 8、common graph structure：
Many times we only want to build commonly used graph structure, like simple link, for example `f1 -> f2 -> f3 -> Callback`, or like simple union, for example `(f11, f12, f13) -> f2 -> f3 -> Callback`.
We can use `FastBuilder` to create those simple structure.

```
        IFunc f = FastBuilder.link(f1, f2, f3).create();
```

or
```
        IFunc f = FastBuilder.link(FastBuilder.unionWithoutStart(f2, f11, f12, f13), f3).create();
```
