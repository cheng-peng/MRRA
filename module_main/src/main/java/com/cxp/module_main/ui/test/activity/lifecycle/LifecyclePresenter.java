package com.cxp.module_main.ui.test.activity.lifecycle;

import android.arch.lifecycle.LifecycleOwner;
import android.util.Log;

/**
 * 文 件 名: LifecyclePresenter
 * 创 建 人: CXP
 * 创建日期: 2018-04-18 11:23
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class LifecyclePresenter implements LifecycleIPresenter {

    @Override
    public void onCreate(LifecycleOwner owner) {
        Log.e("LifecyclePresenter", "onCreate: ");
    }

    @Override
    public void onStart(LifecycleOwner owner) {
        Log.e("LifecyclePresenter", "onStart: ");
    }

    @Override
    public void onResume(LifecycleOwner owner) {
        Log.e("LifecyclePresenter", "onResume: ");
    }

    @Override
    public void onPause(LifecycleOwner owner) {
        Log.e("LifecyclePresenter", "onPause: ");
    }

    @Override
    public void onStop(LifecycleOwner owner) {
        Log.e("LifecyclePresenter", "onStop: ");
    }

    @Override
    public void onDestroy(LifecycleOwner owner) {
        Log.e("LifecyclePresenter", "onDestroy: ");
    }

}
