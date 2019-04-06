package com.carousell.data.network;


import com.carousell.data.dataConst.HttpConst;
import com.carousell.data.dataModel.ArticleModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;


public class ApiService {

    private ApiStructure apiStructure;

    @Inject
    public ApiService(Retrofit retrofit) {
        apiStructure = retrofit.create(ApiStructure.class);
    }


    public Observable getArticleList() {
        Call callRequest = apiStructure.getArticleList();
        return createRequest(callRequest, HttpConst.Request.ARTICLE_REQUEST);
    }


    private Observable<Object> createRequest(Call<Object> call, HttpConst.Request rType) {

        RxSubscriber rxSubscriber = new RxSubscriber(call, rType);
        Observable observable = Observable.create(rxSubscriber)
                .doOnError(throwable -> onRequestFinish())
                .doOnComplete(() -> onRequestFinish())
                .doOnSubscribe(disposable -> onRequestStart());

        return observable;

    }


    private void onRequestStart() {

    }


    private void onRequestFinish() {

    }

    interface ApiStructure {
        @GET("carousell-interview-assets/android/carousell_news.json")
        Call<List<ArticleModel>> getArticleList();

    }
}
