package com.trjx.tbase.activity;

import android.view.View;

import com.trjx.tbase.module.titlemodule.TitleListenter;
import com.trjx.tbase.module.titlemodule.TitleModule;

/**
 * 作者：小童
 * 创建时间：2019/7/31 11:48
 */
public class InitTitleActivity extends InitActivity implements TitleListenter {

    public TitleModule titleModule;


    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        initWork();
        initView();
    }

    @Override
    protected void initView() {
        super.initView();
        titleModule = new TitleModule(context, rootView);
        titleModule.setListenter(this);
    }

    @Override
    public void onClickBack(View view) {
        finish();
    }

    @Override
    public void onClickLeftText(View view) {

    }

    @Override
    public void onClickRightText(View view) {

    }

    @Override
    public void onClickMenu(View view) {

    }

    @Override
    public void onMenuItemClick(int position) {

    }
}
