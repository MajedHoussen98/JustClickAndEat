package ps.ns.just_click_and_eat.network.utils;

import androidx.collection.ArrayMap;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface RetrofitApis {

    @FormUrlEncoded
    @POST("signUp")
    Observable<AppResponse> SendDataRegister(@FieldMap ArrayMap<String, Object> params);

    @GET("restaurants")
    Observable<AppResponse> getRestaurantData();

    @GET("restaurants/{id}")
    Observable<AppResponse> getRestaurantById(
            @Header("Authorization") String authorization,
            @Path("id") int id
    );

    @FormUrlEncoded
    @POST("verifyAccount")
    Observable<AppResponse> verifyAccountUser(@FieldMap ArrayMap<String, Object> params);

    @FormUrlEncoded
    @POST("login")
    Observable<AppResponse> login(@FieldMap ArrayMap<String, Object> params);

    @FormUrlEncoded
    @POST("forget")
    Observable<AppResponse> forgetPassword(@Field("email") String params);

    @FormUrlEncoded
    @POST("changePassword")
    Observable<AppResponse> updatePassword(
            @Header("Authorization") String authorization,
            @FieldMap ArrayMap<String, String> params
    );


    @Multipart
    @POST("update")
    Observable<AppResponse> updateProfile(@Header("Authorization") String authorization,
                                          @FieldMap ArrayMap<String, String> params,
                                          @Part MultipartBody.Part avatar);

}
