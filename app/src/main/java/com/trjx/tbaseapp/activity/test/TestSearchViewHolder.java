package com.trjx.tbaseapp.activity.test;

import android.view.View;
import android.widget.TextView;

import com.trjx.tbase.adapter.TBaseViewHolder2;
import com.trjx.tbaseapp.R;

/**
 * 作者：小童
 * 创建时间：2019/7/19 10:49
 */
public class TestSearchViewHolder extends TBaseViewHolder2 {

    TextView textView;

    public TestSearchViewHolder(View view) {
        super(view);
        textView = view.findViewById(R.id.item_text1);
    }
}
