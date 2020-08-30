package ps.ns.just_click_and_eat.feature.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import ps.ns.just_click_and_eat.databinding.ActivitySplashBinding;
import ps.ns.just_click_and_eat.feature.introApp.view.IntroAppActivity;
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
                
                startActivity(new Intent(SplashActivity.this, IntroAppActivity.class));
                finish();
            }
        }, SPLASH_TIMER);
    }
}