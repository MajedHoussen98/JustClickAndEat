package ps.ns.just_click_and_eat.network.asp.feature;

import android.annotation.SuppressLint;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.StringReader;
import java.util.ArrayList;
import ps.ns.just_click_and_eat.network.asp.model.cart.CartItem;
import ps.ns.just_click_and_eat.network.asp.model.cart.CartModel;
import ps.ns.just_click_and_eat.network.utils.RequestListener;
import ps.ns.just_click_and_eat.network.utils.RetrofitModel;

public class Cart {

    private static final String TAG_SUCCESS = "Response success";
    private static final String TAG_ERROR = "Response error";
    private static final String TAG_PARAMS = "Params";

    public Cart() {
    }

    private final RetrofitModel retrofitModel = new RetrofitModel();
    private Gson gson = new Gson();

    @SuppressLint("CheckResult")
    public void getCart(String token, RequestListener<ArrayList<CartItem>> listener) {
        retrofitModel.getCart(token).subscribe(appResponse -> {
                    Log.e(TAG_SUCCESS, appResponse.getStatus().toString() + "");
                    if (appResponse.getStatus()) {
                        JsonReader reader = new JsonReader(new StringReader(appResponse.getResult()));
                        reader.setLenient(true);
                        CartModel cartModel = gson.fromJson(appResponse.getResult(), CartModel.class);
                        listener.onSuccess((ArrayList<CartItem>) cartModel.getCartItems());
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
