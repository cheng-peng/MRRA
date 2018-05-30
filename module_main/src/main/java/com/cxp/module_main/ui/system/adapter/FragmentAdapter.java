package com.cxp.module_main.ui.system.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.cxp.lib_common.base.BaseFragment;

import java.util.List;

/**
 * 文 件 名: FragmentAdapter
 * 创 建 人: CXP
 * 创建日期: 2018-05-30 9:25
 * 描    述: 适配器
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class FragmentAdapter extends FragmentStatePagerAdapter {

    private List<BaseFragment> mFragments;

    public FragmentAdapter(FragmentManager fm, List<BaseFragment> mFragments) {
        super(fm);
        this.mFragments = mFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments != null ? mFragments.size() : 0;
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }
}
