package com.trjx.tbase.module.recyclermodule;

/**
 * 作者：小童
 * 创建时间：2019/8/5 14:59
 */
public class TRecyclerAdapterException extends Exception {

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }

    public TRecyclerAdapterException() {
        super("t_error:--TRecyclerAdapter不能为空");
    }

    public TRecyclerAdapterException(String message) {
        super(message);
    }
}
