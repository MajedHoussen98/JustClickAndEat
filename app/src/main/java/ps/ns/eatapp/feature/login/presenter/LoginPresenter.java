package ps.ns.eatapp.feature.login.presenter;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Build;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Patterns;
import com.google.android.material.textfield.TextInputEditText;

import ps.ns.eatapp.R;
import ps.ns.eatapp.feature.login.view.LoginActivity;
import ps.ns.eatapp.feature.login.view.LoginView;
import ps.ns.eatapp.utils.AppSharedMethod;

import static ps.ns.eatapp.utils.ConstantApp.FROM_FORGET;
import static ps.ns.eatapp.utils.ConstantApp.FROM_SIGNUp;

public class LoginPresenter {

    private LoginView mView;
    private Activity mActivity;

    public LoginPresenter(Activity mActivity, LoginView mView) {
        this.mView = mView;
        this.mActivity = mActivity;
    }

    public void goToSignUp() {
        mActivity.startActivity(LoginActivity.newInstance(mActivity, FROM_SIGNUp));
    }

    public void goToForget() {
        //TODO:MOUSE
        mActivity.startActivity(LoginActivity.newInstance(mActivity, FROM_FORGET));

        //LoginActivity.initIntent(mActivity,new ForgetPasswordActivity() , "" , "");

    }


    public void validateInputs(TextInputEditText etEmail, TextInputEditText etPassword) {

        if (AppSharedMethod.checkEditText(etEmail)) {
            etEmail.setError(mActivity.getString(R.string.emty_email));
            etEmail.requestFocus();
            return;
        }

        if (AppSharedMethod.checkEmailPatterns(etEmail)) {
            etEmail.setError(mActivity.getString(R.string.errorEmail));
            etEmail.requestFocus();

            return;
        }

        if (AppSharedMethod.checkEditText(etPassword)) {
            etPassword.setError(mActivity.getString(R.string.enter_password));
            etPassword.requestFocus();
            mView.showMessage(mActivity.getString(R.string.enter_password));
            return;
        }
        mView.formData(etEmail.getText().toString().trim(), etPassword.getText().toString().trim());
        mView.showProgress();

        ArrayMap<String, Object> params = new ArrayMap<>();
        params.put("email", etEmail.getText().toString().trim());
        params.put("password", etPassword.getText().toString().trim());
        loginRequest(params);
    }

    private void loginRequest(ArrayMap<String, Object> params) {
    }


    public void DialogProgress(int i) {
        ProgressDialog dialog = new ProgressDialog(mActivity);
        dialog.setMessage("Please wait...");
        if (i == 1)
            dialog.show();
        else
            dialog.dismiss();
    }

}
