package ps.ns.just_click_and_eat.feature.signUp.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ps.ns.just_click_and_eat.databinding.ActivitySignUpBinding;
import ps.ns.just_click_and_eat.feature.signUp.presenter.SignUpPresenter;
import ps.ns.just_click_and_eat.utils.BaseActivity;

import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_WHERE;

public class SignUpActivity extends BaseActivity implements SignUpView {

    private ActivitySignUpBinding binding;
    private SignUpPresenter presenter;

    public static Intent newInstance(Activity mActivity, int fromWhere) {
        Intent intent = new Intent(mActivity, SignUpActivity.class);
        intent.putExtra(FROM_WHERE, fromWhere);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initViews();
        initPresenter();
        initListener();
    }

    private void initViews() {
    }

    private void initPresenter() {
        presenter = new SignUpPresenter(this, this);
    }

    private void initListener() {
        binding.btnSignUp.setOnClickListener(v -> presenter.validationInputs(binding.etName, binding.etEmail, binding.etMobile, binding.etPassword, binding.etConfirmPassword));
        binding.tvBackSignIn.setOnClickListener(v -> presenter.goToLogin());
    }

    @Override
    public void showMessage(String msg) {
        super.showMessage(msg);
        snackErrorShow(binding.getRoot() , msg);
    }

}