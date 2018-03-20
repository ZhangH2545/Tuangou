package com.example.tuangou.eventbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

public class LoginActivity extends AppCompatActivity {
    private EditText name;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name = (EditText) findViewById(R.id.et_username);
        password = (EditText) findViewById(R.id.et_password);
    }
    public void login(View view){
        EventBus.getDefault().post(new User(name.getText().toString().trim(),password.getText().toString().trim()));
        Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_LONG).show();
        finish();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //进行EventBus进行反注册
        EventBus.getDefault().unregister(this);
    }
}
