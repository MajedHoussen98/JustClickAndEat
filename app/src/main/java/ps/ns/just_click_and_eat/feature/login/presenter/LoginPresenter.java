package ps.ns.just_click_and_eat.feature.login.presenter;

import android.app.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.se.omapi.Session;
import android.util.ArrayMap;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.internal.ImageRequest;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import ps.ns.just_click_and_eat.feature.login.view.LoginActivity;
import ps.ns.just_click_and_eat.feature.mainHome.view.MainActivity;
import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.feature.forgetPassword.view.ForgetPasswordActivity;
import ps.ns.just_click_and_eat.feature.login.view.LoginView;
import ps.ns.just_click_and_eat.feature.signUp.view.SignUpActivity;
import ps.ns.just_click_and_eat.utils.AppSharedMethod;
import ps.ns.just_click_and_eat.utils.BaseActivity;
import ps.ns.just_click_and_eat.utils.SharedPreferencesManager;

import static androidx.constraintlayout.widget.Constraints.TAG;
import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_LOGIN;

public class LoginPresenter {

    private LoginView mView;
    private Activity mActivity;
    private BaseActivity activity = new BaseActivity();


    public LoginPresenter(Activity mActivity, LoginView mView) {
        this.mView = mView;
        this.mActivity = mActivity;
    }

    public void goToSignUp() {
        mActivity.startActivity(SignUpActivity.newInstance(mActivity, FROM_LOGIN));
    }

    public void goToForget() {
        mActivity.startActivity(ForgetPasswordActivity.newInstance(mActivity, FROM_LOGIN));
    }

    public void goToMainActivity() {
        mActivity.startActivity(MainActivity.newInstance(mActivity, FROM_LOGIN));
    }

    public void signInWithFacebook(CallbackManager callBackManager) {

            LoginManager.getInstance().logInWithReadPermissions(mActivity, Arrays.asList("email", "public_profile"));
            LoginManager.getInstance().registerCallback(callBackManager,
                    new FacebookCallback<LoginResult>() {
                        @Override
                        public void onSuccess(LoginResult loginResult) {
                            setGraphRequest(loginResult);
                            checkTokenSignIn();
                        }

                        @Override
                        public void onCancel() {
                        }

                        @Override
                        public void onError(FacebookException exception) {
                            mView.showMessage("No internet connection please try again...");
                        }
                    });
        }

    public void validateInputs(TextInputEditText etEmail, TextInputEditText etPassword) {
        if (AppSharedMethod.isEmptyEditText(etEmail)) {
            AppSharedMethod.setErrorEditText(etEmail, mActivity.getString(R.string.emty_email));
            return;
        }
        if (AppSharedMethod.isInvalidEmail(etEmail)) {
            AppSharedMethod.setErrorEditText(etEmail, mActivity.getString(R.string.errorEmail));
            return;
        }
        if (AppSharedMethod.isEmptyEditText(etPassword)) {
            AppSharedMethod.setErrorEditText(etPassword, mActivity.getString(R.string.enter_password));
            return;
        }
        ArrayMap<String, Object> params = new ArrayMap<>();
        params.put("email", AppSharedMethod.getTextFromEditText(etEmail));
        params.put("password", AppSharedMethod.getTextFromEditText(etPassword));
        loginRequest(params);
    }

    private void setGraphRequest(LoginResult loginResult) {
        getProfileImage();
        GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                try {
                    SharedPreferencesManager.savedUserEmail(mActivity, object.getString("email"));
                    goToMainActivity();
                    mActivity.finish();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        Bundle bundle = new Bundle();
        bundle.putString("fields", "email");
        request.setParameters(bundle);
        request.executeAsync();
    }

    private void checkTokenSignIn() {
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();
        assert accessToken != null;
        // Log.e("KEY", "" + accessToken.getToken());
        if (isLoggedIn) {
            SharedPreferencesManager.saveUser(mActivity, accessToken.getToken(), true);
            mActivity.finish();
        }
    }

    private void getProfileImage() {
        Profile profile = Profile.getCurrentProfile();
        if (profile != null) {
            String profileImage = profile.getProfilePictureUri(300, 300).toString();
            String fullName = profile.getName();
            SharedPreferencesManager.profileDataUserSaved(mActivity, profileImage, fullName);
        }
    }

    private void loginRequest(ArrayMap<String, Object> params) {
        if (mView != null) {
            mView.showProgress();
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mView != null) {
                    mView.hideProgress();
                }
            }
        }, 3000);
        mActivity.startActivity(MainActivity.newInstance(mActivity, FROM_LOGIN));
    }

}
