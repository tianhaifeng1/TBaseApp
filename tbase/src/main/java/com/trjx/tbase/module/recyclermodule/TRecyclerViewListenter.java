package com.trjx.tbase.module.recyclermodule;

/**
 * 作者：小童
 * 创建时间：2019/6/12 15:47
 */
public interface TRecyclerViewListenter {
    /**
     * 异常页面点击事件：1.可以处理数据异常的页面；2.还可以处理网络异常的页面
     */
    void onClickRecyclerExceptionPageEvent();

    /**
     * 获取列表数据
     */
    void getRecyclerListData();


}
