package cn.hjf.taskflow.sample.test;

import android.util.Log;

import androidx.annotation.NonNull;

import cn.hjf.taskflow.execute.Callback;
import cn.hjf.taskflow.util.CompoundFuncBuilder0;
import cn.hjf.taskflow.util.Func0;
import cn.hjf.taskflow.util.Func1;
import cn.hjf.taskflow.util.Func2;
import cn.hjf.taskflow.util.IFunc0;
import cn.hjf.taskflow.util.IFunc1;
import cn.hjf.taskflow.util.IFunc2;

public class NullTest {

    public void test() {
        IFunc0<String> start = new Func0<String>() {
            @NonNull
            @Override
            protected String process() throws Throwable {
                return null;
            }
        };
        IFunc1<String, String> f1 = new Func1<String, String>() {
            @NonNull
            @Override
            protected String process(String s) throws Throwable {
                return null;
            }
        };
        IFunc1<String, String> f2 = new Func1<String, String>() {
            @NonNull
            @Override
            protected String process(String s) throws Throwable {
                return null;
            }
        };
        IFunc2<String, String, String> end = new Func2<String, String, String>() {
            @NonNull
            @Override
            protected String process(String s1, String s2) throws Throwable {
                return null;
            }
        };

        IFunc0<String> f = new CompoundFuncBuilder0<String>(start)
                .addEnd(end, f1, f2)
                .addNormal(f1, start)
                .addNormal(f2, start)
                .create();
        f.execute(new Callback<String>() {
            @Override
            public void onComplete(String s) {
                Log.e("O_O", "onComplete " + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("O_O", "onError " + e.getMessage());
            }
        });
    }
}
