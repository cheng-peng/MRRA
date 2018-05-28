package com.cxp.module_main.ui.test.activity.livedata.custom;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.cxp.lib_common.base.BaseActivity;
import com.cxp.module_main.R;


/**
 * 文 件 名: MyLiveDataActivity
 * 创 建 人: CXP
 * 创建日期: 2018-04-18 19:44
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class MyLiveDataActivity extends BaseActivity {

    @Override
    protected void initView() {
        setContentView(R.layout.activity_my_live_data);

        MyObserver observer = new MyObserver();
        MyLiveData data = new MyLiveData();
        data.observe(this, observer);
    }

    private class MyObserver implements Observer<String> {

        //LiveData中的数据变化，通过postValue（可后台线程）或者setValue（主线程）设置后，将触发Observer的onChanged
        @Override
        public void onChanged(@Nullable String o) {
            Toast.makeText(MyLiveDataActivity.this,String.valueOf(o),Toast.LENGTH_SHORT).show();
        }
    }

}
