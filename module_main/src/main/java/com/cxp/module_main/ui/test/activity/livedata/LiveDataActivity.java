package com.cxp.module_main.ui.test.activity.livedata;

import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.cxp.lib_common.base.BaseActivity;
import com.cxp.lib_common.listener.OnClickListenter;
import com.cxp.module_main.R;
import com.cxp.module_main.databinding.ActivityLivedataBinding;
import com.cxp.module_main.ui.test.activity.livedata.custom.MyLiveDataActivity;

/**
 * 文 件 名: LiveDataActivity
 * 创 建 人: CXP
 * 创建日期: 2018-05-28 17:11
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class LiveDataActivity extends BaseActivity {

    @Override
    protected void initView() {
        ActivityLivedataBinding dataBinding= DataBindingUtil.setContentView(LiveDataActivity.this, R.layout.activity_livedata);
        dataBinding.setOnClickListenter(mOnClickListenter);

        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        LiveDataFragment fragment=new LiveDataFragment();
        ft.add(R.id.livedata_fl,fragment);
        ft.commit();

    }

    private OnClickListenter mOnClickListenter=new OnClickListenter() {
        @Override
        public void onClick(int id) {
            startActivity(MyLiveDataActivity.class);
        }
    };
}
