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

import okhttp3.MultipartBody;
import ps.ns.just_click_and_eat.network.asp.model.HomeActivity.Home;
import ps.ns.just_click_and_eat.network.asp.model.MyLocation;
import ps.ns.just_click_and_eat.network.asp.model.User.UserData;
import ps.ns.just_click_and_eat.network.asp.model.User.UserInfo;
import ps.ns.just_click_and_eat.network.utils.RequestListener;
import ps.ns.just_click_and_eat.network.utils.RetrofitModel;

import static ps.ns.just_click_and_eat.network.utils.ConstantRetrofit.HTTP_DELETE_TYPE;
import static ps.ns.just_click_and_eat.network.utils.ConstantRetrofit.HTTP_PUT_TYPE;

public class User {

    private static final String TAG_SUCCESS = "Response success";
    private static final String TAG_ERROR = "Response error";
    private static final String TAG_PARAMS = "Params";

    public User() {
    }

    private final RetrofitModel retrofitModelBeforeLogin = new RetrofitModel(false);
    private final RetrofitModel retrofitModelAfterLogin = new RetrofitModel(true);
    private final RetrofitModel retrofitModelMultiPart = new RetrofitModel();
    private final RetrofitModel retrofitModelPutTypeWithAuth = new RetrofitModel(HTTP_PUT_TYPE, true);
    private final RetrofitModel retrofitModelPutTypeWithoutAuth = new RetrofitModel(HTTP_PUT_TYPE, false);
    private final RetrofitModel retrofitModelDeleteType = new RetrofitModel(HTTP_DELETE_TYPE, true);

    private final RetrofitModel retrofitModel = new RetrofitModel();
    private Gson gson = new Gson();


    @SuppressLint("CheckResult")
    public void signUp(ArrayMap<String, Object> params, final RequestListener<UserData> mRequestListener) {
        Log.e(TAG_PARAMS, params.toString());
        retrofitModel.registration(params)
                .subscribe(appResponse -> {
                    Log.e(TAG_SUCCESS, params + "");
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
                    mRequestListener.onFail(throwable.getMessage(), -1);
                    Log.e(TAG_ERROR, throwable.getMessage() + "");

                });
    }

