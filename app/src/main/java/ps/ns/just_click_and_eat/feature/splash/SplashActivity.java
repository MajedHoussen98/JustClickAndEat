package ps.ns.just_click_and_eat.feature.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import ps.ns.just_click_and_eat.databinding.ActivitySplashBinding;
import ps.ns.just_click_and_eat.feature.introApp.view.IntroAppActivity;
import ps.ns.just_click_and_eat.feature.login.view.LoginActivity;
import ps.ns.just_click_and_eat.feature.mainHome.view.MainActivity;
import ps.ns.just_click_and_eat.feature.maps.view.MapsActivity;
import ps.ns.just_click_and_eat.utils.AppSharedData;
import ps.ns.just_click_and_eat.utils.AppSharedMethod;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ps.ns.just_click_and_eat.databinding.ActivitySplashBinding binding = ActivitySplashBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        AppSharedMethod.statusBarHide(view);
        int SPLASH_TIMER = 3000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (AppSharedData.isOpenBeforeThat() && AppSharedData.isUserLogin()) {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                    Log.e("status", "1");

                } else if (AppSharedData.isOpenBeforeThat() && !AppSharedData.isUserLogin()) {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();
                    Log.e("status", "2");

                } else if (!AppSharedData.isOpenBeforeThat()) {
                    startActivity(new Intent(SplashActivity.this, IntroAppActivity.class));
                    finish();
                    AppSharedData.setOpenBeforeThat(true);
                    Log.e("status", "3");
                }

            }
        }, SPLASH_TIMER);
    }
}