package com.carousell.appSupport;

import android.app.Dialog;
import android.view.Window;

import com.carousell.R;
import com.carousell.appCore.BaseActivity;

import timber.log.Timber;

public class AppLoader {

    private BaseActivity activity;
    private Dialog dialog;


    public AppLoader(BaseActivity activity) {
        this.activity = activity;
        initLoader();
    }

    private void initLoader() {

        dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);

        dialog.setContentView(R.layout.layout_loader);

    }

    public void showLoader() {
        Timber.e("Show Loader");

        if (dialog.isShowing()) {
            return;
        }

        dialog.show();
    }

    public void hideLoader() {

        Timber.e("Hide Loader");
        dialog.dismiss();

    }

}
