package com.trjx.tbase.module.recyclermodule;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * 多布局文件，可以参考此类
 *
 * @param <B>
 * @param <H>
 */

/**
 *  参考类
 *
 * 作者：小童
 * 创建时间：2019/8/6 17:51
 * <p>
 * 描述：此为多条目样式的适配器
 * <p>
 * 注：
 * <p>
 * 1.单页面针对单适配器
 */
@Deprecated
abstract class TRecyclerMoreItemAdapter_<B extends MultiItemEntity, H extends BaseViewHolder>
        extends BaseMultiItemQuickAdapter<B,H> {


    public TRecyclerMoreItemAdapter_(@Nullable List<B> data) {
        super(data);

    }

//    protected void addItemType(int type, @LayoutRes int layoutResId) {
//        super.addItemType(type,layoutResId);
//    }


    @Override
    protected abstract void convert(H helper, B item);
}
