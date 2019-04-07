package com.carousell.data.network;


import android.content.Context;

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
    private Context context;

    @Inject
    public ApiService(Retrofit retrofit, Context context) {
        apiStructure = retrofit.create(ApiStructure.class);
        this.context = context.getApplicationContext();
    }


    public Observable<List<ArticleModel>> getArticleList() {

        Call callRequest = apiStructure.getArticleList();
        RxSubscriber rxSubscriber = new RxSubscriber(context,
                callRequest, HttpConst.Request.ARTICLE_REQUEST);

        return Observable.create(rxSubscriber);
    }


    interface ApiStructure {
        @GET("carousell-interview-assets/android/carousell_news.json")
        Call<List<ArticleModel>> getArticleList();

    }
}
