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

import ps.ns.just_click_and_eat.network.asp.model.HomeModel;
import ps.ns.just_click_and_eat.network.asp.model.PaginationBean;
import ps.ns.just_click_and_eat.network.asp.model.UserData;
import ps.ns.just_click_and_eat.network.utils.RequestListener;
import ps.ns.just_click_and_eat.network.utils.RetrofitModel;

public class Registration {

    private static final String TAG_SUCCESS = "Response success";
    private static final String TAG_ERROR = "Response error";
    private static final String TAG_PARAMS = "Params";

    public Registration() {
    }
//    private final RetrofitModel retrofitModelBeforeLogin = new RetrofitModel(false);
//    private final RetrofitModel retrofitModelAfterLogin = new RetrofitModel(true);
//    private final RetrofitModel retrofitModelMultiPart = new RetrofitModel();
//    private final RetrofitModel retrofitModelPutTypeWithAuth = new RetrofitModel(HTTP_PUT_TYPE, true);
//    private final RetrofitModel retrofitModelPutTypeWithoutAuth = new RetrofitModel(HTTP_PUT_TYPE, false);
//    private final RetrofitModel retrofitModelDeleteType = new RetrofitModel(HTTP_DELETE_TYPE, true);

    private final RetrofitModel retrofitModel = new RetrofitModel();
    private Gson gson = new Gson();

    @SuppressLint("CheckResult")
    public void restaurantResponse(RequestListener<ArrayList<HomeModel>> listener) {
        retrofitModel.getRestaurant().subscribe(appResponse -> {
                    Log.e(TAG_SUCCESS, appResponse.getStatus().toString() + "");
                    if (appResponse.getStatus()) {
//                        JsonReader reader = new JsonReader(new StringReader(appResponse.getResult()));
//                        reader.setLenient(true);
                        PaginationBean bean = gson.fromJson(appResponse.getResult(), PaginationBean.class);
                        Type listType = new TypeToken<ArrayList<HomeModel>>() {
                        }.getType();
                        ArrayList<HomeModel> list = gson.fromJson(bean.getResult(), listType);
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
    public void registration(ArrayMap<String, Object> params, final RequestListener<UserData> mRequestListener) {
        Log.e(TAG_PARAMS, params.toString());
        retrofitModel.registration(params)
                .subscribe(appResponse -> {
                    Log.e(TAG_SUCCESS, appResponse.getStatus().toString() + "");
                    if (appResponse.getStatus()) {
//                        JsonReader reader = new JsonReader(new StringReader(appResponse.getResult()));
//                        reader.setLenient(true);
                        UserData userData = gson.fromJson(appResponse.getResult(), UserData.class);
                        mRequestListener.onSuccess(userData);
                    } else {
                        if (appResponse.getStatusCode() == 406) {
                            JsonReader reader = new JsonReader(new StringReader(appResponse.getResult()));
                            reader.setLenient(true);
                            UserData userData = gson.fromJson(reader, UserData.class);
                            mRequestListener.onSuccess(userData);
                        } else {
                            mRequestListener.onFail(appResponse.getMessage(), appResponse.getStatusCode());
                        }
                    }
                }, throwable -> {
                    Log.e(TAG_ERROR, throwable.getMessage() + "");
                });
    }
}
