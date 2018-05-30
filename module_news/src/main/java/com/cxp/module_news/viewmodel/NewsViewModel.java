package com.cxp.module_news.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.cxp.lib_common.api.ApiClient;
import com.cxp.module_news.bean.NewsData;
import com.cxp.module_news.service.NewsDataService;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 文 件 名: NewsViewModel
 * 创 建 人: CXP
 * 创建日期: 2018-04-24 14:40
 * 描    述: 新闻
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class NewsViewModel extends ViewModel {

    private final CompositeDisposable mDisposable = new CompositeDisposable();

    //加载数据
    public MutableLiveData<NewsData> loadData(String size,String index) {

        MutableLiveData<NewsData> mNewsData = new MutableLiveData<>();

        ApiClient.initService(NewsDataService.class).getNewsData(size, index)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewsData>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable.add(d);
                    }

                    @Override
                    public void onNext(NewsData value) {
                        mNewsData.setValue(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("CXP",e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
        return mNewsData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mDisposable.clear();
    }
}
