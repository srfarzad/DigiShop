package com.navin.digishop.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class SmsReciver extends BroadcastReceiver {

    SmsManager sms = SmsManager.getDefault();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("","");

        final Bundle bundle = intent.getExtras();
        try {
            if (bundle != null) {
                final Object[] pdusObj = (Object[]) bundle.get("pdus");
                for (int i = 0; i < pdusObj.length; i++) {
                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[])pdusObj[i]);
                    String phoneNumber = currentMessage.getDisplayOriginatingAddress();
                    String senderNum = phoneNumber;
                    String message = currentMessage.getDisplayMessageBody();


                    Toast.makeText(context, phoneNumber + "  \n "+ message , Toast.LENGTH_LONG).show();
                } // end for loop
            } // bundle is null
        } catch (Exception e) {
        }


    }
}
