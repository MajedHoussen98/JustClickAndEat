package ps.ns.just_click_and_eat.utils;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

import ps.ns.just_click_and_eat.network.asp.model.User.UserData;
import ps.ns.just_click_and_eat.network.asp.model.User.UserInfo;
import ps.ns.just_click_and_eat.network.asp.model.menu.MenuList;

import static android.content.Context.MODE_PRIVATE;

public class AppSharedData {

//
//    private static final String SHARED_PREF_NAME = "my_shared_preferences";
//    @SuppressLint("StaticFieldLeak")
//    private static AppSharedData manager;
//    private static Context context;
//
//    public AppSharedData(Context context) {
//        this.context = context;
//    }
//
//    public static synchronized AppSharedData getInstance(Context context) {
//        if (context != null) {
//            manager = new AppSharedData(context);
//        }
//        return manager;
//    }
//
//    public  void saveUser(UserData user) {
//        Log.e("user", user.toString());
//        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putInt("id", user.getId());
//        editor.putString("name", user.getName());
//        editor.putString("email", user.getEmail());
//        editor.putString("pic", user.getAvatar());
//      //  editor.putString("access_token", user.getTokenModel().getAccessToken());
//        editor.apply();
//    }
//
//    public  void saveUserWithToken(UserInfo user) {
//        Log.e("user", user.toString());
//        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putInt("id", user.getUserData().getId());
//        editor.putString("name", user.getUserData().getName());
//        editor.putString("email", user.getUserData().getEmail());
//        editor.putString("pic", user.getUserData().getAvatar());
//        editor.putString("access_token", user.getTokenModel().getAccessToken());
//        editor.putString("mobile", user.getUserData().getMobile());
//        editor.apply();
//    }
//
//    public static String getUserToken(Activity activity){
//        return activity.getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE).getString("access_token", "");
//    }
//
//    public static String getUserMobile(Activity activity){
//        return activity.getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE).getString("mobile", "");
//    }
//
//    public UserData getUser() {
//        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
//        return new UserData(
//                sharedPreferences.getInt("id", -1),
//                sharedPreferences.getString("name", null),
//                sharedPreferences.getString("email", null),
//                sharedPreferences.getString("mobile", null),
//                sharedPreferences.getString("avatar", null),
//                sharedPreferences.getString("photo_thumb", null)
//        );
//    }
//
//
//    public static void saveUser(Activity activity, String token, boolean isLogin) {
//        SharedPreferences sharedPreferences = activity.getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString("token", token);
//        editor.putBoolean("isLogin", isLogin);
//        editor.apply();
//    }
//
//    public static void profileDataUserSaved(Activity activity, String profileImage, String userName) {
//        SharedPreferences sharedPreferences = activity.getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString("profile_image", profileImage);
//        editor.putString("user_name", userName);
//        editor.apply();
//    }
//
//    public static SharedPreferences getProfileDataUser(Activity activity) {
//        return activity.getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
//    }
//
//    public static void savedUserEmail(Activity activity, String email) {
//        SharedPreferences sharedPreferences = activity.getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString("email", email);
//        editor.apply();
//    }
//
//    public static SharedPreferences getUserEmail(Activity activity) {
//        return activity.getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
//    }
//
//    public static boolean isLoggedIn(Activity activity) {
//        SharedPreferences sharedPreferences = activity.getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
//        return sharedPreferences.getBoolean("isLogin", false);
//    }
//
//    public void clear() {
//        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.clear();
//        editor.apply();
//
//    }


    public static final String SHARED_APP_DATA = "app_data";
    public static final String SHARED_USER_DATA = "user";
    public static final String SHARED_MENU_LIST = "menu_list";
    public static final String SHARED_SETTINGS = "settings";
    private static final String SHARED_IS_APP_OPENED_BEFORE = "is_app_opened_before";
    private static final String SHARED_IS_USER_LOGIN_BY_SOCIAL = "login_social";
    private static final String SHARED_IS_USER_LOGIN = "is_user_login";
    private static Gson gson = new Gson();
    private static final String DEVICE_ID = "device_id";
    private static final String SHARED_BADGE_COUNT = "BadgeCount";
    private static final String LANGUAGE = "language";
    private static final String SHARED_TABS = "tabs";
    private static final String SHARED_CURRENT_SERVICE_TYPE = "current_service_type";
    private static final String SHARED_IS_SHOW_BEFORE = "is_show_before";
    private static final String SHARED_FCM_TOKEN = "fcm_token";


    public static boolean isOpenBeforeThat() {
        return JustClickApp.getInstance().getSharedPreferences(SHARED_APP_DATA, MODE_PRIVATE)
                .getBoolean(SHARED_IS_APP_OPENED_BEFORE, false);
    }

    public static void setOpenBeforeThat(boolean open) {
        JustClickApp.getInstance().getSharedPreferences(SHARED_APP_DATA, MODE_PRIVATE).edit()
                .putBoolean(SHARED_IS_APP_OPENED_BEFORE, open).apply();
    }

    public static boolean isUserLogin() {
        return JustClickApp.getInstance().getSharedPreferences(SHARED_APP_DATA, MODE_PRIVATE)
                .getBoolean(SHARED_IS_USER_LOGIN, false);
    }

