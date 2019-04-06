package com.carousell.appCore;

import com.carousell.data.dataModel.ResponseModel;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

public abstract class BasePresenter<T extends ViewContract>
        implements Observer<ResponseModel> {

    private T vContract;

    public void attachView(T view) {
        vContract = view;
    }

    protected T getViewContract() {
        return vContract;
    }

    public void deAttachView() {
        this.vContract = null;
    }


    @Override
    public void onComplete() {
        getViewContract().hideLoader();
    }

    @Override
    public void onNext(ResponseModel rModel) {
        Timber.e("Base On Next Action");
    }

    @Override
    public void onError(Throwable e) {
        getViewContract().hideLoader();
    }

    @Override
    public void onSubscribe(Disposable d) {
        getViewContract().showLoader();
    }
}
