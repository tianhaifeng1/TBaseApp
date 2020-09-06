package com.trjx.tbaseapp.activity.fragment;

import android.view.View;

import com.trjx.tbaseapp.R;
import com.trjx.tbaseapp.base.DemoMVPFragment;


public class MainFourFragment extends DemoMVPFragment<MainFourView,MainFourPresenter>
implements MainFourView{

    @Override
    protected int initLayout() {
        return R.layout.fragment_main_four;
    }

    @Override
    protected void initFragmentView(View view) {

    }

    @Override
    protected MainFourPresenter initPersenter() {
        return new MainFourPresenter(this);
    }
    @Override
    public void initData() {
        super.initData();

    }
}
