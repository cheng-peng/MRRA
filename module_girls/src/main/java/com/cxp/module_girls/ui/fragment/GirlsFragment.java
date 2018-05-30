package com.cxp.module_girls.ui.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.cxp.lib_common.base.ARouterPath;
import com.cxp.lib_common.base.BaseFragment;
import com.cxp.module_girls.R;
import com.cxp.module_girls.databinding.GirlsDataBinding;

/**
 * 文 件 名: GirlsFragment
 * 创 建 人: CXP
 * 创建日期: 2018-05-30 11:37
 * 描    述: 妹纸页面
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
@Route(path = ARouterPath.GIRLS_FRAGMENT)
public class GirlsFragment extends BaseFragment {

    @Autowired(name = "flag")
    public boolean isFlag;

    @Autowired
    public String content;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        GirlsDataBinding dataBinding= DataBindingUtil.inflate(inflater, R.layout.fragment_girls,container,false);
        ARouter.getInstance().inject(GirlsFragment.this);

        if (getArguments() != null) {
            isFlag = getArguments().getBoolean("flag");
            content = getArguments().getString("content");
            dataBinding.setName(content);
        }

        return dataBinding.getRoot();
    }
}
