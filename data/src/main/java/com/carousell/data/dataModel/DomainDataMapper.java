package com.carousell.data.dataModel;

import com.carousell.domain.domainModel.Article;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class DomainDataMapper {

    @Inject
    public DomainDataMapper() {
    }

    public List<Article> transform(List<ArticleModel> aList) {
        List<Article> list = new ArrayList<>();

        for (ArticleModel aModel : aList) {

            Article article = new Article();

            article.setBanner_url(aModel.getBanner_url());
            article.setDescription(aModel.getDescription());
            article.setTitle(aModel.getTitle());
            article.setId(aModel.getId());
            article.setRank(aModel.getRank());
            article.setTime_created(aModel.getTime_created());
            list.add(article);
        }

        return list;
    }

}
