package com.trjx.tbaseapp.activity;

import androidx.annotation.NonNull;

import com.trjx.tbase.http.HttpBase;
import com.trjx.tbaseapp.base.DemoPresenter;
import com.trjx.tbaseapp.bean.DemoRespBean;
import com.trjx.tbaseapp.bean.HeadInfoModel;
import com.trjx.tbaseapp.bean.TestBean;
import com.trjx.tbaseapp.bean.req.ReqTest2Info;
import com.trjx.tbaseapp.bean.req.ReqTestInfo;
import com.trjx.tbaseapp.bean.resp.GoodsListModel;
import com.trjx.tlibs.uils.Logger;

import java.util.List;

public class MainPresenter extends DemoPresenter<MainView> {

    public MainPresenter(@NonNull MainView view) {
        super(view);
    }

    protected void getTestInfo(){
        showDialog("请求中...");

        String timeStr = getCurrentTimeStr();

        ReqTestInfo reqTestInfo = new ReqTestInfo();
        reqTestInfo.setUserId("71");
        reqTestInfo.setTimestamp(timeStr);

        HeadInfoModel headInfoModel = new HeadInfoModel();
        headInfoModel.setTimestamp(timeStr);
        headInfoModel.setVersion("1.0");
        headInfoModel.setSign(getSignMD5String(reqTestInfo.toString()));

        model.test(reqTestInfo, new TObserver<DemoRespBean<TestBean>>() {
            @Override
            public void onNext(DemoRespBean<TestBean> respBean) {
                Logger.t("---" + gson.toJson(respBean));
                if(responseState(respBean)){
                    if(isViewAttach()){
                        getView().testSuccess(respBean.getData());
                    }
                }
            }
        });

    }


    protected void getTest2Info(){
        showDialog("请求中...");

        String timeStr = getCurrentTimeStr();

        ReqTest2Info reqTestInfo = new ReqTest2Info();
        reqTestInfo.setTimestamp(timeStr);
        reqTestInfo.setRelatedCatids(0);
        reqTestInfo.setPage(1);
        reqTestInfo.setPageSize(20);
        reqTestInfo.setTypes(0);

        HeadInfoModel headInfoModel = new HeadInfoModel();
        headInfoModel.setTimestamp(timeStr);
        headInfoModel.setVersion("1.0");
        headInfoModel.setSign(getSignMD5String(reqTestInfo.toString()));
        HttpBase.headerInfo = gson.toJson(headInfoModel);

        model.test2(reqTestInfo, new TObserver<DemoRespBean<GoodsListModel>>() {
            @Override
            public void onNext(DemoRespBean<GoodsListModel> respBean) {
                Logger.t("---" + gson.toJson(respBean));
                if(responseState(respBean)){
                    if(isViewAttach()){
                        getView().test3Success(respBean.getData());
                    }
                }
            }
        });

    }

    protected void getTest2Info_2(){
        showDialog("请求中...");

        String timeStr = getCurrentTimeStr();

        ReqTest2Info reqTestInfo = new ReqTest2Info();
        reqTestInfo.setTimestamp(timeStr);
        reqTestInfo.setRelatedCatids(0);
        reqTestInfo.setPage(1);
        reqTestInfo.setPageSize(20);
        reqTestInfo.setTypes(0);

        HeadInfoModel headInfoModel = new HeadInfoModel();
        headInfoModel.setTimestamp(timeStr);
        headInfoModel.setVersion("1.0");
        headInfoModel.setSign(getSignMD5String(reqTestInfo.toString()));
        HttpBase.headerInfo = gson.toJson(headInfoModel);

        model.test3(gson.toJson(reqTestInfo), new TObserver<DemoRespBean<List<GoodsListModel>>>() {
            @Override
            public void onNext(DemoRespBean<List<GoodsListModel>> respBean) {
                Logger.t("---" + gson.toJson(respBean));
                if (responseState(respBean)) {
                    if (isViewAttach()) {
                        getView().test2Success(respBean.getData());
                    }
                }
            }
        });

    }
    protected void getTest2Info_3(){
        showDialog("请求中...");

        String timeStr = getCurrentTimeStr();

        ReqTest2Info reqTestInfo = new ReqTest2Info();
        reqTestInfo.setTimestamp(timeStr);
        reqTestInfo.setRelatedCatids(0);
        reqTestInfo.setPage(1);
        reqTestInfo.setPageSize(20);
        reqTestInfo.setTypes(0);

        HeadInfoModel headInfoModel = new HeadInfoModel();
        headInfoModel.setTimestamp(timeStr);
        headInfoModel.setVersion("1.0");
        headInfoModel.setSign(getSignMD5String(reqTestInfo.toString()));
        HttpBase.headerInfo = gson.toJson(headInfoModel);

        model.test3_(gson.toJson(reqTestInfo), new TObserver<DemoRespBean<GoodsListModel>>() {
            @Override
            public void onNext(DemoRespBean<GoodsListModel> respBean) {
                Logger.t("---" + gson.toJson(respBean));
                if (responseState(respBean)) {
                    if (isViewAttach()) {
                        getView().test3Success(respBean.getData());
                    }
                }
            }
        });

    }
}
