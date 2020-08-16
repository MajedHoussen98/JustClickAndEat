package ps.ns.just_click_and_eat.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesManager {
    private static final String SHARED_PREF_NAME = "my_shared_preferences";
    @SuppressLint("StaticFieldLeak")
    private static SharedPreferencesManager manager;
    private Context context;

    public SharedPreferencesManager(Context context) {
        this.context = context;
    }

    public static synchronized SharedPreferencesManager getInstance(Context context) {
        if (context != null) {
            manager = new SharedPreferencesManager(context);
        }
        return manager;
    }

//    public void saveUser(DataUser user, String password) {
//        Log.e("user", user.toString());
//        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putInt("id", user.getId());
//        editor.putInt("user_no", user.getUser_no());
//        editor.putString("name", user.getName());
//        editor.putString("pic", user.getPic());
//        editor.putString("token", user.getToken());
//        editor.putString("password", password);
//
//        editor.apply();
//    }

    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt("id", -1) != -1;
    }

//    public DataUser getUser() {
//        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
//        return new DataUser(
//                sharedPreferences.getInt("id", -1),
//                sharedPreferences.getInt("user_no", -1),
//                sharedPreferences.getString("name", null),
//                sharedPreferences.getString("pic", null),
//                sharedPreferences.getString("token", null),
//                sharedPreferences.getString("password", null)
//
//        );

    public void clear() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();

    }
}
