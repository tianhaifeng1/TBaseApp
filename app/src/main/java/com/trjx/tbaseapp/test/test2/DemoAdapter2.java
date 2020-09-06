package com.trjx.tbaseapp.test.test2;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseViewHolder;
import com.trjx.tbase.module.recyclermodule.TRecyclerAdapter2;
import com.trjx.tbaseapp.R;
import com.trjx.tbaseapp.test.TestBean;
import com.trjx.tbaseapp.test.TestMoreBean;
import com.trjx.tlibs.uils.GlideUtile;

import java.util.List;

/**
 * 作者：小童
 * 创建时间：2019/8/6 16:37
 */
public class DemoAdapter2 extends TRecyclerAdapter2 {


    public DemoAdapter2(int code) {
        super(code);
    }

    public DemoAdapter2(int code, @Nullable List<Object> data) {
        super(code, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Object item) {
        if (code == 1) {
            TestBean bean = (TestBean) item;
            helper.setText(R.id.item_test_name, bean.getName());
            helper.setText(R.id.item_test_age, bean.getAge());
            helper.setText(R.id.item_test_address, bean.getAddress());
        }else if(code == 2){
            TestMoreBean bean = (TestMoreBean) item;
            helper.setText(R.id.item_test2_text, bean.getName());
            GlideUtile.bindImageView(mContext, bean.getPath(), helper.getView(R.id.item_test2_img));
        }
    }


    @Override
    protected int addItemLayoutRes() {
        if (code == 1) {
            return R.layout.item_test;
        }else if(code == 2){
            return R.layout.item_test2;
        }
        return 0;
    }



}
