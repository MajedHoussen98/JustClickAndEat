package ps.ns.just_click_and_eat.feature.editPassword.presenter;

import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;

import androidx.collection.ArrayMap;

import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.feature.editPassword.view.EditPasswordView;
import ps.ns.just_click_and_eat.feature.mainHome.view.MainActivity;
import ps.ns.just_click_and_eat.feature.myAccount.view.MyAccountActivity;
import ps.ns.just_click_and_eat.network.asp.feature.NetworkShared;
import ps.ns.just_click_and_eat.network.utils.RequestListener;
import ps.ns.just_click_and_eat.utils.AppSharedData;
import ps.ns.just_click_and_eat.utils.AppSharedMethod;

import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_EDIT_ACCOUNT;

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

        ArrayMap<String, String> params = new ArrayMap<>();

        params.put("old_password", AppSharedMethod.getTextFromEditText(etCurrentPassword));
        params.put("new_password", AppSharedMethod.getTextFromEditText(etNewPassword));
        params.put("confirm_password", AppSharedMethod.getTextFromEditText(etConfirmPassword));


        ChangePasswordRequest(AppSharedData.getUserInfo().getTokenData().getAccessToken(), params);
    }

    private void ChangePasswordRequest(String token, ArrayMap<String, String> params) {
        mView.showProgress();
        NetworkShared.getAsp().getUser().updatePassword(token, params, new RequestListener<String>() {
            @Override
            public void onSuccess(String data) {
                mView.hideProgress();
                mView.showMessage("Password changed...");
                mActivity.startActivity(new Intent(mActivity, MainActivity.class));
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