    @SuppressLint("CheckResult")
    public void verifyAccountUser(ArrayMap<String, Object> params, final RequestListener<String> mRequestListener) {
        Log.e(TAG_PARAMS, params.toString());
        retrofitModel.verifyAccountUser(params)
                .subscribe(appResponse -> {
                    Log.e(TAG_SUCCESS, params + "");
                    Log.e(TAG_SUCCESS, appResponse.getStatus().toString() + "");
                    if (appResponse.getStatus()) {
                        JsonReader reader = new JsonReader(new StringReader(appResponse.getResult()));
                        reader.setLenient(true);
                        String response = gson.toJson(appResponse.getResult());
                        mRequestListener.onSuccess(response);
                    } else {
                        if (appResponse.getStatusCode() == 406) {
                            JsonReader reader = new JsonReader(new StringReader(appResponse.getResult()));
                            reader.setLenient(true);
                            String response = gson.toJson(appResponse.getResult());
                            mRequestListener.onSuccess(response);
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
    public void login(ArrayMap<String, Object> params, final RequestListener<UserInfo> mRequestListener) {
        Log.e(TAG_PARAMS, params.toString());
        retrofitModelBeforeLogin.login(params)
                .subscribe(appResponse -> {
                    Log.e(TAG_SUCCESS, appResponse.getStatus().toString() + "");
                    if (appResponse.getStatus()) {
//                        JsonReader reader = new JsonReader(new StringReader(appResponse.getResult()));
//                        reader.setLenient(true);
                        UserInfo userInfo = gson.fromJson(appResponse.getResult(), UserInfo.class);
                        mRequestListener.onSuccess(userInfo);
                    } else {
                        if (appResponse.getStatusCode() == 406) {
                            JsonReader reader = new JsonReader(new StringReader(appResponse.getResult()));
                            reader.setLenient(true);
                            UserInfo userInfo = gson.fromJson(reader, UserInfo.class);
                            mRequestListener.onSuccess(userInfo);
                        } else {
                            mRequestListener.onFail(appResponse.getMessage(), appResponse.getStatusCode());
                        }
                    }
                }, throwable -> {
                    Log.e(TAG_ERROR, throwable.getMessage() + "");
                    mRequestListener.onFail(throwable.getMessage(), -1);
                });
    }

    @SuppressLint("CheckResult")
    public void logout(String token, int id, final RequestListener<Integer> mRequestListener) {
        retrofitModel.logout(token, id)
                .subscribe(appResponse -> {
                    Log.e(TAG_SUCCESS, appResponse.getStatus().toString() + "");
                    if (appResponse.getStatus()) {
//                        JsonReader reader = new JsonReader(new StringReader(appResponse.getResult()));
//                        reader.setLenient(true);
                        mRequestListener.onSuccess(1);
                    } else {
                        if (appResponse.getStatusCode() == 406) {
                            JsonReader reader = new JsonReader(new StringReader(appResponse.getResult()));
                            reader.setLenient(true);
                            mRequestListener.onSuccess(-1);
                        } else {
                            mRequestListener.onFail(appResponse.getMessage(), appResponse.getStatusCode());
                        }
                    }
                }, throwable -> {
                    Log.e(TAG_ERROR, throwable.getMessage() + "");
                    mRequestListener.onFail(throwable.getMessage(), -1);
                });
    }

    @SuppressLint("CheckResult")
    public void forgetPassword(String params, final RequestListener<String> mRequestListener) {
        Log.e(TAG_PARAMS, params.toString());
        retrofitModel.forgetPassword(params)
                .subscribe(appResponse -> {
                    Log.e(TAG_SUCCESS, appResponse.getStatus().toString() + "");
                    if (appResponse.getStatus()) {
//                        JsonReader reader = new JsonReader(new StringReader(appResponse.getResult()));
//                        reader.setLenient(true);
                        String email = gson.toJson(appResponse.getResult());
                        mRequestListener.onSuccess(email);
                    } else {
                        if (appResponse.getStatusCode() == 406) {
                            JsonReader reader = new JsonReader(new StringReader(appResponse.getResult()));
                            reader.setLenient(true);
                            String email = gson.toJson(appResponse.getResult());
                            mRequestListener.onSuccess(email);
                        } else {
                            mRequestListener.onFail(appResponse.getMessage(), appResponse.getStatusCode());
                        }
                    }
                }, throwable -> {
                    Log.e(TAG_ERROR, throwable.getMessage() + "");
                    mRequestListener.onFail(throwable.getMessage(), -1);
                });
    }

    @SuppressLint("CheckResult")
    public void updatePassword(String token, ArrayMap<String, String> params, final RequestListener<String> mRequestListener) {
        Log.e(TAG_PARAMS, params.toString());
        retrofitModel.updatePassword(token, params)
                .subscribe(appResponse -> {
                    Log.e(TAG_SUCCESS, appResponse.getStatus().toString() + "");
                    if (appResponse.getStatus()) {
                        String userToken = gson.toJson(appResponse.getResult());
                        mRequestListener.onSuccess(userToken);
                    } else {
                        if (appResponse.getStatusCode() == 406) {
                            JsonReader reader = new JsonReader(new StringReader(appResponse.getResult()));
                            reader.setLenient(true);
                            String userToken = gson.toJson(appResponse.getResult());
                            mRequestListener.onSuccess(userToken);
                        } else {
                            mRequestListener.onFail(appResponse.getMessage(), appResponse.getStatusCode());
                        }
                    }
                }, throwable -> {
                    Log.e(TAG_ERROR, throwable.getMessage() + "");
                    mRequestListener.onFail(throwable.getMessage(), -1);

                });
    }

    @SuppressLint("CheckResult")
    public void updateProfile(String token, ArrayMap<String, String> params, MultipartBody.Part part, final RequestListener<String> mRequestListener) {
        Log.e(TAG_PARAMS, params.toString());
        retrofitModel.updateProfile(token, params, part)
                .subscribe(appResponse -> {
                    Log.e(TAG_SUCCESS, appResponse.getStatus().toString() + "");
                    if (appResponse.getStatus()) {
                        String userToken = gson.toJson(appResponse.getResult());
                        mRequestListener.onSuccess(userToken);
                    } else {
                        if (appResponse.getStatusCode() == 406) {
                            JsonReader reader = new JsonReader(new StringReader(appResponse.getResult()));
                            reader.setLenient(true);
                            String userToken = gson.toJson(appResponse.getResult());
                            mRequestListener.onSuccess(userToken);
                        } else {
                            mRequestListener.onFail(appResponse.getMessage(), appResponse.getStatusCode());
                        }
                    }
                }, throwable -> {
                    Log.e(TAG_ERROR, throwable.getMessage() + "");
                    mRequestListener.onFail(throwable.getMessage(), -1);

                });
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

}
