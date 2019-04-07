package com.carousell.homeActivity;

import com.carousell.appCore.BasePresenter;
import com.carousell.appCore.ViewContract;
import com.carousell.domain.ArticleUseCase;
import com.carousell.domain.DefaultObserver;
import com.carousell.domain.comm.ResponseMarker;
import com.carousell.domain.domainModel.Article;

import java.util.ArrayList;

import javax.inject.Inject;

import timber.log.Timber;

public class HomePresenterImpl extends BasePresenter<HomePresenterImpl.HomePresenter> {

    private ArticleUseCase articleUseCase;

    @Inject
    public HomePresenterImpl(ArticleUseCase useCase) {
        this.articleUseCase = useCase;
    }


    public void getArticleList() {
        getViewContract().showLoader();
        articleUseCase.execute(new ArticleObserver(), ArticleUseCase.Params.getArticle());
    }


    public interface HomePresenter extends ViewContract {
        void onArticleRecieved(ArrayList<Article> tModel);
    }


    @Override
    public void deAttachView() {
        articleUseCase.dispose();
        attachView(null);
    }

    private final class ArticleObserver extends DefaultObserver<ResponseMarker> {

        @Override
        public void onComplete() {
            HomePresenterImpl.this.getViewContract().hideLoader();
        }

        @Override
        public void onError(Throwable e) {
            HomePresenterImpl.this.getViewContract().hideLoader();
            HomePresenterImpl.this.getViewContract().showMessage(e.getMessage());
        }

        @Override
        public void onNext(ResponseMarker rModel) {
            ArrayList aList = (ArrayList<Article>) rModel.getResponse();
            HomePresenterImpl.this.getViewContract().onArticleRecieved(aList);
        }
    }

}


