package com.navin.digishop.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.navin.digishop.MainActivity;
import com.navin.digishop.R;
import com.navin.digishop.models.IResponseMessage;
import com.navin.digishop.webservice.ApiCaller;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {


    @BindView(R.id.edt_username) AppCompatEditText edt_username;
    @BindView(R.id.edt_password) AppCompatEditText edt_password;
    @BindView(R.id.rel_login) RelativeLayout rel_login;
    @BindView(R.id.progress) ProgressBar progress;


    ApiCaller apiCaller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        apiCaller = new ApiCaller();
    }


    @OnClick(R.id.rel_login)
    public void login_click() {

        String username = edt_username.getText().toString();
        String password = edt_password.getText().toString();

        apiCaller.a();
        try {
            apiCaller.b();
        } catch (Exception e) {
            e.printStackTrace();
        }

        progress.setVisibility(View.VISIBLE);

        apiCaller.login(username, password, new IResponseMessage() {
            @Override
            public void onSuccess(Object response) {
                progress.setVisibility(View.GONE);
                Log.e("","");
                Toast.makeText(getApplicationContext(),"Login Success", Toast.LENGTH_LONG).show();

                try {
                    JSONObject jsonObject = new JSONObject(response.toString());

                    int code = jsonObject.getInt("code");

                    if(code>0) {

                        finish();

                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                        startActivity(intent);


                    }
                    else {
                        Toast.makeText(getApplicationContext(),"User and password are wrong", Toast.LENGTH_LONG).show();

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailuer(String errorMessage) {
                progress.setVisibility(View.GONE);
                Log.e("","");
                Toast.makeText(getApplicationContext(),"Login Failed", Toast.LENGTH_LONG).show();
            }
        });


    }


}
