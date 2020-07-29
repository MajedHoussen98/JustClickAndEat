package ps.ns.eatapp.feature.forgetPassword.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.util.ArrayMap;
import android.widget.EditText;

import ps.ns.eatapp.R;
import ps.ns.eatapp.feature.forgetPassword.view.ForgetPasswordView;
import ps.ns.eatapp.feature.login.view.LoginActivity;
import ps.ns.eatapp.utils.AppSharedMethod;

import static ps.ns.eatapp.utils.ConstantApp.FROM_FORGET_PASSWORD;

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

        ArrayMap<String, Object> params = new ArrayMap<>();
        params.put("email", AppSharedMethod.getTextFromEditText(etEmail));

        forgetPasswordRequest(params);
    }

    private void forgetPasswordRequest(ArrayMap<String, Object> params) {
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
    }
}
