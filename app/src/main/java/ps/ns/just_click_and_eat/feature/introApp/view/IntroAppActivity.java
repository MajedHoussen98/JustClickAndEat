package ps.ns.just_click_and_eat.feature.introApp.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import java.util.ArrayList;

import ps.ns.just_click_and_eat.feature.introApp.adapter.IntroAdapter;
import ps.ns.just_click_and_eat.feature.introApp.presenter.IntroPresenter;
import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.databinding.ActivityIntroAppBinding;
import ps.ns.just_click_and_eat.network.asp.model.IntroApp;
import ps.ns.just_click_and_eat.utils.AppSharedMethod;
import ps.ns.just_click_and_eat.utils.BaseActivity;

import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_WHERE;

public class IntroAppActivity extends BaseActivity implements IntroView {

    private ActivityIntroAppBinding binding;
    private IntroPresenter presenter;

    public static Intent newInstance(Activity mActivity, int fromWhere) {
        Intent intent = new Intent(mActivity, IntroAppActivity.class);
        intent.putExtra(FROM_WHERE, fromWhere);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIntroAppBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initViews();
        AppSharedMethod.statusBarLight(this);

    }

    private void initViews() {
        presenter = new IntroPresenter(this, this);
        viewListener();
        getDataIntro();

    }


    private void viewListener() {
        binding.btnSignIn.setOnClickListener(v -> presenter.goToLogin());
        binding.btnGetStarted.setOnClickListener(v -> presenter.goToHome());

    }

    private void getDataIntro() {
        presenter.getAppIntro(binding.viewPager, binding.springDotsIndicator);
    }

}