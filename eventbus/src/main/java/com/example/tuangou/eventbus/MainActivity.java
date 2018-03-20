package com.example.tuangou.eventbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {
    private TextView  username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //进行EventBus进行注册
        EventBus.getDefault().register(this);
      username = (TextView) findViewById(R.id.tv_username);
    }

    //接收订阅事件
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(User event) {
        /* Do something */
        username.setText("用户名为:"+event.getUsername());

    };
    public void startlogin(View view){
        startActivity(new Intent(this,LoginActivity.class));
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //进行EventBus进行反注册
        EventBus.getDefault().unregister(this);
    }
}
