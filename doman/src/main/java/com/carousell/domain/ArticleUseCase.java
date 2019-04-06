package com.carousell.domain;

import com.carousell.domain.executor.PostExecutionThread;
import com.carousell.domain.executor.ThreadExecutor;
import com.carousell.domain.repository.ArticleRepository;
import com.carousell.domain.useCase.UseCase;

import javax.inject.Inject;

import io.reactivex.Observable;
import timber.log.Timber;

public class ArticleUseCase extends UseCase<Object,ArticleUseCase.Params> {

    private final ArticleRepository articleRepository;

    @Inject
    ArticleUseCase(ArticleRepository aRepository, ThreadExecutor threadExecutor,
                   PostExecutionThread postExecutionThread) {
        super(threadExecutor,postExecutionThread);
        this.articleRepository = aRepository;
    }

    @Override
    public Observable buildUseCaseObservable(Params param) {
        return this.articleRepository.getArticles();
    }


    public static final class Params {


        private Params() {
        }

        public static Params getArticle() {
            return new Params();
        }
    }

}
