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
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import ps.ns.just_click_and_eat.utils.AppSharedData;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static ps.ns.just_click_and_eat.network.utils.ConstantRetrofit.ACCEPT_TYPE;
import static ps.ns.just_click_and_eat.network.utils.ConstantRetrofit.AUTHORIZATION;
import static ps.ns.just_click_and_eat.network.utils.ConstantRetrofit.BASE_URL;
import static ps.ns.just_click_and_eat.network.utils.ConstantRetrofit.BEARER;
import static ps.ns.just_click_and_eat.network.utils.ConstantRetrofit.CONTENT_TYPE;
import static ps.ns.just_click_and_eat.network.utils.ConstantRetrofit.CONTENT_TYPE_MULTI_PART;
import static ps.ns.just_click_and_eat.network.utils.ConstantRetrofit.HEADER_ACCEPT_TYPE;
import static ps.ns.just_click_and_eat.network.utils.ConstantRetrofit.HEADER_CONTENT_TYPE;
import static ps.ns.just_click_and_eat.network.utils.ConstantRetrofit.HTTP_DELETE_TYPE;
import static ps.ns.just_click_and_eat.network.utils.ConstantRetrofit.HTTP_METHOD_OVERRIDE;
import static ps.ns.just_click_and_eat.network.utils.ConstantRetrofit.HTTP_PUT_TYPE;


public class RetrofitModel {

    //main variables
    private RetrofitApis api;
    private Scheduler subscribeOn;
    private Scheduler observeOn;

    private Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    public RetrofitModel(Boolean isAppRegistered) {
        Interceptor interceptorToHeaderData;
        if (isAppRegistered) {
            interceptorToHeaderData = chain -> {
                Request.Builder builder = chain.request().newBuilder()
                        .addHeader(HEADER_CONTENT_TYPE, CONTENT_TYPE)
                        //  .addHeader(LANGUAGE, AppSharedData.getLanguage())
                        .addHeader(HEADER_ACCEPT_TYPE, ACCEPT_TYPE)
                        .addHeader(AUTHORIZATION, AppSharedData.getUserInfo() == null ? "" : BEARER + AppSharedData.getUserInfo().getTokenData().getAccessToken());
                return chain.proceed(builder.build());
            };
        } else {
            interceptorToHeaderData = chain -> {
                Request.Builder builder = chain.request().newBuilder()
                        .addHeader(HEADER_CONTENT_TYPE, CONTENT_TYPE)
                        //  .addHeader(LANGUAGE, AppSharedData.getLanguage())
                        .addHeader(HEADER_ACCEPT_TYPE, ACCEPT_TYPE);
                return chain.proceed(builder.build());
            };
        }
        init(interceptorToHeaderData);
    }

    public RetrofitModel() {
        Interceptor interceptorToHeaderData;
        interceptorToHeaderData = chain -> {
            Request.Builder builder = chain.request().newBuilder()
                    //.addHeader(LANGUAGE, AppSharedData.getLanguage())
                    .addHeader(HEADER_ACCEPT_TYPE, ACCEPT_TYPE);
            return chain.proceed(builder.build());
        };
        init(interceptorToHeaderData);
    }

    public RetrofitModel(String type, Boolean withAuth) {
        Interceptor interceptorToHeaderData = null;
        if (type.equals(HTTP_PUT_TYPE) && withAuth) {
            interceptorToHeaderData = chain -> {
                Request.Builder builder = chain.request().newBuilder()
                        .addHeader(HEADER_CONTENT_TYPE, CONTENT_TYPE_MULTI_PART)
                        //.addHeader(LANGUAGE, AppSharedData.getLanguage())
                        .addHeader(AUTHORIZATION, AppSharedData.getUserInfo() == null ? "" : BEARER + AppSharedData.getUserInfo())
                        .addHeader(HTTP_METHOD_OVERRIDE, HTTP_PUT_TYPE);
                return chain.proceed(builder.build());
            };
        } else if (type.equals(HTTP_PUT_TYPE) && !withAuth) {
            interceptorToHeaderData = chain -> {
                Request.Builder builder = chain.request().newBuilder()
                        .addHeader(HEADER_CONTENT_TYPE, CONTENT_TYPE_MULTI_PART)
                        //.addHeader(LANGUAGE, AppSharedData.getLanguage())
                        .addHeader(HTTP_METHOD_OVERRIDE, HTTP_PUT_TYPE);
                return chain.proceed(builder.build());
            };
        } else if (type.equals(HTTP_DELETE_TYPE)) {
            interceptorToHeaderData = chain -> {
                Request.Builder builder = chain.request().newBuilder()
                        .addHeader(HEADER_CONTENT_TYPE, CONTENT_TYPE)
                        //.addHeader(LANGUAGE, AppSharedData.getLanguage())
                        .addHeader(HTTP_METHOD_OVERRIDE, HTTP_DELETE_TYPE)
                        .addHeader(AUTHORIZATION, AppSharedData.getUserInfo() == null ? "" : BEARER + AppSharedData.getUserInfo().getTokenData().getAccessToken());
                return chain.proceed(builder.build());
            };
        }

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

    public Observable<AppResponse> getAppInfo() {
        return api.getAppInfo()
                .subscribeOn(subscribeOn)
                .observeOn(observeOn);
    }

    public Observable<AppResponse> registration(ArrayMap<String, Object> params) {
        return api.SendDataRegister(params)
                .subscribeOn(subscribeOn)
                .observeOn(observeOn);
    }

    public Observable<AppResponse> verifyAccountUser(ArrayMap<String, Object> params) {
        return api.verifyAccountUser(params)
                .subscribeOn(subscribeOn)
                .observeOn(observeOn);
    }

    public Observable<AppResponse> login(ArrayMap<String, Object> params) {
        return api.login(params)
                .subscribeOn(subscribeOn)
                .observeOn(observeOn);
    }

    public Observable<AppResponse> forgetPassword(String email) {
        return api.forgetPassword(email)
                .subscribeOn(subscribeOn)
                .observeOn(observeOn);
    }


    public Observable<AppResponse> logout(String token, int deviceId) {
        return api.logout(BEARER + token, deviceId)
                .subscribeOn(subscribeOn)
                .observeOn(observeOn);
    }


    public Observable<AppResponse> getRestaurant() {
        return api.getRestaurantData()
                .subscribeOn(subscribeOn)
                .observeOn(observeOn);
    }


    public Observable<AppResponse> search(String keyword) {
        return api.search(keyword)
                .subscribeOn(subscribeOn)
                .observeOn(observeOn);
    }

//    public Observable<AppResponse> getRestaurantById(String token, int id) {
//        return api.getRestaurantById(BEARER + AppSharedData.getUserInfo().getTokenData().getAccessToken(), id)
//                .subscribeOn(subscribeOn)
//                .observeOn(observeOn);
//    }


    public Observable<AppResponse> updatePassword(String token, ArrayMap<String, String> params) {
        return api.updatePassword(BEARER + token, params)
                .subscribeOn(subscribeOn)
                .observeOn(observeOn);
    }

    public Observable<AppResponse> updateProfile(String token, ArrayMap<String, String> params, MultipartBody.Part part) {
        return api.updateProfile(BEARER + token, params, part)
                .subscribeOn(subscribeOn)
                .observeOn(observeOn);
    }

        public Observable<AppResponse> getMenuList(int id) {
        return api.getMenuList(id)
                .subscribeOn(subscribeOn)
                .observeOn(observeOn);
    }

}
