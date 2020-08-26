package ps.ns.just_click_and_eat.utils;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.lifecycle.LifecycleObserver;
import androidx.multidex.MultiDexApplication;

public class JustClickApp extends MultiDexApplication implements LifecycleObserver {

    private static JustClickApp instance;
    private static Boolean isMainActivityOpen = false;
    private static Boolean isChatActivityOpen = false;

    public static JustClickApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    public static boolean isMainActivityOpen() {
        return isMainActivityOpen;
    }

    public static void setMainActivityOpen(Boolean isOpen) {
        isMainActivityOpen = isOpen;
    }

    public static Boolean isChatActivityOpen() {
        return isChatActivityOpen;
    }

    public static void setChatActivityOpen(Boolean isOpen) {
        isChatActivityOpen = isOpen;
    }

}
