package com.carousell.data.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class HttpUtils {

    public static boolean isValidResponse(int httpCode) {
        return (httpCode >= 200 && httpCode < 300);
    }


    public static boolean isConnectionAvailable(Context context) {
        ConnectivityManager mgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = mgr.getActiveNetworkInfo();
        return (netInfo != null) ? netInfo.isConnected() : false;
    }
}
