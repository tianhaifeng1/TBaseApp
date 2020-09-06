package com.trjx.tbaseapp.activity;

import com.trjx.tbase.mvp.TView;
import com.trjx.tbaseapp.bean.TestBean;
import com.trjx.tbaseapp.bean.resp.GoodsListModel;

import java.util.List;

public interface MainView extends TView {

    void testSuccess(TestBean testBean);
    void test2Success(List<GoodsListModel> goodsList);
    void test3Success(GoodsListModel goodsListModel);

}
