package cn.hjf.taskflow.sample;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import cn.hjf.taskflow.sample.test.CompoundFuncTest;
import cn.hjf.taskflow.sample.test.FuncCreatorTest;
import cn.hjf.taskflow.sample.test.FuncGraphTest;
import cn.hjf.taskflow.sample.test.FuncLinkTest;
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

//        new SingleFuncTest().toInt("123");
//        new SingleFuncTest().toInt("123ss");
//        new SingleFuncTest().toIntDealWithException("123ss");
//
//        new FuncLinkTest().testPass("40");
//        new FuncLinkTest().testPass("80");
//        new FuncLinkTest().testPass("80a");

//        new FuncGraphTest().testData("abcd");

//        new CompoundFuncTest().testData("abcdef");

        new FuncCreatorTest().test("hjf");
    }
}
