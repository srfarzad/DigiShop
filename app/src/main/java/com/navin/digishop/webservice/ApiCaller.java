package com.navin.digishop.webservice;

import com.navin.digishop.models.Category;
import com.navin.digishop.models.IResponseMessage;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiCaller {

    IService iService;

    @Inject
    public ApiCaller () {

    iService = ApiClient.getRetrofit().create(IService.class);

    }


    public void login (String user , String pass , IResponseMessage listener) {

     Call<ResponseBody> call= iService.login(user,pass);


     call.enqueue(new Callback<ResponseBody>() {
         @Override
         public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

             try {
                 listener.onSuccess(response.body().string());
             } catch (IOException e) {
                 e.printStackTrace();
             }


         }

         @Override
         public void onFailure(Call<ResponseBody> call, Throwable t) {

             listener.onFailuer(t.getMessage().toString());

         }
     });



    }



    public void getCat(IResponseMessage listener) {


        Call<List<Category>> call = iService.getCategories();


        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {

                listener.onSuccess(response.body());


            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {

                listener.onFailuer(t.getMessage().toString());
            }
        });






    }







    public void a () {

    }

    public void b () throws Exception {

    }


}
