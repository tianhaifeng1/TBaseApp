package com.trjx.tbaseapp.activity.fragment;

import android.view.View;
import android.widget.TextView;

import com.trjx.tbaseapp.R;
import com.trjx.tbaseapp.activity.MainNavActivity;
import com.trjx.tbaseapp.base.DemoMVPFragment;


public class MainOneFragment extends DemoMVPFragment<MainOneView,MainOnePresenter>
implements MainOneView{

    private TextView one;

    @Override
    protected int initLayout() {
        return R.layout.fragment_main_one;
    }


    @Override
    protected void initFragmentView(View view) {

        one = view.findViewById(R.id.one);
        one.setOnClickListener(v -> ((MainNavActivity) getActivity()).skipTab(2));

    }

    @Override
    protected MainOnePresenter initPersenter() {
        return new MainOnePresenter(this);
    }

    @Override
    public void initData() {
        super.initData();

    }
}
