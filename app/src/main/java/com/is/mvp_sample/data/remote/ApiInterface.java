package com.is.mvp_sample.data.remote;

import com.is.mvp_sample.data.remote.pojo.LoginPojoModel;
import com.is.mvp_sample.data.remote.pojo.RegisterPojoModel;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @author Islam
 * @date 10/11/2018
 */

public interface ApiInterface {


    @POST("login.php")
    @FormUrlEncoded
    Observable<LoginPojoModel> login(@Field("email") String email,
                                     @Field("password") String password);

    @POST("register.php")
    @FormUrlEncoded
    Observable<RegisterPojoModel> register(@Field("email") String email,
                                           @Field("name") String name,
                                           @Field("password") String password);

}
