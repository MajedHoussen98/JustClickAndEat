package ps.ns.just_click_and_eat.network.utils;

import androidx.collection.ArrayMap;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.DELETE;
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

    @GET("app_info")
    Observable<AppResponse> getAppInfo();

    @FormUrlEncoded
    @POST("signUp")
    Observable<AppResponse> sendDataRegister(@FieldMap ArrayMap<String, Object> params);

    @FormUrlEncoded
    @POST("verifyAccount")
    Observable<AppResponse> verifyAccountUser(@FieldMap ArrayMap<String, Object> params);

    @FormUrlEncoded
    @POST("login")
    Observable<AppResponse> login(@FieldMap ArrayMap<String, Object> params);

    @POST("logout")
    Observable<AppResponse> logout(@Header("Authorization") String authorization);

    @FormUrlEncoded
    @POST("forget")
    Observable<AppResponse> forgetPassword(@Field("email") String params);

    @GET("restaurants")
    Observable<AppResponse> getRestaurantData();

    @GET("restaurants/{id}")
    Observable<AppResponse> getRestaurantById(
            @Header("Authorization") String authorization,
            @Path("id") int id
    );

    @FormUrlEncoded
    @POST("changePassword")
    Observable<AppResponse> updatePassword(
            @Header("Authorization") String authorization,
            @FieldMap ArrayMap<String, String> params
    );

    @FormUrlEncoded
    @POST("search_restaurant")
    Observable<AppResponse> search(@Field("name") String params);

    @Multipart
    @POST("profile")
    Observable<AppResponse> updateProfile(@Header("Authorization") String authorization,
                                          @QueryMap ArrayMap<String, String> params,
                                          @Part MultipartBody.Part avatar);

    @GET("restaurant/{id}/menu")
    Observable<AppResponse> getMenuList(@Path("id") int id);

    @GET("user_address")
    Observable<AppResponse> getMyLocation(@Header("Authorization") String authorization);

    @DELETE("user_address/{id}")
    Observable<AppResponse> removeMyLocation(@Header("Authorization") String authorization,
                                             @Path("id") int id);

    @FormUrlEncoded
    @POST("user_address")
    Observable<AppResponse> sendMyLocation(@Header("Authorization") String authorization,
                                           @FieldMap ArrayMap<String, Object> params);

    @FormUrlEncoded
    @POST("getFavorite")
    Observable<AppResponse> getFavorite(@Header("Authorization") String authorization,
                                        @Field("type") String params);

    @FormUrlEncoded
    @POST("favorite")
    Observable<AppResponse> deleteAddFavorite(@Header("Authorization") String authorization,
                                              @FieldMap ArrayMap<String, Object> params);

    @GET("meal/{id}/ingredients")
    Observable<AppResponse> getMealIngredients(@Path("id") int id);
}
