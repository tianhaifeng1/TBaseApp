package com.trjx.tbaseapp.test;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseViewHolder;
import com.trjx.tbase.module.recyclermodule.TRecyclerMoreItemAdapter;
import com.trjx.tbaseapp.R;
import com.trjx.tlibs.uils.GlideUtile;

import java.util.List;

/**
 * 作者：小童
 * 创建时间：2019/8/6 15:47
 */
public class RvMoreAdapter extends TRecyclerMoreItemAdapter<TestMoreBean> {

    public RvMoreAdapter(@Nullable List<TestMoreBean> data) {
        super(data);
        addItemType(1, R.layout.item_test);
        addItemType(2, R.layout.item_test2);

    }

    @Override
    protected void convert(BaseViewHolder helper, TestMoreBean bean) {
            int type = bean.getItemType();
            switch (type) {
                case 1:
                    helper.setText(R.id.item_test_name, bean.getName());
                    helper.setText(R.id.item_test_age, bean.getAge());
                    helper.setText(R.id.item_test_address, bean.getAddress());
                    break;
                case 2:
                    helper.setText(R.id.item_test2_text,bean.getName());
                    GlideUtile.bindImageView(mContext,bean.getPath(),helper.getView(R.id.item_test2_img));
                    break;
            }
    }

}
