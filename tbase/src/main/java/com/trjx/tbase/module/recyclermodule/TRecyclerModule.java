package com.trjx.tbase.module.recyclermodule;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.trjx.R;
import com.trjx.tlibs.uils.Logger;

import java.util.List;

/**
 * 作者：小童
 * 创建时间：2019/8/6 14:23
 * <p>
 * 描述：RecyclerView 模块化
 */
public class TRecyclerModule {

    private Builder builder;

    /**
     * 当前页面状态：0.正常；1.默认页面；2.异常页面
     */
    private int state = 0;

    //默认布局的控件
    private RelativeLayout defRl;
    private ImageView defImg;
    private TextView defText;
    private LinearLayout defLinearLayout;

    //列表布局的控件
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;

    private void initView(View rootView) {
        defRl = rootView.findViewById(R.id.layout_default_all);
        defImg = rootView.findViewById(R.id.layout_default_img);
        defText = rootView.findViewById(R.id.layout_default_text);
        defLinearLayout = rootView.findViewById(R.id.layout_default_linearlayout);

        defImg.setImageResource(builder.resDrawable);
        defText.setText(builder.defTextStr);

        defRl.setOnClickListener(v -> {
            if (!builder.clickDefaultPage) {
                return;
            }
            defRl.setVisibility(View.GONE);
            isShowListLayout(true);
            if (state == 2) {//点击请求异常页面的事件
                state = 0;
                if (null != builder.listenter) {
                    builder.listenter.onClickRecyclerExceptionPageEvent();
                }
            } else if (state == 1) {//点击暂无数据页面的事件，重新请求页面数据
                state = 0;
                if (null != builder.listenter) {
                    setRefreshing(true);
                    builder.listenter.getRecyclerListData();
                }
            }
        });

        swipeRefreshLayout = rootView.findViewById(R.id.swiperefreshlayout);
        recyclerView = rootView.findViewById(R.id.recyclerview);
        isShowListLayout(true);
        swipeRefreshLayout.setColorSchemeColors(builder.colors);
        swipeRefreshLayout.setOnRefreshListener(() -> {
            if (null != builder.listenter) {
                builder.page = 1;
                builder.listenter.getRecyclerListData();
            }
        });
        recyclerView.setLayoutManager(builder.layoutManager);
        setRefreshing(true);
        try {
            initAdapter();
        } catch (TRecyclerAdapterException e) {
            e.printStackTrace();
        }
    }

    //获取默认布局的view
    public RelativeLayout getDefView() {
        return defRl;
    }

    //添加其它view，用于默认页面的扩展：如：默认页面需要添加一个跳转按钮等，可以使用此方法
    public void addOtherView(View view) {
        defLinearLayout.addView(view);
    }

    //移除添加的View
    public void removeOtherView() {
        defLinearLayout.removeAllViews();
    }

    //获取默认布局的view
    public RelativeLayout getOView() {
        return defRl;
    }


    /**
     * 设置默认布局的图片
     *
     * @param resDrawable
     */
    public void setDefImg(@DrawableRes int resDrawable) {
        defImg.setImageResource(resDrawable);
    }

    /**
     * 设置默认布局的文本
     *
     * @param defTextStr
     */
    public void setDefText(String defTextStr) {
        defText.setText(defTextStr == null ? "" : defTextStr);
    }

    /**
     * Set the visibility state of this view.
     *
     * @param visibility One of {View.VISIBLE,View.INVISIBLE,or View.GONE.}
     * @attr ref android.R.styleable#View_visibility
     */
    public void setDefTextViewVisibility(int visibility) {
        defText.setVisibility(visibility);
    }

    /**
     * 获取 RecyclerView 控件
     *
     * @return
     */
    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    private void initAdapter() throws TRecyclerAdapterException {
        if (builder.recyclerAdapter == null) {
            throw new TRecyclerAdapterException();
        } else {
            builder.recyclerAdapter.setOnLoadMoreListener(() -> {
                if (builder.listenter != null) {
                    builder.page++;
                    builder.listenter.getRecyclerListData();
                }
            }, recyclerView);

            builder.recyclerAdapter.openLoadAnimation();
            recyclerView.setAdapter(builder.recyclerAdapter);
        }
    }

    /**
     * 绑定数据
     *
     * @param listData
     */
    public void bindListData(List<?> listData) {
        this.bindListData(listData, false);//默认显示
    }

    public void bindListData(List<?> listData, boolean gone) {

        if (builder.recyclerAdapter == null) {
            return;
        }
        final int size = listData == null ? 0 : listData.size();
        if (builder.page == 1) {
            builder.recyclerAdapter.setNewData(listData);
            if (listData == null || size == 0) {
                isShowDefLayout(true);
            } else {
                isShowDefLayout(false);
            }

        } else {
            if (size > 0) {
                builder.recyclerAdapter.addData(listData);
            }
        }

        if (size < builder.pageSize) {
            //false：显示结尾没有更多数据，反之不显示
            builder.recyclerAdapter.loadMoreEnd(gone);
        } else {
            builder.recyclerAdapter.loadMoreComplete();
        }

    }


