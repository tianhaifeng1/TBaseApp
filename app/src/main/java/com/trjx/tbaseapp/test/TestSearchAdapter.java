package com.trjx.tbaseapp.test;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.trjx.tbase.adapter.TBaseAdapter2;
import com.trjx.tbase.adapter.TBaseViewHolder2;
import com.trjx.tbaseapp.R;

import java.util.List;

/**
 * 作者：小童
 * 创建时间：2019/8/9 11:46
 */
public class TestSearchAdapter extends TBaseAdapter2<TestSearchInfoBean, TestSearchAdapter.TestSearchViewHolder> {


    public TestSearchAdapter(Context context, List<TestSearchInfoBean> testSearchInfoBeans) {
        super(context, testSearchInfoBeans);
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
    public void bindView(int position, TestSearchViewHolder testSearchViewHolder) {

        TestSearchInfoBean infoBean = tList.get(position);
        testSearchViewHolder.textView.setText(infoBean.getResultName());

    }

    public class TestSearchViewHolder extends TBaseViewHolder2 {

        TextView textView;

        public TestSearchViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.item_text1);
        }

    }

}
