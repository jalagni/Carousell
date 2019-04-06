package com.carousell.dSupport;



import android.content.Context;

import com.carousell.domain.executor.PostExecutionThread;
import com.carousell.domain.executor.ThreadExecutor;
import com.carousell.domain.repository.ArticleRepository;
import com.carousell.mainApp.MainApp;
import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface AppComponent {

    void inject(MainApp app);

    Context getContext();

    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();
    ArticleRepository getArticleRepository();

    HomeComponent setHomeComponent();
}
