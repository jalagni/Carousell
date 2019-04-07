package com.carousell;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;


import com.carousell.R;
import com.carousell.appCore.BaseActivity;
import com.carousell.appSupport.AppDialog;
import com.carousell.appSupport.NavMngr;
import com.carousell.databinding.ActivityMainBinding;
import com.carousell.homeActivity.HomeFragment;

import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import timber.log.Timber;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding aBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        aBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(aBinding.toolbar);


        initActivity();

    }

    private void initActivity() {
        getSupportActionBar().setTitle(getString(R.string.app_name));

        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.menu);
        aBinding.toolbar.setOverflowIcon(drawable);

    }

    @Override
    protected void onStart() {
        super.onStart();
        NavMngr.getInstance().pushFragment(HomeFragment.newInstance());
    }

    @Override
    public void onBackPressed() {
        if (!NavMngr.getInstance().isLastFragment()) {
            NavMngr.getInstance().popFragment();
            return;
        }

        AppDialog.getInstance().showConfirmDialog(this
                , R.string.app_name, R.string.confirmMessage,
                new AppDialog.DCallback() {
                    @Override
                    public void dialogCallback(int dStatus, int dType, Object object) {
                        MainActivity.this.finish();
                    }
                });

    }

    private void takeAction() {
        Timber.e("Click Action....");
        NavMngr.getInstance().pushFragment(HomeFragment.newInstance());

    }

}
