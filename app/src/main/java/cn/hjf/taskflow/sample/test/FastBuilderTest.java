package cn.hjf.taskflow.sample.test;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import cn.hjf.taskflow.execute.Callback;
import cn.hjf.taskflow.util.FastBuilder;
import cn.hjf.taskflow.util.Func0;
import cn.hjf.taskflow.util.Func2;
import cn.hjf.taskflow.util.IFunc0;
import cn.hjf.taskflow.util.IFunc2;

public class FastBuilderTest {
    public void testUnion() {
        IFunc0<String> f1 = new Func0<String>() {
            @Nullable
            @Override
            protected String process() throws Throwable {
                return "s";
            }
        };
        IFunc0<Integer> f2 = new Func0<Integer>() {
            @Nullable
            @Override
            protected Integer process() throws Throwable {
                return 1;
            }
        };
        IFunc2<String, Integer, String> end = new Func2<String, Integer, String>() {
            @Nullable
            @Override
            protected String process(String s, Integer integer) throws Throwable {
                return s + integer;
            }
        };
        FastBuilder.unionWithoutStart(end, f1, f2).execute(new Callback<String>() {
            @Override
            public void onComplete(@Nullable String s) {
                Log.e("O_O", "onComplete " + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e("O_O", "onError " + e.getMessage());
            }
        });
    }
}
