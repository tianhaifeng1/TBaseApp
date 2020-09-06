package com.trjx.tbaseapp.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;

import com.trjx.tbase.activity.InitActivity;
import com.trjx.tbase.module.titlemodule.TitleModule;
import com.trjx.tbase.tdialog.TLoadingDialog;
import com.trjx.tbaseapp.R;

public class TestTDialogActivity extends InitActivity {

    private Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_tdialog);
        initWork();
        initView();

        handler = new Handler();
    }

    @Override
    protected void initView() {
        super.initView();
        TitleModule titleModule = new TitleModule(context, rootView);
        titleModule.initTitle("测试TDialog");
    }

    private String[] strings = {"请求中...", "加载中...", "测试中...", "消息验证中..."};

    private TLoadingDialog loadingDialog;

    public void onClickTDailogLoading(View view) {

        loadingDialog = new TLoadingDialog.Builder(this)
                .setGravity(Gravity.CENTER)
                .setMessage("消息1")
                .setCancelable(true)
                .create();
        loadingDialog.show(getSupportFragmentManager(),"tishi");

        changeTDialogLoadingText();

    }

    private void changeTDialogLoadingText(){

        int index = (int) (Math.random() * 4);
        handler.postDelayed(() -> {
            if(loadingDialog.isShowing()){
                loadingDialog.setMessage(strings[index]);
            }
            changeTDialogLoadingText();
        }, 2000);

    }

}
