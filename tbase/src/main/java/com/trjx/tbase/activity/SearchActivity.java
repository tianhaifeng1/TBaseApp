package com.trjx.tbase.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.trjx.R;
import com.trjx.tbase.adapter.TBaseAdapter2;
import com.trjx.tbase.module.titlemodule.TitleListenter;
import com.trjx.tbase.module.titlemodule.TitleModule;
import com.trjx.tlibs.uils.Logger;
import com.trjx.tlibs.uils.SharedPreferencesUtils;
import com.trjx.tlibs.uils.ToastUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by W on 2018/3/24.
 */

public abstract class SearchActivity<B,Adapter extends TBaseAdapter2>
        extends InitActivity
        implements AdapterView.OnItemClickListener, TitleListenter {

    public static String searchHistory = "SearchHistory";

    protected EditText editText;
    protected ListView listView;
    protected LinearLayout historyLL;
    protected TextView btnClear;

    protected ListView listview_history;

    protected ImageView empty;

    protected TitleModule titleModule;

    protected boolean isShowSearchBtn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initWork();
        initView();
    }

    @Override
    protected void initView() {
        titleModule = new TitleModule(context, rootView);
        titleModule.setListenter(this);
        titleModule.initTitle(null,true);

        if(isShowSearchBtn){
            titleModule.initTitleMenu(TitleModule.MENU_TEXT,"搜索");
        }


        editText = findViewById(R.id.title_center_text);

        listView = findViewById(R.id.listview);
        empty = findViewById(R.id.empty);
        historyLL = findViewById(R.id.history_ll);
        btnClear = findViewById(R.id.search_clear);
        listview_history = findViewById(R.id.listview_history);
        btnClear.setOnClickListener(v -> {
            historyData.clear();
            arrayAdapter.notifyDataSetChanged();
            changeSearchData("");
        });

        getSearchHistoryData();

        editText.setOnClickListener(v -> {
            historyLL.setVisibility(View.VISIBLE);
            listView.setVisibility(View.GONE);
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

    }


    protected void setShowSearchBtn(){

    }

    protected boolean isSearch = true;

    protected List<String> historyData = new ArrayList<>();
    protected ArrayAdapter arrayAdapter;

    protected void getSearchHistoryData() {
        historyData.clear();
        String searchHistoryStr = (String) SharedPreferencesUtils.getParam(context,searchHistory, "");
        Logger.t("----------searchHistoryStr = " + searchHistoryStr);
        if (!searchHistoryStr.equals("")) {
            historyData.addAll(Arrays.asList(searchHistoryStr.split("\\|")));
        }
        Logger.t("----------size = " + historyData.size());
        if(null == arrayAdapter){
            arrayAdapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, android.R.id.text1, historyData);
            listview_history.setAdapter(arrayAdapter);
            listview_history.setOnItemClickListener((parent, view, position, id) -> {
                String str = historyData.get(position);
                editText.setText(str);
                editText.setSelection(str.length());
                searchData(str);
            });
        }else{
            arrayAdapter.notifyDataSetChanged();
        }
    }

    protected void searchBefore(){
        if(!isSearch){
            return;
        }
        String ssStr = editText.getText().toString().trim();
        if(ssStr.equals("")){
            ToastUtil.showToast(context,"搜索内容不能为空");
            return;
        }
        isSearch = false;
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
//                    ToastUtil.showToast(context,"搜索内容："+ssStr);
        Logger.t("---------ss = " + ssStr);
        searchData(ssStr);
    }

    protected void searchData(String searchStr){
        historyLL.setVisibility(View.GONE);
        listView.setVisibility(View.VISIBLE);
        infoList.clear();
        searchPost(searchStr);
        historyData.add(0, searchStr);
        changeSearchData(searchStr);
    }

    protected void changeSearchData(String searchStr){
        StringBuilder stringBuilder = new StringBuilder();
        int totalNum = 0;
        if (historyData.size() > 0) {
            e:for (int i = 0; i < historyData.size(); i++) {
                String conStr = historyData.get(i);
                if (!conStr.equals(searchStr)) {
                    stringBuilder.append(historyData.get(i) + "|");
                    totalNum++;
                    if (totalNum == 10) {
                        break e;
                    }
                }else{
                    if (i == 0) {
                        stringBuilder.append(historyData.get(i) + "|");
                        totalNum++;
                    }
                }
            }
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        Logger.t("--------------str = "+stringBuilder.toString());
        SharedPreferencesUtils.setParam(context,searchHistory,stringBuilder.toString());
    }

    //    搜索请求
    protected abstract void searchPost(String searchStr);

    protected List<B> infoList = new ArrayList<>();

    protected Adapter adapter;

    public void getSearchDataList(List<B> infoList) {
        isSearch = true;
        if(infoList == null || infoList.size()==0){
            empty.setVisibility(View.VISIBLE);
        }else{
            empty.setVisibility(View.GONE);
            this.infoList.addAll(infoList);
        }
        if(null == adapter){
            adapter = initAdapter(this.infoList);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(this);
        }else{
            adapter.notifyDataSetChanged();
        }
    }


    protected abstract Adapter initAdapter(List<B> infoList);


    @Override
    public void onClickBack(View view) {
        finish();
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
}
