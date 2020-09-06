package com.trjx.tbaseapp.activity.fragment;

import android.view.View;

import com.trjx.tbaseapp.R;
import com.trjx.tbaseapp.base.DemoMVPFragment;


public class MainThreeFragment extends DemoMVPFragment<MainThreeView,MainThreePresenter>
implements MainThreeView{

    @Override
    protected int initLayout() {
        return R.layout.fragment_main_three;
    }

    @Override
    protected void initFragmentView(View view) {

    }

    @Override
    protected MainThreePresenter initPersenter() {
        return new MainThreePresenter(this);
    }
    @Override
    public void initData() {
        super.initData();

    }
}
