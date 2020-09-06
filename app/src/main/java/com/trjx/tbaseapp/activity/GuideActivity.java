package com.trjx.tbaseapp.activity;


import android.os.Bundle;

import com.trjx.tbase.activity.GuidePageActivity;
import com.trjx.tbaseapp.R;
import com.trjx.tbaseapp.test.test2.Rv2Activity;

import java.util.List;

public class GuideActivity extends GuidePageActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean setPageData(List<Object> imgList) {
        imgList.add(R.mipmap.page1);
        imgList.add(R.mipmap.page2);
        imgList.add(R.mipmap.page3);
        return true;
    }

    @Override
    protected void onClickSkipView() {
        skipActivity(Rv2Activity.class);
    }



}
