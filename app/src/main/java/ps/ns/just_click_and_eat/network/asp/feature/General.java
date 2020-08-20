package ps.ns.just_click_and_eat.network.asp.feature;

import android.annotation.SuppressLint;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import ps.ns.just_click_and_eat.network.asp.model.HomeModel;
import ps.ns.just_click_and_eat.network.asp.model.PaginationBean;
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
}
