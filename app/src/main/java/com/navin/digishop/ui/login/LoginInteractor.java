package com.navin.digishop.ui.login;

import android.content.Intent;
import android.widget.Toast;

import com.navin.digishop.MainActivity;
import com.navin.digishop.models.IResponseMessage;
import com.navin.digishop.webservice.ApiCaller;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginInteractor {


    public interface ILoginListener {

        public void onUsernameError();

        public void onPasswordError();

        public void onSuccess();

        public void onLoginFailed();

        public void onFailed();

    }


    ApiCaller apiCaller;

    public LoginInteractor() {
        apiCaller = new ApiCaller();
    }


    public void login(String username, String password, ILoginListener listener) {


        if (username.isEmpty()) {
            listener.onUsernameError();
            return;
        }


        if(password.isEmpty()){
            listener.onPasswordError();
            return;
        }


        apiCaller.login(username, password, new IResponseMessage() {
            @Override
            public void onSuccess(Object response) {


                try {
                    JSONObject jsonObject = new JSONObject(response.toString());

                    int code = jsonObject.getInt("code");

                    if (code > 0) {

                        listener.onSuccess();


                    } else {

                        listener.onLoginFailed();


                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }




            }

            @Override
            public void onFailuer(String errorMessage) {

                listener.onFailed();

            }
        });







    }


}
