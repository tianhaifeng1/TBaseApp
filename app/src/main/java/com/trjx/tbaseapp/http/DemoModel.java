package com.trjx.tbaseapp.http;


import com.trjx.tbase.http.HttpBase;
import com.trjx.tbase.mvp.TModel;
import com.trjx.tbaseapp.bean.DemoRespBean;
import com.trjx.tbaseapp.bean.TestBean;
import com.trjx.tbaseapp.bean.req.ReqTest2Info;
import com.trjx.tbaseapp.bean.req.ReqTestInfo;
import com.trjx.tbaseapp.bean.resp.GoodsListModel;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class DemoModel extends TModel {

    private DemoHttpRetrofit httpRetrofit;

    public DemoModel() {
        httpRetrofit = DemoHttpRetrofit.getInstance();
        HttpBase.headerName = "extend";
        //这里可以设置固定的HeadInfoModel
//        HttpBase.headerInfo = "{\"apptype\":\"android\",\"appversion\":\"1.0.2\",\"deviceName\":\"Xiaomi\",\"model\":\"user\",\"requesttime\":\"\",\"token\":\"cDw8/rmyJ5gJ8U+7gAFbZqKeK3u9NHBRulvafbEhna4\\u003d\",\"userName\":\"13729501678\"}";

    }

    public void test(ReqTestInfo reqTestInfo, Observer<DemoRespBean<TestBean>> observer) {

        httpRetrofit.httpAPI.test(reqTestInfo.getUserId())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void test2(ReqTest2Info reqTestInfo, Observer<DemoRespBean<GoodsListModel>> observer) {

        httpRetrofit.httpAPI.test2(reqTestInfo.getTypes(),reqTestInfo.getRelatedCatids(),reqTestInfo.getPage(),reqTestInfo.getPageSize())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }
    public void test3(String jsonStr, Observer<DemoRespBean<List<GoodsListModel>>> observer) {

        httpRetrofit.httpAPI.test3(HttpBase.getRequestBody(jsonStr))
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void test3_(String jsonStr, Observer<DemoRespBean<GoodsListModel>> observer) {

        httpRetrofit.httpAPI.test3_(HttpBase.getRequestBody(jsonStr))
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }



}
