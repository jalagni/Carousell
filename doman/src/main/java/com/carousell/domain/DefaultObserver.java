
package com.carousell.domain;

import io.reactivex.observers.DisposableObserver;

public class DefaultObserver<T> extends DisposableObserver<T> {
  @Override public void onNext(T t) {
  }

  @Override public void onComplete() {
  }

  @Override public void onError(Throwable exception) {
  }
}
