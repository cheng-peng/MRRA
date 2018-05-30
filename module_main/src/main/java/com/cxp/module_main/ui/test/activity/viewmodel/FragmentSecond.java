package com.cxp.module_main.ui.test.activity.viewmodel;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cxp.module_main.R;
import com.cxp.module_main.databinding.SecondDataBinding;

/**
 * 文 件 名: FragmentSecond
 * 创 建 人: CXP
 * 创建日期: 2018-05-30 13:46
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class FragmentSecond extends Fragment {

    private FragmentViewModel mFragmentViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        SecondDataBinding dataBinding= DataBindingUtil.inflate(inflater, R.layout.fragment_second,container,false);
        mFragmentViewModel= ViewModelProviders.of(getActivity()).get(FragmentViewModel.class);
        mFragmentViewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                dataBinding.setName(user.getName());
            }
        });
        return dataBinding.getRoot();
    }
}
