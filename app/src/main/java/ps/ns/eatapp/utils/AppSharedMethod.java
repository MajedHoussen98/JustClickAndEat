package ps.ns.eatapp.utils;

import android.text.TextUtils;
import android.util.Patterns;
import android.widget.EditText;

import com.mukesh.OtpView;

public class AppSharedMethod {

    //TODO: Check Edit Text
    public static boolean checkEditText(EditText editText){
        return TextUtils.isEmpty(editText.getText().toString().trim());
    }

    //TODO: Check Email Patterns
    public static boolean checkEmailPatterns(EditText editText){
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

}
