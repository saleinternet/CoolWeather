package com.csw.android.coolweather.util;

/**
 * Http连接回调函数
 * Created by chensiwen on 15/8/5.
 */
public interface HttpCallbackListener {

    /**
     * 连接完成
     * */
    void onFinish(String response);

    /**
     * 失败
     * */
    void onError(Exception e);
}
