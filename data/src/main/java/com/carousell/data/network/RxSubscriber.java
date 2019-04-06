package com.carousell.data.network;


import com.carousell.data.dataConst.HttpConst;
import com.carousell.data.dataModel.ResponseModel;

import io.reactivex.Emitter;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RxSubscriber implements ObservableOnSubscribe, Callback {

    private HttpConst.Request rType;
    private Call<ResponseModel> callRequest;
    private Emitter emitter;

    public RxSubscriber(Call call, HttpConst.Request rType) {
        this.callRequest = call;
        this.rType = rType;
    }


    @Override
    public void onResponse(Call call, Response response) {
        boolean state =  isValidResponse(response.code());
        if(!state){
            NetworkError nError = new NetworkError(rType,"Try Again");
            emitter.onError(nError);
            return;
        }

        ResponseModel rModel = new ResponseModel(rType,response.body());


        rModel.reqType = rType;

        emitter.onNext(rModel);
        emitter.onComplete();
    }

    @Override
    public void onFailure(Call call, Throwable t) {
        emitter.onError(t);
    }

    @Override
    public void subscribe(ObservableEmitter emitter) throws Exception {
        this.emitter = emitter;
        callRequest.enqueue(this);
    }


    private boolean isValidResponse(int httpCode) {
        return (httpCode >= 200 && httpCode < 300);
    }

}
