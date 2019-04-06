package com.carousell.homeActivity;

import com.carousell.appCore.BasePresenter;
import com.carousell.appCore.ViewContract;
import com.carousell.data.dataModel.ArticleModel;
import com.carousell.data.dataModel.ResponseModel;
import com.carousell.domain.ArticleUseCase;
import com.carousell.domain.DefaultObserver;

import java.util.ArrayList;

import javax.inject.Inject;

public class HomePresenterImpl extends BasePresenter<HomePresenterImpl.HomePresenter> {

    private ArticleUseCase articleUseCase;

    @Inject
    public HomePresenterImpl(ArticleUseCase useCase) {
        this.articleUseCase = useCase;
    }


    public void getArticleList() {
        articleUseCase.execute(new ArticleObserver(), ArticleUseCase.Params.getArticle());
    }



    @Override
    public void onNext(ResponseModel rModel) {

    }


    public interface HomePresenter extends ViewContract {
        void onArticleRecieved(ArrayList<ArticleModel> tModel);
    }


    private final class ArticleObserver extends DefaultObserver<Object> {

        @Override public void onComplete() {
            HomePresenterImpl.this.getViewContract().hideLoader();
        }

        @Override public void onError(Throwable e) {
            HomePresenterImpl.this.getViewContract().hideLoader();
            HomePresenterImpl.this.getViewContract().showMessage(e.getMessage());
        }

        @Override public void onNext(Object obj) {
            ResponseModel rModel = (ResponseModel) obj;
            HomePresenterImpl.this.getViewContract().onArticleRecieved((ArrayList<ArticleModel>) rModel.response);
        }
    }

}


