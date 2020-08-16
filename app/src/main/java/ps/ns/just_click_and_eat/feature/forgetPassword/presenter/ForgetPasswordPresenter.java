package ps.ns.just_click_and_eat.feature.forgetPassword.presenter;

import android.app.Activity;
import android.os.Handler;
import android.util.ArrayMap;
import android.widget.EditText;

import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.feature.forgetPassword.view.ForgetPasswordView;
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
