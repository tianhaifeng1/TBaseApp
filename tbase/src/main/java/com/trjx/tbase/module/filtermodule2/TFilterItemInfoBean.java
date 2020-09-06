package com.trjx.tbase.module.filtermodule2;

/**
 * 作者：小童
 * 创建时间：2019/8/22 18:16
 *
 * 列表项的实现类
 *
 */
public class TFilterItemInfoBean implements TFilterItemInfo {

    private String filterItemName;

    private boolean filterItemSelect;

    public void setFilterItemName(String filterItemName) {
        this.filterItemName = filterItemName;
    }

    public boolean isFilterItemSelect() {
        return filterItemSelect;
    }

    public void setFilterItemSelect(boolean filterItemSelect) {
        this.filterItemSelect = filterItemSelect;
    }

    @Override
    public String getFilterItemName() {
        return filterItemName;
    }

    @Override
    public boolean getIsSelelct() {
        return filterItemSelect;
    }
}
