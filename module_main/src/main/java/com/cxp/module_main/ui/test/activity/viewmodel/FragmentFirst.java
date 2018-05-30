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

import com.cxp.lib_common.listener.OnClickListenter;
import com.cxp.module_main.R;
import com.cxp.module_main.databinding.FirstDataBinding;

/**
 * 文 件 名: FragmentFirst
 * 创 建 人: CXP
 * 创建日期: 2018-05-30 13:46
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class FragmentFirst extends Fragment {

    private FragmentViewModel mFragmentViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FirstDataBinding dataBinding= DataBindingUtil.inflate(inflater, R.layout.fragment_first,container,false);
        mFragmentViewModel = ViewModelProviders.of(getActivity()).get(FragmentViewModel.class);
        User mUser=new User("1","CXP",18);
        mFragmentViewModel.getUser().setValue(mUser);
        mFragmentViewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                dataBinding.setName(user.getName());
            }
        });
        dataBinding.setOnClickListenter(mOnClickListenter);
        return dataBinding.getRoot();
    }

    private OnClickListenter mOnClickListenter=new OnClickListenter() {
        @Override
        public void onClick(int id) {
            User mUser=new User("1","程小鹏。",18);
            mFragmentViewModel.getUser().setValue(mUser);
        }
    };
}
