package com.cxp.lib_common.base;

import android.support.annotation.Keep;

/**
 * 文 件 名: IApplicationDelegate
 * 创 建 人: CXP
 * 创建日期: 2018-05-25 16:23
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
@Keep
public interface IApplicationDelegate {

    void onCreate();

    void onTerminate();

    void onLowMemory();

    void onTrimMemory(int level);

}
