package com.csw.android.coolweather.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.csw.android.coolweather.service.AutoUpdateService;

/**
 * 后台自动更新天气广播接收器
 * Created by chensiwen on 15/8/7.
 */
public class AutoUpdateReceiver extends BroadcastReceiver {

    /**
     * 启动后台自动更新天气服务
     * */
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, AutoUpdateService.class);
        context.startService(i);
    }
}
