package com.trjx.tbase.activity;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.trjx.R;
import com.trjx.tbase.module.titlemodule.TitleListenter;
import com.trjx.tbase.module.titlemodule.TitleModule;
import com.trjx.tlibs.uils.Logger;
import com.trjx.tlibs.uils.SharedPreferencesUtils;
import com.trjx.tlibs.uils.ToastUtil2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 未完成，待测试
 *
 * 作者：小童
 * 创建时间：2019/8/9 9:30
 *
 * 注：使用方法
 *
 * 1.布局文件必须为：R.layout.activity_search2
 * 2.Adapter extends TBaseAdapter2
 * 3.实现SearchListenter接口，来进行搜索请求处理
 * 4.搜索完的数据只需要调用 bindSearchDataList 方法进行数据绑定即可
 *
 */


public class SearchActivityAssist2<B> implements TitleListenter, AdapterView.OnItemClickListener {

    private boolean isShowSearchBtn;

    private BaseQuickAdapter recyclerAdapter;

    private InitActivity initActivity;

    private SearchListenter searchListenter;

    private String tag = "SearchHistory";

    public SearchActivityAssist2(InitActivity initActivity) {
        this(false, initActivity);
    }

    public SearchActivityAssist2(boolean isShowSearchBtn, InitActivity initActivity) {
        this.isShowSearchBtn = isShowSearchBtn;
        this.initActivity = initActivity;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * Adapter extends TBaseAdapter2
     *
     * @param adapter
     * @return
     */
    public <Adapter extends BaseQuickAdapter> void setAdapter(Adapter adapter) {
        this.recyclerAdapter = adapter;
    }

    public void setSearchListenter(SearchListenter searchListenter) {
        this.searchListenter = searchListenter;
    }



    public void setAdapter(){

    }


    public void init(View rootView){
        initView(rootView);
    }


    /**
     * 设置标题
     *
     * @param titleName
     */
    public void setTitleName(String titleName) {
        titleModule.setTitleText(titleName);
    }


    private EditText editText;
    private RecyclerView recyclerview;
    private LinearLayout historyLL;
    private TextView btnClear;

    private RecyclerView recyclerview_history;

    private ImageView empty;

    private TitleModule titleModule;

//
//    public SearchActivityAssist() {
//        this(initActivity, false);
//    }
//    public SearchActivityAssist(InitActivity initActivity,boolean isShowSearchBtn) {
//        this.initActivity = initActivity;
//        this.isShowSearchBtn = isShowSearchBtn;
//    }

    private void initView(View rootView) {
        titleModule = new TitleModule(initActivity, rootView);
        titleModule.setListenter(this);
        titleModule.initTitle(null, true);

        if (isShowSearchBtn) {
            titleModule.initTitleMenu(TitleModule.MENU_TEXT, "搜索");
        }

        editText = rootView.findViewById(R.id.title_center_text);

        recyclerview = rootView.findViewById(R.id.recyclerview);
        empty = rootView.findViewById(R.id.empty);
        historyLL = rootView.findViewById(R.id.history_ll);
        btnClear = rootView.findViewById(R.id.search_clear);
        recyclerview_history = rootView.findViewById(R.id.recyclerview_history);

        recyclerview.setLayoutManager(new LinearLayoutManager(initActivity.context));

        btnClear.setOnClickListener(v -> {
            historyData.clear();
            arrayAdapter.notifyDataSetChanged();
            changeSearchData("");
        });

        getSearchHistoryData();

        editText.setOnClickListener(v -> {
            historyLL.setVisibility(View.VISIBLE);
            recyclerview.setVisibility(View.GONE);
            empty.setVisibility(View.GONE);
            getSearchHistoryData();
        });

        editText.setOnKeyListener((v, keyCode, event) -> {
            Logger.t("-----keyCode = " + keyCode);
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                searchBefore();
                return true;
            }
            return false;
        });

//        if (adapter != null) {
//            recyclerview.setAdapter(adapter);
//            recyclerview.setOnItemClickListener(this);
//        }

    }



    private boolean isSearch = true;

