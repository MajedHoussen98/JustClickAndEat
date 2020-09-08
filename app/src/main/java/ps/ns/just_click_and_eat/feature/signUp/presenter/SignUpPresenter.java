package ps.ns.just_click_and_eat.feature.signUp.presenter;

import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;

import androidx.collection.ArrayMap;

import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.feature.login.view.LoginActivity;
import ps.ns.just_click_and_eat.feature.signUp.view.SignUpView;
import ps.ns.just_click_and_eat.feature.verfication.view.VerificationActivity;
import ps.ns.just_click_and_eat.network.asp.feature.NetworkShared;
import ps.ns.just_click_and_eat.network.asp.model.User.UserData;
import ps.ns.just_click_and_eat.network.utils.RequestListener;
import ps.ns.just_click_and_eat.utils.AppSharedData;
import ps.ns.just_click_and_eat.utils.AppSharedMethod;

import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_SIGN_UP;

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

        if (AppSharedMethod.getTextFromEditText(etMobile).length() != 10) {
            AppSharedMethod.setErrorEditText(etMobile, mActivity.getString(R.string.mobile_less));
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
        params.put("password_confirmation", AppSharedMethod.getTextFromEditText(etConfirmPassword));

        signUpRequest(params);

    }

    private static final String TAG = "SignUpPresenter";

    private void signUpRequest(ArrayMap<String, Object> params) {
        mView.showProgress();
        NetworkShared.getAsp().getUser().signUp(params, new RequestListener<UserData>() {
            @Override
            public void onSuccess(UserData data) {
                int id = data.getId();
                String email = data.getEmail(), mobile = data.getMobile();
                Intent intent = new Intent(VerificationActivity.newInstance(mActivity, FROM_SIGN_UP));
                intent.putExtra("user_id", id);
                intent.putExtra("mobile", mobile);
                intent.putExtra("email", email);
                AppSharedData.setUserData(data);
                mView.hideProgress();
                mActivity.startActivity(intent);
                mActivity.finish();
            }
            @Override
            public void onFail(String message, int code) {
                mView.hideProgress();
                mView.showMessage(message);
            }
        });
    }
}





