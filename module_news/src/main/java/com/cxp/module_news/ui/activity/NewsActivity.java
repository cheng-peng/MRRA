package com.cxp.module_news.ui.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxp.lib_common.base.ARouterPath;
import com.cxp.lib_common.base.BaseActivity;
import com.cxp.lib_common.bean.ResultsBean;
import com.cxp.lib_common.listener.OnClickListenter;
import com.cxp.lib_common.listener.OnItemClickListenter;
import com.cxp.lib_common.utils.NetUtils;
import com.cxp.lib_common.utils.T;
import com.cxp.module_news.R;
import com.cxp.module_news.bean.NewsData;
import com.cxp.module_news.databinding.ActivityNewsBinding;
import com.cxp.module_news.ui.adapter.NewsAdapter;
import com.cxp.module_news.viewmodel.NewsViewModel;

/**
 * 文 件 名: NewsActivity
 * 创 建 人: CXP
 * 创建日期: 2018-05-29 14:51
 * 描    述: 新闻首页
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
@Route(path = ARouterPath.NEWS_MAIN)
public class NewsActivity extends BaseActivity {

    @Autowired
     String name;

    private NewsAdapter adapter;
    private NewsViewModel newsViewModel;
    private int index = 1;

    private Context mContext;

    @Override
    protected void initView() {

        mContext = this;

        if (getIntent() != null) {
            Log.e("CXP",getIntent().getExtras().getString("name"));
        }

        ActivityNewsBinding dataBinding = DataBindingUtil.setContentView(NewsActivity.this, R.layout.activity_news);
        dataBinding.setOnClickListenter(mOnClickListenter);
        //使用ViewModelProvider才可以使ViewModel跟Activity的生命周期关联一起
        newsViewModel = ViewModelProviders.of(NewsActivity.this).get(NewsViewModel.class);
        adapter = new NewsAdapter(mOnItemClickListenter);
        dataBinding.newsRecyclerview.setAdapter(adapter);
        //订阅数据变化来刷新UI
        getNewsDataLoad("20", "1");
    }

    //单击事件
    private OnClickListenter mOnClickListenter = new OnClickListenter() {
        @Override
        public void onClick(int id) {
            index++;
            getNewsDataLoad("20", "" + index);
        }
    };

    //子项单击事件
    private OnItemClickListenter mOnItemClickListenter = new OnItemClickListenter() {
        @Override
        public void onItemClick(ResultsBean resultsBean) {
            T.show(mContext, resultsBean.getDesc());
        }
    };

    /**
     * 加载数据
     */
    private void getNewsDataLoad(String size, String index) {

        if (!NetUtils.isConnected()) {
            T.show(mContext, getString(R.string.no_net));
            return;
        }

        //观察数据变化来刷新UI
        newsViewModel.loadData(size, index).observe(this, new Observer<NewsData>() {
            @Override
            public void onChanged(@Nullable NewsData newsData) {
                Log.i("CXP", "subscribeToModel onChanged onChanged");
                adapter.setNewsList(newsData.getResults());
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        //退出动画
//        overridePendingTransition(0, R.anim.slide_down_out);
    }
}
