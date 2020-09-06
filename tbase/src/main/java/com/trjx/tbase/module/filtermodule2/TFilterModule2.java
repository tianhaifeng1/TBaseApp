package com.trjx.tbase.module.filtermodule2;

import android.content.Context;
import android.view.LayoutInflater;

import java.util.List;

/**
 * 作者：小童
 * 创建时间：2019/8/22 15:20
 */
public class TFilterModule2 {




    private Builder bulider;

    private OnTFilterItemClickListener listener;

    public void setOnTFilterModuleListener(OnTFilterItemClickListener listener) {
        this.listener = listener;
    }


    public static class Builder {

        private Context context;

        private TFilterParams params;

        private LayoutInflater inflater;

        public Builder(Context context) {
            this.context = context;
            inflater = LayoutInflater.from(context);
            params = new TFilterParams();
            params.init(context);
        }


        public Builder setFilterTabTextSize(int filterTabTextSize) {
            params.filterTabTextSize = filterTabTextSize;
            return this;
        }

        public Builder setFilterItemTextSize(int filterItemTextSize) {
            params.filterItemTextSize = filterItemTextSize;
            return this;
        }

        public Builder setFilterTabNumber(int tabNumber) {
            params.filterTabNumber = tabNumber;
            return this;
        }
        public Builder setFilterItemTag(boolean showTag) {
            params.showTag = showTag;
            return this;
        }

        public Builder setTabList(List<TFilterTabInfo> tabInfoBeanList) {
            params.tabInfoBeanList = tabInfoBeanList;
            return this;
        }

        public Builder setItemList( String[] itemListTags, List<TFilterItemInfo>... filterItemInfos) {

            if (itemListTags != null && itemListTags.length > 0) {
                for (int i = 0; i < itemListTags.length; i++) {
                    List<TFilterItemInfo> list = null;
                    if (i < filterItemInfos.length) {
                        list = filterItemInfos[i];
                    }
                    params.itemInfoBeanList.put(itemListTags[i], list);
                }
            }

            return this;
        }



        public Builder setOnTFilterModuleListener(OnTFilterItemClickListener listener) {
            params.listener = listener;
            return this;
        }


        public TFilterModule2 creat(){

            TFilterModule2 filterModule2 = new TFilterModule2();
            filterModule2.bulider = this;

            params.initView(context);




            return filterModule2;
        }

    }

}
