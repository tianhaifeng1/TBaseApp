package com.trjx.tbase.activity.mvp;

import android.view.View;

import com.trjx.tbase.activity.InitActivity;
import com.trjx.tbase.module.titlemodule.TitleListenter;
import com.trjx.tbase.mvp.TModel;
import com.trjx.tbase.mvp.TPresenter;
import com.trjx.tbase.mvp.TView;
import com.trjx.tlibs.uils.Logger;


public abstract class BaseMVPActivity<V extends TView,M extends TModel, P extends TPresenter<V,M>>
        extends InitActivity implements TitleListenter {

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        Logger.t("-------------init-------------");
        initWork();
        initView();
    }

    private P presenter;

    /**
     * 获取 Presenter 对象，
     */
    public P getPresenter() {
        if (presenter == null) {
            presenter = initPersenter();
            presenter.setModel(initModel());
        }
        return presenter;
    }

    protected abstract P initPersenter();

    protected abstract M initModel();

    @Override
    protected void onDestroy() {
        if (presenter != null) {
            presenter.detachView();
            presenter = null;
        }
        super.onDestroy();
    }


    //=================================TitleModel 相关方法===========================================
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
