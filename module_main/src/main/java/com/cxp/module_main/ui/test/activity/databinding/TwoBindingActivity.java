package com.cxp.module_main.ui.test.activity.databinding;

import android.databinding.DataBindingUtil;

import com.cxp.lib_common.base.BaseActivity;
import com.cxp.module_main.R;
import com.cxp.module_main.bean.UserInfoOField;
import com.cxp.module_main.databinding.TwoBinding;

/**
 * 文 件 名: TwoBindingActivity
 * 创 建 人: CXP
 * 创建日期: 2018-05-28 12:50
 * 描    述: 双向绑定
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class TwoBindingActivity extends BaseActivity {

    @Override
    protected void initView() {

        TwoBinding twoBinding= DataBindingUtil.setContentView(TwoBindingActivity.this, R.layout.activity_twobinding);
        UserInfoOField mUserInfoOField=new UserInfoOField("CXP",25,"哈哈");
        twoBinding.setUserInfo(mUserInfoOField);

    }
}
