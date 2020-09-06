package com.trjx.tbase.activity;

import android.content.Intent;
import android.os.Bundle;

import com.github.chrisbanes.photoview.PhotoView;
import com.trjx.R;
import com.trjx.tlibs.uils.GlideUtile;


/**
 * 查看图片
 */
public class LookImagesOneActivity extends BaseActivity {

    private PhotoView photoView;

    private String pathImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_image_one);
    }

    @Override
    protected void initView() {
        super.initView();

        titleModule.initTitle("", true);
        titleModule.setTitleLeftText(1 + "/" + 1);
        titleModule.setTitleLeftTextColor(R.color.color_white);
        photoView = findViewById(R.id.item_image_imageview);
        Intent intent = getIntent();
        pathImg = intent.getStringExtra("path");
        GlideUtile.bindImageView(context,pathImg,photoView);

    }

    @Override
    public void onResume() {
        super.onResume();
        activityManager.setStateBarColor(false,this);
    }

}
