package com.carousell.domain.utils;

import android.content.Context;
import android.content.res.Resources;

import com.carousell.domain.R;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import timber.log.Timber;

public class DomainHelper {

    private Context context;

    @Inject
    public DomainHelper(Context context){
        this.context = context.getApplicationContext();
    }

    public String getReadableDate(long time) {

        long diff = System.currentTimeMillis() - (time * 1000);
        int days = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

        Timber.e("Days: " + days);

        if (days >= 365) {
            return context.getString(R.string.yearsAgo, (days / 365));
        } else if (days >= 30) {
            return context.getString(R.string.monthsAgo, (days / 30));
        } else if (days >= 7) {
            return context.getString(R.string.weeksAgo, (days / 7));
        } else {
            return context.getString(R.string.daysAgo, (days));
        }

    }

}
