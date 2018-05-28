package com.cxp.module_main.ui.test.activity.livedata;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

/**
 * 文 件 名: NameViewModel
 * 创 建 人: CXP
 * 创建日期: 2018-04-18 14:36
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class NameViewModel extends ViewModel {

    //当前姓名
    private MutableLiveData<String> mCurrentName;
    //姓名列表
    private MutableLiveData<List<String>> mNameListData;

    public MutableLiveData<String> getCurrentName() {
        if (mCurrentName == null) {
            mCurrentName = new MutableLiveData<>();
        }
        return mCurrentName;
    }
    public MutableLiveData<List<String>> getNameList(){
        if (mNameListData == null) {
            mNameListData = new MutableLiveData<>();
        }
        return mNameListData;
    }
}
