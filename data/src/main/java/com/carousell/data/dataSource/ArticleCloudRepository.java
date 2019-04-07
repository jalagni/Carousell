package com.carousell.data.dataSource;

import com.carousell.data.dataModel.ArticleModel;
import com.carousell.data.network.ApiService;
import com.carousell.domain.comm.ResponseMarker;
import com.carousell.domain.domainModel.Article;
import com.carousell.domain.repository.ArticleRepository;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import io.reactivex.Observable;

public class ArticleCloudRepository implements ArticleRepository {

    private ApiService apiservice;


    @Inject
    public ArticleCloudRepository(ApiService aService) {
        this.apiservice = aService;
    }


    @Override
    public Observable<ResponseMarker> getArticles() {
        return apiservice.getArticleList().map(rModel->{

            ArrayList<ArticleModel> aList = (ArrayList<ArticleModel>) rModel.getResponse();

            List<Article> dest = new ArrayList<>();
            for (ArticleModel aModel : aList) {
                dest.add(aModel);
            }
            return rModel;

        });
    }

}
