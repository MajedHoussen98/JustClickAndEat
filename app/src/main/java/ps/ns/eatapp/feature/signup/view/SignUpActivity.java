package ps.ns.eatapp.feature.signup.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import ps.ns.eatapp.databinding.ActivitySignUpBinding;
import ps.ns.eatapp.feature.login.view.LoginActivity;
import ps.ns.eatapp.feature.signup.presenter.SignUpPresenter;
import ps.ns.eatapp.feature.verfication.view.VerificationActivity;

public class SignUpActivity extends AppCompatActivity implements SignUpView {

    private ActivitySignUpBinding binding;
    private SignUpPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initViews();
        initPresenter();
        viewListener();
    }

    private void initViews() {
    }

    private void initPresenter() {
        presenter = new SignUpPresenter(this, this);
    }

    private void viewListener() {
        binding.btnSignUp.setOnClickListener(v -> presenter.validationInputs(binding.etName, binding.etEmail, binding.etMobile, binding.etPassword, binding.etConfirmPassword));
        binding.tvBackSignIn.setOnClickListener(v -> {startActivity(new Intent(SignUpActivity.this, LoginActivity.class));});
    }

    @Override
    public void formData(String name, String email, String mobile, String password, String confirmPassword) {
        Log.e("TAGSSignUp", "name: \t" + name + "\t" + "email: \t" + email + "\t" + "mobile: \t" + mobile + "\t" + "pass: \t" + password + "\t" + "passC: \t" + confirmPassword);

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