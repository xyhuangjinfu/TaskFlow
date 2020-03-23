package cn.hjf.taskflow.sample.test;

import android.util.Log;

import androidx.annotation.NonNull;

import cn.hjf.taskflow.execute.Callback;
import cn.hjf.taskflow.util.CompoundFuncBuilder1;
import cn.hjf.taskflow.util.Func1;
import cn.hjf.taskflow.util.FuncExecutor;
import cn.hjf.taskflow.util.IFunc1;

public class FuncLinkTest {

    public void testPass(final String value) {
        Func1<String, Integer> toInt = new Func1<String, Integer>() {
            @NonNull
            @Override
            protected Integer process(String s) throws Exception {
                return Integer.valueOf(s);
            }
        };
        Func1<Integer, Boolean> compare = new Func1<Integer, Boolean>() {
            @NonNull
            @Override
            protected Boolean process(Integer integer) throws Exception {
                return integer > 60;
            }
        };
        Func1<Boolean, String> toResult = new Func1<Boolean, String>() {
            @NonNull
            @Override
            protected String process(Boolean b) throws Exception {
                return b ? "pass" : "not pass";
            }
        };

        IFunc1<String, String> f = new CompoundFuncBuilder1<String, String>(toInt)
                .addEnd(toResult, compare)
                .addNormal(compare, toInt)
                .create();

        FuncExecutor.execute(f, new Callback<String>() {
            @Override
            public void onComplete(String o) {
                Log.e("O_O", "onComplete " + value + " , " + o);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("O_O", "onError " + value + " , " + e.getMessage());
            }
        }, value);
    }
}
