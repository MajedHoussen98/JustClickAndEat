package ps.ns.eatapp.feature.editAccount.presenter;

import android.app.Activity;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.widget.EditText;
import android.widget.Toast;

import ps.ns.eatapp.R;
import ps.ns.eatapp.feature.editAccount.view.EditAccountView;
import ps.ns.eatapp.utils.AppSharedMethod;

public class EditAccountPresenter {

    private Activity mActivity;
    private EditAccountView mView;

    public EditAccountPresenter(Activity mActivity, EditAccountView mView) {
        this.mActivity = mActivity;
        this.mView = mView;
    }

    public void validationInput(String image, EditText etName, EditText etEmail){
        if (TextUtils.isEmpty(image)){
            Toast.makeText(mActivity, "Choose a picture please", Toast.LENGTH_SHORT).show();
            return;
        }
        
        if (AppSharedMethod.checkEditText(etName)){
            etName.setError(mActivity.getString(R.string.enter_name));
            etName.requestFocus();
            return;
        }

        if (AppSharedMethod.checkEditText(etEmail)) {
            etEmail.setError("Enter Your Email Please");
            etEmail.requestFocus();
            return;
        }

        if (AppSharedMethod.checkEmailPatterns(etEmail)) {
            etEmail.setError(mActivity.getString(R.string.errorEmail));
            return;
        }
        
        mView.formData(image, AppSharedMethod.getTextFromEditText(etName), AppSharedMethod.getTextFromEditText(etEmail));


        ArrayMap<String, Object> params = new ArrayMap<>();
        
        params.put("image", image);
        params.put("name", AppSharedMethod.getTextFromEditText(etName));
        params.put("email", AppSharedMethod.getTextFromEditText(etEmail));
        
        EditAccountRequest();
        
    }

    private void EditAccountRequest() {
    }
}
