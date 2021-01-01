package com.example.testtbs;

import android.app.Application;
import android.util.Log;

import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.sdk.QbSdk;

import java.util.HashMap;


/**
 * @Description:
 * @CreateDate: 2020/12/31 0031 22:03
 * @Author: liusheng
 * @UpdateDate: 2020/12/31 0031 22:03
 * @UpdateRemark:
 * @Version: V1.0
 */
public class MyApp extends Application {

    private String TAG="MyApp";
    @Override
    public void onCreate() {
        super.onCreate();
        initX5();
    }


       private void initX5() {
           // 在调用TBS初始化、创建WebView之前进行如下配置
           HashMap map = new HashMap();
           map.put(TbsCoreSettings.TBS_SETTINGS_USE_SPEEDY_CLASSLOADER, true);
           map.put(TbsCoreSettings.TBS_SETTINGS_USE_DEXLOADER_SERVICE, true);
           QbSdk.initTbsSettings(map);
            //x5內核初始化回调
           QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {
               @Override
               public void onViewInitFinished(boolean arg0) {
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                   if(arg0){
                       Log.e(TAG, "x5內核初始化完成,内核加载--成功 " );
                   }else {
                       Log.e(TAG, "x5內核初始化完成,内核加载--失败，自动切换使用系统内核 " );
                   }
               }
               @Override
               public void onCoreInitFinished() {Log.e(TAG, "========onCoreInitFinished===");
               }
           };
           //流量下载内核
           QbSdk.setDownloadWithoutWifi(true);
            //x5内核初始化接口
           QbSdk.initX5Environment(getApplicationContext(), cb);
        }
}
