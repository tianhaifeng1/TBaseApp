package com.trjx.tbase.http;

import com.trjx.tlibs.uils.Logger;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class HttpBase {

    // baseUrl 不能为空
    public static String baseUrl = "http://192.168.1.152:8080/demo/";

    public static String encodeStr = "application/json; charset=utf-8";
    public static String encodeStr2 = "application/x-www-form-urlencoded; charset=utf-8";

    public static String headerName = "";
    public static String headerInfo = "";

    /**
     * 超时时间20s
     */
    protected static long DEFAULT_TIMEOUT = 15;

    //请求成功
    public static int POST_SUCCESS = 200;


    public HttpBase(int postType) {
        init();
        Retrofit.Builder builder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .client(postType == 0 ? genericClientCommon() : genericClientJson());
        setAPI(builder.build());
    }

    public abstract void init();

    public abstract void setAPI(Retrofit retrofit);


    /**
     * 添加统一header,超时时间,http日志打印
     * body采用UTF-8编码
     *
     * @return
     */
    protected static OkHttpClient genericClientJson() {
        //新建log拦截器
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(message -> {
            //打印retrofit日志
            Logger.i("tong_http", "======="+message);
        });
        logging.level(HttpLoggingInterceptor.Level.BODY);
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(logging).connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        builder.addInterceptor(chain -> {
            Request request = chain.request();
            Request.Builder requestBuilder = request.newBuilder();
            requestBuilder.addHeader("Content-Type", encodeStr);
            if (headerName != null && !headerName.equals("")) {
                requestBuilder.addHeader(headerName, headerInfo);
            }
//            requestBuilder.post(RequestBody.create(MediaType.parse(encodeStr),
//                    bodyToString(request.body())));
            requestBuilder.post(RequestBody.create(bodyToString(request.body()), MediaType.parse(encodeStr)));
            request = requestBuilder.build();
            return chain.proceed(request);
        });
        return builder.build();
    }

    /**
     * 添加统一header,超时时间,http日志打印
     * body采用UTF-8编码
     *
     * @return
     */
    protected static OkHttpClient genericClientCommon() {
        //新建log拦截器
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(message -> {
            //打印retrofit日志
            Logger.i("tong_http", "======="+message);
        });
        logging.level(HttpLoggingInterceptor.Level.BODY);
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
//        builder.addInterceptor(logging)
//                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
//                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
//                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        builder.addInterceptor(logging).connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        builder.addInterceptor(chain -> {
            Request request = chain.request();
            Request.Builder requestBuilder = request.newBuilder();
            requestBuilder.addHeader("Content-Type", HttpBase.encodeStr2);
            if (headerName != null && !headerName.equals("")) {
                requestBuilder.addHeader(headerName, headerInfo);
            }
            request = requestBuilder.build();
            return chain.proceed(request);
        });
        return builder.build();
    }

    private static String bodyToString(final RequestBody request) {
        try {
            final Buffer buffer = new Buffer();
            if (request != null)
                request.writeTo(buffer);
            else
                return "";
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }

    /**
     * 将json串转化为RequestBody对象
     *
     * @param jsonStr
     * @return
     */
    public static RequestBody getRequestBody(String jsonStr) {
        return RequestBody.create(MediaType.parse(HttpBase.encodeStr), jsonStr);
    }

    /**
     * 将json串转化为RequestBody对象
     *
     * @param jsonStr   json字符串
     * @param encodeStr 数据的编码格式
     * @return
     */
    public static RequestBody getRequestBody(String jsonStr, String encodeStr) {
        return RequestBody.create(MediaType.parse(encodeStr), jsonStr);
    }

}
