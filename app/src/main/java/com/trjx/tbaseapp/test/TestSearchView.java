package com.trjx.tbaseapp.test;

import com.trjx.tbase.mvp.TView;

import java.util.List;

/**
 * 作者：小童
 * 创建时间：2019/8/9 11:37
 */
public interface TestSearchView extends TView {

    void getListDataSuccess(List<TestSearchInfoBean> list);

}
