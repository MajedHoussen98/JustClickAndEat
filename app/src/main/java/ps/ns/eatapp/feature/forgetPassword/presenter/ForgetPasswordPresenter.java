package ps.ns.eatapp.feature.forgetPassword.presenter;

import android.app.Activity;
import android.util.ArrayMap;
import android.widget.EditText;

import ps.ns.eatapp.R;
import ps.ns.eatapp.feature.forgetPassword.view.ForgetPasswordView;
import ps.ns.eatapp.utils.AppSharedMethod;

public class ForgetPasswordPresenter {
    private Activity mActivity;
    private ForgetPasswordView mView;

    public ForgetPasswordPresenter(Activity mActivity, ForgetPasswordView mView) {
        this.mActivity = mActivity;
        this.mView = mView;
    }
    
    
    public void validationInputs(EditText etEmail){
        
        if (AppSharedMethod.checkEditText(etEmail)) {
            etEmail.setError("Enter Your Email Please");
            etEmail.requestFocus();
            return;
        }

        if (AppSharedMethod.checkEmailPatterns(etEmail)) {
            etEmail.setError(mActivity.getString(R.string.errorEmail));
            return;
        }
        
        mView.FormData(AppSharedMethod.getTextFromEditText(etEmail));

        ArrayMap<String , Object> params = new ArrayMap<>();
        params.put("email", AppSharedMethod.getTextFromEditText(etEmail));
        
        ForgetPasswordRequest(params);
    }

    private void ForgetPasswordRequest(ArrayMap<String, Object> params) {
    }
}
