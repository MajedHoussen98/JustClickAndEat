package ps.ns.just_click_and_eat.feature.verfication.verficationPresenter;

import android.app.Activity;
import android.content.Intent;


import androidx.collection.ArrayMap;

import com.mukesh.OtpView;

import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.feature.login.view.LoginActivity;
import ps.ns.just_click_and_eat.feature.verfication.view.VerificationView;
import ps.ns.just_click_and_eat.network.asp.feature.NetworkShared;
import ps.ns.just_click_and_eat.network.utils.RequestListener;
import ps.ns.just_click_and_eat.utils.AppSharedMethod;

public class VerificationPresenter {
    private Activity mActivity;
    private VerificationView mView;


    public VerificationPresenter(Activity mActivity, VerificationView mView) {
        this.mActivity = mActivity;
        this.mView = mView;
    }


    public void validationInputs(OtpView otpCode) {
        if (AppSharedMethod.checkOtpView(otpCode)) {
            AppSharedMethod.setErrorVerification(otpCode, mActivity.getString(R.string.enter_code));
            return;
        }


        ArrayMap<String, Object> params = new ArrayMap<>();
        params.put("code", AppSharedMethod.getTextFromOtp(otpCode));

        verificationRequest(params);


    }




    public void verificationRequest(ArrayMap<String, Object> params) {
        mView.showMessage("open email and verify it...");
        NetworkShared.getAsp().getUser().verifyAccountUser(params, new RequestListener<String>() {
            @Override
            public void onSuccess(String data) {
                mActivity.startActivity(new Intent(mActivity, LoginActivity.class));
                mActivity.finish();
            }

            @Override
            public void onFail(String message, int code) {
            }
        });
    }
}
