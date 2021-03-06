package com.carousell.domain;

import com.carousell.domain.comm.ResponseMarker;
import com.carousell.domain.domainModel.Article;
import com.carousell.domain.executor.PostExecutionThread;
import com.carousell.domain.executor.ThreadExecutor;
import com.carousell.domain.repository.ArticleRepository;
import com.carousell.domain.useCase.UseCase;
import com.carousell.domain.utils.DomainHelper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class ArticleUseCase extends UseCase<ResponseMarker, ArticleUseCase.Params> {

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
        return this.articleRepository.getArticles().map( rModel ->{

            List<Article> aList = (ArrayList<Article>) rModel.getResponse();

            for (Article aModel : aList) {
                aModel.setFormateDate(dHelper.getReadableDate(aModel.getTime_created()));
            }

            return rModel;
        });
    }

    public static final class Params {

        private Params() {}
        public static Params getArticle() {
            return new Params();
        }
    }

}
