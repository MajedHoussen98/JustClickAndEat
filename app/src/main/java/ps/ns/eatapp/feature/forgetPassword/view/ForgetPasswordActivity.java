package ps.ns.eatapp.feature.forgetPassword.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import ps.ns.eatapp.R;
import ps.ns.eatapp.databinding.ActivityForgetPasswordBinding;
import ps.ns.eatapp.feature.forgetPassword.presenter.ForgetPasswordPresenter;
import ps.ns.eatapp.feature.login.view.LoginActivity;

import static ps.ns.eatapp.utils.ConstantApp.FROM_WHERE;

public class ForgetPasswordActivity extends AppCompatActivity implements ForgetPasswordView {

    private ActivityForgetPasswordBinding binding;
    private ForgetPasswordPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForgetPasswordBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initViews();
        initPresenter();
        viewListener();

    }

    private void initViews() {

    }

    private void initPresenter() {
        presenter = new ForgetPasswordPresenter(this, this);
    }

    private void viewListener() {
        binding.btnSend.setOnClickListener(v -> presenter.validationInputs(binding.etEmail));
    }

    @Override
    public void FormData(String email) {
        Log.e("forget", "email: \t" + email);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showMessage(String msg) {

    }
}