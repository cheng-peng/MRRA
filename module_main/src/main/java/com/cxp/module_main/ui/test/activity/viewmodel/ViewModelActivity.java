package com.cxp.module_main.ui.test.activity.viewmodel;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import com.cxp.lib_common.base.BaseActivity;
import com.cxp.module_main.R;

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

        setContentView(R.layout.activity_viewmodel);

        tv=findViewById(R.id.viewmodel_tv);

        model= ViewModelProviders.of(this).get(MyViewModel.class);
        model.getUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {

                tv.setText("name:"+users.get(0).getName()+",age:"+users.get(0).getAge());

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

}
