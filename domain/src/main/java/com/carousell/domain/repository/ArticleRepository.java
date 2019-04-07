package com.carousell.domain.repository;


import com.carousell.domain.comm.ResponseMarker;
import com.carousell.domain.domainModel.Article;

import java.util.List;

import io.reactivex.Observable;

public interface ArticleRepository {
    Observable<ResponseMarker> getArticles();
}
