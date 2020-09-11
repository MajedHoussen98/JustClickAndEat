package ps.ns.just_click_and_eat.network.asp.feature;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.collection.ArrayMap;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import ps.ns.just_click_and_eat.network.asp.model.MyLocation;
import ps.ns.just_click_and_eat.network.utils.RequestListener;
import ps.ns.just_click_and_eat.network.utils.RetrofitModel;

public class Location {
    private static final String TAG_SUCCESS = "Response success";
    private static final String TAG_ERROR = "Response error";
    private static final String TAG_PARAMS = "Params";

    public Location() {
    }
    private final RetrofitModel retrofitModel = new RetrofitModel();
    private Gson gson = new Gson();

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

    @SuppressLint("CheckResult")
    public void addLocation(String token, ArrayMap<String, Object> params, final RequestListener<ArrayList<MyLocation>> mRequestListener) {
        Log.e(TAG_PARAMS, params.toString());
        retrofitModel.sendMyLocation(token, params)
                .subscribe(appResponse -> {
                    Log.e(TAG_SUCCESS, params + "");
                    Log.e(TAG_SUCCESS, appResponse.getStatus().toString() + "");
                    if (appResponse.getStatus()) {
//                        JsonReader reader = new JsonReader(new StringReader(appResponse.getResult()));
//                        reader.setLenient(true);
                        Type listType = new TypeToken<ArrayList<MyLocation>>() {
                        }.getType();
                        ArrayList<MyLocation> myLocation = gson.fromJson(appResponse.getResult(), listType);
                        mRequestListener.onSuccess(myLocation);
                    } else {
                        if (appResponse.getStatusCode() == 406) {
                            JsonReader reader = new JsonReader(new StringReader(appResponse.getResult()));
                            reader.setLenient(true);
                            ArrayList<MyLocation> myLocation = gson.fromJson(reader, MyLocation.class);
                            mRequestListener.onSuccess(myLocation);
                        } else {
                            mRequestListener.onFail(appResponse.getMessage(), appResponse.getStatusCode());
                        }
                    }
                }, throwable -> {
                    mRequestListener.onFail(throwable.getMessage(), -1);
                    Log.e(TAG_ERROR, throwable.getMessage() + "");

                });
    }

    @SuppressLint("CheckResult")
    public void removeLocation(String token, int id, final RequestListener<ArrayList<MyLocation>> mRequestListener) {
        Log.e(TAG_PARAMS, String.valueOf(id));
        retrofitModel.removeMyLocation(token, id)
                .subscribe(appResponse -> {
                    Log.e(TAG_SUCCESS, id + "");
                    Log.e(TAG_SUCCESS, appResponse.getStatus().toString() + "");
                    if (appResponse.getStatus()) {
//                        JsonReader reader = new JsonReader(new StringReader(appResponse.getResult()));
//                        reader.setLenient(true);
                        Type listType = new TypeToken<ArrayList<MyLocation>>() {
                        }.getType();
                        ArrayList<MyLocation> myLocation = gson.fromJson(appResponse.getResult(), listType);
                        mRequestListener.onSuccess(myLocation);
                    } else {
                        if (appResponse.getStatusCode() == 406) {
                            JsonReader reader = new JsonReader(new StringReader(appResponse.getResult()));
                            reader.setLenient(true);
                            ArrayList<MyLocation> myLocation = gson.fromJson(reader, MyLocation.class);
                            mRequestListener.onSuccess(myLocation);
                        } else {
                            mRequestListener.onFail(appResponse.getMessage(), appResponse.getStatusCode());
                        }
                    }
                }, throwable -> {
                    mRequestListener.onFail(throwable.getMessage(), -1);
                    Log.e(TAG_ERROR, throwable.getMessage() + "");

                });
    }

    @SuppressLint("CheckResult")
    public void updateLocation(String token, int id, ArrayMap<String, Object> params, final RequestListener<ArrayList<MyLocation>> mRequestListener) {
        Log.e(TAG_PARAMS, params.toString());
        retrofitModel.updateMyLocation(token, id, params)
                .subscribe(appResponse -> {
                    Log.e(TAG_SUCCESS, params + "");
                    Log.e(TAG_SUCCESS, appResponse.getStatus().toString() + "");
                    if (appResponse.getStatus()) {
//                        JsonReader reader = new JsonReader(new StringReader(appResponse.getResult()));
//                        reader.setLenient(true);
                        Type listType = new TypeToken<ArrayList<MyLocation>>() {
                        }.getType();
                        ArrayList<MyLocation> myLocation = gson.fromJson(appResponse.getResult(), listType);
                        mRequestListener.onSuccess(myLocation);
                    } else {
                        if (appResponse.getStatusCode() == 406) {
                            JsonReader reader = new JsonReader(new StringReader(appResponse.getResult()));
                            reader.setLenient(true);
                            ArrayList<MyLocation> myLocation = gson.fromJson(reader, MyLocation.class);
                            mRequestListener.onSuccess(myLocation);
                        } else {
                            mRequestListener.onFail(appResponse.getMessage(), appResponse.getStatusCode());
                        }
                    }
                }, throwable -> {
                    mRequestListener.onFail(throwable.getMessage(), -1);
                    Log.e(TAG_ERROR, throwable.getMessage() + "");

                });
    }
}
