package com.carousell.utils;

import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.carousell.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class AppUtils {

    public static boolean isValidString(String sText) {

        if (sText == null || sText.trim().isEmpty()) {
            return false;
        }
        return true;
    }


    public static boolean isConnectionAvailable(Context context) {
        ConnectivityManager mgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = mgr.getActiveNetworkInfo();
        return (netInfo != null) ? netInfo.isConnected() : false;
    }



    public static String getDisplayDate(long time) {
        SimpleDateFormat sFormat = new SimpleDateFormat("dd MMM yyyy");
        return sFormat.format(new Date(time * 1000));
    }



}
