package com.cxp.module_girls.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.cxp.lib_common.api.ApiClient;
import com.cxp.module_girls.bean.GirlsData;
import com.cxp.module_girls.service.GirlsDataService;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 文 件 名: GirlsViewModel
 * 创 建 人: CXP
 * 创建日期: 2018-04-24 14:46
 * 描    述: 妹子
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class GirlsViewModel extends ViewModel {

    private final CompositeDisposable mDisposable = new CompositeDisposable();

    //加载数据
    public MutableLiveData<GirlsData> loadData(String size,String index) {

        MutableLiveData<GirlsData> mGirlsData = new MutableLiveData<>();

        ApiClient.initService(GirlsDataService.class).getGirlsData(size, index)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GirlsData>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable.add(d);
                    }

                    @Override
                    public void onNext(GirlsData value) {
                        mGirlsData.setValue(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("CXP",e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
        return mGirlsData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mDisposable.clear();
    }
}
