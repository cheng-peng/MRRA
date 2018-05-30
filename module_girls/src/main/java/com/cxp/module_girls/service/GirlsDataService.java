package com.cxp.module_girls.service;


import com.cxp.module_girls.bean.GirlsData;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 文 件 名: GirlsDataService
 * 创 建 人: CXP
 * 创建日期: 2018-04-24 14:12
 * 描    述: Gank 接口
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public interface GirlsDataService {

    @GET("api/data/福利/{size}/{index}")
    Observable<GirlsData> getGirlsData(@Path("size") String size, @Path("index") String index);

}
