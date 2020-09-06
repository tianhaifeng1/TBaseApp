package com.trjx.tbase.module.recyclermodule;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 参考类
 *
 * 作者：小童
 * 创建时间：2019/8/6 17:51
 * <p>
 * 描述：此为单条目样式的适配器
 * <p>
 * 注：
 * <p>
 * 1.一个适配器，使用与所有的列表页面，用 code 作为区别码，区别不同的适配页面
 */
@Deprecated
abstract class TRecyclerAdapter2_<H extends BaseViewHolder> extends BaseQuickAdapter<Object, H> {

    //区别码
    public int code;

    public TRecyclerAdapter2_(int code) {
        this(code, null);
    }

    @Override
    protected abstract void convert(H helper, Object item);

    public TRecyclerAdapter2_(int code, @Nullable List<Object> data) {
        super(data);
        this.code = code;
        mLayoutResId = addItemLayoutRes();
    }

    protected abstract @LayoutRes
    int addItemLayoutRes();


//    @Override
//    public H onCreateViewHolder(ViewGroup parent, int viewType) {
//        H viewholder = super.onCreateViewHolder(parent, viewType);
//        viewholder.setCode(code);
//        return viewholder;
//    }


//
//    @Override
//    protected H onCreateDefViewHolder(ViewGroup parent, int viewType) {
//        return super.onCreateDefViewHolder(parent, viewType);
//    }

//    @Override
//    protected H createBaseViewHolder(View view) {
//        H viewholder = super.createBaseViewHolder(view);
//        viewholder.setCode(code);
//        return super.createBaseViewHolder(view);
//    }

//    @Override
//    public void onBindViewHolder(H holder, int position) {
//        super.onBindViewHolder(holder, position);
//    }


}
