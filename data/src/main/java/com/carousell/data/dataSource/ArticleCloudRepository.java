package com.carousell.data.dataSource;

import com.carousell.data.dataModel.ArticleModel;
import com.carousell.data.dataModel.DomainDataMapper;
import com.carousell.data.network.ApiService;
import com.carousell.domain.domainModel.Article;
import com.carousell.domain.repository.ArticleRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import timber.log.Timber;

public class ArticleCloudRepository implements ArticleRepository {

    private ApiService apiservice;

    private DomainDataMapper dataMapper;

    @Inject
    public ArticleCloudRepository(ApiService aService, DomainDataMapper dataMapper) {

        this.apiservice = aService;
        this.dataMapper = dataMapper;
    }

    @Override
    public Observable<List<Article>> getArticles() {
        return apiservice.getArticleList().map(this.dataMapper::transform);
    }
}
