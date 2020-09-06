package com.trjx.tbaseapp.activity.test;

import android.view.View;
import android.widget.AdapterView;

import com.trjx.tbase.activity.SearchActivity;
import com.trjx.tlibs.uils.ToastUtil2;

import java.util.ArrayList;
import java.util.List;

public class TestSearchActivity extends SearchActivity<String,TestSearchAdapter> {

    @Override
    protected void initView() {
        //是否显示标题栏的搜索按钮
        isShowSearchBtn = true;
        super.initView();
        titleModule.setMenuText("搜索2");
    }

    @Override
    protected void searchPost(String searchStr) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("item_data_" + (i + 10));
        }
        getSearchDataList(list);
    }

    @Override
    protected TestSearchAdapter initAdapter(List<String> infoList) {
        return new TestSearchAdapter(context, infoList);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ToastUtil2.showToast(context, infoList.get(position));
    }
}
