package com.carousell.mainApp;

import android.app.Application;


import com.carousell.BuildConfig;
import com.carousell.dSupport.AppComponent;
import com.carousell.dSupport.AppContext;
import com.carousell.dSupport.ApplicationModule;
import com.carousell.dSupport.DaggerAppComponent;

import javax.inject.Inject;

import retrofit2.Retrofit;
import timber.log.Timber;

public class MainApp extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {

        super.onCreate();
        initApplication();
    }

    private void initApplication() {
        if (!BuildConfig.DEBUG)
            return;

        Timber.plant(new Timber.DebugTree());


    }


    public AppComponent getAppComponent() {

        if (appComponent != null)
            return appComponent;


        appComponent = DaggerAppComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        appComponent.inject(MainApp.this);

        return appComponent;

    }

}
