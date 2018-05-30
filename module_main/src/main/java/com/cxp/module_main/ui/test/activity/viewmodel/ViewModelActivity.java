package com.cxp.module_main.ui.test.activity.viewmodel;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.TextView;

import com.cxp.lib_common.base.BaseActivity;
import com.cxp.lib_common.listener.OnClickListenter;
import com.cxp.module_main.R;
import com.cxp.module_main.databinding.ViewModelDataBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * 文 件 名: ViewModelActivity
 * 创 建 人: CXP
 * 创建日期: 2018-05-28 17:12
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class ViewModelActivity extends BaseActivity {

    TextView tv;

    private  MyViewModel model;

    @Override
    protected void initView() {

        ViewModelDataBinding dataBinding= DataBindingUtil.setContentView(ViewModelActivity.this,R.layout.activity_viewmodel);
        dataBinding.setOnClickListenter(mOnClickListenter);

        model= ViewModelProviders.of(this).get(MyViewModel.class);
        model.getUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {

                dataBinding.viewmodelTv.setText("name:"+users.get(0).getName()+",age:"+users.get(0).getAge());

                for (int i = 0; i < users.size(); i++) {
                    Log.e("CXP","name:"+users.get(i).getName()+",age:"+users.get(i).getAge());
                }
            }
        });

        //初始化数据
        initData();


    }

    //初始化数据
    private void initData() {
        List<User> list=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user=new User();
            user.setUserId(""+i);
            user.setName("CXP"+i);
            user.setAge(18+i);
            list.add(user);
        }
        model.getUsers().setValue(list);
    }

    private OnClickListenter mOnClickListenter=new OnClickListenter() {
        @Override
        public void onClick(int id) {

            FragmentManager fm = getSupportFragmentManager();
            //2.开启一个事务，通过调用beginTransaction方法开启。
            FragmentTransaction ft =fm.beginTransaction();
            //Fragment 跳转
            Fragment fragment =null;
            if (id== R.id.viewmodel_fist) {
                fragment= new FragmentFirst();
            }else if (id== R.id.viewmodel_second) {
                fragment= new FragmentSecond();
            }
            //向容器内加入Fragment，一般使用add或者replace方法实现，需要传入容器的id和Fragment的实例。
            ft.replace(R.id.viewmodel_fl,fragment);
            //提交事务，调用commit方法提交。
            ft.commit();
        }
    };

}
