package cn.hjf.taskflow.sample.test;

import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import cn.hjf.taskflow.core.Task;
import cn.hjf.taskflow.core.TaskCreator;
import cn.hjf.taskflow.execute.Callback;
import cn.hjf.taskflow.execute.Engine;
import cn.hjf.taskflow.util.Func0;
import cn.hjf.taskflow.util.Func1;
import cn.hjf.taskflow.util.Func2;
import cn.hjf.taskflow.util.Func3;
import cn.hjf.taskflow.util.FuncCreator1;
import cn.hjf.taskflow.util.FuncGraphBuilder;
import cn.hjf.taskflow.util.FuncN;
import cn.hjf.taskflow.util.IFunc;
import cn.hjf.taskflow.util.IFunc0;
import cn.hjf.taskflow.util.IFunc1;
import cn.hjf.taskflow.util.IFunc2;
import cn.hjf.taskflow.util.IFuncN;
import cn.hjf.taskflow.util.TaskFlow;

public class Sample {
    private class Vocab {
        String s = "";

        public Vocab(String s) {
            this.s = s;
        }
    }

    private class ExampleV1 {
        String s = "";

        public ExampleV1(String s) {
            this.s = s;
        }
    }

    private class ExampleV2 {
        String s = "";

        public ExampleV2(String s) {
            this.s = s;
        }
    }

    private class Favorite {
        String s = "";

        public Favorite(String s) {
            this.s = s;
        }
    }

    private class SearchData {
        String s = "";

        public SearchData(String s) {
            this.s = s;
        }
    }

    public void f1() {
        Func0<Vocab> fetchVocab = new Func0<Vocab>("fetchVocab") {
            @NonNull
            @Override
            protected Vocab process() throws Exception {
                return new Vocab("vocab");
            }
        };
        Func1<Vocab, ExampleV1> fetchExample = new Func1<Vocab, ExampleV1>("fetchExample") {
            @NonNull
            @Override
            protected ExampleV1 process(Vocab vocab) throws Exception {
                return new ExampleV1("examplev1 " + vocab.s);
            }
        };
        Func1<ExampleV1, ExampleV2> transExample = new Func1<ExampleV1, ExampleV2>("transExample") {
            @NonNull
            @Override
            protected ExampleV2 process(ExampleV1 exampleV1) throws Exception {
                return new ExampleV2("examplev2 " + exampleV1.s);
            }
        };
        Func1<Vocab, Favorite> fetchFavorite = new Func1<Vocab, Favorite>("fetchFavorite") {
            @NonNull
            @Override
            protected Favorite process(Vocab vocab) throws Exception {
                return new Favorite("favorite " + vocab.s);
            }
        };
        Func3<Vocab, ExampleV2, Favorite, SearchData> mergeData = new Func3<Vocab, ExampleV2, Favorite, SearchData>("mergeData") {
            @NonNull
            @Override
            protected SearchData process(Vocab p, ExampleV2 exampleV2, Favorite favorite) throws Exception {
                return new SearchData("search \n" + p.s + "\n" + exampleV2.s + "\n" + favorite.s);
            }
        };

        IFunc1<Vocab, ExampleV2> fetchAndTransExample = (IFunc1<Vocab, ExampleV2>) new FuncGraphBuilder()
                .joinTo(transExample, fetchExample)
                .create();

        Func1<String, String> ff = new Func1<String, String>() {
            @NonNull
            @Override
            protected String process(String s) throws Exception {
                return "qwer";
            }
        };
//		TaskFlow.create()
//				.only(ff)
//				.execute(new Callback<String>() {
//					@Override
//					public void onComplete(String o) {
//						Log.e("O_O", o);
//					}
//
//					@Override
//					public void onError(Throwable e) {
//						Log.e("O_O", e.getMessage());
//					}
//				});

        IFunc0<SearchData> f = (IFunc0<SearchData>) new TaskFlow()

                .joinTo(fetchAndTransExample, fetchVocab)

                .joinTo(fetchFavorite, fetchVocab)
                .joinTo(mergeData, fetchVocab, fetchAndTransExample, fetchFavorite)
                .create();
        TaskFlow.execute(f, new Callback<SearchData>() {
            @Override
            public void onComplete(SearchData o) {
                Log.e("O_O", o.s);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("O_O", e.getMessage());
            }
        });
    }

