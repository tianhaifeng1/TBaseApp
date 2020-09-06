package com.trjx.tbase.mvp;

/**
 * MVP设计模式：View层（基类）
 *
 * UI层（View、Activity、Fragment以及它们子类）
 */
public interface TView {

    void showDialog(String msg);

    void hideDialog();

    /**
     * 请求失败:
     */
    void tPostFail(int resultState);

    /**
     * 提示方法:
     * @param message 提示文字
     */
    void tRemind(String message);

    /**
     * 请求异常
     * @param errorMsg
     */
    void tPostError(String errorMsg);


    /**
     * 请求完成
     * @param code 用于区分那个请求
     */
    void tPostFinish(int code);
}
