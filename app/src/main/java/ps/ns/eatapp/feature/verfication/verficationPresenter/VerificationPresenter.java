package ps.ns.eatapp.feature.verfication.verficationPresenter;

import android.app.Activity;
import android.util.ArrayMap;
import android.widget.EditText;

import com.mukesh.OnOtpCompletionListener;
import com.mukesh.OtpView;

import ps.ns.eatapp.R;
import ps.ns.eatapp.feature.login.view.LoginActivity;
import ps.ns.eatapp.feature.verfication.view.VerificationView;
import ps.ns.eatapp.utils.AppSharedMethod;

import static ps.ns.eatapp.utils.ConstantApp.FROM_FORGET_PASSWORD;

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
