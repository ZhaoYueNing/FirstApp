package com.zhao.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
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


        mButton_1 =(Button)findViewById(R.id.button_1);//button_1实例化
        mButton_1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                /**
                 * 启动一个新的Activity
                 * 显示intent和隐式intent
                 * intent只有当action和category都匹配时才会响应
                 */
//                Intent intent=new Intent(FirstActivity.this,SecondActivity.class);//显示intent
//                Intent intent=new Intent("com.zhao.activitytest.ACTION_START");//隐式intent
//                intent.addCategory("com.zhao.activitytest.MY_CATEGORY");//为intent添加category匹配
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri
                        .parse("http://github.com/zhaoyuening"));//调用浏览器打开网页
                startActivity(intent);//启动新的Activity 将intent对象传入startActivity方法
                Toast.makeText(FirstActivity.this, R.string.create_second_activity, Toast.LENGTH_SHORT).show();
                Log.d("Zhao", getString(R.string.create_second_activity));
            }
        });
        //设置监听器
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