    public static void setUserLogin(boolean login) {
        JustClickApp.getInstance().getSharedPreferences(SHARED_APP_DATA, MODE_PRIVATE).edit()
                .putBoolean(SHARED_IS_USER_LOGIN, login).apply();
    }

    public static void setProfileUser(String profileImage, String userName) {
        JustClickApp.getInstance().getSharedPreferences(SHARED_APP_DATA, MODE_PRIVATE)
                .edit().putString(SHARED_USER_DATA, gson.toJson(profileImage))
                .putString(SHARED_USER_DATA, gson.toJson(userName))
                .apply();
    }

    public static UserInfo getProfileUser() {
        UserInfo mUser = gson.fromJson(JustClickApp.getInstance().getSharedPreferences(SHARED_APP_DATA, MODE_PRIVATE)
                .getString(SHARED_USER_DATA, null), UserInfo.class);
        return mUser;
    }

    public static void setUserInfo(UserInfo user) {
        JustClickApp.getInstance().getSharedPreferences(SHARED_APP_DATA, MODE_PRIVATE)
                .edit().putString(SHARED_USER_DATA, gson.toJson(user)).apply();
    }

    public static UserInfo getUserInfo() {
        UserInfo mUser = gson.fromJson(JustClickApp.getInstance().getSharedPreferences(SHARED_APP_DATA, MODE_PRIVATE)
                .getString(SHARED_USER_DATA, null), UserInfo.class);
        return mUser;
    }

    public static void setUserData(UserData user) {
        JustClickApp.getInstance().getSharedPreferences(SHARED_APP_DATA, MODE_PRIVATE)
                .edit().putString(SHARED_USER_DATA, gson.toJson(user)).apply();
    }

    public static UserData getUserData() {
        UserData mUser = gson.fromJson(JustClickApp.getInstance().getSharedPreferences(SHARED_APP_DATA, MODE_PRIVATE)
                .getString(SHARED_USER_DATA, null), UserData.class);
        return mUser;
    }

    public static void setMenuList(ArrayList<MenuList> list){
        JustClickApp.getInstance().getSharedPreferences(SHARED_APP_DATA, MODE_PRIVATE)
                .edit().putStringSet(SHARED_MENU_LIST, Collections.singleton(gson.toJson(list))).apply();
    }

    public static MenuList getMenuList() {
        MenuList mList = gson.fromJson(JustClickApp.getInstance().getSharedPreferences(SHARED_APP_DATA, MODE_PRIVATE)
                .getString(SHARED_USER_DATA, null), MenuList.class);
        return mList;
    }



    public static void setUserEmailSocial(String userEmail) {
        JustClickApp.getInstance().getSharedPreferences(SHARED_APP_DATA, MODE_PRIVATE)
                .edit().putString(SHARED_USER_DATA, gson.toJson(userEmail)).apply();
    }

    public static UserData getUserEmailSocial() {
        UserData mUser = gson.fromJson(JustClickApp.getInstance().getSharedPreferences(SHARED_APP_DATA, MODE_PRIVATE)
                .getString(SHARED_USER_DATA, null), UserData.class);
        return mUser;
    }


    public static String getDeviceId() {
        return JustClickApp.getInstance().getSharedPreferences(SHARED_APP_DATA, MODE_PRIVATE)
                .getString(DEVICE_ID, "");
    }

    public static void saveDeviceId(String deviceID) {
        JustClickApp.getInstance().getSharedPreferences(SHARED_APP_DATA, MODE_PRIVATE).edit()
                .putString(DEVICE_ID, deviceID).apply();
    }


    public static void setBadgeCount(String userId, int count) {
        JustClickApp.getInstance().getSharedPreferences(SHARED_APP_DATA, MODE_PRIVATE).edit()
                .putInt(SHARED_BADGE_COUNT + userId, count).apply();
    }

    public static int getBadgeCount(String userId) {
        return JustClickApp.getInstance().getSharedPreferences(SHARED_APP_DATA, MODE_PRIVATE)
                .getInt(SHARED_BADGE_COUNT + userId, 0);
    }

    public static void saveLanguage(String language) {
        JustClickApp.getInstance().getSharedPreferences(LANGUAGE, MODE_PRIVATE).edit().putString(LANGUAGE, language).apply();
    }

    public static String getLanguage() {
        String currentLanguage = Locale.getDefault().getDisplayLanguage();
        if (currentLanguage.equals("العربية")) {
            currentLanguage = "ar";
        } else {
            currentLanguage = "en";
        }
        return JustClickApp.getInstance().getSharedPreferences(LANGUAGE, MODE_PRIVATE).getString(LANGUAGE, currentLanguage);
//        return  ConstantApp.EN_ISO;
    }


//    public static void setSettings(Settings settings) {
//        JustClickApp.getInstance().getSharedPreferences(SHARED_APP_DATA, MODE_PRIVATE)
//                .edit().putString(SHARED_SETTINGS, gson.toJson(settings)).apply();
//    }
//
//    public static Settings getSettings() {
//        Settings settings = gson.fromJson(JustClickApp.getInstance().getSharedPreferences(SHARED_APP_DATA, MODE_PRIVATE)
//                .getString(SHARED_SETTINGS, null), Settings.class);
//        return settings;
//    }
}
