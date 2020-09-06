package com.trjx.tbase.mvp;

import com.google.gson.Gson;

/**
 * MVP设计模式：Model层（基类）
 *
 * 数据层（数据库、文件、网络等等...）
 *
 * 注：关联Gson库，用于数据处理
 *
 */
public class TModel{

    //    private HttpRetrofit httpRetrofit;
//
//    public TModel() {
//        httpRetrofit = HttpRetrofit.getInstance();
//        HttpBase.headerName = "appBaseInfo";
//        HttpBase.headerInfo = "{\"apptype\":\"android\",\"appversion\":\"1.0.2\",\"deviceName\":\"Xiaomi\",\"model\":\"user\",\"requesttime\":\"\",\"token\":\"cDw8/rmyJ5gJ8U+7gAFbZqKeK3u9NHBRulvafbEhna4\\u003d\",\"userName\":\"13729501678\"}";
//    }

    protected Gson gson;

    public TModel() {
        gson = new Gson();

    }
}
