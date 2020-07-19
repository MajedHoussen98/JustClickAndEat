package ps.ns.eatapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.mukesh.OnOtpCompletionListener;
import com.mukesh.OtpView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ps.ns.eatapp.databinding.ActivityVerificationCodeBinding;

public class VerificationCode extends AppCompatActivity {


    private ActivityVerificationCodeBinding binding;


//    private Activtity binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVerificationCodeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.otpView.setOtpCompletionListener(new OnOtpCompletionListener() {
            @Override public void onOtpCompleted(String otp) {
                // do Stuff
                Log.d("onOtpCompleted=>", otp);
            }
        });
    }
}