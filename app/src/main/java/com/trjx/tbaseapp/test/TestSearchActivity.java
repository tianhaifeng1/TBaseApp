package com.trjx.tbaseapp.test;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.trjx.tbase.activity.SearchActivityAssist;
import com.trjx.tbase.activity.SearchListenter;
import com.trjx.tbaseapp.R;
import com.trjx.tbaseapp.base.DemoMVPActivity;

import java.util.List;

/**
 * 作者：小童
 * 创建时间：2019/8/9 11:36
 */
public class TestSearchActivity extends DemoMVPActivity<TestSearchView,TestSearchPresenter> implements SearchListenter, TestSearchView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }


    private SearchActivityAssist searchActivityAssist;
    @Override
    protected void initView() {

        searchActivityAssist = new SearchActivityAssist<TestSearchInfoBean>(this);
//        searchActivityAssist.setTag("");
        searchActivityAssist.setSearchListenter(this);
        searchActivityAssist.setAdapter(new TestSearchAdapter(context, searchActivityAssist.getInfoList()));
        searchActivityAssist.init(rootView);


    }

    @Override
    protected TestSearchPresenter initPersenter() {
        return new TestSearchPresenter(this);
    }

    @Override
    public void searchPost(String searchStr) {
        getPresenter().responseSearchData(searchStr);
    }

    @Override
    public void getListDataSuccess(List<TestSearchInfoBean> list) {
        searchActivityAssist.bindSearchDataList(list);
    }
}
