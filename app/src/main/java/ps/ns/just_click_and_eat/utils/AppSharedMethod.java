package ps.ns.just_click_and_eat.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import androidx.annotation.RequiresApi;
import com.mukesh.OtpView;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import ps.ns.just_click_and_eat.R;
import static com.facebook.FacebookSdk.getCacheDir;

public class AppSharedMethod {

    //TODO: Check Edit Text
    public static boolean isEmptyEditText(EditText editText) {
        return TextUtils.isEmpty(editText.getText().toString().trim());
    }

    //TODO: Check Email Patterns
    public static boolean isInvalidEmail(EditText editText) {
        return !Patterns.EMAIL_ADDRESS.matcher(editText.getText().toString().trim()).matches();
    }

    //TODO: Get Text From Edit Text
    public static String getTextFromEditText(EditText editText) {
        return editText.getText().toString().trim();
    }

    //TODO: Check Otp (Verification)
    public static boolean checkOtpView(OtpView otpView) {
        return TextUtils.isEmpty(otpView.getText().toString().trim());
    }

    //TODO: Get Text From Otp (Verification)
    public static String getTextFromOtp(OtpView otpView) {
        return otpView.getText().toString().trim();
    }


    //TODO: Set Error EditText
    public static void setErrorEditText(EditText editText, String message) {
        editText.setError(message);
        editText.requestFocus();
    }

    //TODO: Set Error Code
    public static void setErrorVerification(OtpView otpView, String message) {
        otpView.setError(message);
        otpView.requestFocus();
    }

    //TODO: Set Status Bar Light
    public static void statusBarLight(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            activity.getWindow().setStatusBarColor(activity.getResources().getColor(R.color.whiteColor, activity.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().setStatusBarColor(activity.getResources().getColor(R.color.whiteColor));
        }
    }

    //TODO: Hide Status Bar
    public static void statusBarHide(View view) {
        view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    //TODO: Set Status Bar Transparent
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void statusTRANSPARENT(Activity activity) {
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
    }

    //TODO: Show Status Bar
    public static void statusBarShow(Activity activity) {
        activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }


    //TODO: Convert Bitmap to MultiPart
    public static MultipartBody.Part bitmapToMultipartBodyPart(Bitmap bitmap, String name) {
        if (bitmap == null) {
            return null;
        }
        //create a file to write bitmap data
        int iUniqueId = (int) (System.currentTimeMillis() & 0xfffffff);
        File file = new File(getCacheDir(), iUniqueId + ".jpg");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Convert bitmap to byte array
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
        byte[] bitmapdata = bos.toByteArray();

        //write the bytes in file
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            fos.write(bitmapdata);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //pass it like this
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        return MultipartBody.Part.createFormData(name, file.getName(), requestFile);
    }


}
