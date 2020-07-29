package ps.ns.eatapp.feature.login.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ps.ns.eatapp.databinding.ActivitySigninBinding;
import ps.ns.eatapp.feature.login.presenter.LoginPresenter;
import ps.ns.eatapp.utils.BaseActivity;

import static ps.ns.eatapp.utils.ConstantApp.FROM_WHERE;

public class LoginActivity extends BaseActivity implements LoginView {
    private ActivitySigninBinding binding;
    private LoginPresenter presenter;

    public static Intent newInstance(Activity mActivity, int fromWhere) {
        Intent intent = new Intent(mActivity, LoginActivity.class);
        intent.putExtra(FROM_WHERE, fromWhere);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySigninBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initPresenter();
        viewListener();

    }


    private void viewListener() {
        binding.btnSignIn.setOnClickListener(v -> presenter.validateInputs(binding.etEmail, binding.etPassword));
        binding.tvSignUp.setOnClickListener(v -> presenter.goToSignUp());
        binding.tvForgetPassword.setOnClickListener(v -> presenter.goToForget());
    }

    private void initPresenter() {
        presenter = new LoginPresenter(this, this);
    }


}