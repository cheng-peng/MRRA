package com.cxp.module_main.ui.system.activity;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.alibaba.android.arouter.launcher.ARouter;
import com.cxp.lib_common.base.ARouterPath;
import com.cxp.lib_common.base.BaseActivity;
import com.cxp.lib_common.base.BaseFragment;
import com.cxp.lib_common.widget.NoScrollViewPager;
import com.cxp.module_main.R;
import com.cxp.module_main.databinding.FragmentDataBinding;
import com.cxp.module_main.ui.system.adapter.FragmentAdapter;
import com.cxp.module_main.ui.system.fragment.AboutFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 文 件 名: FragmentActivity
 * 创 建 人: CXP
 * 创建日期: 2018-05-30 9:06
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */

public class FragmentActivity extends BaseActivity {

    private NoScrollViewPager mPager;
    private FragmentAdapter mAdapter;

    @Override
    protected void initView() {
        FragmentDataBinding dataBinding = DataBindingUtil.setContentView(FragmentActivity.this, R.layout.activity_fragment_pager);
        mPager = dataBinding.fragmentViewpager;
        dataBinding.fragmentNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        BaseFragment fragmentNews = (BaseFragment) ARouter.getInstance().build(ARouterPath.NEWS_FRAGMENT).navigation();
        BaseFragment fragmentGirls = (BaseFragment) ARouter.getInstance().build(ARouterPath.GIRLS_FRAGMENT).withBoolean("flag",true).withString("content","妹纸").navigation();
        BaseFragment fragmentAbout = new AboutFragment();

        List<BaseFragment> mFragments=new ArrayList<>();

        mFragments.add(fragmentNews);
        mFragments.add(fragmentGirls);
        mFragments.add(fragmentAbout);

        mAdapter = new FragmentAdapter(getSupportFragmentManager(), mFragments);
        mPager.setPagerEnabled(false);
        mPager.setAdapter(mAdapter);

    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int i = item.getItemId();
            if (i == R.id.navigation_home) {
                mPager.setCurrentItem(0);
                return true;
            } else if (i == R.id.navigation_dashboard) {
                mPager.setCurrentItem(1);
                return true;
            } else if (i == R.id.navigation_notifications) {
                mPager.setCurrentItem(2);
                return true;
            }
            return false;
        }

    };

}
