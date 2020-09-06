package com.trjx.tbase.module.filtermodule2;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.trjx.R;

import java.util.List;

/**
 * 作者：小童
 * 创建时间：2019/8/22 17:13
 */
public class TFilterTabAdapter extends BaseQuickAdapter<TFilterTabInfo,BaseViewHolder> {

    public TFilterTabAdapter(@Nullable List<TFilterTabInfo> data) {
        super(data);
        mLayoutResId = R.layout.item_filter_tab;
    }

    @Override
    protected void convert(BaseViewHolder helper, TFilterTabInfo item) {
        helper.setText(R.id.item_filter_tab_text, item.getFilterTabName());
        int[] iconRes = item.getFilterTabIconRes();
        int iconR = 0;
        if (iconRes != null && iconRes.length > 0) {
            if (item.getFilterTabSelectState() > 0) {
                if (item.getFilterTabSelectState() <= iconRes.length) {
                    iconR = iconRes[item.getFilterTabSelectState()];
                }
            } else {
                iconR = iconRes[0];
            }
        }

        if (iconR > 0) {
            ((ImageView) helper.getView(R.id.item_filter_tab_icon)).setImageResource(iconR);
        }
    }
}
