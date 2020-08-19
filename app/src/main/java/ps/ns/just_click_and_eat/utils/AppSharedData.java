package ps.ns.just_click_and_eat.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import ps.ns.just_click_and_eat.network.asp.model.UserData;

public class AppSharedData {

    private static final String SHARED_PREF_NAME = "my_shared_preferences";
    @SuppressLint("StaticFieldLeak")
    private static AppSharedData manager;
    private Context context;

    public AppSharedData(Context context) {
        this.context = context;
    }

    public static synchronized AppSharedData getInstance(Context context) {
        if (context != null) {
            manager = new AppSharedData(context);
        }
        return manager;
    }

    public void saveUser(UserData user, String password) {
        Log.e("user", user.toString());
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("id", user.getId());
        editor.putString("name", user.getName());
        editor.putString("email", user.getEmail());
        editor.putString("pic", user.getAvatar());
        editor.putString("password", password);
        editor.apply();
    }

    public static void saveUser(Activity activity, String token, boolean isLogin) {
        SharedPreferences sharedPreferences = activity.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("token", token);
        editor.putBoolean("isLogin", isLogin);
        editor.apply();
    }

    public static void profileDataUserSaved(Activity activity, String profileImage, String userName) {
        SharedPreferences sharedPreferences = activity.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("profile_image", profileImage);
        editor.putString("user_name", userName);
        editor.apply();
    }

    public static SharedPreferences getProfileDataUser(Activity activity) {
        return activity.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    public static void savedUserEmail(Activity activity, String email) {
        SharedPreferences sharedPreferences = activity.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("email", email);
        editor.apply();
    }

    public static SharedPreferences getUserEmail(Activity activity) {
        return activity.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    public static boolean isLoggedIn(Activity activity) {
        SharedPreferences sharedPreferences = activity.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("isLogin", false);
    }

    public void clear() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();

    }
}
