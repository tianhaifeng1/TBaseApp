package com.trjx.tbase.module.recyclermodule;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 作者：小童
 * 创建时间：2019/8/6 17:51
 * <p>
 * 描述：此为单条目样式的适配器
 * <p>
 * 注：
 * <p>
 * 1.单页面针对单适配器
 */
public abstract class TRecyclerAdapter<B> extends BaseQuickAdapter<B, BaseViewHolder> {

    @Override
    protected abstract void convert(BaseViewHolder helper, B item);

    public TRecyclerAdapter(@Nullable List<B> data) {
        super(data);
        mLayoutResId = addItemLayoutRes();
    }

    protected abstract @LayoutRes
    int addItemLayoutRes();

}
