package com.carousell.domain.comm;

public interface ResponseMarker<T> {

    T getReqType();
    Object getResponse();
}