    private class User {
        String name;

        public User(String name) {
            this.name = name;
        }
    }

    private class Friend {
        String name;

        public Friend(String name) {
            this.name = name;
        }
    }

    private class FriendDetail {
        Friend mFriend;
        String comment;

        public FriendDetail(Friend friend, String comment) {
            mFriend = friend;
            this.comment = comment;
        }
    }

    private class MergeData {
        User mUser;
        List<FriendDetail> mFriendDetails;

        public MergeData(User user, List<FriendDetail> friendDetails) {
            mUser = user;
            mFriendDetails = friendDetails;
        }
    }

    public void f2() {

        Task queryUser = new Task("queryUser") {
            @NonNull
            @Override
            public Object process(Object... params) throws Exception {
                Log.e("O_O", "queryUser " + Thread.currentThread().getName());
                return new User("hjf");
            }
        };
        Task queryFriendList = new Task("queryFriendList") {
            @NonNull
            @Override
            public Object process(Object... params) throws Exception {
                Log.e("O_O", "queryFriendList " + Thread.currentThread().getName());
                List<Friend> list = new ArrayList<>();
                list.add(new Friend("fa"));
                list.add(new Friend("fb"));
                list.add(new Friend("fc"));
                return list;
            }
        };
        TaskCreator queryFriendDetailTaskCreator = new TaskCreator("queryFriendDetailTaskCreator") {
            @Override
            public Task createTask(Object... params) {
                Log.e("O_O", "queryFriendDetailTaskCreator " + Thread.currentThread().getName());
                List<Friend> list = (List<Friend>) params[0];

                Task start = new Task("start") {
                    @NonNull
                    @Override
                    public Object process(Object... params) throws Exception {
                        Log.e("O_O", "start " + Thread.currentThread().getName());
                        return params[0];
                    }
                };
                Task end = new Task("end") {
                    @NonNull
                    @Override
                    public Object process(Object... params) throws Exception {
                        Log.e("O_O", "end " + Thread.currentThread().getName());
                        List<FriendDetail> l = new ArrayList<>();
                        for (Object o : params) {
                            FriendDetail f = (FriendDetail) o;
                            l.add(f);
                        }
                        return l;
                    }
                };

                int num = 0;
                for (Friend o : list) {
                    num++;
                    final Friend f = (Friend) o;

                    Task query = new Task("query " + num) {
                        @NonNull
                        @Override
                        public Object process(Object... params) throws Exception {
                            Log.e("O_O", "query " + Thread.currentThread().getName());
                            return new FriendDetail(f, "xxx");
                        }
                    };

                    start.before(query);
                    query.before(end);
                }

                return start;
            }
        };
        Task mergeData = new Task("mergeData") {
            @NonNull
            @Override
            public Object process(Object... params) throws Exception {
                Log.e("O_O", "mergeData " + Thread.currentThread().getName());
                return new MergeData((User) params[0], (List<FriendDetail>) params[1]);
            }
        };

        queryUser.before(queryFriendList);
        queryFriendList.before(queryFriendDetailTaskCreator);

        queryUser.before(mergeData);
        queryFriendDetailTaskCreator.before(mergeData);

        Engine.execute(queryUser, new Callback() {
            @Override
            public void onComplete(Object o) {
                Log.e("O_O", o.toString());
            }

            @Override
            public void onError(Throwable e) {
                Log.e("O_O", e.getMessage());
            }
        });
    }

