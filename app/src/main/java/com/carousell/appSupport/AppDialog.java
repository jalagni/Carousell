package com.carousell.appSupport;

import android.app.AlertDialog;
import android.content.DialogInterface;


import com.carousell.R;
import com.carousell.appCore.BaseActivity;

import timber.log.Timber;

public class AppDialog {

    private static AppDialog aDialog;

    public static AppDialog getInstance() {
        if (aDialog != null)
            return aDialog;

        aDialog = new AppDialog();
        return aDialog;
    }

    private AppDialog() {
    }

    public void showConfirmDialog(BaseActivity bActivity, int titleId, int msgId, final DCallback dCallback) {

        AlertDialog.Builder aBuilder = new AlertDialog.Builder(bActivity);

        aBuilder.setTitle(titleId)
                .setMessage(msgId)
                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dCallback.dialogCallback(AppConst.INVALID, DialogInterface.BUTTON_POSITIVE, null);
                    }
                });

        aBuilder.create().show();

        Timber.e("Confirm Message");
    }


    public interface DCallback {
        void dialogCallback(int dStatus, int dType, Object object);
    }
}
