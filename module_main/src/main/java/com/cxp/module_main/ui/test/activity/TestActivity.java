package com.cxp.module_main.ui.test.activity;

import android.databinding.DataBindingUtil;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxp.lib_common.base.ARouterPath;
import com.cxp.lib_common.base.BaseActivity;
import com.cxp.lib_common.listener.OnClickListenter;
import com.cxp.module_main.R;
import com.cxp.module_main.databinding.ActivityTestBinding;
import com.cxp.module_main.ui.test.activity.databinding.DataBinDingActivity;
import com.cxp.module_main.ui.test.activity.lifecycle.LifecycleActivity;
import com.cxp.module_main.ui.test.activity.livedata.LiveDataActivity;
import com.cxp.module_main.ui.test.activity.room.RoomActivity;
import com.cxp.module_main.ui.test.activity.viewmodel.ViewModelActivity;

/**
 * 文 件 名: TestActivity
 * 创 建 人: CXP
 * 创建日期: 2018-05-28 8:25
 * 描    述: 测试用例
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
@Route(path = ARouterPath.MAIN_TEST)
public class TestActivity extends BaseActivity {

    @Override
    protected void initView() {
        ActivityTestBinding dataBinding = DataBindingUtil.setContentView(TestActivity.this, R.layout.activity_test);
        dataBinding.setOnClickListenter(mOnClickListenter);
    }

    private OnClickListenter mOnClickListenter = new OnClickListenter() {
        @Override
        public void onClick(int id) {
            if (id == R.id.test_databinding) {
                //DataBinding
                startActivity(DataBinDingActivity.class);
            } else if (id == R.id.test_lifecycle) {
                //Lifecycle
                startActivity(LifecycleActivity.class);
            } else if (id == R.id.test_room) {
                //Room
                startActivity(RoomActivity.class);
            } else if (id == R.id.test_livedata) {
                //LiveData
                startActivity(LiveDataActivity.class);
            } else if (id == R.id.test_viewmodel) {
                //ViewModel
                startActivity(ViewModelActivity.class);
            }

        }
    };

}
