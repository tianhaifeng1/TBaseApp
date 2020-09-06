package com.trjx.tbase.mvp;

import androidx.annotation.NonNull;

import com.google.gson.Gson;

import java.lang.ref.WeakReference;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import static com.trjx.tbase.http.HttpBase.POST_SUCCESS;

/**
 * MVP设计模式：Presenter层（基类）
 * <p>
 * 中介（MVP设计目的：为了将UI层和数据层进行解耦和），通过P层进行关联
 */
public abstract class TPresenter<V extends TView, M extends TModel> implements IBaseTPresenter {

    // 防止 Activity 不走 onDestory() 方法，所以采用弱引用来防止内存泄漏
    private WeakReference<V> mViewRef;
    protected M model;
    protected Gson gson;


    public TPresenter(@NonNull V view) {
        attachView(view);
        gson = new Gson();
    }

    private void attachView(V view) {
        mViewRef = new WeakReference(view);
    }

    /**
     * 设置TModel
     *
     * @param model
     */
    public void setModel(M model) {
        this.model = model;
    }

    /**
     * 获取View层对象
     *
     * @return
     */
    public V getView() {
        return mViewRef.get();
    }

    /**
     * 判断是否关联了View层
     *
     * @return
     */
    @Override
    public boolean isViewAttach() {
        return mViewRef != null && getView() != null;
    }

    /**
     * 解除View层关联
     */
    @Override
    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }


    @Override
    public void showDialog(String msg) {
        if (isViewAttach()) {
            getView().showDialog(msg);
        }
    }

    @Override
    public void hideDialog() {
        if (isViewAttach()) {
            getView().hideDialog();
        }
    }

    /**
     * 用于 Toast 提示
     * @param msg
     */
    public void onRemind(String msg) {
        if (isViewAttach()) {
            getView().tRemind(msg);
        }
    }



    //判断数据的状态
    public boolean responseState(RespResultInfo resultInfo) {
        return responseState(resultInfo, false, null);//默认不需要提醒
    }

    public boolean responseState(RespResultInfo resultInfo,String remindMsg) {
        return responseState(resultInfo, true, remindMsg);
    }

    public boolean responseState(RespResultInfo resultInfo, boolean isRemind,String remindMsg) {
        if (resultInfo != null) {
            int state = resultInfo.getResultState();
            if (state == POST_SUCCESS) {//成功返回数据
                return true;
            } else {
                if (isRemind && isViewAttach()) {
                    //可以控制提示的内容
                    getView().tRemind(remindMsg == null || remindMsg.equals("") ? resultInfo.getRemindMessage() : remindMsg);//需要提醒的调用此方法
                }

                if (isViewAttach()) {
                    getView().tPostFail(resultInfo.getResultState());
                }

            }
        } else {
            if (isViewAttach()) {
                getView().tPostError("返回的数据异常");
            }
        }
        return false;
    }


    public abstract class TObserver<T> implements Observer<T> {

        @Override
        public void onSubscribe(Disposable d) {
            //可以随时取消连接（请求之前条用）
        }

        //    一下为请求的返回结果
//    成功获取到请求值
        @Override
        public abstract void onNext(T bean);

        //    请求异常：与onNext 互斥
        @Override
        public void onError(Throwable e) {
            if (isViewAttach()) {
                getView().tPostError(e.getMessage());
            }
            if (isViewAttach()) {
                getView().tPostFinish(-1);
            }
        }

        //    请求完成
        @Override
        public void onComplete() {
            if (isViewAttach()) {
                getView().tPostFinish(-1);
            }
        }

    }



}
