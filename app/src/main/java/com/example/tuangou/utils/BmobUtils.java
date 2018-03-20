package com.example.tuangou.utils;

import android.util.Log;

import com.example.tuangou.entity.BaseModel;
import com.example.tuangou.entity.FavorInfo;
import com.example.tuangou.entity.MyUser;
import com.example.tuangou.listner.IBmobLoginListener;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by layer on 16/11/1.
 */
public class BmobUtils {

    private static String objID;
    private static IBmobLoginListener mListener;
    private static BmobUtils instance = null;
    //单例
    public static BmobUtils getInstance(IBmobLoginListener mListener2){
        mListener = mListener2;
        if (instance == null){
                return new BmobUtils();
        }
        return instance;
    }


    /***
     * 发送手机验证码
     *
     * @param phoneNumber
     */
    public void sendMsg(String phoneNumber) {
        BmobSMS.requestSMSCode(phoneNumber, "layer", new QueryListener<Integer>() {
            @Override
            public void done(Integer smsId, BmobException ex) {
                if (ex == null) {//验证码发送成功
                    mListener.sendMsgSucess();
                }
            }
        });
    }

    /***
     * 通过验证码登录
     *
     * @param phoneNumber
     * @param code
     */
    public void loginByMsg(String phoneNumber, String code) {
        BmobUser.loginBySMSCode(phoneNumber, code, new LogInListener<MyUser>() {

            @Override
            public void done(MyUser user, BmobException e) {
                if (user != null) {
                    mListener.loginSucess();
                }
            }
        });
    }

    /***
     * 添加数据
     *
     * @param model
     */
    public static void insertData(BaseModel model) {
//注意：不能调用gameScore.setObjectId("")方法
        model.save(new SaveListener<String>() {
            @Override
            public void done(String objectId, BmobException e) {
                if (e == null) {
                    objID = objectId;
                } else {

                }
            }
        });
    }

    /***
     * 删除数据
     *
//     * @param model
     */
    public static void deleteData(BaseModel model) {
        model.setObjectId(objID);
        model.delete(new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    Log.i("bmob", "成功");
                } else {
                    Log.i("bmob", "失败：" + e.getMessage() + "," + e.getErrorCode());
                }
            }
        });
    }


    public static void updateData() {

    }


    public void queryData(FavorInfo model,String queryKey,Object queryValue) {
        BmobQuery<FavorInfo> query = new BmobQuery<>();
        //查询playerName叫“比目”的数据
        query.addWhereEqualTo(queryKey, queryValue);
        //返回50条数据，如果不加上这条语句，默认返回10条数据
        query.setLimit(50);
        //执行查询方法
        query.findObjects(new FindListener<FavorInfo>() {
            @Override
            public void done(List<FavorInfo> object, BmobException e) {
                if (e == null) {
                    mListener.querySucess(object);
                } else {
                    mListener.queryFailure(e);
                }
            }
        });
    }

}
