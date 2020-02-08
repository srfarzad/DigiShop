package com.navin.digishop.config;

import android.app.Application;

import androidx.multidex.MultiDexApplication;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.pushpole.sdk.PushPole;

public class AppConfig extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();


        PushPole.initialize(this,true);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

    }
}
