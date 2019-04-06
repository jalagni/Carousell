package com.carousell.appCore;


public abstract class BasePresenter<T extends ViewContract>{

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


}
