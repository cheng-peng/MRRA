package com.cxp.module_main.ui.system.activity;

import android.content.Context;
import android.databinding.DataBindingUtil;

import com.alibaba.android.arouter.launcher.ARouter;
import com.cxp.lib_common.base.ARouterPath;
import com.cxp.lib_common.base.BaseActivity;
import com.cxp.lib_common.listener.OnClickListenter;
import com.cxp.lib_common.utils.T;
import com.cxp.module_main.R;
import com.cxp.module_main.databinding.ActivityMainBinding;

/**
 * 文 件 名: MainActivity
 * 创 建 人: CXP
 * 创建日期: 2018-05-25 17:33
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class MainActivity extends BaseActivity {

    private Context mContext;

    @Override
    protected void initView() {
        mContext = this;
        ActivityMainBinding dataBinding= DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
        dataBinding.setOnClickListenter(mOnClickListenter);
    }


    //单击事件
    private OnClickListenter mOnClickListenter = new OnClickListenter() {
        @Override
        public void onClick(int id) {
            if (id == R.id.main_news) {
                T.show(mContext, "News");
            } else if (id == R.id.main_girls) {
                T.show(mContext, "Girls");
            } else if (id == R.id.main_fragment) {
                T.show(mContext, "Fragment");
            }else if (id == R.id.main_test) {
                ARouter.getInstance()
                        .build(ARouterPath.MAIN_TEST)
                        .navigation(MainActivity.this);
            }
        }
    };
}