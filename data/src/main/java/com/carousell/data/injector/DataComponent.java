package com.carousell.data.injector;

import com.carousell.data.dataSource.ArticleCloudRepository;

import dagger.Component;
import retrofit2.Retrofit;

@Component(modules = {AppNetwork.class})
public interface DataComponent {

    void inject(ArticleCloudRepository aRepository);

//    Retrofit getRetrofit();

}
