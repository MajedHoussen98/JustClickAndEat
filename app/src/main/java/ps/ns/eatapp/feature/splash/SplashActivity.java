package ps.ns.eatapp.feature.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import ps.ns.eatapp.R;
import ps.ns.eatapp.databinding.ActivitySplashBinding;
import ps.ns.eatapp.feature.introApp.IntroAppActivity;
import ps.ns.eatapp.utils.AppSharedMethod;

public class SplashActivity extends AppCompatActivity {
    private View view;
    private ActivitySplashBinding binding;

    private static int SPLASH_TIMER = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        setContentView(view);
        AppSharedMethod.statusBarHide(view);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, IntroAppActivity.class));
                finish();
            }
        }, SPLASH_TIMER);
    }
}