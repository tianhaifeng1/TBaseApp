package com.trjx.tbase.http;

import retrofit2.Retrofit;

/**
 * 例子：根据实际重新继承HttpBase方法
 */
@Deprecated
public class HttpRetrofit extends HttpBase {


//    private static String baseUrl = "http://192.168.1.152:8080/tandroid/";


    private volatile static HttpRetrofit mInstance;

    public API httpAPI;

    private HttpRetrofit() {
        super(0);
    }

    @Override
    public void init() {
//        baseUrl = "http://192.168.1.152:8080/demo/";
//        DEFAULT_TIMEOUT = 10;//设置默认的超时时间（默认20s）
//        POST_SUCCESS = 200;//成功的参数

    }

    @Override
    public void setAPI(Retrofit retrofit) {
        httpAPI = retrofit.create(API.class);
    }


    /**
     * 请求体为键值对
     *
     * @return
     */
    public static HttpRetrofit getInstance() {
        if (mInstance == null) {
            synchronized (HttpRetrofit.class) {
                if (mInstance == null) {
                    mInstance = new HttpRetrofit();
                }
            }
        }
        return mInstance;
    }


}
