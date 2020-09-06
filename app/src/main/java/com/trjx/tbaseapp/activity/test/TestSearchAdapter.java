package com.trjx.tbaseapp.activity.test;

import android.content.Context;
import android.view.View;

import com.trjx.tbase.adapter.TBaseAdapter2;
import com.trjx.tbaseapp.R;

import java.util.List;

/**
 * 作者：小童
 * 创建时间：2019/7/19 10:06
 */
public class TestSearchAdapter extends TBaseAdapter2<String, TestSearchViewHolder> {

    public TestSearchAdapter(Context context, List<String> strings) {
        super(context, strings);
    }

    @Override
    public int initLayout() {
        return R.layout.item_text;
    }

    @Override
    public TestSearchViewHolder initViewHolder(View convertView) {
        return new TestSearchViewHolder(convertView);
    }

    @Override
    public void bindView(int position, TestSearchViewHolder viewHolder) {
        String str = tList.get(position);
        viewHolder.textView.setText(str);

    }

}
