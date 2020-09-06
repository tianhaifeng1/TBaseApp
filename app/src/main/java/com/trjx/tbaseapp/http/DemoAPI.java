package com.trjx.tbaseapp.http;

import com.trjx.tbaseapp.bean.DemoRespBean;
import com.trjx.tbaseapp.bean.TestBean;
import com.trjx.tbaseapp.bean.resp.GoodsListModel;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface DemoAPI {

    //
    @FormUrlEncoded
    @POST("member/memberInfo")
    Observable<DemoRespBean<TestBean>> test(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("goods/goodsList")
    Observable<DemoRespBean<GoodsListModel>> test2(@Field("types") int types,
                                                   @Field("relatedCatids") int relatedCatids,
                                                   @Field("page") int page,
                                                   @Field("pageSize") int pageSize
    );

    @POST("goods/goodsList")
    Observable<DemoRespBean<List<GoodsListModel>>> test3(@Body RequestBody body);

    @POST("http://192.168.1.152:8080/demo/test/goods/goodsList")
    Observable<DemoRespBean<GoodsListModel>> test3_(@Body RequestBody body);


//    @POST("test/test")
//    Observable<DemoRespBean<TestBean>> test();
//
//    @FormUrlEncoded
//    @POST("userController/userinfo")
//    Observable<RespBean<Users>> login(@Field("phone") String username,
//                                      @Field("psw") String password);
//
//    @FormUrlEncoded
//    @POST("userController/userinfoAll")
//    Observable<RespBean<List<Users>>> userAll(@Field("page") int page,
//                                              @Field("pageSize") int pageSize);
//
////    @FormUrlEncoded
////    @POST("userController/userinfoAll2")
////    Observable<RespBean<PageBean<Users>>> userAll2(@Field("page") int page,
////                                                   @Field("pageSize") int pageSize);
//
//    @FormUrlEncoded
//    @POST("userController/userinfoCreate")
//    Observable<RespBean> userAdd(@Field("phone") String phone,
//                                 @Field("psw") String psw);
//
//    @FormUrlEncoded
//    @POST("userController/userinfoCreateMore")
//    Observable<RespBean> userAddMore(@Field("info") String contactsJsonStr);
//
//
//    //----------------------测试用--------------------------------
//    @FormUrlEncoded
//    @POST("https://tpmtea.gantower.com/app/Leave/saveLeave.do")
//    Observable<RespBean> saveLeave(@Field("data") String data);


//    @FormUrlEncoded
//    @POST
//    Call<Users> login(@Url String url,
//                      @Field("sch_id") int sch_id,
//                      @Field("username") String username,
//                      @Field("password") String password);

}
