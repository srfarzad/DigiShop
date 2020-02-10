package com.navin.digishop.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BootupReciever extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context , "DigiShop Start Service", Toast.LENGTH_LONG).show();


       // Intent intent1 = new Intent(context , MediaService.class);
      // context.startService(intent1);

    }
}
