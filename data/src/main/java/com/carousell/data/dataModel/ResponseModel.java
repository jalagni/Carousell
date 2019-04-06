package com.carousell.data.dataModel;


import com.carousell.data.dataConst.HttpConst;

public class ResponseModel {
    public HttpConst.Request reqType;
    public Object response;

    public ResponseModel(HttpConst.Request reqType, Object object){
        this.reqType = reqType;
        this.response = object;
    }

    public HttpConst.Request getReqType() {
        return reqType;
    }

    public Object getResponse() {
        return response;
    }
}
