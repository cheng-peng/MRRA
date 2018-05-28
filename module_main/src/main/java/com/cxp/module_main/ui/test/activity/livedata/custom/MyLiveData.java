package com.cxp.module_main.ui.test.activity.livedata.custom;

import android.arch.lifecycle.LiveData;
import android.util.Log;

/**
 * 文 件 名: MyLiveData
 * 创 建 人: CXP
 * 创建日期: 2018-04-18 19:39
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class MyLiveData extends LiveData<String> {

    private final String TAG = "MyLiveData";

    private int count = 0;
    private boolean RUN = true;

    private LongTimeWork mThread=new LongTimeWork();

    public MyLiveData() {
        mThread.start();
    }

    @Override
    protected void onActive() {
        super.onActive();

        //当调用observe的时候执行   （调用observe的页面显示会执行）
        Log.e(TAG, "onActive");

        RUN = true;

        //类似于终端进程
        mThread.interrupt();
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        //当取消调用observe的时候执行   （切换后台，或者页面不可见执行）
        Log.e(TAG, "onInactive");

        RUN = false;
    }

    private class LongTimeWork extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    if (!RUN) {
                        Thread.sleep(Long.MAX_VALUE);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                count++;
                postValue(String.valueOf(count));

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

