package com.trjx.tbase.module.filtermodule2;

import androidx.annotation.IntRange;

/**
 * 作者：小童
 * 创建时间：2019/8/22 18:01
 */
public interface TFilterTabInfo {


//    //名字
//    private String name;
//    //    图标集合:0:代表默认的；0<.代表选中状态,陪和参数 selectState
////    @DrawableRes
//    private int[] iconRes;
//    // 是否选中
//    private boolean isSelect;
//    //选中的状态:定义状态, 值代表iconRes的下标，与参数iconRes 同步,值需大于0
//    private int selectState;


    String getFilterTabName();

    int[] getFilterTabIconRes();

    //总共有几中状态

    @IntRange(from = 2)
    int getFilterTabStateTotal();

    //0:代表未选中；
    //>0：代表选中；值对应 iconRes 的下标，
    int getFilterTabSelectState();
    void setFilterTabSelectState(int state);

}
