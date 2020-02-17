package com.navin.digishop.config;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDexApplication;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
//import com.pushpole.sdk.PushPole;

public class AppConfig extends MultiDexApplication {

    Context context;
    private static AppConfig instance = null;

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();
        instance = this;

        //PushPole.initialize(this,true);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

    }


    public Context getContext() {
        return context;
    }

    public static AppConfig getInstance() {
        return instance;
    }

}
