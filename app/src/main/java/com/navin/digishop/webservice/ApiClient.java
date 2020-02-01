package com.navin.digishop.webservice;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static Retrofit retrofit = null;

    public final static String KEY_URL="http://androidsupport.ir/market/";


    public static Retrofit getRetrofit(){

        if(retrofit==null){

            retrofit = new Retrofit.Builder().baseUrl(KEY_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;

    }

}

