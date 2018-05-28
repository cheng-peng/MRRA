package com.cxp.module_main.ui.test.activity.databinding;

import android.databinding.DataBindingUtil;

import com.cxp.lib_common.base.BaseActivity;
import com.cxp.module_main.R;
import com.cxp.module_main.bean.UserInfoOField;
import com.cxp.module_main.databinding.ActivityIncludeBinding;

/**
 * 文 件 名: IncludeActivity
 * 创 建 人: CXP
 * 创建日期: 2018-05-28 16:17
 * 描    述: include使用数据绑定
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class IncludeActivity extends BaseActivity {
    @Override
    protected void initView() {
        ActivityIncludeBinding dataBinding= DataBindingUtil.setContentView(IncludeActivity.this, R.layout.activity_include);
        UserInfoOField mUserInfoOField=new UserInfoOField("CXP",25,"哈哈");
        dataBinding.setUserInfo(mUserInfoOField);
    }
}
