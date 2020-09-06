package com.trjx.tbaseapp.test;

import androidx.annotation.NonNull;

import com.trjx.tbaseapp.base.DemoPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：小童
 * 创建时间：2019/8/9 11:37
 */
public class TestSearchPresenter extends DemoPresenter<TestSearchView> {

    public TestSearchPresenter(@NonNull TestSearchView view) {
        super(view);
    }


    public void responseSearchData(String searchStr){

        List<TestSearchInfoBean> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            TestSearchInfoBean infoBean = new TestSearchInfoBean();
            infoBean.setResultName("测试数据" + i);
            list.add(infoBean);
        }

        if(isViewAttach()){
            getView().getListDataSuccess(list);
        }

    }

}
