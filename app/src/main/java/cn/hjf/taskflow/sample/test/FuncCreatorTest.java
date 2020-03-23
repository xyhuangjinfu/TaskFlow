package cn.hjf.taskflow.sample.test;

import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.hjf.taskflow.execute.Callback;
import cn.hjf.taskflow.util.Func1;
import cn.hjf.taskflow.util.FuncCreator1;
import cn.hjf.taskflow.util.FuncExecutor;
import cn.hjf.taskflow.util.CompoundFuncBuilder;
import cn.hjf.taskflow.util.FuncN;
import cn.hjf.taskflow.util.IFunc;
import cn.hjf.taskflow.util.IFunc1;

public class FuncCreatorTest {

    private class Friend {
        String id;

        public Friend(String id) {
            this.id = id;
        }
    }

    public void test(final String userId) {
        Func1<String, List<String>> getFriendIdList = new Func1<String, List<String>>("getFriendIdList") {
            @NonNull
            @Override
            protected List<String> process(String s) throws Exception {
                return Arrays.asList(s + " f-1", s + " f-2", s + " f-3", s + " f-4");
            }
        };

        FuncCreator1<List<String>, List<Friend>> creator1 = new FuncCreator1<List<String>, List<Friend>>("creator1") {
            @NonNull
            @Override
            protected IFunc createFunc(final List<String> list) {
                Func1<List<String>, List<String>> start = new Func1<List<String>, List<String>>("start") {
                    @NonNull
                    @Override
                    protected List<String> process(List<String> list) throws Exception {
                        return list;
                    }
                };
                FuncN<List<Friend>> end = new FuncN<List<Friend>>("end") {
                    @NonNull
                    @Override
                    protected List<Friend> process(Object... params) throws Exception {
                        List<Friend> l = new ArrayList<>();
                        for (Object o : params) {
                            l.add((Friend) o);
                        }
                        return l;
                    }
                };

                int index = 0;
                for (int i = 0; i < list.size(); i++) {
                    final int findex = index;
                    Func1<List<String>, Friend> f = new Func1<List<String>, Friend>("f " + findex) {
                        @NonNull
                        @Override
                        protected Friend process(List<String> s) throws Exception {
                            return new Friend(list.get(findex));
                        }
                    };

                    start.before(f);
                    f.before(end);

                    index++;
                }

                return start;
            }
        };

        IFunc1<String, List<Friend>> getAllFriend = (IFunc1<String, List<Friend>>) new CompoundFuncBuilder()
                .joinTo(creator1, getFriendIdList)
                .create();

        FuncExecutor.execute(getAllFriend, new Callback<List<Friend>>() {
            @Override
            public void onComplete(List<Friend> o) {
                Log.e("O_O", "onComplete " + userId + " , " + o);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("O_O", "onError " + userId + " , " + e.getMessage());
            }
        }, userId);
    }
}
