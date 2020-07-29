package ps.ns.eatapp.feature.signup.presenter;

import android.app.Activity;
import android.content.Intent;
import android.util.ArrayMap;
import android.widget.EditText;

import ps.ns.eatapp.R;
import ps.ns.eatapp.feature.signup.view.SignUpActivity;
import ps.ns.eatapp.feature.signup.view.SignUpView;
import ps.ns.eatapp.feature.verfication.view.VerificationActivity;
import ps.ns.eatapp.utils.AppSharedMethod;

public class SignUpPresenter {

    private SignUpView mView;
    private Activity mActivity;

    public SignUpPresenter(Activity mActivity, SignUpView mView) {
        this.mView = mView;
        this.mActivity = mActivity;
    }

    public void goToLogin() {

    }

    public void validationInputs(EditText etName, EditText etEmail, EditText etMobile, EditText etPassword, EditText etConfirmPassword) {

        if (AppSharedMethod.checkEditText(etName)) {
            etName.setError(mActivity.getString(R.string.enter_name));
            etName.requestFocus();
            return;
        }

        if (AppSharedMethod.checkEditText(etEmail)) {
            etEmail.setError("Enter Your Email Please");
            etEmail.requestFocus();
            return;
        }

        if (AppSharedMethod.checkEmailPatterns(etEmail)) {
            etEmail.setError(mActivity.getString(R.string.errorEmail));
            return;
        }
//        String regexStr = "^[0-9]$";
//        String number = AppSharedMethod.getTextFromEditText(etMobile);
//        if (AppSharedMethod.getTextFromEditText(etMobile).length() < 10 || number.length() > 13 || !number.matches(regexStr)) {
//            etMobile.setError(mActivity.getString(R.string.error_mobile));
//            etMobile.requestFocus();
//            return;
//        }

        if (AppSharedMethod.checkEditText(etMobile)) {
            etMobile.setError(mActivity.getString(R.string.error_mobile));
            etMobile.requestFocus();
            return;
        }

        if (AppSharedMethod.checkEditText(etPassword)) {
            etPassword.setError("Enter your password please");
            etPassword.requestFocus();
            return;
        }

        if (AppSharedMethod.getTextFromEditText(etPassword).length() < 8) {
            etPassword.setError(mActivity.getString(R.string.password_less));
            etPassword.requestFocus();
            return;
        }

        if (AppSharedMethod.checkEditText(etConfirmPassword)) {
            etConfirmPassword.setError("Enter your password please");
            etConfirmPassword.requestFocus();
            return;
        }

        if (!AppSharedMethod.getTextFromEditText(etPassword).equals(AppSharedMethod.getTextFromEditText(etConfirmPassword))) {
            etConfirmPassword.setError(mActivity.getString(R.string.password_not_match));
            etConfirmPassword.requestFocus();
            return;
        }

        mActivity.startActivity(new Intent(mActivity, VerificationActivity.class));

        mView.formData(AppSharedMethod.getTextFromEditText(etName), AppSharedMethod.getTextFromEditText(etEmail), AppSharedMethod.getTextFromEditText(etMobile), AppSharedMethod.getTextFromEditText(etPassword), AppSharedMethod.getTextFromEditText(etConfirmPassword));
        ArrayMap<String, Object> params = new ArrayMap<>();
        params.put("name", AppSharedMethod.getTextFromEditText(etName));
        params.put("email", AppSharedMethod.getTextFromEditText(etEmail));
        params.put("mobile", AppSharedMethod.getTextFromEditText(etMobile));
        params.put("password", AppSharedMethod.getTextFromEditText(etPassword));
        params.put("confirmPassword", AppSharedMethod.getTextFromEditText(etConfirmPassword));

        SignUpRequest(params);

    }

    private void SignUpRequest(ArrayMap<String, Object> params) {
    }
}
