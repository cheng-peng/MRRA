package com.cxp.module_main.ui.system.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cxp.lib_common.base.BaseFragment;
import com.cxp.module_main.R;
import com.cxp.module_main.databinding.AboutDataBinding;

/**
 * 文 件 名: AboutFragment
 * 创 建 人: CXP
 * 创建日期: 2018-05-30 11:10
 * 描    述: 关于我们
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class AboutFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        AboutDataBinding dataBinding= DataBindingUtil.inflate(inflater, R.layout.fragment_about,container,false);
        return dataBinding.getRoot();
    }
}
