package com.cxp.module_news.ui.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxp.lib_common.base.ARouterPath;
import com.cxp.lib_common.base.BaseFragment;
import com.cxp.module_news.R;
import com.cxp.module_news.databinding.NewsDataBinding;

/**
 * 文 件 名: NewsFragment
 * 创 建 人: CXP
 * 创建日期: 2018-05-30 11:30
 * 描    述: 新闻页面
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
@Route(path = ARouterPath.NEWS_FRAGMENT)
public class NewsFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        NewsDataBinding dataBinding= DataBindingUtil.inflate(inflater, R.layout.fragment_news,container,false);
        return dataBinding.getRoot();
    }
}
