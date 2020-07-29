package ps.ns.eatapp.feature.EditPassword.presenter;

import android.app.Activity;
import android.util.ArrayMap;
import android.widget.EditText;

import ps.ns.eatapp.R;
import ps.ns.eatapp.feature.EditPassword.view.EditPasswordView;
import ps.ns.eatapp.utils.AppSharedMethod;

public class EditPasswordPresenter {
    private Activity mActivity;
    private EditPasswordView mView;

    public EditPasswordPresenter(Activity mActivity, EditPasswordView mView) {
        this.mActivity = mActivity;
        this.mView = mView;
    }
    
    
    public void validationInputs(EditText etCurrentPassword, EditText etNewPassword, EditText etConfirmPassword){
        
        if (AppSharedMethod.checkEditText(etCurrentPassword)) {
            etCurrentPassword.setError("Enter your password please");
            etCurrentPassword.requestFocus();
            return;
        }

        if (AppSharedMethod.checkEditText(etNewPassword)) {
            etNewPassword.setError("Enter your password please");
            etNewPassword.requestFocus();
            return;
        }

        if (AppSharedMethod.getTextFromEditText(etNewPassword).length() < 8) {
            etNewPassword.setError(mActivity.getString(R.string.password_less));
            etNewPassword.requestFocus();
            return;
        }

        if (AppSharedMethod.checkEditText(etConfirmPassword)) {
            etConfirmPassword.setError("Enter your password please");
            etConfirmPassword.requestFocus();
            return;
        }

        if (!AppSharedMethod.getTextFromEditText(etNewPassword).equals(AppSharedMethod.getTextFromEditText(etConfirmPassword))) {
            etConfirmPassword.setError(mActivity.getString(R.string.password_not_match));
            etConfirmPassword.requestFocus();
            return;
        }
        
        mView.formData(AppSharedMethod.getTextFromEditText(etCurrentPassword), AppSharedMethod.getTextFromEditText(etNewPassword), AppSharedMethod.getTextFromEditText(etConfirmPassword));

        ArrayMap<String, Object> params = new ArrayMap<>();
        
        params.put("currentPassword", AppSharedMethod.getTextFromEditText(etCurrentPassword));
        params.put("newPassword", AppSharedMethod.getTextFromEditText(etNewPassword));
        params.put("confirmPassword", AppSharedMethod.getTextFromEditText(etConfirmPassword));
        
        ChangePasswordRequest();
    }

    private void ChangePasswordRequest() {
    }
}
