package com.trjx.tbaseapp.activity;

import com.trjx.tbase.activity.NavBottomActivity;
import com.trjx.tbaseapp.R;
import com.trjx.tbaseapp.activity.fragment.MainFourFragment;
import com.trjx.tbaseapp.activity.fragment.MainOneFragment;
import com.trjx.tbaseapp.activity.fragment.MainThreeFragment;
import com.trjx.tbaseapp.activity.fragment.MainTwoFragment;

public class MainNavActivity extends NavBottomActivity {

    @Override
    protected void initFragmentData() {
        fragmentList.add(new MainOneFragment());
        fragmentList.add(new MainTwoFragment());
        fragmentList.add(new MainThreeFragment());
        fragmentList.add(new MainFourFragment());
    }

    @Override
    protected int initTabMenu() {
        return R.menu.navigation_main;
    }
}
