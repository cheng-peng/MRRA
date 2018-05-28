package com.cxp.module_main.ui.test.activity.lifecycle;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cxp.module_main.R;


/**
 * 文 件 名: LifecycleFragment
 * 创 建 人: CXP
 * 创建日期: 2018-04-18 13:58
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class LifecycleFragment extends Fragment {

    private  LifecyclePresenter  mLifecyclePresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_lifecycle, container, false);

        initView();

        return view;
    }

    private void initView() {

        mLifecyclePresenter=new LifecyclePresenter();
        getLifecycle().addObserver(mLifecyclePresenter);
    }

}
