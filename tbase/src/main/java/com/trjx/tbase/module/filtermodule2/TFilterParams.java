package com.trjx.tbase.module.filtermodule2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.IntRange;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.trjx.R;

import java.util.HashMap;
import java.util.List;

/**
 * 作者：小童
 * 创建时间：2019/8/22 15:44
 */
public class TFilterParams {

    public static final String FILTER_ITEM_ONE = "item1";
    public static final String FILTER_ITEM_TWO = "item2";
    public static final String FILTER_ITEM_THREE = "item3";
    public static final String FILTER_ITEM_FOUR = "item4";
    public static final String FILTER_ITEM_FIVE = "item5";


    //背景色
    //第一行的背景色
//    public int filterTabBg;
//    //第二行的整体背景色
//    public int filterAllBg;
//    //第二行的列表项背景色
//    public int filterItemBg;
//    public int filterItemSelectBg;


    //字体
//    字体大小
    public int filterTabTextSize;
    public int filterItemTextSize;


    //    字体颜色
//    public int filterTabTextColor;
//    public int filterItemTextColor;
//    public int filterItemSelectTextColor;


    private Context context;

    //    第一行的数量（2~5）
    @IntRange(from = 2, to = 5)
    public int filterTabNumber;

    // 筛选栏的数据
    public List<TFilterTabInfo> tabInfoBeanList;


    //    选择列表的数据
    public HashMap<String, List<TFilterItemInfo>> itemInfoBeanList;

    // 是否显示条目的选中标识
    public boolean showTag;

    //    监听
    public OnTFilterItemClickListener listener;


    public void init(Context context) {
        this.context = context;
//        filterTabBg = Color.parseColor("#ffffff");
//        filterAllBg = Color.parseColor("#40666666");
//        filterItemBg = Color.parseColor("#ffffff");
//        filterItemSelectBg = Color.parseColor("#dddddd");

        filterTabTextSize = 14;
        filterItemTextSize = 12;

        filterTabNumber = 2;

//        context.getResources().getDisplayMetrics().density
//        filterTabTextSize = context.getResources().getDimensionPixelOffset(filterTabTextSize);

    }


    private int index = -1;

    private ViewHolder viewHolder;

    public void initView(Context context) {

        View view = LayoutInflater.from(context).inflate(R.layout.layout_filter2, null);
        viewHolder = new ViewHolder(view);

        viewHolder.mLayoutFilterTabRv.setLayoutManager(new GridLayoutManager(context, filterTabNumber) {

            @Override
            public boolean canScrollVertically() {
                return false;
            }

            @Override
            public boolean canScrollHorizontally() {
                return false;
            }
        });

        TFilterTabAdapter tabAdapter = new TFilterTabAdapter(tabInfoBeanList);
        viewHolder.mLayoutFilterTabRv.setAdapter(tabAdapter);
        tabAdapter.setOnItemClickListener((adapter, view1, position) -> {

            int state = changeState(position);

            int stateTotal = tabInfoBeanList.get(position).getFilterTabStateTotal();
            //显示隐藏
            if (index == position && stateTotal == 2) {
                tabAdapter.notifyItemChanged(position);
                //只有两种状态,重复点击隐藏
                viewHolder.mLayoutFilterItemRl.setVisibility(View.GONE);
                index = -1;
                return;
            }else{
                if(index == position){
                    tabAdapter.notifyItemChanged(position);
                }else{
                    tabAdapter.notifyItemChanged(position);
                    tabAdapter.notifyItemChanged(index);
                }
                index = position;
            }

            switch (position) {
                case 0:
                    loadItemData(state, itemInfoBeanList.get(FILTER_ITEM_ONE));
                    break;
                case 1:
                    loadItemData(state, itemInfoBeanList.get(FILTER_ITEM_TWO));
                    break;
                case 2:
                    loadItemData(state, itemInfoBeanList.get(FILTER_ITEM_THREE));
                    break;
                case 3:
                    loadItemData(state, itemInfoBeanList.get(FILTER_ITEM_FOUR));
                    break;
                case 4:
                    loadItemData(state, itemInfoBeanList.get(FILTER_ITEM_FIVE));
                    break;
            }
        });

    }

    //state 的改变
    private int changeState(int pos) {
        TFilterTabInfo tabInfo = tabInfoBeanList.get(pos);
        int state = tabInfo.getFilterTabSelectState();
        int stateTotal = tabInfo.getFilterTabStateTotal();

        if (stateTotal > 2) {
            state = state + 1;
            if (state >= stateTotal) {
                state = 1;
            }
        } else {
            if (state == 1) {
                state = 0;
            } else {
                state = 1;
            }

        }

        tabInfo.setFilterTabSelectState(state);


        return state;
    }

    private void loadItemData(int state, List<TFilterItemInfo> infoList) {

        //tab 的显示

        //item 的显示
        if (infoList == null) {
            //没有列表项
            viewHolder.mLayoutFilterItemRl.setVisibility(View.GONE);
        } else {
//            有列表项
            viewHolder.mLayoutFilterItemRl.setVisibility(View.VISIBLE);

            viewHolder.mLayoutFilterItemRecyclerview.setLayoutManager(new LinearLayoutManager(context));
            TFilterItemAdapter itemAdapter = new TFilterItemAdapter(infoList);
            itemAdapter.setTag(showTag);
            viewHolder.mLayoutFilterItemRecyclerview.setAdapter(itemAdapter);
            itemAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                }
            });

        }


    }

    static class ViewHolder {

        View view;
        private RecyclerView mLayoutFilterTabRv;
        private RecyclerView mLayoutFilterItemRecyclerview;
        private RelativeLayout mLayoutFilterItemRl;

        public ViewHolder(View view) {
            this.view = view;
            mLayoutFilterTabRv = view.findViewById(R.id.layout_filter_tab_rv);
            mLayoutFilterItemRecyclerview = view.findViewById(R.id.layout_filter_item_recyclerview);
            mLayoutFilterItemRl = view.findViewById(R.id.layout_filter_item_rl);
        }
    }


}
