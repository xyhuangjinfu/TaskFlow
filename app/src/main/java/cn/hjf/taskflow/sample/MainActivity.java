package cn.hjf.taskflow.sample;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import cn.hjf.taskflow.sample.test.SingleFuncTest;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("O_O", "---------------------------------------------------------------------");
//        new Sample().f1();
//        new Sample().f2();
//        new Sample().f3();

        new SingleFuncTest().toInt("123");
        new SingleFuncTest().toInt("123ss");
        new SingleFuncTest().toIntDealWithException("123ss");
    }
}
