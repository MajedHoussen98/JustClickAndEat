package ps.ns.just_click_and_eat.feature.verfication.verficationPresenter;

import android.app.Activity;
import android.util.ArrayMap;

import com.mukesh.OtpView;

import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.feature.verfication.view.VerificationView;
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

    private void verificationRequest(ArrayMap<String, Object> params) {
    }
}
