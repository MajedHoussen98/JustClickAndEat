package ps.ns.eatapp.feature.login.presenter;

import android.app.Activity;
import android.os.Handler;
import android.util.ArrayMap;

import com.google.android.material.textfield.TextInputEditText;

import ps.ns.eatapp.MainActivity;
import ps.ns.eatapp.R;
import ps.ns.eatapp.feature.forgetPassword.view.ForgetPasswordActivity;
import ps.ns.eatapp.feature.login.view.LoginView;
import ps.ns.eatapp.feature.signUp.view.SignUpActivity;
import ps.ns.eatapp.ui.HomeFragment;
import ps.ns.eatapp.utils.AppSharedMethod;
import ps.ns.eatapp.utils.BaseActivity;

import static ps.ns.eatapp.utils.ConstantApp.FROM_LOGIN;

public class LoginPresenter{

    private LoginView mView;
    private Activity mActivity;


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
        },3000);
        mActivity.startActivity(MainActivity.newInstance(mActivity, FROM_LOGIN));
    }


}
