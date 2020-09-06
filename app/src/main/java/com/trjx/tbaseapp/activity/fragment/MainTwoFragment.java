package com.trjx.tbaseapp.activity.fragment;

import android.view.View;

import com.trjx.tbaseapp.R;
import com.trjx.tbaseapp.base.DemoMVPFragment;


public class MainTwoFragment extends DemoMVPFragment<MainTwoView,MainTwoPresenter>
implements MainTwoView{

    @Override
    protected int initLayout() {
        return R.layout.fragment_main_two;
    }

    @Override
    protected void initFragmentView(View view) {

    }

    @Override
    protected MainTwoPresenter initPersenter() {
        return new MainTwoPresenter(this);
    }

    @Override
    public void initData() {
        super.initData();

    }


}
