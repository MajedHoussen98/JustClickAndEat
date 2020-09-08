package ps.ns.just_click_and_eat.feature.editAccount.presenter;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

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
    private int REQUEST_IMAGE = 100;
    private Bitmap bitmap;


    public EditAccountPresenter(Activity mActivity, EditAccountView mView) {
        this.mActivity = mActivity;
        this.mView = mView;
    }

    public void goToMyAccount() {
        mActivity.startActivity(MyAccountActivity.newInstance(mActivity, FROM_EDIT_ACCOUNT));
    }

    public void selectImage() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT).setType("image/*");
        mActivity.startActivityForResult(Intent.createChooser(intent, "Select Image"), REQUEST_IMAGE);
    }

    public void validationInput(EditText etName, ImageView userImage) {
        if (AppSharedMethod.isEmptyEditText(etName)) {
            AppSharedMethod.setErrorEditText(etName, mActivity.getString(R.string.enter_name));
            return;
        }
        BitmapDrawable drawable = (BitmapDrawable) userImage.getDrawable();
        bitmap = drawable.getBitmap();
        ArrayMap<String, String> params = new ArrayMap<>();
        params.put("name", AppSharedMethod.getTextFromEditText(etName));
        editAccountRequest(
                AppSharedData.getUserInfo().getTokenData().getAccessToken(),
                params,
                AppSharedMethod.bitmapToMultipartBodyPart(bitmap, "photo"));
    }

    private void editAccountRequest(String token, ArrayMap<String, String> params, MultipartBody.Part part) {
        mView.showProgress();
        NetworkShared.getAsp().getUser().updateProfile(token, params, part, new RequestListener<String>() {
            @Override
            public void onSuccess(String data) {
                mView.hideProgress();
                mView.showMessage("Success Update...");
            }

            @Override
            public void onFail(String message, int code) {
                mView.hideProgress();
                mView.showMessage(message);
            }
        });
    }

}
