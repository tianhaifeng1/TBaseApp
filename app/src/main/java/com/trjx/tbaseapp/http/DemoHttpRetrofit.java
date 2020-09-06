package com.trjx.tbaseapp.http;


import com.trjx.tbase.http.HttpBase;

import retrofit2.Retrofit;

public class DemoHttpRetrofit extends HttpBase {

    private volatile static DemoHttpRetrofit mInstance;

    public DemoAPI httpAPI;

    private DemoHttpRetrofit() {
        super(1);
    }

    @Override
    public void init() {
        baseUrl = "http://192.168.1.4:8090/egou.war.app/";
//        baseUrl = "http://192.168.1.152:8080/demo/";
    }

    @Override
    public void setAPI(Retrofit retrofit) {
        httpAPI = retrofit.create(DemoAPI.class);
    }

    /**
     *
     * 获取单例对象
     *
     * @return
     */
    public static DemoHttpRetrofit getInstance() {
        if (mInstance == null) {
            synchronized (DemoHttpRetrofit.class) {
                if (mInstance == null){
                    mInstance = new DemoHttpRetrofit();
                }
            }
        }
        return mInstance;
    }

}
