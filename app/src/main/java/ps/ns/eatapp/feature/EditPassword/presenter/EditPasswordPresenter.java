package ps.ns.eatapp.feature.EditPassword.presenter;

import android.app.Activity;
import android.util.ArrayMap;
import android.widget.EditText;

import ps.ns.eatapp.R;
import ps.ns.eatapp.feature.EditPassword.view.EditPasswordView;
import ps.ns.eatapp.ui.MyAccountActivity;
import ps.ns.eatapp.utils.AppSharedMethod;

import static ps.ns.eatapp.utils.ConstantApp.FROM_EDIT_ACCOUNT;

public class EditPasswordPresenter {
    private Activity mActivity;
    private EditPasswordView mView;

    public EditPasswordPresenter(Activity mActivity, EditPasswordView mView) {
        this.mActivity = mActivity;
        this.mView = mView;
    }

    public void goToMyAccount() {
        mActivity.startActivity(MyAccountActivity.newInstance(mActivity, FROM_EDIT_ACCOUNT));
    }


    public void validationInputs(EditText etCurrentPassword, EditText etNewPassword, EditText etConfirmPassword) {

        if (AppSharedMethod.isEmptyEditText(etCurrentPassword)) {
            AppSharedMethod.setErrorEditText(etCurrentPassword, mActivity.getString(R.string.enter_currentPassword));
            return;
        }

        if (AppSharedMethod.isEmptyEditText(etNewPassword)) {
            AppSharedMethod.setErrorEditText(etNewPassword, mActivity.getString(R.string.enter_new_password));
            return;
        }

        if (AppSharedMethod.getTextFromEditText(etNewPassword).length() < 8) {
            AppSharedMethod.setErrorEditText(etNewPassword, mActivity.getString(R.string.password_less));
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

        if (!AppSharedMethod.getTextFromEditText(etNewPassword).equals(AppSharedMethod.getTextFromEditText(etConfirmPassword))) {
            AppSharedMethod.setErrorEditText(etConfirmPassword, mActivity.getString(R.string.password_not_match));
            return;
        }

        ArrayMap<String, Object> params = new ArrayMap<>();

        params.put("currentPassword", AppSharedMethod.getTextFromEditText(etCurrentPassword));
        params.put("newPassword", AppSharedMethod.getTextFromEditText(etNewPassword));
        params.put("confirmPassword", AppSharedMethod.getTextFromEditText(etConfirmPassword));

        ChangePasswordRequest();
    }

    private void ChangePasswordRequest() {
    }
}
