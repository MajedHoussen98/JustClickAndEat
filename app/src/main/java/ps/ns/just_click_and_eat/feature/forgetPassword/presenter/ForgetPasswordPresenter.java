package ps.ns.just_click_and_eat.feature.forgetPassword.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.widget.EditText;

import androidx.collection.ArrayMap;

import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.feature.forgetPassword.view.ForgetPasswordView;
import ps.ns.just_click_and_eat.feature.login.view.LoginActivity;
import ps.ns.just_click_and_eat.network.asp.feature.NetworkShared;
import ps.ns.just_click_and_eat.network.asp.model.UserData;
import ps.ns.just_click_and_eat.network.utils.RequestListener;
import ps.ns.just_click_and_eat.utils.AppSharedMethod;

public class ForgetPasswordPresenter {
    private Activity mActivity;
    private ForgetPasswordView mView;

    public ForgetPasswordPresenter(Activity mActivity, ForgetPasswordView mView) {
        this.mActivity = mActivity;
        this.mView = mView;
    }


    public void validationInputs(EditText etEmail) {

        if (AppSharedMethod.isEmptyEditText(etEmail)) {
            AppSharedMethod.setErrorEditText(etEmail, mActivity.getString(R.string.emty_email));
            return;
        }

        if (AppSharedMethod.isInvalidEmail(etEmail)) {
            AppSharedMethod.setErrorEditText(etEmail, mActivity.getString(R.string.errorEmail));
            return;
        }

        String params = AppSharedMethod.getTextFromEditText(etEmail);
        forgetPasswordRequest(params);
    }

    private void forgetPasswordRequest(String params) {

        mView.showProgress();
        NetworkShared.getAsp().getUser().forgetPassword(params, new RequestListener<String>() {
            @Override
            public void onSuccess(String data) {
                mView.hideProgress();
                mView.showMessage("Check your email to reset password...");
                mActivity.startActivity(new Intent(mActivity, LoginActivity.class));
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