    /**
     * 请求异常方法
     */
    public void error() {
        if (builder.page == 1) {
            state = 2;
            setDefImg(R.mipmap.default_list);
            isShowDefLayout(true);
        }
    }

    /**
     * 刷新按钮是否显示
     *
     * @param isRefresh true 显示，反之不显示
     */
    public void setRefreshing(boolean isRefresh) {
        swipeRefreshLayout.setRefreshing(isRefresh);
    }

    //

    /**
     * 可以设置swipeRefreshLayout的使用：（默认是可以使用的）
     *
     * @param enable false 为禁用 ，true为恢复使用
     */
    public void setSwipeRefreshEnable(boolean enable) {
        swipeRefreshLayout.setEnabled(enable);
    }


    /**
     * 获取页码
     *
     * @return 页码
     */
    public int getPage() {
        return builder.page;
    }

    public void setPage(int page) {
        builder.page = page;
    }

    /**
     * 获取页面条目大小
     *
     * @return 页码
     */
    public int getPageSize() {
        return builder.pageSize;
    }

    public void setPageSize(int pageSize) {
        builder.pageSize = pageSize;
    }

    /**
     * 是否显示默认布局
     *
     * @param isShow
     */
    public void isShowDefLayout(boolean isShow) {
        if (builder.page != 1) {
            return;
        }
        if (isShow) {
            state = 1;
            defRl.setVisibility(View.VISIBLE);
            isShowListLayout(false);
        } else {
            defRl.setVisibility(View.GONE);
            isShowListLayout(true);
        }
    }


    /**
     * 是否显示列表控件
     *
     * @param isShow
     */
    public void isShowListLayout(boolean isShow) {
        if (isShow) {
            recyclerView.setVisibility(View.VISIBLE);
        } else {
            recyclerView.setVisibility(View.GONE);
        }
    }


    public void deleteListData(int position) {
        try {
            builder.recyclerAdapter.remove(position);
            if (builder.recyclerAdapter.getData().size() == 0) {
                state = 1;
                defRl.setVisibility(View.VISIBLE);
                isShowListLayout(false);
            }

        } catch (Exception e) {
            e.printStackTrace();
            Logger.t("删除条目数据异常");
        }
    }


    public static class Builder {

        private Context context;

        /* 每页大小 */
        private int pageSize = 20;

        private int page = 1;
        /**
         * 是否可以点击默认页面:默认不能点击
         */
        private boolean clickDefaultPage = false;

        private String defTextStr;

        private @DrawableRes
        int resDrawable;

        private TRecyclerViewListenter listenter;


        private int colors[] = {
                Color.rgb(47, 223, 189),
                Color.rgb(223, 47, 189),
                Color.rgb(189, 223, 47),
                Color.rgb(47, 55, 80)
        };

        private RecyclerView.LayoutManager layoutManager;

        private BaseQuickAdapter recyclerAdapter;

        public Builder(Context context) {
            this.context = context;
            defTextStr = "暂无数据";
            resDrawable = R.mipmap.default_list;
        }

        public Builder setPageSize(int pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public Builder setPage(int page) {
            this.page = page;
            return this;
        }

        public Builder setClickDefaultPage(boolean clickDefaultPage) {
            this.clickDefaultPage = clickDefaultPage;
            return this;
        }

        public Builder setDefTextStr(String defTextStr) {
            if (defTextStr != null && !defTextStr.equals("")) {
                this.defTextStr = defTextStr;
            }
            return this;
        }

        public Builder setDefImgRes(@DrawableRes int resDrawable) {
            this.resDrawable = resDrawable;
            return this;
        }

        public Builder setTRecyclerViewListenter(TRecyclerViewListenter listenter) {
            this.listenter = listenter;
            return this;
        }

        /**
         * 初始化刷新按钮的样式
         *
         * @return
         */
        public Builder setColors(int[] colors) {
            if (colors != null || colors.length > 0) {
                this.colors = colors;
            }
            return this;
        }

        public Builder setLayoutManager(RecyclerView.LayoutManager layoutManager) {
            this.layoutManager = layoutManager;
            return this;
        }

        /**
         * 创建适配器
         */
        public <Adapter extends BaseQuickAdapter> Builder createAdapter(Adapter adapter) {
            recyclerAdapter = adapter;
            return this;
        }


        public TRecyclerModule creat(View rootView) {
            if (layoutManager == null) {
                layoutManager = new LinearLayoutManager(context);
            }

            TRecyclerModule recyclerModule_ = new TRecyclerModule();
            recyclerModule_.builder = this;
            recyclerModule_.initView(rootView);
            return recyclerModule_;
        }


    }


}
