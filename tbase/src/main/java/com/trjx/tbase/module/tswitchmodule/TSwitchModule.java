package com.trjx.tbase.module.tswitchmodule;

import android.content.Context;
import android.view.View;


/**
 * @author tong
 * @date 2018/3/18 18:28
 *
 * 注：
 *
 */

public class TSwitchModule {

    private Context context;

    public TSwitchModule(Context context) {
        this.context = context;
    }

    public static class Builder {

        private TSwitchInfo switchInfo;

        public Builder(Context context) {
            switchInfo = new TSwitchInfo(context);
        }

        public Builder setSelectTextColor(int textColor) {
            switchInfo.setSelectTextColor(textColor);
            return this;
        }
        public Builder setNoSelectTextColor(int textColor) {
            switchInfo.setNoSelectTextColor(textColor);
            return this;
        }

        public Builder setLeftText(String leftText) {
            switchInfo.setLeftText(leftText);
            return this;
        }
        public Builder setCenterText(String centerText) {
            switchInfo.setCenterText(centerText);
            return this;
        }
        public Builder setRightText(String rightText) {
            switchInfo.setRightText(rightText);
            return this;
        }


        public Builder setShowType(int showType) {
            switchInfo.setShowType(showType);
            return this;
        }


        public Builder setState(TSwitchInfo.State toggleState) {
            switchInfo.setToggle(toggleState);
            return this;
        }

        public Builder setTSwitchListenter(TSwitchListenter listenter) {
            switchInfo.setListenter(listenter);
            return this;
        }

        public TSwitchModule create(View rootView){
            TSwitchModule tSwitchModule = new TSwitchModule(switchInfo.context);
            switchInfo.init(rootView,tSwitchModule);
            return tSwitchModule;
        }

    }

}
