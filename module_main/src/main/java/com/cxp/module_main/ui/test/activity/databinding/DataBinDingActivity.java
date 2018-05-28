package com.cxp.module_main.ui.test.activity.databinding;

import android.databinding.DataBindingUtil;

import com.cxp.lib_common.base.BaseActivity;
import com.cxp.lib_common.listener.OnClickListenter;
import com.cxp.module_main.R;
import com.cxp.module_main.databinding.DataBindingDemo;

/**
 * 文 件 名: DataBinDingActivity
 * 创 建 人: CXP
 * 创建日期: 2018-05-28 8:56
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class DataBinDingActivity extends BaseActivity {

    @Override
    protected void initView() {
        DataBindingDemo dataBinding= DataBindingUtil.setContentView(DataBinDingActivity.this, R.layout.activity_databinding);
        dataBinding.setOnClickListenter(mOnClickListenter);
    }

    private OnClickListenter mOnClickListenter=new OnClickListenter() {
        @Override
        public void onClick(int id) {
            if (id== R.id.databinding_info) {
                //用户信息
                startActivity(UserInfoActivity.class);
            }else if (id==R.id.databinding_collection){
                //集合使用
                startActivity(CollectionActivity.class);
            }else if (id==R.id.databinding_twobinding){
                //双向绑定
                startActivity(TwoBindingActivity.class);
            }else if (id==R.id.databinding_include){
                //Include绑定
                startActivity(IncludeActivity.class);
            }
        }
    };
}
