package ps.ns.eatapp.feature.editAccount.presenter;

import android.app.Activity;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.widget.EditText;
import android.widget.Toast;

import ps.ns.eatapp.R;
import ps.ns.eatapp.feature.editAccount.view.EditAccountView;
import ps.ns.eatapp.ui.MyAccountActivity;
import ps.ns.eatapp.utils.AppSharedMethod;

import static ps.ns.eatapp.utils.ConstantApp.FROM_EDIT_ACCOUNT;

public class EditAccountPresenter {

    private Activity mActivity;
    private EditAccountView mView;

    public EditAccountPresenter(Activity mActivity, EditAccountView mView) {
        this.mActivity = mActivity;
        this.mView = mView;
    }

    public void goToMyAccount() {
        mActivity.startActivity(MyAccountActivity.newInstance(mActivity, FROM_EDIT_ACCOUNT));
    }

    public void validationInput(String image, EditText etName, EditText etEmail) {
        if (TextUtils.isEmpty(image)) {
            return;
        }

        if (AppSharedMethod.isEmptyEditText(etName)) {
            AppSharedMethod.setErrorEditText(etName, mActivity.getString(R.string.enter_name));
            return;
        }

        if (AppSharedMethod.isEmptyEditText(etEmail)) {
            AppSharedMethod.setErrorEditText(etEmail, mActivity.getString(R.string.emty_email));

            return;
        }

        if (AppSharedMethod.isInvalidEmail(etEmail)) {
            AppSharedMethod.setErrorEditText(etEmail, mActivity.getString(R.string.errorEmail));
            return;
        }


        ArrayMap<String, Object> params = new ArrayMap<>();

        params.put("image", image);
        params.put("name", AppSharedMethod.getTextFromEditText(etName));
        params.put("email", AppSharedMethod.getTextFromEditText(etEmail));

        editAccountRequest();

    }

    private void editAccountRequest() {
    }
}
