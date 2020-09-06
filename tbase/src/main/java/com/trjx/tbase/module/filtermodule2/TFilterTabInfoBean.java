package com.trjx.tbase.module.filtermodule2;

/**
 * 作者：小童
 * 创建时间：2019/8/22 17:14
 *
 * 筛选项的模型数据
 *
 */
public class TFilterTabInfoBean implements TFilterTabInfo {

    //名字
    private String name;
    //    图标集合:0:代表默认的；0<.代表选中状态,陪和参数 selectState
//    @DrawableRes
    private int[] iconRes;
    // 选中的状态: 0代表为选中 定义状态, 值代表iconRes的下标，与参数iconRes 同步,值需大于0
    private int selectState;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getIconRes() {
        return iconRes;
    }

    public void setIconRes(int[] iconRes) {
        this.iconRes = iconRes;
    }

    public int getSelectState() {
        return selectState;
    }

    public void setSelectState(int selectState) {
        this.selectState = selectState;
    }

    @Override
    public String getFilterTabName() {
        return name;
    }

    @Override
    public int[] getFilterTabIconRes() {
        return iconRes;
    }

    @Override
    public int getFilterTabStateTotal() {
        return iconRes != null ? iconRes.length : 0;
    }

    @Override
    public int getFilterTabSelectState() {
        return selectState;
    }

    @Override
    public void setFilterTabSelectState(int state) {
        selectState = state;
    }
}
