package com.trjx.tbaseapp.test;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.trjx.tbase.module.recyclermodule.TRecyclerModule;
import com.trjx.tbase.module.recyclermodule.TRecyclerViewListenter;
import com.trjx.tbaseapp.R;
import com.trjx.tbaseapp.base.DemoMVPActivity;
import com.trjx.tlibs.uils.ToastUtil2;

import java.util.List;

public class RvMoreActivity extends DemoMVPActivity<RvView, RvPresenter>
        implements RvView, TRecyclerViewListenter, BaseQuickAdapter.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);
    }

    private RvMoreAdapter moreAdapter;
    private TRecyclerModule recyclerModule;

    @Override
    protected void initView() {
        super.initView();
        titleModule.initTitle("测试", false);

        moreAdapter = new RvMoreAdapter(null);
        recyclerModule = new TRecyclerModule.Builder(context)
                .setLayoutManager(new LinearLayoutManager(context))
                .setClickDefaultPage(false)
                .setDefImgRes(R.mipmap.default_list)
                .setDefTextStr("数据异常")
                .setPage(1)
                .setPageSize(20)
                .setTRecyclerViewListenter(this)
                .createAdapter(moreAdapter)
                .creat(rootView);

        moreAdapter.setOnItemClickListener(this);
        getRecyclerListData();
    }

    @Override
    protected RvPresenter initPersenter() {
        return new RvPresenter(this);
    }

    @Override
    public void testSuccess(List<?> testBeanList) {
        recyclerModule.bindListData(testBeanList);
        recyclerModule.setRefreshing(false);
    }

    @Override
    public void onClickRecyclerExceptionPageEvent() {

    }

    @Override
    public void getRecyclerListData() {
        getPresenter().testMoreDate(recyclerModule.getPage());
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        ToastUtil2.showToast(context, ((TestMoreBean) adapter.getData().get(position)).getName());
    }
}
