package com.example.tuangou;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.igexin.sdk.PushManager;
import com.yolanda.nohttp.NoHttp;

import cn.bmob.v3.Bmob;

//import cn.bmob.v3.Bmob;

/**
 * Created by layer on 16/11/1.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {

        super.onCreate();
        //NoHttp初始化配置
        NoHttp.initialize(this);

        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
        SDKInitializer.initialize(getApplicationContext());

        //Fresco图片加载框架初始化
        Fresco.initialize(this);

        //bmob的初始化
        Bmob.initialize(this,"52d1927aa1752997597cf87618836ae9");

    }
}
