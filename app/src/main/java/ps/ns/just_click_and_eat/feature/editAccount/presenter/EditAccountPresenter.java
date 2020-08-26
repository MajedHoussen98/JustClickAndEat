package ps.ns.just_click_and_eat.feature.editAccount.presenter;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.collection.ArrayMap;

import okhttp3.MultipartBody;
import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.feature.editAccount.view.EditAccountView;
import ps.ns.just_click_and_eat.feature.myAccount.view.MyAccountActivity;
import ps.ns.just_click_and_eat.network.asp.feature.NetworkShared;
import ps.ns.just_click_and_eat.network.utils.RequestListener;
import ps.ns.just_click_and_eat.utils.AppSharedData;
import ps.ns.just_click_and_eat.utils.AppSharedMethod;

import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_EDIT_ACCOUNT;

public class EditAccountPresenter {

    private Activity mActivity;
    private EditAccountView mView;
    private int REQUEST_IMAGE = 1;


    public EditAccountPresenter(Activity mActivity, EditAccountView mView) {
        this.mActivity = mActivity;
        this.mView = mView;
    }

    public void goToMyAccount() {
        mActivity.startActivity(MyAccountActivity.newInstance(mActivity, FROM_EDIT_ACCOUNT));
    }

//    public void selectImage() {
//        Intent intent = new Intent(Intent.ACTION_GET_CONTENT).setType("image/*");
//        mActivity.startActivityForResult(Intent.createChooser(intent, "Select Image"), REQUEST_IMAGE);
//    }

    public void validationInput(EditText etName) {

        if (AppSharedMethod.isEmptyEditText(etName)) {
            AppSharedMethod.setErrorEditText(etName, mActivity.getString(R.string.enter_name));
            return;
        }

        ArrayMap<String, Object> params = new ArrayMap<>();

        params.put("name", AppSharedMethod.getTextFromEditText(etName));
        params.put("mobile", AppSharedData.getUserInfo().getUserData().getMobile());


        // editAccountRequest(AppSharedData.getUserToken(mActivity), params);

    }

    private void editAccountRequest(String token, ArrayMap<String, String> params, MultipartBody.Part part) {

        NetworkShared.getAsp().getUser().updateProfile(token, params, part, new RequestListener<String>() {
            @Override
            public void onSuccess(String data) {

            }

            @Override
            public void onFail(String message, int code) {

            }
        });
    }
}
