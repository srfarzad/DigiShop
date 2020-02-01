package com.navin.digishop.webservice;

import com.navin.digishop.models.Category;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IService {



    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseBody> login(@Field("username") String user , @Field("password") String  pass );


    @GET("getCategories.php")
    Call<List<Category>> getCategories();


}
