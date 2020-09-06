package com.trjx.tbase.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import androidx.annotation.LayoutRes;

import java.util.List;

/**
*
* 作者：小童
* 创建时间：2019/7/19 10:36
*
* 描述：此为TBaseAdapter 的简化版，封装了TBaseViewHolder，方便使用，对于一般需求的可以使用此Adapter
*
*/
public abstract class TBaseAdapter2<T,ViewHolder extends TBaseViewHolder2> extends BaseAdapter{

    protected Context context;
    protected List<T> tList;
    protected LayoutInflater inflater;

    public TBaseAdapter2(Context context, List<T> tList) {
        this.context = context;
        this.tList = tList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return tList.size();
    }

    @Override
    public Object getItem(int position) {
        return tList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (null == convertView) {
            convertView = inflater.inflate(initLayout(), null);
            viewHolder = initViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        bindView(position, viewHolder);
        return convertView;
    }

    /**
     * 初始化item布局文件
     * @return
     */
    public abstract @LayoutRes int initLayout();

    /**
     * 初始化ViewHolder：需要集成TBaseViewHolder
     * @param convertView
     * @return
     */
    public abstract ViewHolder initViewHolder(View convertView);

    /**
     * 绑定数据
     * @param position
     * @param viewHolder
     */
    public abstract void bindView(int position, ViewHolder viewHolder);

    /**
     * 局部更新数据，调用一次getView()方法；Google推荐的做法
     *
     * @param listView 要更新的listview
     * @param position 要更新的位置
     */
    public void updateItemView(ListView listView, int position) {
        /**第一个可见的位置**/
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        /**最后一个可见的位置**/
        int lastVisiblePosition = listView.getLastVisiblePosition();
        /**在看见范围内才更新，不可见的滑动后自动会调用getView方法更新**/
        if (position >= firstVisiblePosition && position <= lastVisiblePosition) {
            /**获取指定位置view对象**/
            View view = listView.getChildAt(position - firstVisiblePosition);
            if(updataItemView(view,position)){
                getView(position, view, listView);
            }
        }
    }


    /**
     * 局部更新数据，调用一次getView()方法；Google推荐的做法
     *
     * @param listView 要更新的listview
     * @param position 要更新的位置
     */
    public void updateItemViewX(ListView listView, int position) {
        /**第一个可见的位置**/
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        /**最后一个可见的位置**/
        int lastVisiblePosition = listView.getLastVisiblePosition();
        /**在看见范围内才更新，不可见的滑动后自动会调用getView方法更新**/
        if (position >= firstVisiblePosition && position <= lastVisiblePosition) {
            /**获取指定位置view对象**/
            View view = listView.getChildAt(position - firstVisiblePosition);
            if(updataItemView(view,position)){
                getView(position-1, view, listView);
            }
        }
    }


    protected boolean updataItemView(View view, int position){

        return true;
    }
}
