package com.carousell.data.exception;

import com.carousell.data.dataConst.HttpConst;

public class NetworkError extends DataException {
    private HttpConst.Request rType;
    private String msg;

    public NetworkError(HttpConst.Request rType,String msg){
        this.rType = rType;
        this.msg = msg;

    }

    @Override
    public String getMessage() {
        return msg;
    }

    public HttpConst.Request getrType() {
        return rType;
    }
}
