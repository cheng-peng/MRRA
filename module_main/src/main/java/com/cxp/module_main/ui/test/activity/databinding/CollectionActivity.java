package com.cxp.module_main.ui.test.activity.databinding;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableArrayMap;
import android.databinding.ObservableList;
import android.databinding.ObservableMap;

import com.cxp.lib_common.base.BaseActivity;
import com.cxp.lib_common.listener.OnClickListenter;
import com.cxp.module_main.R;
import com.cxp.module_main.databinding.ActivityCollectionBinding;

import java.util.Random;

/**
 * 文 件 名: CollectionActivity
 * 创 建 人: CXP
 * 创建日期: 2018-05-28 11:05
 * 描    述: 集合使用
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class CollectionActivity extends BaseActivity {

    private  ObservableMap<String, String> map;
    private ObservableList<String> list;

    @Override
    protected void initView() {

        ActivityCollectionBinding dataBinding= DataBindingUtil.setContentView(CollectionActivity.this, R.layout.activity_collection);
        map = new ObservableArrayMap<>();
        map.put("name", "CXP_map");
        map.put("age", "26");
        dataBinding.setMap(map);
        list = new ObservableArrayList<>();
        list.add("CXP_list");
        list.add("哈哈哈");
        dataBinding.setList(list);
        dataBinding.setIndex(0);
        dataBinding.setKey("name");
        dataBinding.setOnClickListenter(mOnClickListenter);
    }

    private OnClickListenter mOnClickListenter=new OnClickListenter() {
        @Override
        public void onClick(int id) {
            list.add(0,"程鹏");
            map.put("name", "CXP,hi" + new Random().nextInt(100));
            map.put("age", "" + new Random().nextInt(100));
        }
    };
}
