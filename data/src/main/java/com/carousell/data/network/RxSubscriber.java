package com.carousell.data.network;

import android.content.Context;
import com.carousell.data.R;
import com.carousell.data.dataConst.HttpConst;
import com.carousell.data.dataModel.ResponseModel;
import com.carousell.data.exception.NetworkError;
import com.carousell.data.utils.HttpUtils;
import com.carousell.domain.comm.ResponseMarker;

import io.reactivex.Emitter;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RxSubscriber implements ObservableOnSubscribe, Callback {

    private HttpConst.Request rType;
    private Call<ResponseMarker> callRequest;
    private Context context;
    private Emitter emitter;

    public RxSubscriber(Context context, Call call, HttpConst.Request rType) {
        this.callRequest = call;
        this.rType = rType;
        this.context = context;
    }


    @Override
    public void onResponse(Call call, Response response) {
        boolean state = HttpUtils.isValidResponse(response.code());
        if (!state) {
            NetworkError nError = new NetworkError(rType, context.getString(R.string.tryLater));
            emitter.onError(nError);
            return;
        }

        ResponseModel rModel = new ResponseModel(rType,response.body());
        emitter.onNext(rModel);

//        emitter.onNext(response.body());
        emitter.onComplete();
    }

    @Override
    public void onFailure(Call call, Throwable t) {
        emitter.onError(t);
    }

    @Override
    public void subscribe(ObservableEmitter emitter) throws Exception {
        if (!HttpUtils.isConnectionAvailable(context)) {
            emitter.onError(new NetworkError(rType, context.getString(R.string.check_internet)));
            return;
        }

        this.emitter = emitter;
        callRequest.enqueue(this);
    }

}
