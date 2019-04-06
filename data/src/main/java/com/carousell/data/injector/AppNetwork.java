package com.carousell.data.injector;



import com.carousell.data.BuildConfig;
import com.carousell.data.dataConst.HttpConst;
import com.carousell.data.network.RequestInterceptor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

@Module
public class AppNetwork {

    @Provides
    public Retrofit getRetrofit(OkHttpClient client) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpConst.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }


    @Provides
    public OkHttpClient getHttpClient(RequestInterceptor rInterceptor) {
        OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder();
        httpBuilder.addInterceptor(rInterceptor);

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpBuilder.addInterceptor(logging);
        }

        return httpBuilder.build();

    }

    @Provides
    public RequestInterceptor getRequestIntercept() {
        return new RequestInterceptor();
    }

}
