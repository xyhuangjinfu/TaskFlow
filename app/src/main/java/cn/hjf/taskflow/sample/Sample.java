package cn.hjf.taskflow.sample;

import android.telecom.Call;
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
import cn.hjf.taskflow.util.Func3;
import cn.hjf.taskflow.util.FuncGraphBuilder;
import cn.hjf.taskflow.util.IFunc1;
import cn.hjf.taskflow.util.TaskFlow;

public class Sample {
    class Vocab {
        String s = "";

        public Vocab(String s) {
            this.s = s;
        }
    }

    class ExampleV1 {
        String s = "";

        public ExampleV1(String s) {
            this.s = s;
        }
    }

    class ExampleV2 {
        String s = "";

        public ExampleV2(String s) {
            this.s = s;
        }
    }

    class Favorite {
        String s = "";

        public Favorite(String s) {
            this.s = s;
        }
    }

    class SearchData {
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
                .joinTo(fetchExample, transExample)
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

        TaskFlow.create()
//				.joinTo(fetchVocab, fetchExample)
//				.joinTo(fetchExample, transExample)

                .joinTo(fetchVocab, fetchAndTransExample)

                .joinTo(fetchVocab, fetchFavorite)
                .joinTo(fetchVocab, fetchAndTransExample, fetchFavorite, mergeData)
                .execute(new Callback<SearchData>() {
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

    public void f2() {
        class User {
            String name;

            public User(String name) {
                this.name = name;
            }
        }
        class Friend {
            String name;

            public Friend(String name) {
                this.name = name;
            }
        }
        class FriendDetail {
            Friend mFriend;
            String comment;

            public FriendDetail(Friend friend, String comment) {
                mFriend = friend;
                this.comment = comment;
            }
        }
        class MergeData {
            User mUser;
            List<FriendDetail> mFriendDetails;

            public MergeData(User user, List<FriendDetail> friendDetails) {
                mUser = user;
                mFriendDetails = friendDetails;
            }
        }

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
            protected Task[] createTask(Object... params) {
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

                return new Task[]{start, end};
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
}
