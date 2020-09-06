package com.trjx.tbaseapp.http;

/**
 * 请求相应状态码
 */
public class RespState {

    //重新登录
    public static int POST_LOGIN_EXPRIES = 401;
    //请求超时
    public static int POST_TIMEOUT = 300;
    //秘钥错误
    public static int POST_SIGN_ERROR = 402;
    //参数错误
    public static int POST_PARAM_ERROR = 403;
    //支付余额不足
    public static int POST_REFRESH = 203;
    //非法操作
    public static int POST_ERROR = 202;


}
