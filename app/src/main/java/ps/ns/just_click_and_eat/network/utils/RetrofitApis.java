package ps.ns.just_click_and_eat.network.utils;

import androidx.collection.ArrayMap;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface RetrofitApis {

    @FormUrlEncoded
    @POST("signUp")
    Observable<AppResponse> SendDataRegister(
            @FieldMap ArrayMap<String, Object> params
            );

    @GET("restaurants")
    Observable<AppResponse> getRestaurantData();


}
