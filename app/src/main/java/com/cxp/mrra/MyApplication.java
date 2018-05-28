package com.cxp.mrra;

import android.content.Context;
import android.support.multidex.MultiDex;

import com.alibaba.android.arouter.launcher.ARouter;
import com.cxp.lib_common.base.BaseApplication;
import com.cxp.lib_common.utils.AppUtils;
import com.facebook.stetho.Stetho;

/**
 * 文 件 名: MyApplication
 * 创 建 人: CXP
 * 创建日期: 2018-05-25 16:51
 * 描    述: 初始化
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */

public class MyApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        if (AppUtils.isAppDebug()) {
            //开启InstantRun之后，一定要在ARouter.init之前调用openDebug
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);

        //谷歌调试工具
        Stetho.initializeWithDefaults(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // dex突破65535的限制
        MultiDex.install(this);
    }
}
