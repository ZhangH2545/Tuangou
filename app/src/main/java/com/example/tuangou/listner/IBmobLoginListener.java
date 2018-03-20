package com.example.tuangou.listner;

import com.example.tuangou.entity.FavorInfo;

import java.util.List;

import cn.bmob.v3.exception.BmobException;

/**
 * Created by layer on 16/11/1.
 */
public interface IBmobLoginListener {

    void sendMsgSucess();
    void loginSucess();
    void querySucess(List<FavorInfo> object);
    void queryFailure(BmobException e);
}
