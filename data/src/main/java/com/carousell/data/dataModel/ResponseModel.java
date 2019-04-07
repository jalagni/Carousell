package com.carousell.data.dataModel;

import com.carousell.data.dataConst.HttpConst;
import com.carousell.domain.comm.ResponseMarker;

public class ResponseModel implements ResponseMarker<HttpConst.Request> {
    public HttpConst.Request reqType;
    public Object response;

    public ResponseModel(HttpConst.Request reqType, Object object) {
        this.reqType = reqType;
        this.response = object;
    }

    @Override
    public HttpConst.Request getReqType() {
        return reqType;
    }

    @Override
    public Object getResponse() {
        return response;
    }
}
