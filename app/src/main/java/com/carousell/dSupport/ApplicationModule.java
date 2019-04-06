package com.carousell.dSupport;

import android.content.Context;

import com.carousell.UIThread;
import com.carousell.data.dataSource.ArticleCloudRepository;
import com.carousell.data.executor.JobExecutor;
import com.carousell.domain.executor.PostExecutionThread;
import com.carousell.domain.executor.ThreadExecutor;
import com.carousell.domain.repository.ArticleRepository;
import com.carousell.mainApp.MainApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final MainApp application;

    public ApplicationModule(MainApp application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }


    @Provides @Singleton ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }


    @Provides @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }


    @Provides @Singleton
    ArticleRepository provideArticleRepository(ArticleCloudRepository aRepository) {
        return aRepository;
    }

}