    public void f3() {
        IFunc0<User> queryUser = new Func0<User>("queryUser") {
            @NonNull
            @Override
            public User process() throws Exception {
                Log.e("O_O", "queryUser " + Thread.currentThread().getName());
                return new User("hjf");
            }
        };
        IFunc1<User, List<Friend>> queryFriendList = new Func1<User, List<Friend>>("queryFriendList") {
            @NonNull
            @Override
            public List<Friend> process(User u) throws Exception {
                Log.e("O_O", "queryFriendList " + Thread.currentThread().getName());
                List<Friend> list = new ArrayList<>();
                list.add(new Friend("fa" + u.name));
                list.add(new Friend("fb" + u.name));
                list.add(new Friend("fc" + u.name));
                return list;
            }
        };

        IFunc1<List<Friend>, List<FriendDetail>> queryFriendDetailTaskCreator = new FuncCreator1<List<Friend>, List<FriendDetail>>("queryFriendDetailTaskCreator") {
            @Override
            protected IFunc createFunc(List<Friend> p) {
                Log.e("O_O", "queryFriendDetailTaskCreator " + Thread.currentThread().getName());

                IFunc1<List<Friend>, List<Friend>> start = new Func1<List<Friend>, List<Friend>>("start") {
                    @NonNull
                    @Override
                    public List<Friend> process(List<Friend> friendList) throws Exception {
                        Log.e("O_O", "start " + Thread.currentThread().getName());
                        return friendList;
                    }
                };
                IFuncN<List<FriendDetail>> end = new FuncN<List<FriendDetail>>("end") {
                    @NonNull
                    @Override
                    public List<FriendDetail> process(Object... params) throws Exception {
                        Log.e("O_O", "end " + Thread.currentThread().getName());
                        List<FriendDetail> l = new ArrayList<>();
                        for (Object o : params) {
                            FriendDetail f = (FriendDetail) o;
                            l.add(f);
                        }
                        return l;
                    }
                };

                int num = 0;
                for (Friend o : p) {

                    final int index = num;
                    IFunc1<List<Friend>, FriendDetail> query = new Func1<List<Friend>, FriendDetail>("query " + num) {
                        @NonNull
                        @Override
                        public FriendDetail process(List<Friend> f) throws Exception {
                            Log.e("O_O", "query " + Thread.currentThread().getName());
                            return new FriendDetail(f.get(index), "xxx");
                        }
                    };

                    start.before(query);
                    query.before(end);

                    num++;
                }

                return start;
            }
        };

        IFunc2<User, List<FriendDetail>, MergeData> mergeData = new Func2<User, List<FriendDetail>, MergeData>("mergeData") {
            @NonNull
            @Override
            public MergeData process(User u, List<FriendDetail> l) throws Exception {
                Log.e("O_O", "mergeData " + Thread.currentThread().getName());
                return new MergeData(u, l);
            }
        };

//        IFunc<MergeData> f = new TaskFlow<SearchData>()
//                .joinTo(queryUser, queryFriendList)
//                .joinTo(queryFriendList, queryFriendDetailTaskCreator)
//                .joinTo(queryUser, queryFriendDetailTaskCreator, mergeData)
////                .create();
//                TaskFlow.execute(f,new Callback() {
//                    @Override
//                    public void onComplete(Object o) {
//                        Log.e("O_O", o.toString());
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e("O_O", e.getMessage());
//                    }
//                });

        IFunc0<MergeData> f = (IFunc0<MergeData>) new TaskFlow<MergeData>()
                .joinTo(queryFriendList, queryUser)
                .joinTo(queryFriendDetailTaskCreator, queryFriendList)
                .joinTo(mergeData, queryUser, queryFriendDetailTaskCreator)
                .create();
        TaskFlow.execute(f, new Callback() {
            @Override
            public void onComplete(Object o) {
                Log.e("O_O", o.toString());
            }

            @Override
            public void onError(Throwable e) {
                Log.e("O_O", e.getMessage());
            }
        });
    }
}
