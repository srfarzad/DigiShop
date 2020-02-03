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

import com.google.android.material.snackbar.Snackbar;
import com.navin.digishop.MainActivity;
import com.navin.digishop.R;
import com.navin.digishop.models.IResponseMessage;
import com.navin.digishop.utils.SnackBarUtil;
import com.navin.digishop.webservice.ApiCaller;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements ILoginView {


    @BindView(R.id.edt_username)
    AppCompatEditText edt_username;
    @BindView(R.id.edt_password)
    AppCompatEditText edt_password;
    @BindView(R.id.rel_login)
    RelativeLayout rel_login;
    @BindView(R.id.progress)
    ProgressBar progress;
    @BindView(R.id.rel_main)
    RelativeLayout rel_main;




    LoginPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        presenter = new LoginPresenter(this,new LoginInteractor());

    }


    @OnClick(R.id.rel_login)
    public void login_click() {

        String username = edt_username.getText().toString();
        String password = edt_password.getText().toString();
        presenter.doLogin(username,password);

    }


    @Override
    public void showProgressBar() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progress.setVisibility(View.GONE);
    }

    @Override
    public void onUsernameError() {

        SnackBarUtil.alert(rel_main,getApplicationContext(),getString(R.string.username_required),0);

        //Snackbar.make(rel_main, getString(R.string.username_required), Snackbar.LENGTH_LONG).show();

    }

    @Override
    public void onPasswordError() {

        SnackBarUtil.alert(rel_main,getApplicationContext(),getString(R.string.password_required),0);

        //Snackbar.make(rel_main, getString(R.string.password_required), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onError() {
        SnackBarUtil.alert(rel_main,getApplicationContext(),getString(R.string.failed),0);
       // Snackbar.make(rel_main, getString(R.string.failed), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void navigateToHome() {


        finish();

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);

        startActivity(intent);

    }

    @Override
    public void onLoginFailed() {
        SnackBarUtil.alert(rel_main,getApplicationContext(),getString(R.string.login_failed),0);
      //  Snackbar.make(rel_main, getString(R.string.login_failed), Snackbar.LENGTH_LONG).show();
    }
}
