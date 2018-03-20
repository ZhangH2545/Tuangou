package com.example.tuangou.nohttp;

import com.yolanda.nohttp.rest.Response;

/**
 * Created by layer on 16/11/1.
 */
public interface HttpListner<T> {
    void onSucceed(int what, Response<T> response);
    void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis);

}
