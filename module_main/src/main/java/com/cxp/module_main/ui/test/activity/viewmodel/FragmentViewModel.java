package com.cxp.module_main.ui.test.activity.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * 文 件 名: FragmentViewModel
 * 创 建 人: CXP
 * 创建日期: 2018-05-30 13:57
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class FragmentViewModel extends ViewModel {

    private MutableLiveData<User> user;

    public MutableLiveData<User> getUser(){
        if (user==null) {
            user=new MutableLiveData<>();
        }
        return user;
    }

}
