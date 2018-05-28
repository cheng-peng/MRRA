package com.cxp.module_main.ui.test.activity.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

/**
 * 文 件 名: MyViewModel
 * 创 建 人: CXP
 * 创建日期: 2018-04-18 20:38
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class MyViewModel extends ViewModel {

    private MutableLiveData<List<User>> users;
    public MutableLiveData<List<User>> getUsers(){
        if (users==null) {
            users=new MutableLiveData<>();
            //加载数据
            loadUser();
        }
        return users;
    }

    private void loadUser() {

    }
}
