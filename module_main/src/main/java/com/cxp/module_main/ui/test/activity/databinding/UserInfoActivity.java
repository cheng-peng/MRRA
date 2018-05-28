package com.cxp.module_main.ui.test.activity.databinding;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;

import com.cxp.lib_common.base.BaseActivity;
import com.cxp.lib_common.utils.T;
import com.cxp.module_main.BR;
import com.cxp.module_main.R;
import com.cxp.module_main.bean.UserInfo;
import com.cxp.module_main.databinding.UserInfoDataBinding;

import java.util.Random;

/**
 * 文 件 名: UserInfoActivity
 * 创 建 人: CXP
 * 创建日期: 2018-05-28 9:19
 * 描    述: 动态改变用户信息
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class UserInfoActivity extends BaseActivity {

    private UserInfo mUserInfo;
    private Context mContext;

    @Override
    protected void initView() {
        mContext=this;
        UserInfoDataBinding mDataBinding= DataBindingUtil.setContentView(UserInfoActivity.this, R.layout.activity_userinfo);
        mUserInfo=new UserInfo("CXP",25,"详情");
        mDataBinding.setUserInfo(mUserInfo);
        mDataBinding.setUserInfoChange(new UserInfoChange());
        //属性值发生改变回调
        mUserInfo.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                if (propertyId== BR.name) {
                    T.show(mContext,"改变name");
                }
            }
        });
    }

    public class UserInfoChange{

        public void changeUserInfoName() {
            mUserInfo.setName("CXP" + new Random().nextInt(100));
            mUserInfo.setAge(new Random().nextInt(100));
        }

        public void changeGoodsDetails() {
            mUserInfo.setDetails("details" + new Random().nextInt(100));
            mUserInfo.setAge(new Random().nextInt(100));
        }

    }
}
