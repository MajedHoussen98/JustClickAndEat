package ps.ns.just_click_and_eat.feature.login.presenter;

import android.app.Activity;
import android.os.Handler;
import android.util.ArrayMap;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Arrays;

import ps.ns.just_click_and_eat.feature.login.view.LoginActivity;
import ps.ns.just_click_and_eat.feature.mainHome.view.MainActivity;
import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.feature.forgetPassword.view.ForgetPasswordActivity;
import ps.ns.just_click_and_eat.feature.login.view.LoginView;
import ps.ns.just_click_and_eat.feature.signUp.view.SignUpActivity;
import ps.ns.just_click_and_eat.utils.AppSharedMethod;

import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_LOGIN;

public class LoginPresenter {

    private LoginView mView;
    private Activity mActivity;
    private CallbackManager callbackManager;


    public LoginPresenter(Activity mActivity, LoginView mView) {
        this.mView = mView;
        this.mActivity = mActivity;
    }

    public void goToSignUp() {
        mActivity.startActivity(SignUpActivity.newInstance(mActivity, FROM_LOGIN));
    }

    public void goToForget() {
        mActivity.startActivity(ForgetPasswordActivity.newInstance(mActivity, FROM_LOGIN));
    }

    public void signInWithFacebook() {
        callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        // App code
                        LoginManager.getInstance().logInWithReadPermissions(mActivity, Arrays.asList("public_profile"));
                    }

                    @Override
                    public void onCancel() {
                        // App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                    }
                });
    }


    public void validateInputs(TextInputEditText etEmail, TextInputEditText etPassword) {


        if (AppSharedMethod.isEmptyEditText(etEmail)) {
            AppSharedMethod.setErrorEditText(etEmail, mActivity.getString(R.string.emty_email));
            return;
        }

        if (AppSharedMethod.isInvalidEmail(etEmail)) {
            AppSharedMethod.setErrorEditText(etEmail, mActivity.getString(R.string.errorEmail));
            return;
        }

        if (AppSharedMethod.isEmptyEditText(etPassword)) {
            AppSharedMethod.setErrorEditText(etPassword, mActivity.getString(R.string.enter_password));
            return;
        }

        ArrayMap<String, Object> params = new ArrayMap<>();
        params.put("email", AppSharedMethod.getTextFromEditText(etEmail));
        params.put("password", AppSharedMethod.getTextFromEditText(etPassword));
        loginRequest(params);

    }

    private void loginRequest(ArrayMap<String, Object> params) {

        if (mView != null) {
            mView.showProgress();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mView != null) {
                    mView.hideProgress();
                }
            }
        }, 3000);
        mActivity.startActivity(MainActivity.newInstance(mActivity, FROM_LOGIN));
    }


}
