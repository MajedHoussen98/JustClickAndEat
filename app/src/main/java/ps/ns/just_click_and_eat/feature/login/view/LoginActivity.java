package ps.ns.just_click_and_eat.feature.login.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.View;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import java.lang.reflect.Array;
import java.util.Arrays;

import ps.ns.just_click_and_eat.databinding.ActivitySigninBinding;
import ps.ns.just_click_and_eat.feature.login.presenter.LoginPresenter;
import ps.ns.just_click_and_eat.utils.BaseActivity;

import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_WHERE;

public class LoginActivity extends BaseActivity implements LoginView {
    private ActivitySigninBinding binding;
    private LoginPresenter presenter;
    private CallbackManager callbackManager;


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
        initViews();
        initPresenter();
        viewListener();
    }


    private void initViews() {
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        callbackManager = CallbackManager.Factory.create();
    }

    private void initPresenter() {
        presenter = new LoginPresenter(this, this);
    }

    private void viewListener() {
        binding.btnSignIn.setOnClickListener(v -> presenter.validateInputs(binding.etEmail, binding.etPassword));
        binding.tvSignUp.setOnClickListener(v -> presenter.goToSignUp());
        binding.tvForgetPassword.setOnClickListener(v -> presenter.goToForget());
        binding.llSignWithFacebook.setOnClickListener(v -> presenter.signInWithFacebook(callbackManager));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void showMessage(String msg) {
        super.showMessage(msg);
        snackErrorShow(binding.getRoot() , msg);
    }
}