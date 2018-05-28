package com.cxp.lib_common.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * 文 件 名: BaseActivity
 * 创 建 人: CXP
 * 创建日期: 2018-05-25 17:15
 * 描    述: Activity基类
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public abstract class BaseActivity extends AppCompatActivity {

    /**
     * 界面初始化前期准备
     */
    protected void beforeInit() {

    }

    /**
     * 获取布局Id
     *
     * @return 布局id
     */
//    protected abstract int getContentViewLayoutId();


    /**
     * 初始化布局及控件
     */
    protected abstract void initView();

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        //执行一些默认的操作
//        ButterKnife.bind(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beforeInit();
//        if (getContentViewLayoutId() != 0) {
//            setContentView(getContentViewLayoutId());
//            initView();
//        }
        initView();
    }

    //页面跳转
    protected void startActivity(Class cls) {
        Intent intent = new Intent(this,cls);
        startActivity(intent);
    }

}
