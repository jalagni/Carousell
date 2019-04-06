package com.carousell.data.dataSource;

import com.carousell.data.injector.AppNetwork;
import com.carousell.data.injector.DaggerDataComponent;
import com.carousell.data.network.ApiService;
import com.carousell.domain.repository.ArticleRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import timber.log.Timber;

public class ArticleCloudRepository implements ArticleRepository {

    private ApiService apiService;

    @Inject
    public ArticleCloudRepository(){

        AppNetwork appNetwork = new AppNetwork();
        OkHttpClient client= appNetwork.getHttpClient(appNetwork.getRequestIntercept());
        apiService = new ApiService(appNetwork.getRetrofit(client));

        Timber.e("apiService: "+apiService);

    }

    @Override
    public Observable<List<Object>> getArticles() {
        return apiService.getArticleList();
    }
}
