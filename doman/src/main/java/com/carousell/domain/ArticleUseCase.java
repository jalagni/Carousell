package com.carousell.domain;

import com.carousell.domain.domainModel.Article;
import com.carousell.domain.executor.PostExecutionThread;
import com.carousell.domain.executor.ThreadExecutor;
import com.carousell.domain.repository.ArticleRepository;
import com.carousell.domain.useCase.UseCase;
import com.carousell.domain.utils.DomainHelper;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class ArticleUseCase extends UseCase<Object, ArticleUseCase.Params> {

    private final ArticleRepository articleRepository;
    private final DomainHelper dHelper;

    @Inject
    ArticleUseCase(DomainHelper dHelper,
                   ArticleRepository aRepository,
                   ThreadExecutor threadExecutor,
                   PostExecutionThread postExecutionThread) {

        super(threadExecutor, postExecutionThread);
        this.articleRepository = aRepository;
        this.dHelper = dHelper;

    }

    @Override
    public Observable buildUseCaseObservable(Params param) {
        return this.articleRepository.getArticles().map(this::transform);
    }


    public List<Article> transform(List<Article> aList) {

        for (Article aModel : aList) {
            aModel.setFormateDate(dHelper.getReadableDate(aModel.getTime_created()));
        }
        return aList;
    }

    public static final class Params {

        private Params() {}
        public static Params getArticle() {
            return new Params();
        }
    }

}
