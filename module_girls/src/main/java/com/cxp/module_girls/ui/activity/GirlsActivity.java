package com.cxp.module_girls.ui.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxp.lib_common.base.ARouterPath;
import com.cxp.lib_common.base.BaseActivity;
import com.cxp.lib_common.bean.ResultsBean;
import com.cxp.lib_common.listener.OnClickListenter;
import com.cxp.lib_common.listener.OnItemClickListenter;
import com.cxp.lib_common.utils.NetUtils;
import com.cxp.lib_common.utils.T;
import com.cxp.module_girls.R;
import com.cxp.module_girls.bean.GirlsData;
import com.cxp.module_girls.databinding.ActivityGirlsBinding;
import com.cxp.module_girls.ui.adapter.GirlsAdapter;
import com.cxp.module_girls.viewmodel.GirlsViewModel;

/**
 * 文 件 名: GirlsActivity
 * 创 建 人: CXP
 * 创建日期: 2018-05-29 17:13
 * 描    述: 妹纸首页
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
@Route(path = ARouterPath.GIRLS_MAIN)
public class GirlsActivity extends BaseActivity {

    private GirlsAdapter adapter;
    private GirlsViewModel girlsViewModel;
    private int index=1;

    private Context mContext;

    @Override
    protected void initView() {

        mContext=this;

        ActivityGirlsBinding dataBinding= DataBindingUtil.setContentView(GirlsActivity.this, R.layout.activity_girls);
        dataBinding.setOnClickListenter(mOnClickListenter);
        //使用ViewModelProvider才可以使ViewModel跟Activity的生命周期关联一起
        girlsViewModel = ViewModelProviders.of(GirlsActivity.this).get(GirlsViewModel.class);
        adapter=new GirlsAdapter(mOnItemClickListenter);
        dataBinding.girlsRecyclerview.setAdapter(adapter);
        //订阅数据变化来刷新UI
        getGrilsDataLoad("20","1");
    }

    //单击事件
    private OnClickListenter mOnClickListenter=new OnClickListenter() {
        @Override
        public void onClick(int id) {
            index++;
            getGrilsDataLoad("20",""+index);
        }
    };

    //子项单击事件
    private OnItemClickListenter mOnItemClickListenter=new OnItemClickListenter() {
        @Override
        public void onItemClick(ResultsBean resultsBean) {
            T.show(mContext,resultsBean.getDesc());
        }
    };

    /**
     * 加载数据
     */
    private void getGrilsDataLoad(String size,String index){

        if (!NetUtils.isConnected()) {
            T.show(mContext,getString(R.string.no_net));
            return ;
        }

        //观察数据变化来刷新UI
        girlsViewModel.loadData(size,index).observe(this, new Observer<GirlsData>() {
            @Override
            public void onChanged(@Nullable GirlsData girlsData) {
                Log.i("CXP", "subscribeToModel onChanged onChanged");
                adapter.setGirlsList(girlsData.getResults());
            }
        });
    }
}
