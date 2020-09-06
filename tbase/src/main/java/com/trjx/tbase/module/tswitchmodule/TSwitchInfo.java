package com.trjx.tbase.module.tswitchmodule;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.ColorInt;

import com.trjx.R;

public class TSwitchInfo {

    public final static int SHOWTYPE_TWO = 2;
    public final static int SHOWTYPE_THREE = 3;

    private int selectTextColor;
    private int noSelectTextColor;

    private String leftText;
    private String centerText;
    private String rightText;

    private int showType;

    //初始化选中位置
    private State toggleState;

    private TSwitchListenter listenter;

    public final Context context;

    public TSwitchInfo(Context context) {
        this.context = context;
        selectTextColor = context.getResources().getColor(R.color.tswitch_textcolor_select);
        noSelectTextColor = context.getResources().getColor(R.color.tswitch_textcolor_select_no);
        showType = SHOWTYPE_TWO;//显示类型，默认显示2个Tab
        toggleState = State.LEFT;//选中Tab，默认选中左边的Tab
        leftText = "TAB1";
        centerText = "TAB2";
        rightText = "TAB3";
    }


    public void setToggle(State toggleState) {
        this.toggleState = toggleState;
    }

    public void setSelectTextColor(@ColorInt int selectTextColor) {
        this.selectTextColor = selectTextColor;
    }

    public void setListenter(TSwitchListenter listenter) {
        this.listenter = listenter;
    }

    public void setNoSelectTextColor(@ColorInt int noSelectTextColor) {
        this.noSelectTextColor = noSelectTextColor;
    }

    public void setLeftText(String leftText) {
        this.leftText = leftText;
    }

    public void setCenterText(String centerText) {
        this.centerText = centerText;
    }

    public void setRightText(String rightText) {
        this.rightText = rightText;
    }

    public void setShowType(int showType) {
        this.showType = showType;
    }

    public enum State {
        LEFT, MIDDEL, RIGHT;
    }


    public void init(View rootView, TSwitchModule switchModule) {
        initView(rootView);
        initEvent(switchModule);
    }


    private LinearLayout tswitch_ll;
    private TextView leftTextView;
    private TextView centerTextView;
    private TextView rightTextView;

    private void initView(View rootView) {
        tswitch_ll = rootView.findViewById(R.id.tswitch_ll);
        leftTextView = rootView.findViewById(R.id.tswitch_left);
        centerTextView = rootView.findViewById(R.id.tswitch_center);
        rightTextView = rootView.findViewById(R.id.tswitch_right);
    }


    private void initEvent(TSwitchModule switchModule) {

        leftTextView.setText(leftText);
        rightTextView.setText(rightText);

        if (showType == TSwitchInfo.SHOWTYPE_THREE) {
            centerTextView.setVisibility(View.VISIBLE);
            centerTextView.setText(centerText);
        } else {
            centerTextView.setVisibility(View.GONE);
        }

        toggle(toggleState);

        leftTextView.setOnClickListener(v -> {
            toggle(TSwitchInfo.State.LEFT);
            if (null != listenter) {
                listenter.onClickTSwitchTab(TSwitchInfo.State.LEFT);
            }
        });
        centerTextView.setOnClickListener(v -> {
            toggle(TSwitchInfo.State.RIGHT);
            if (null != listenter) {
                listenter.onClickTSwitchTab(TSwitchInfo.State.MIDDEL);
            }
        });
        rightTextView.setOnClickListener(v -> {
            toggle(TSwitchInfo.State.RIGHT);
            if (null != listenter) {
                listenter.onClickTSwitchTab(TSwitchInfo.State.RIGHT);
            }
        });
    }


    public void toggle(TSwitchInfo.State togState) {
        if (showType == TSwitchInfo.SHOWTYPE_THREE) {
            toggleThree(togState);
        } else {
            toggleTwo(togState);
        }
    }

    private void toggleTwo(TSwitchInfo.State togState) {
        if (togState == TSwitchInfo.State.LEFT) {
            leftTextView.setBackgroundResource(R.drawable.tswitch_left_select);
            leftTextView.setTextColor(selectTextColor);
            rightTextView.setBackgroundResource(R.drawable.tswitch_right_);
            rightTextView.setTextColor(noSelectTextColor);
        } else if (togState == TSwitchInfo.State.RIGHT) {
            leftTextView.setBackgroundResource(R.drawable.tswitch_left_);
            leftTextView.setTextColor(noSelectTextColor);
            rightTextView.setBackgroundResource(R.drawable.tswitch_right_select);
            rightTextView.setTextColor(selectTextColor);
        }

    }

    private void toggleThree(TSwitchInfo.State togState) {
        if (togState == TSwitchInfo.State.LEFT) {
            leftTextView.setBackgroundResource(R.drawable.tswitch_left_select);
            leftTextView.setTextColor(selectTextColor);
            rightTextView.setBackgroundResource(R.drawable.tswitch_right_);
            rightTextView.setTextColor(noSelectTextColor);
            centerTextView.setBackgroundResource(R.drawable.tswitch_center_);
            centerTextView.setTextColor(noSelectTextColor);
        } else if (togState == TSwitchInfo.State.RIGHT) {
            leftTextView.setBackgroundResource(R.drawable.tswitch_left_);
            leftTextView.setTextColor(noSelectTextColor);
            rightTextView.setBackgroundResource(R.drawable.tswitch_right_select);
            rightTextView.setTextColor(selectTextColor);
            centerTextView.setBackgroundResource(R.drawable.tswitch_center_);
            centerTextView.setTextColor(noSelectTextColor);
        } else if (togState == TSwitchInfo.State.MIDDEL) {
            leftTextView.setBackgroundResource(R.drawable.tswitch_left_);
            leftTextView.setTextColor(noSelectTextColor);
            rightTextView.setBackgroundResource(R.drawable.tswitch_right_);
            rightTextView.setTextColor(noSelectTextColor);
            centerTextView.setBackgroundResource(R.drawable.tswitch_center_select);
            centerTextView.setTextColor(selectTextColor);
        }
    }


}
