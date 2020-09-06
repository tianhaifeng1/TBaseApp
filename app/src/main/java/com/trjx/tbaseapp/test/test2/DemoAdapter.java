package com.trjx.tbaseapp.test.test2;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseViewHolder;
import com.trjx.tbase.module.recyclermodule.TRecyclerAdapter;
import com.trjx.tbaseapp.R;
import com.trjx.tbaseapp.test.TestBean;

import java.util.List;

/**
 * 作者：小童
 * 创建时间：2019/8/6 16:37
 */
public class DemoAdapter extends TRecyclerAdapter<TestBean> {

    public DemoAdapter(@Nullable List<TestBean> data) {
        super(data);
    }

    @Override
    protected int addItemLayoutRes() {
        return R.layout.item_test;
    }

    @Override
    protected void convert(BaseViewHolder helper, TestBean item) {
        helper.setText(R.id.item_test_name, item.getName());
        helper.setText(R.id.item_test_age, item.getAge()+"");
        helper.setText(R.id.item_test_address, item.getAddress());
    }


}
