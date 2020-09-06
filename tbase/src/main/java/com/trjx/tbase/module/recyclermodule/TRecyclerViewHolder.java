package com.trjx.tbase.module.recyclermodule;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.IdRes;

import com.chad.library.adapter.base.BaseViewHolder;
import com.trjx.tlibs.uils.GlideUtile;

/**
 *
 * 参考类
 *
 * 作者：小童
 * 创建时间：2019/8/6 11:01
 *
 * 图片绑定：GlideUtile
 *
 *
 *
 */
@Deprecated
public class TRecyclerViewHolder extends BaseViewHolder {

    public TRecyclerViewHolder(View view) {
        super(view);
    }

    public BaseViewHolder setImageUrl(Context context,@IdRes int viewId, Object url) {
        ImageView imageView = getView(viewId);
        GlideUtile.bindImageView(context,url,imageView);
        return this;
    }

    public ImageView getImageView(@IdRes int viewId){
        return getView(viewId);
    }




}