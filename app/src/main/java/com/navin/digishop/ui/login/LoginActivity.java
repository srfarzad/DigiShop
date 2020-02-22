package com.navin.digishop.ui.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.navin.digishop.MainActivity;
import com.navin.digishop.R;
import com.navin.digishop.config.AppConfig;
import com.navin.digishop.database.Basket;
import com.navin.digishop.database.BasketDatabase;
//import com.navin.digishop.di.DaggerUserComponent;
import com.navin.digishop.di.UserComponent;
import com.navin.digishop.di.UserModule;
import com.navin.digishop.models.IResponseMessage;
import com.navin.digishop.service.MediaService;
import com.navin.digishop.utils.ApplicationManager;
import com.navin.digishop.utils.SnackBarUtil;
import com.navin.digishop.webservice.ApiCaller;
import com.navin.digishop.webservice.ApiComponent;
//import com.navin.digishop.webservice.DaggerApiComponent;
import com.navin.digishop.webservice.ServiceModule;

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


    @BindView(R.id.adView) AdView adView;

    private FirebaseAuth mAuth;





    LoginPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();



        presenter = new LoginPresenter(this,new LoginInteractor());


        showAds();

        service();



        Intent intent = new Intent();
        intent.setClassName("com.navin.digiservice","com.navin.digiservice.MessageService");
        intent.setAction("com.navin.digiservice.MessageService");

        intent.putExtra("id",1);
        intent.putExtra("name" , "{\n" +
                "\"id\" : 1,\n" +
                "\"title\" : \"adsad\"\n" +
                ",\"icon\" : \"http://addadasd.png\"\n" +
                "}");


        sendBroadcast(intent);


    //    UserComponent component = DaggerUserComponent.builder().userModule(new UserModule()).build();


       // component.provideUser().addContact("hi@gmail.com");
        //Log.e("Component", component.provideUser().getContact());


/*
        ApiComponent apiComponent = DaggerApiComponent.builder().serviceModule(
                new ServiceModule()).build();
*/

        //apiComponent.getWebserviceCaller().

        AppConfig appConfig = AppConfig.getInstance();

        appConfig.getContext();


        BasketDatabase basketDatabase = BasketDatabase.getInstance(this);

        Basket basket = new Basket(1,"lg");

        basketDatabase.Dao().insert(basket);

        Log.e("","");




    }

    private void service() {
        if(ApplicationManager.isMyServiceRunning(this, MediaService.class)){

            Intent intent1 = new Intent(getApplicationContext() , MediaService.class);
            startService(intent1);
        }
        else {
            Toast.makeText(this,"service is ruuning before" , Toast.LENGTH_LONG).show();
        }
    }

    private void showAds() {
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);


        adView.setAdListener(new AdListener(){

            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Log.e("","");
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                Log.e("","");
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                Log.e("","");
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
                Log.e("","");
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
                Log.e("","");
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
                Log.e("","");
            }
        });
    }


    @OnClick(R.id.rel_login)
    public void login_click() {

        String username = edt_username.getText().toString();
        String password = edt_password.getText().toString();
     //   presenter.doLogin(username,password);


        mAuth.createUserWithEmailAndPassword(username , password )
                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.e("","");
                    }
                });







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
