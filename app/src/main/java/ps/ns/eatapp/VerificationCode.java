package ps.ns.eatapp;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.mukesh.OnOtpCompletionListener;
import com.mukesh.OtpView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VerificationCode extends AppCompatActivity {

    @BindView(R.id.otp_view)
    OtpView otpView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_code);
        ButterKnife.bind(this);

        otpView.setOtpCompletionListener(new OnOtpCompletionListener() {
            @Override public void onOtpCompleted(String otp) {
                // do Stuff
                Log.d("onOtpCompleted=>", otp);
            }
        });
    }
}