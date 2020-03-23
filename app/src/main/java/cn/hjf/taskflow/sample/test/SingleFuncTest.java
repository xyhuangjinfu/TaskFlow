package cn.hjf.taskflow.sample.test;

import android.util.Log;

import androidx.annotation.NonNull;

import cn.hjf.taskflow.execute.Callback;
import cn.hjf.taskflow.util.Func1;
import cn.hjf.taskflow.util.FuncExecutor;

public class SingleFuncTest {

    public void toInt(final String value) {
        Func1<String, Integer> f = new Func1<String, Integer>() {
            @NonNull
            @Override
            protected Integer process(String s) throws Exception {
                return Integer.valueOf(s);
            }
        };

        FuncExecutor.execute(f, new Callback<Integer>() {
            @Override
            public void onComplete(Integer o) {
                Log.e("O_O", "onComplete " + value + " , " + o);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("O_O", "onError " + value + " , " + e.getMessage());
            }
        }, value);
    }

    public void toIntDealWithException(final String value) {
        Func1<String, Integer> f = new Func1<String, Integer>() {
            @NonNull
            @Override
            protected Integer process(String s) throws Exception {
                try {
                    return Integer.valueOf(s);
                } catch (Exception e) {
                    return -1;
                }
            }
        };

        FuncExecutor.execute(f, new Callback<Integer>() {
            @Override
            public void onComplete(Integer o) {
                Log.e("O_O", "onComplete " + value + " , " + o);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("O_O", "onError " + value + " , " + e.getMessage());
            }
        }, value);
    }
}
