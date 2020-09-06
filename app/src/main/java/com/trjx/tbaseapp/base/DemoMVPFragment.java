package com.trjx.tbaseapp.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.trjx.tbase.activity.mvp.BaseMVPFragment;
import com.trjx.tbase.mvp.TPresenter;
import com.trjx.tbase.mvp.TView;
import com.trjx.tbaseapp.http.DemoModel;

public abstract class DemoMVPFragment<V extends TView, P extends TPresenter<V, DemoModel>>
        extends BaseMVPFragment<V, DemoModel,P> {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(initLayout(), null);
        initFragmentView(view);
        return view;
    }

    @Override
    protected DemoModel initModel() {
        return new DemoModel();
    }

    //初始化布局文件
    protected abstract int initLayout();
    //初始化View
    protected abstract void initFragmentView(View view);

}
