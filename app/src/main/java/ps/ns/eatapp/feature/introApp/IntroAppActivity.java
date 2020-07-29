package ps.ns.eatapp.feature.introApp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

import ps.ns.eatapp.MainActivity;
import ps.ns.eatapp.feature.login.view.LoginActivity;
import ps.ns.eatapp.R;
import ps.ns.eatapp.adapter.IntroAdapter;
import ps.ns.eatapp.databinding.ActivityIntroAppBinding;
import ps.ns.eatapp.model.IntroModel;

public class IntroAppActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityIntroAppBinding binding;

    IntroAdapter adapter;
    ArrayList<IntroModel> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIntroAppBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initViews();
        getDataIntro();
        viewListener();


    }

    private void initViews() {
        list = new ArrayList<>();
    }


    private void viewListener() {
        binding.btnSignIn.setOnClickListener(this);
        binding.btnGetStarted.setOnClickListener(this);
    }

    private void getDataIntro() {
        list.add(new IntroModel(R.drawable.group1, getString(R.string.title1), getString(R.string.description1)));
        list.add(new IntroModel(R.drawable.group2, getString(R.string.title2), getString(R.string.description2)));
        list.add(new IntroModel(R.drawable.group3, getString(R.string.title3), getString(R.string.description3)));

        adapter = new IntroAdapter(list);
        binding.viewPager.setAdapter(adapter);
        binding.springDotsIndicator.setViewPager(binding.viewPager);

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_get_started) {
            startActivity(new Intent(IntroAppActivity.this, MainActivity.class));
            finish();
        } else if (v.getId() == R.id.btn_sign_in) {
            startActivity(new Intent(IntroAppActivity.this, LoginActivity.class));
        }
    }
}