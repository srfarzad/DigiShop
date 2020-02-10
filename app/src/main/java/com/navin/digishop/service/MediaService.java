package com.navin.digishop.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.navin.digishop.R;

public class MediaService extends Service {


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        //Media Player
        //VideoView
        //EXO PLAYER


        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext() , R.raw.st_ready);

        mediaPlayer.start();



        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
