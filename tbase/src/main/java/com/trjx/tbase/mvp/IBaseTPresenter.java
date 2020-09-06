package com.trjx.tbase.mvp;

public interface IBaseTPresenter {

    void showDialog(String msg);

    void hideDialog();

    boolean isViewAttach();

    void detachView();

}
