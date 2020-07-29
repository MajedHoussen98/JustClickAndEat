package ps.ns.eatapp.feature.login.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import ps.ns.eatapp.databinding.ActivitySigninBinding;
import ps.ns.eatapp.feature.forgetPassword.view.ForgetPasswordActivity;
import ps.ns.eatapp.feature.login.presenter.LoginPresenter;
import ps.ns.eatapp.feature.signup.view.SignUpActivity;

import static ps.ns.eatapp.utils.ConstantApp.FROM_WHERE;

public class LoginActivity extends AppCompatActivity implements LoginView {
    private ActivitySigninBinding binding;
    private LoginPresenter presenter;

    public static Intent newInstance(Activity mActivity, int fromWhere) {
        Intent intent = new Intent(mActivity, LoginActivity.class);
        intent.putExtra(FROM_WHERE, fromWhere);
        return intent;
    }

    public static void initIntent(Activity activityFrom, Activity activityTo, String key, String val) {
        activityFrom.startActivity(new Intent(activityFrom, activityTo.getClass())
                .putExtra(key, val));
    }//end


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySigninBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initView();
        initPresenter();
        viewListener();

    }

    private void initView() {
        //  binding.tvSignUp.setOnClickListener(v -> presenter.goToSignUp());

        //  binding.tvForgetPassword.setOnClickListener(v -> presenter.goToForget());
        //binding.tvForgetPassword.setOnClickListener(v -> presenter.goToForget());
    }


    private void viewListener() {
        binding.btnSignIn.setOnClickListener(v -> presenter.validateInputs(binding.etEmail, binding.etPassword));

        binding.tvSignUp.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
        });
        binding.tvForgetPassword.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, ForgetPasswordActivity.class));
        });
    }

    private void initPresenter() {
        presenter = new LoginPresenter(this, this);
    }


    @Override
    public void showProgress() {
        presenter.DialogProgress(1);
    }

    @Override
    public void hideProgress() {
        presenter.DialogProgress(-1);
    }

    @Override
    public void showMessage(String msg) {
        Log.e("MESAGES", msg);
    }

    @Override
    public void formData(String id, String pass) {
        Log.e("TAGS", "id: \t" + id + "\t" + "pass: \t" + pass);
    }
}