package com.navin.digishop.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import com.navin.digishop.PaymentService;

public class PayService extends Service {


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return paymentService;
    }



    PaymentService.Stub paymentService = new PaymentService.Stub() {
        @Override
        public void payment(String price) throws RemoteException {
            Log.e("","");
        }

        @Override
        public void login(String username, String password) throws RemoteException {
            Log.e("","");

        }

        @Override
        public void isLogin() throws RemoteException {
            Log.e("","");
        }

        @Override
        public void logout() throws RemoteException {
            Log.e("","");
        }

        @Override
        public void invoice() throws RemoteException {
            Log.e("","");
        };
    };
}
