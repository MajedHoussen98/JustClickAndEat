package ps.ns.just_click_and_eat.network.utils;

import androidx.collection.ArrayMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static ps.ns.just_click_and_eat.network.utils.ConstantRetrofit.BASE_URL;


public class RetrofitModel {

    // main variables
    private RetrofitApis api;
    private Scheduler subscribeOn;
    private Scheduler observeOn;

    private Gson gson = new GsonBuilder()
            .setLenient()
            .create();


    public RetrofitModel() {
        Interceptor interceptorToHeaderData;
        interceptorToHeaderData = chain -> {
            Request.Builder builder = chain.request().newBuilder();
            //       .addHeader(HEADER_ACCEPT_TYPE, ACCEPT_TYPE);
            //       .addHeader(AUTHORIZATION, AppSharedData.getUserData() == null ? "" : BEARER + AppSharedData.getUserData().getToken().getAccessToken())
            return chain.proceed(builder.build());
        };
        init(interceptorToHeaderData);
    }


    private void init(Interceptor interceptorToHeaderData) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient httpClient = new OkHttpClient.Builder()
//                .addInterceptor(new NetworkConnectionInterceptor())
                .addInterceptor(interceptorToHeaderData)
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .build();

        this.api = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient)
                .build()
                .create(RetrofitApis.class);

        subscribeOn = Schedulers.io();
        observeOn = AndroidSchedulers.mainThread();
    }


    public Observable<AppResponse> getRestaurant() {
        return api.getRestaurantData()
                .subscribeOn(subscribeOn)
                .observeOn(observeOn);
    }

    public Observable<AppResponse> registration(ArrayMap<String, Object> params) {
        return api.SendDataRegister(params)
                .subscribeOn(subscribeOn)
                .observeOn(observeOn);
    }
}
