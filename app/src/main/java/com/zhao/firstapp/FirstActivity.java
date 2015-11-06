package com.zhao.firstapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

/**
 * 一个测试类
 * 赵岳宁  2015/11/6
 */
public class FirstActivity extends Activity {
    //Button one
    Button mButton_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//取消状态栏显示
        setContentView(R.layout.first_layout);


        //设置监听器
        mButton_1 =(Button)findViewById(R.id.button_1);//button_1实例化
        mButton_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Zhao", "监听器触发");
                Toast.makeText(FirstActivity.this, "This is Button_one!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 设置隐藏式菜单
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    /**
     * 定义菜单的相应事件
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(FirstActivity.this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(FirstActivity.this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }
}
