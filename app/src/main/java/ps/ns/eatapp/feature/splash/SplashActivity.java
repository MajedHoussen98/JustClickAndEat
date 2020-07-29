package ps.ns.eatapp.feature.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import ps.ns.eatapp.R;
import ps.ns.eatapp.feature.introApp.IntroAppActivity;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIMER = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, IntroAppActivity.class));
                finish();
            }
        }, SPLASH_TIMER);
    }
}