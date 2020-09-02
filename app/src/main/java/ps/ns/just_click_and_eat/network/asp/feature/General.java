package ps.ns.just_click_and_eat.network.asp.feature;

import android.annotation.SuppressLint;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import ps.ns.just_click_and_eat.network.asp.model.HomeActivity.Home;
import ps.ns.just_click_and_eat.network.asp.model.IntroApp;
import ps.ns.just_click_and_eat.network.asp.model.MyLocation;
import ps.ns.just_click_and_eat.network.asp.model.PaginationBean;
import ps.ns.just_click_and_eat.network.asp.model.menu.MenuList;
import ps.ns.just_click_and_eat.network.utils.RequestListener;
import ps.ns.just_click_and_eat.network.utils.RetrofitModel;

public class General {
    private static final String TAG_SUCCESS = "Response success";
    private static final String TAG_ERROR = "Response error";
    private static final String TAG_PARAMS = "Params";

    public General() {
    }

    private final RetrofitModel retrofitModel = new RetrofitModel();
    private Gson gson = new Gson();


    @SuppressLint("CheckResult")
    public void getAppInfo(RequestListener<ArrayList<IntroApp>> listener) {
        retrofitModel.getAppInfo().subscribe(appResponse -> {
                    Log.e(TAG_SUCCESS, appResponse.getStatus().toString() + "");
                    if (appResponse.getStatus()) {
//                        JsonReader reader = new JsonReader(new StringReader(appResponse.getResult()));
//                        reader.setLenient(true);
                        Type listType = new TypeToken<ArrayList<IntroApp>>() {
                        }.getType();
                        ArrayList<IntroApp> list = gson.fromJson(appResponse.getResult(), listType);
                        listener.onSuccess(list);

                    } else {
                        listener.onFail(appResponse.getMessage(), appResponse.getStatusCode());
                    }
                }, throwable -> {
                    listener.onFail(throwable.getMessage(), -1);
                    Log.e(TAG_ERROR, throwable.getMessage() + "");
                }
        );
    }

    @SuppressLint("CheckResult")
    public void getRestaurants(RequestListener<ArrayList<Home>> listener) {
        retrofitModel.getRestaurant().subscribe(appResponse -> {
                    Log.e(TAG_SUCCESS, appResponse.getStatus().toString() + "");
                    if (appResponse.getStatus()) {
//                        JsonReader reader = new JsonReader(new StringReader(appResponse.getResult()));
//                        reader.setLenient(true);
                        PaginationBean bean = gson.fromJson(appResponse.getResult(), PaginationBean.class);
                        Type listType = new TypeToken<ArrayList<Home>>() {
                        }.getType();
                        ArrayList<Home> list = gson.fromJson(bean.getResult(), listType);
                        listener.onSuccess(list);
                    } else {
                        listener.onFail(appResponse.getMessage(), appResponse.getStatusCode());
                    }
                }, throwable -> {
                    listener.onFail(throwable.getMessage(), -1);
                    Log.e(TAG_ERROR, throwable.getMessage() + "");
                }
        );
    }

    @SuppressLint("CheckResult")
    public void getRestaurantsById(int id, String token, RequestListener<Home> listener) {
        retrofitModel.getRestaurantById(token, id).subscribe(appResponse -> {
                    Log.e(TAG_SUCCESS, appResponse.getStatus().toString() + "");
                    if (appResponse.getStatus()) {
//                        JsonReader reader = new JsonReader(new StringReader(appResponse.getResult()));
//                        reader.setLenient(true);
                        Type listType = new TypeToken<Home>() {
                        }.getType();
                        Home list = gson.fromJson(appResponse.getResult(), listType);
                        listener.onSuccess(list);
                    } else {
                        listener.onFail(appResponse.getMessage(), appResponse.getStatusCode());
                    }
                }, throwable -> {
                    listener.onFail(throwable.getMessage(), -1);
                    Log.e(TAG_ERROR, throwable.getMessage() + "");
                }
        );
    }

    @SuppressLint("CheckResult")
    public void search(String params, RequestListener<ArrayList<Home>> listener) {
        retrofitModel.search(params).subscribe(appResponse -> {
                    Log.e(TAG_SUCCESS, appResponse.getStatus().toString() + "");
                    if (appResponse.getStatus()) {
//                        JsonReader reader = new JsonReader(new StringReader(appResponse.getResult()));
//                        reader.setLenient(true);
                        Type listType = new TypeToken<ArrayList<Home>>() {
                        }.getType();
                        ArrayList<Home> list = gson.fromJson(appResponse.getResult(), listType);
                        listener.onSuccess(list);

                    } else {
                        listener.onFail(appResponse.getMessage(), appResponse.getStatusCode());
                    }
                }, throwable -> {
                    listener.onFail(throwable.getMessage(), -1);
                    Log.e(TAG_ERROR, throwable.getMessage() + "");
                }
        );
    }

    @SuppressLint("CheckResult")
    public void getMenuList(int id, RequestListener<ArrayList<MenuList>> listener) {
        retrofitModel.getMenuList(id).subscribe(appResponse -> {
                    Log.e(TAG_SUCCESS, appResponse.getStatus().toString() + "");
                    if (appResponse.getStatus()) {
//                        JsonReader reader = new JsonReader(new StringReader(appResponse.getResult()));
//                        reader.setLenient(true);
                        Type listType = new TypeToken<ArrayList<MenuList>>() {
                        }.getType();
                        ArrayList<MenuList> list = gson.fromJson(appResponse.getResult(), listType);
                        listener.onSuccess(list);
                    } else {
                        listener.onFail(appResponse.getMessage(), appResponse.getStatusCode());
                    }
                }, throwable -> {
                    listener.onFail(throwable.getMessage(), -1);
                    Log.e(TAG_ERROR, throwable.getMessage() + "");
                }
        );
    }

    @SuppressLint("CheckResult")
    public void getMyLocation(String token, RequestListener<ArrayList<MyLocation>> listener) {
        retrofitModel.getMyLocation(token).subscribe(appResponse -> {
                    Log.e(TAG_SUCCESS, appResponse.getStatus().toString() + "");
                    if (appResponse.getStatus()) {
//                        JsonReader reader = new JsonReader(new StringReader(appResponse.getResult()));
//                        reader.setLenient(true);
                        Type listType = new TypeToken<ArrayList<MyLocation>>() {
                        }.getType();
                        ArrayList<MyLocation> list = gson.fromJson(appResponse.getResult(), listType);
                        listener.onSuccess(list);
                    } else {
                        listener.onFail(appResponse.getMessage(), appResponse.getStatusCode());
                    }
                }, throwable -> {
                    listener.onFail(throwable.getMessage(), -1);
                    Log.e(TAG_ERROR, throwable.getMessage() + "");
                }
        );
    }


}
