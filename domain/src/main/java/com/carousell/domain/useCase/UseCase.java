package com.carousell.domain.useCase;

import com.carousell.domain.executor.PostExecutionThread;
import com.carousell.domain.executor.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public abstract class UseCase<T, Params> {

    private final CompositeDisposable disposables;

    public abstract Observable<T>  buildUseCaseObservable(Params param);

    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;


    public UseCase(ThreadExecutor tExecutor, PostExecutionThread pThread) {
        this.threadExecutor = tExecutor;
        this.postExecutionThread = pThread;
        this.disposables = new CompositeDisposable();
    }

    public void execute(DisposableObserver<T> observer, Params params){
        final Observable<T> observable = this.buildUseCaseObservable(params)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler());
        addDisposable(observable.subscribeWith(observer));
    }


    public void dispose() {
        if (!disposables.isDisposed()) {
            disposables.dispose();
        }
    }

    /**
     * Dispose from current {@link CompositeDisposable}.
     */
    private void addDisposable(Disposable disposable) {
        disposables.add(disposable);
    }

}
