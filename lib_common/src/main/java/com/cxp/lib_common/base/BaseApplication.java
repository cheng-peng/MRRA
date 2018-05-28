package com.cxp.lib_common.base;

import android.app.Application;

import com.cxp.lib_common.utils.AppUtils;
import com.cxp.lib_common.utils.ClassUtils;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

import java.util.List;

/**
 * 文 件 名: BaseApplication
 * 创 建 人: CXP
 * 创建日期: 2018-05-25 15:54
 *
 * 要想使用BaseApplication，必须在组件中实现自己的Application，并且继承BaseApplication；
 * 组件中实现的Application必须在debug包中的AndroidManifest.xml中注册，否则无法使用；
 * 组件的Application需置于java/debug文件夹中，不得放于主代码；
 * 组件中获取Context的方法必须为:Utils.getContext()，不允许其他写法；
 */
public class BaseApplication extends Application {

    public static final String ROOT_PACKAGE = "com.cxp.lib_common";

    private static BaseApplication sInstance;

    private List<IApplicationDelegate> mAppDelegateList;

    public static BaseApplication getIns() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)  // (可选）是否显示线程信息。默认值true
                .methodCount(0)         // （可选）要显示多少个方法行。默认2
                .methodOffset(7)        // （可选）将内部方法调用隐藏到偏移量。默认
//                .logStrategy(customLog) // （可选）更改日志策略以打印输出。默认LogCat
                .tag("CXP")   // （可选）每个日志的全局标记。默认PRETTY_LOGGER .build
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));

        AppUtils.init(this);

        //获取单一路径下所有实现了接口的类对象
        mAppDelegateList = ClassUtils.getObjectsWithInterface(this, IApplicationDelegate.class, ROOT_PACKAGE);
        for (IApplicationDelegate delegate : mAppDelegateList) {
            delegate.onCreate();
        }
    }

    /**
     * 程序终止的时候执行
     */
    @Override
    public void onTerminate() {
        super.onTerminate();
        for (IApplicationDelegate delegate : mAppDelegateList) {
            delegate.onTerminate();
        }
    }


    /**
     * 低内存的时候执行
     */
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        for (IApplicationDelegate delegate : mAppDelegateList) {
            delegate.onLowMemory();
        }
    }

    /**
     * 程序在内存清理的时候执行
     * @param level
     */
    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        for (IApplicationDelegate delegate : mAppDelegateList) {
            delegate.onTrimMemory(level);
        }
    }
}
