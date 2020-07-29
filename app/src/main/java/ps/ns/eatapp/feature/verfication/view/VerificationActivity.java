package ps.ns.eatapp.feature.verfication.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.mukesh.OnOtpCompletionListener;

import ps.ns.eatapp.databinding.ActivityVerificationCodeBinding;
import ps.ns.eatapp.feature.verfication.verficationPresenter.VerificationPresenter;

public class VerificationActivity extends AppCompatActivity implements VerificationView {


    private ActivityVerificationCodeBinding binding;
    private VerificationPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVerificationCodeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initViews();
        initPresenter();
        listenerViews();
    }

    private void initViews() {
    }

    private void initPresenter() {
        presenter = new VerificationPresenter(this, this);
    }

    private void listenerViews() {
        presenter.validationInputs(binding.otpView);
    }


    @Override
    public void formData(String code) {
        Log.e("code", "code: " + code);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showMessage(String msg) {

    }
}