    private List<String> historyData = new ArrayList<>();
    private ArrayAdapter arrayAdapter;


    private void getSearchHistoryData() {
        historyData.clear();
        String searchHistoryStr = (String) SharedPreferencesUtils.getParam(initActivity.context, tag, "");
        Logger.t("----------searchHistoryStr = " + searchHistoryStr);
        if (!searchHistoryStr.equals("")) {
            historyData.addAll(Arrays.asList(searchHistoryStr.split("\\|")));
        }
        Logger.t("----------size = " + historyData.size());
        if (null == arrayAdapter) {
            arrayAdapter = new ArrayAdapter(initActivity.context, android.R.layout.simple_list_item_1, android.R.id.text1, historyData);
//            recyclerview_history.setAdapter(arrayAdapter);
//            recyclerview_history.setOnItemClickListener((parent, view, position, id) -> {
//                String str = historyData.get(position);
//                editText.setText(str);
//                editText.setSelection(str.length());
//                searchData(str);
//            });
        } else {
            arrayAdapter.notifyDataSetChanged();
        }
    }

    private void searchBefore() {
        if (!isSearch) {
            return;
        }
        String ssStr = editText.getText().toString().trim();
        if (ssStr.equals("")) {
            ToastUtil2.showToast(initActivity.context, "搜索内容不能为空");
            return;
        }
        isSearch = false;
        InputMethodManager imm = (InputMethodManager) initActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
//                    ToastUtil.showToast(context,"搜索内容："+ssStr);
        Logger.t("---------ss = " + ssStr);
        searchData(ssStr);
    }


    private void searchData(String searchStr) {
        historyLL.setVisibility(View.GONE);
        recyclerview.setVisibility(View.VISIBLE);
//        infoList.clear();
        if (searchListenter != null) {
            searchListenter.searchPost(searchStr);
        }
        historyData.add(0, searchStr);
        changeSearchData(searchStr);
    }

    private void changeSearchData(String searchStr) {
        StringBuilder stringBuilder = new StringBuilder();
        int totalNum = 0;
        if (historyData.size() > 0) {
            e:
            for (int i = 0; i < historyData.size(); i++) {
                String conStr = historyData.get(i);
                if (!conStr.equals(searchStr)) {
                    stringBuilder.append(historyData.get(i) + "|");
                    totalNum++;
                    if (totalNum == 10) {
                        break e;
                    }
                } else {
                    if (i == 0) {
                        stringBuilder.append(historyData.get(i) + "|");
                        totalNum++;
                    }
                }
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        Logger.t("--------------str = " + stringBuilder.toString());
        SharedPreferencesUtils.setParam(initActivity.context, tag, stringBuilder.toString());
    }


    public void bindSearchDataList(List<B> infoList) {
        isSearch = true;
        if (infoList == null || infoList.size() == 0) {
            empty.setVisibility(View.VISIBLE);
        } else {
            empty.setVisibility(View.GONE);
        }

//        if (adapter != null) {
//            adapter.notifyDataSetChanged();
//        }

    }


    /**
     * 绑定数据
     * @param listData
     */
    public void bindListData(List<?> listData) {
        this.bindListData(listData, false);//默认显示
    }
    public void bindListData(List<?> listData,boolean gone) {

        if (recyclerAdapter == null) {
            return;
        }

        isSearch = true;
        if (listData == null || listData.size() == 0) {
            empty.setVisibility(View.VISIBLE);
        } else {
            empty.setVisibility(View.GONE);
            if (recyclerAdapter.getData() == null) {
                recyclerAdapter.setNewData(listData);
            }else{
                recyclerAdapter.replaceData(listData);
            }
        }
        recyclerAdapter.loadMoreEnd(true);
    }




    @Override
    public void onClickBack(View view) {
        initActivity.finish();
    }

    @Override
    public void onClickLeftText(View view) {

    }

    @Override
    public void onClickRightText(View view) {
        searchBefore();
    }

    @Override
    public void onClickMenu(View view) {

    }

    @Override
    public void onMenuItemClick(int position) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }


}
