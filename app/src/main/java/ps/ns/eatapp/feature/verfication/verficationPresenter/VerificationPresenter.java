package ps.ns.eatapp.feature.verfication.verficationPresenter;

import android.app.Activity;
import android.util.ArrayMap;
import android.widget.EditText;

import com.mukesh.OnOtpCompletionListener;
import com.mukesh.OtpView;

import ps.ns.eatapp.feature.verfication.view.VerificationView;
import ps.ns.eatapp.utils.AppSharedMethod;

public class VerificationPresenter {
    private Activity mActivity;
    private VerificationView mView;


    public VerificationPresenter(Activity mActivity, VerificationView mView) {
        this.mActivity = mActivity;
        this.mView = mView;
    }


    public void validationInputs(OtpView otpCode) {

        otpCode.setOtpCompletionListener(new OnOtpCompletionListener() {
            @Override
            public void onOtpCompleted(String otp) {
                if (AppSharedMethod.checkOtpView(otpCode)) {
                    otpCode.setError("Enter Your Code Please");
                    otpCode.requestFocus();
                    return;
                }
            }
        });


        mView.formData(AppSharedMethod.getTextFromEditText(otpCode));

        ArrayMap<String, Object> params = new ArrayMap<>();
        params.put("code", AppSharedMethod.getTextFromOtp(otpCode));

        VerificationRequest(params);


    }

    private void VerificationRequest(ArrayMap<String, Object> params) {
    }
}
