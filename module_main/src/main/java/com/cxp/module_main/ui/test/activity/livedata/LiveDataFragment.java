package com.cxp.module_main.ui.test.activity.livedata;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.cxp.module_main.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 文 件 名: LiveDataFragment
 * 创 建 人: CXP
 * 创建日期: 2018-04-18 14:38
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class LiveDataFragment extends Fragment {

    private NameViewModel mNameViewModel;

    TextView mTvName;
    Button bt1;
    Button bt2;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNameViewModel = ViewModelProviders.of(this).get(NameViewModel.class);
        mNameViewModel.getCurrentName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                mTvName.setText(s);
            }
        });
        mNameViewModel.getNameList().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(@Nullable List<String> strings) {
                for (String string : strings) {
                    Log.e("CXP", "name：" + string);
                }
            }
        });

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_live_data, container, false);

        //初始化视图
        initView(view);
       
        return view;
    }

    //初始化视图
    private void initView(View view) {
        mTvName = view.findViewById(R.id.fragment_live_data_tv);
        bt1= view.findViewById(R.id.fragment_live_data_bt1);
        bt2= view.findViewById(R.id.fragment_live_data_bt2);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //postValue 可以异步赋值，也可以同步赋值
                        mNameViewModel.getCurrentName().postValue("哈哈哈");
                    }
                }).start();

                //setValue 只能同步赋值
//                mNameViewModel.getCurrentName().setValue("CXP");
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> nameList = new ArrayList<>();
                for (int i = 0; i < 10; i++){
                    nameList.add("CXP<" + i + ">");
                }
                mNameViewModel.getNameList().setValue(nameList);
            }
        });
    }

}
