package ps.ns.just_click_and_eat.utils;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import com.mukesh.OtpView;

import ps.ns.just_click_and_eat.R;

public class AppSharedMethod {

    //TODO: Check Edit Text
    public static boolean isEmptyEditText(EditText editText){
        return TextUtils.isEmpty(editText.getText().toString().trim());
    }

    //TODO: Check Email Patterns
    public static boolean isInvalidEmail(EditText editText){
        return !Patterns.EMAIL_ADDRESS.matcher(editText.getText().toString().trim()).matches();
    }

    //TODO: Get Text From Edit Text
    public static String getTextFromEditText(EditText editText){
        return editText.getText().toString().trim();
   }

    //TODO: Check Otp (Verification)
    public static boolean checkOtpView(OtpView otpView){
        return TextUtils.isEmpty(otpView.getText().toString().trim());
    }

    //TODO: Get Text From Otp (Verification)
    public static String getTextFromOtp(OtpView otpView){
        return otpView.getText().toString().trim();
    }


    //TODO: Set Error EditText
    public static void setErrorEditText(EditText editText, String message){
        editText.setError(message);
        editText.requestFocus();
    }

    //TODO: Set Error Code
    public static void setErrorVerification(OtpView otpView, String message){
        otpView.setError(message);
        otpView.requestFocus();
    }


    public static void statusBarLight(Activity activity){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            activity.getWindow().setStatusBarColor(activity.getResources().getColor(R.color.whiteColor, activity.getTheme()));

        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().setStatusBarColor(activity.getResources().getColor(R.color.whiteColor));
        }
    }


    public static void statusBarHide(View view){
        view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                  |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                                  |View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    public static void statusBarShow(Activity activity){
        activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
