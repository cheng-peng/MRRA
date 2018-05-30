package com.cxp.module_news.service;


import com.cxp.module_news.bean.NewsData;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 文 件 名: NewsDataService
 * 创 建 人: CXP
 * 创建日期: 2018-04-24 14:12
 * 描    述: News 接口
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public interface NewsDataService {

    @GET("api/data/Android/{size}/{index}")
    Observable<NewsData> getNewsData(@Path("size") String size, @Path("index") String index);
}
