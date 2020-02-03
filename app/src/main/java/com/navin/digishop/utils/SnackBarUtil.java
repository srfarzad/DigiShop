package com.navin.digishop.utils;

import android.content.Context;

import android.view.View;
import android.view.ViewGroup;

import androidx.core.content.ContextCompat;

import com.google.android.material.snackbar.Snackbar;
import com.navin.digishop.R;


/**
 * Created by Android on 12/23/2015.
 */
public class SnackBarUtil {

    public SnackBarUtil() {


    }

    //java doc

    /**
     * this method is using for display a message
     * @param view
     * @param context
     * @param message is important parameter for showing message
     * @param color
     */
    public static void alert(View view, Context context, String message, int color) {

        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
        ViewGroup group = (ViewGroup) snackbar.getView();
        if (color == 0) {
            group.setBackgroundColor(ContextCompat.getColor(context, R.color.red_500));
        } else {
            group.setBackgroundColor(ContextCompat.getColor(context, R.color.green_500));

        }
        snackbar.show();

    }


}
