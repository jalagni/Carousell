package com.carousell.domain.repository;

import java.util.List;

import io.reactivex.Observable;

public interface ArticleRepository {
    Observable<List<Object>> getArticles();
}
