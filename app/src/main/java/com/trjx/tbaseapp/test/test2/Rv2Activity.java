package com.trjx.tbaseapp.test.test2;

import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;

import com.trjx.tbase.module.recyclermodule.TRecyclerModule;
import com.trjx.tbase.module.recyclermodule.TRecyclerViewListenter;
import com.trjx.tbaseapp.R;
import com.trjx.tbaseapp.base.DemoMVPActivity;
import com.trjx.tbaseapp.test.RvPresenter;
import com.trjx.tbaseapp.test.RvView;

import java.util.List;

public class Rv2Activity extends DemoMVPActivity<RvView, RvPresenter>
        implements RvView, TRecyclerViewListenter {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);
    }


    private TRecyclerModule recyclerModule;

    @Override
    protected void initView() {
        super.initView();
        titleModule.initTitle("测试", false);
        recyclerModule = new TRecyclerModule.Builder(context)
                .setLayoutManager(new GridLayoutManager(context, 2))
                .setClickDefaultPage(false)
                .setDefImgRes(R.mipmap.default_list)
                .setDefTextStr("数据异常")
                .setClickDefaultPage(true)
                .setPage(1)
                .setPageSize(20)
                .setTRecyclerViewListenter(this)
                .createAdapter(new DemoAdapter(null))
                .creat(rootView);
        getRecyclerListData();
    }

    @Override
    protected RvPresenter initPersenter() {
        return new RvPresenter(this);
    }


    @Override
    public void testSuccess(List<?> testBeanList) {
        recyclerModule.bindListData(testBeanList);
    }

    @Override
    public void onClickRecyclerExceptionPageEvent() {

    }

    @Override
    public void getRecyclerListData() {
        getPresenter().testDate(recyclerModule.getPage());
    }


    @Override
    public void tPostError(String errorMsg) {
        super.tPostError(errorMsg);
        recyclerModule.setRefreshing(false);
    }
}
