package com.cxp.module_main.ui.test.activity.lifecycle;

import android.util.Log;

import com.cxp.lib_common.base.BaseActivity;
import com.cxp.module_main.R;

/**
 * 文 件 名: LifecycleActivity
 * 创 建 人: CXP
 * 创建日期: 2018-05-28 17:22
 * 描    述: 自动设置生命周期
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class LifecycleActivity extends BaseActivity {

    @Override
    protected void initView() {
        setContentView(R.layout.activity_lifecycle);

        Log.e("LifecyleActivity", "onCreate: ");

        LifecyclePresenter mLifecyclePresenter = new LifecyclePresenter();
        getLifecycle().addObserver(mLifecyclePresenter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("LifecyleActivity", "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("LifecyleActivity", "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("LifecyleActivity", "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("LifecyleActivity", "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("LifecyleActivity", "onDestroy: ");
    }
}
