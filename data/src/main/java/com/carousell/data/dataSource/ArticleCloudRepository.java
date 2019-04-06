package com.carousell.data.dataSource;

import com.carousell.data.network.ApiService;
import com.carousell.domain.repository.ArticleRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import timber.log.Timber;

public class ArticleCloudRepository implements ArticleRepository {

    private ApiService apiservice;

    @Inject
    public ArticleCloudRepository(ApiService aService){

        this.apiservice = aService;
        Timber.e("apiService: "+aService);

    }

    @Override
    public Observable<List<Object>> getArticles() {
        return apiservice.getArticleList();
    }
}
