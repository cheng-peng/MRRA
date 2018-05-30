package com.cxp.lib_common.api;


import com.cxp.lib_common.BuildConfig;
import com.cxp.lib_common.base.BaseApplication;
import com.cxp.lib_common.utils.NetUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 文 件 名: ApiClient
 * 创 建 人: CXP
 * 创建日期: 2018-04-24 14:08
 * 描    述: 连接配置
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class ApiClient {

    public static final String GankHost = "http://gank.io/";

    //默认网络请求时间
    private static final int DEFAULT_TIMEOUT = 10;
    //缓存大小 10M
    private static final int CACHE_SIZE = 10 * 1024 * 1024;

    //拦截器 用来设置缓存
    private static final Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Response originalResponse = chain.proceed(chain.request());
            if (NetUtils.isConnected()) {
                int maxAge = 60; // 在线缓存在1分钟内可读取
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .removeHeader("Cache-Control")
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .build();
            } else {
                int maxStale = 60 * 60 * 24 * 28; // 离线时缓存保存4周   only-if-cached 仅仅使用缓存
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .removeHeader("Cache-Control")
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }
        }
    };

    /**
     * 获得想要的 retrofit service
     * @param clazz    想要的 retrofit service 接口，Retrofit会代理生成对应的实体类
     * @param <T>      api service
     * @return
     */
    public static <T> T initService(Class<T> clazz) {
        return getRetrofitInstance().create(clazz);
    }

    /**单例retrofit*/
    private static Retrofit retrofitInstance;
    private static Retrofit getRetrofitInstance(){
        if (retrofitInstance == null) {
            synchronized (ApiClient.class) {
                if (retrofitInstance == null) {
                    retrofitInstance = new Retrofit.Builder()
                            .baseUrl(GankHost)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .client(getOkHttpClientInstance())
                            .build();
                }
            }
        }
        return retrofitInstance;
    }

    /**单例OkHttpClient*/
    private static OkHttpClient okHttpClientInstance;
    private static OkHttpClient getOkHttpClientInstance(){
        if (okHttpClientInstance == null) {
            synchronized (ApiClient.class) {
                if (okHttpClientInstance == null) {
                    OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
                    //设置超时时间
                    //链接超时时间设置
                    builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
                    //读取超时时间设置
                    builder.readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
                    //写入超时时间设置
                    builder.writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

                    //添加缓存
                    File cacheFile = new File(BaseApplication.getIns().getCacheDir(), "okHttpCache");
                    builder.cache(new Cache(cacheFile, CACHE_SIZE));

                    if (BuildConfig.DEBUG) {
                        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                        builder.addInterceptor(httpLoggingInterceptor);
                    }

                    // 添加拦截器
                    builder.addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {

                            Request request = chain.request();
                            if (!NetUtils.isConnected()) {
                                //没有网络连接  CacheControl.FORCE_CACHE 仅仅使用缓存
                                request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
                            }
                            return chain.proceed(request);
                        }
                    });

                    builder.addNetworkInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)
                            .addInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR);
                    okHttpClientInstance = builder.build();
                }
            }
        }
        return okHttpClientInstance;
    }
}
