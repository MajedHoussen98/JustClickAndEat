package ps.ns.eatapp.feature.signUp.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.util.ArrayMap;
import android.widget.EditText;

import ps.ns.eatapp.R;
import ps.ns.eatapp.feature.login.view.LoginActivity;
import ps.ns.eatapp.feature.signUp.view.SignUpView;
import ps.ns.eatapp.feature.verfication.view.VerificationActivity;
import ps.ns.eatapp.utils.AppSharedMethod;

import static ps.ns.eatapp.utils.ConstantApp.FROM_SIGN_UP;

public class SignUpPresenter {

    private SignUpView mView;
    private Activity mActivity;

    public SignUpPresenter(Activity mActivity, SignUpView mView) {
        this.mView = mView;
        this.mActivity = mActivity;
    }

    public void goToLogin() {
        mActivity.startActivity(LoginActivity.newInstance(mActivity, FROM_SIGN_UP));
    }

    public void validationInputs(EditText etName, EditText etEmail, EditText etMobile, EditText etPassword, EditText etConfirmPassword) {

        if (AppSharedMethod.isEmptyEditText(etName)) {
            AppSharedMethod.setErrorEditText(etName, mActivity.getString(R.string.enter_name));
            return;
        }

        if (AppSharedMethod.isEmptyEditText(etEmail)) {
            AppSharedMethod.setErrorEditText(etEmail, mActivity.getString(R.string.emty_email));

            return;
        }

        if (AppSharedMethod.isInvalidEmail(etEmail)) {
            AppSharedMethod.setErrorEditText(etEmail, mActivity.getString(R.string.errorEmail));
            return;
        }

        if (AppSharedMethod.isEmptyEditText(etMobile)) {
            AppSharedMethod.setErrorEditText(etMobile, mActivity.getString(R.string.error_mobile));
            return;
        }

        if (AppSharedMethod.isEmptyEditText(etPassword)) {
            AppSharedMethod.setErrorEditText(etPassword, mActivity.getString(R.string.enter_password));

            return;
        }

        if (AppSharedMethod.getTextFromEditText(etPassword).length() < 8) {
            AppSharedMethod.setErrorEditText(etPassword, mActivity.getString(R.string.password_less));
            return;
        }

        if (AppSharedMethod.isEmptyEditText(etConfirmPassword)) {
            AppSharedMethod.setErrorEditText(etConfirmPassword, mActivity.getString(R.string.enter_password));
            return;
        }

        if (AppSharedMethod.getTextFromEditText(etConfirmPassword).length() < 8) {
            AppSharedMethod.setErrorEditText(etConfirmPassword, mActivity.getString(R.string.password_less));
            return;
        }


        if (!AppSharedMethod.getTextFromEditText(etPassword).equals(AppSharedMethod.getTextFromEditText(etConfirmPassword))) {
            AppSharedMethod.setErrorEditText(etConfirmPassword, mActivity.getString(R.string.password_not_match));
            return;
        }

        ArrayMap<String, Object> params = new ArrayMap<>();
        params.put("name", AppSharedMethod.getTextFromEditText(etName));
        params.put("email", AppSharedMethod.getTextFromEditText(etEmail));
        params.put("mobile", AppSharedMethod.getTextFromEditText(etMobile));
        params.put("password", AppSharedMethod.getTextFromEditText(etPassword));
        params.put("confirmPassword", AppSharedMethod.getTextFromEditText(etConfirmPassword));

        signUpRequest(params);

    }

    private void signUpRequest(ArrayMap<String, Object> params) {
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

        mActivity.startActivity(VerificationActivity.newInstance(mActivity, FROM_SIGN_UP));
    }
}
