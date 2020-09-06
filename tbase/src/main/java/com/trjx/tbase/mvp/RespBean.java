package com.trjx.tbase.mvp;

/**
 * 例子 ：返回结果数据的对象
 * @param <T>
 */

public class RespBean<T> extends RespResultInfo{

    private int state;
    private int errorCode;
    private String message;
    private T data;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RespBean{" +
                "state=" + state +
                ", errorCode=" + errorCode +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    @Override
    public int getResultState() {
        return state;
    }

    @Override
    public String getRemindMessage() {
        return message;
    }
}
