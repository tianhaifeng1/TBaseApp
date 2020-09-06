package com.trjx.tbase.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;
import com.trjx.R;
import com.trjx.tbase.adapter.TViewPagerStateAdapter;
import com.trjx.tbase.fragment.TFragment;
import com.trjx.tlibs.views.TViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * 底部导航按钮需参考 navigation_bottom.xml menu布局，注意id不能改变
 *
 * 参数：smoothScroll 是否带滚动动画
 * 参数：reselectedRefresh 是否底部按钮重复选择刷新
 *
 * 注：底部按钮最多支持5个
 *
 */
public abstract class NavBottomActivity extends InitActivity implements BottomNavigationView.OnNavigationItemReselectedListener,
        BottomNavigationView.OnNavigationItemSelectedListener{

    protected BottomNavigationView mBottomNavView;
    protected TViewPager mViewpager;
    //ViewPager是否带滚动动画
    protected boolean smoothScroll = false;

    //    底部按钮重复选择刷新
    protected boolean reselectedRefresh = false;

    //fragment数据集合
    protected List<TFragment> fragmentList = new ArrayList<>();

    protected TViewPagerStateAdapter tViewPagerStateAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        initWork();
        initView();


    }

    /**
     * 可以自定义布局：需要包含activity_nav_bottom 中的对应控件，负责会报异常
     *
     * @return
     */
    protected @LayoutRes
    int initLayout() {
        return R.layout.activity_nav_bottom;
    }


    @Override
    protected void initView() {

        mBottomNavView = findViewById(R.id.bottom_nav_view);
        mViewpager = findViewById(R.id.viewpager);
        mViewpager.setScanScroll(false);
        mViewpager.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);

        mBottomNavView.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);

//        1.取消位移动画的效果
//        activityAssist.disableShiftMode(mBottomNavView);
//        2.取消导航栏的点击效果（类似水波纹的效果）：app:itemBackground="@null"
//        3.取消导航栏的每项点击文字和图片放大的效果：我们需要在values中的demens.xml中设置相应的值

        mBottomNavView.setOnNavigationItemSelectedListener(this);
        mBottomNavView.setOnNavigationItemReselectedListener(this);
        initFragmentData();
        //添加底部菜单
        int resMenuId = initTabMenu();
        if (resMenuId == 0) {
            //默认
            resMenuId = R.menu.navigation_bottom;
        }
        mBottomNavView.inflateMenu(resMenuId);
        tViewPagerStateAdapter = new TViewPagerStateAdapter(getSupportFragmentManager());
        tViewPagerStateAdapter.setmFragments(fragmentList);
        mViewpager.setAdapter(tViewPagerStateAdapter);
        mViewpager.setOffscreenPageLimit(fragmentList.size());

    }


    protected abstract void initFragmentData();
//    {
//        //默认
////        if (fragmentList == null || fragmentList.size() == 0) {
////            fragmentList.add(BlankFragment.newInstance("首页", ""));
////            fragmentList.add(BlankFragment.newInstance("订单", ""));
////            fragmentList.add(BlankFragment.newInstance("消息", ""));
////            fragmentList.add(BlankFragment.newInstance("我的", ""));
////        }
//    }

    protected abstract int initTabMenu();
//    {
//        return R.menu.navigation_bottom;
//    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        int position = intent.getIntExtra("position", -1);
        if (position > -1) {
            skipTab(position);
        }
    }


    public void skipTab(int position){
        if (menuItem != null) {
            menuItem.setChecked(false);
        } else {
            mBottomNavView.getMenu().getItem(0).setChecked(false);
        }
        menuItem = mBottomNavView.getMenu().getItem(position);
        menuItem.setChecked(true);
        mViewpager.setCurrentItem(position, smoothScroll);
        fragmentList.get(position).initData();
    }


    @Override
    public void onNavigationItemReselected(@NonNull MenuItem item) {
        if(reselectedRefresh){
            int itemId = item.getItemId();
            if (itemId == R.id.nav_bottom_item1) {
                fragmentList.get(0).initData();
            } else if (itemId == R.id.nav_bottom_item2) {
                fragmentList.get(1).initData();
            } else if (itemId == R.id.nav_bottom_item3) {
                fragmentList.get(2).initData();
            } else if (itemId == R.id.nav_bottom_item4) {
                fragmentList.get(3).initData();
            } else if (itemId == R.id.nav_bottom_item5) {
                fragmentList.get(4).initData();
            }
        }
    }

    private MenuItem menuItem;

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        menuItem = item;
        int itemId = item.getItemId();
        if (itemId == R.id.nav_bottom_item1) {
            mViewpager.setCurrentItem(0, smoothScroll);
            fragmentList.get(0).initData();
            return true;
        } else if (itemId == R.id.nav_bottom_item2) {
            mViewpager.setCurrentItem(1, smoothScroll);
            fragmentList.get(1).initData();
            return true;
        } else if (itemId == R.id.nav_bottom_item3) {
            mViewpager.setCurrentItem(2, smoothScroll);
            fragmentList.get(2).initData();
            return true;
        } else if (itemId == R.id.nav_bottom_item4) {
            mViewpager.setCurrentItem(3, smoothScroll);
            fragmentList.get(3).initData();
            return true;
        } else if (itemId == R.id.nav_bottom_item5) {
            mViewpager.setCurrentItem(4, smoothScroll);
            fragmentList.get(4).initData();
            return true;
        }
        return false;
    }


}
