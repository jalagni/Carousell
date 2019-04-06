package com.carousell.data.network;

import com.carousell.data.dataConst.HttpConst;

public class NetworkError extends Exception {
    private HttpConst.Request rType;
    private String msg;

    public NetworkError(HttpConst.Request rType,String msg){
        this.rType = rType;
        this.msg = msg;

    }



    public HttpConst.Request getrType() {
        return rType;
    }
}
