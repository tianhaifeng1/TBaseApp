package com.trjx.tbase.module.filtermodule2;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.trjx.R;

import java.util.List;

/**
 * 作者：小童
 * 创建时间：2019/8/22 17:13
 */
public class TFilterItemAdapter extends BaseQuickAdapter<TFilterItemInfo,BaseViewHolder> {


    // 增加条目标识
    private boolean tag;

    public TFilterItemAdapter(@Nullable List<TFilterItemInfo> data) {
        super(data);
        mLayoutResId = R.layout.item_filter_item;
    }

    public void setTag(boolean tag) {
        this.tag = tag;
    }

    @Override
    protected void convert(BaseViewHolder helper, TFilterItemInfo item) {
        helper.setText(R.id.item_filter_item_text, item.getFilterItemName());

        if(tag){
            if(item.getIsSelelct()){
                helper.setBackgroundRes(R.id.item_filter_item_text, R.color.filter_item_select_bg);
                helper.setTextColor(R.id.item_filter_item_text, mContext.getResources().getColor(R.color.filter_item_select_textcolor));
            }else{
                helper.setBackgroundRes(R.id.item_filter_item_text, R.color.filter_item_bg);
                helper.setTextColor(R.id.item_filter_item_text, mContext.getResources().getColor(R.color.filter_item_textcolor));
            }
        }

    }
}
