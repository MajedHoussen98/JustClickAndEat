package ps.ns.eatapp.feature.verfication.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.mukesh.OnOtpCompletionListener;

import ps.ns.eatapp.databinding.ActivityVerificationCodeBinding;
import ps.ns.eatapp.feature.login.view.LoginActivity;
import ps.ns.eatapp.feature.verfication.verficationPresenter.VerificationPresenter;

import static ps.ns.eatapp.utils.ConstantApp.FROM_WHERE;

public class VerificationActivity extends AppCompatActivity implements VerificationView {


    private ActivityVerificationCodeBinding binding;
    private VerificationPresenter presenter;


    public static Intent newInstance(Activity mActivity, int fromWhere) {
        Intent intent = new Intent(mActivity, VerificationActivity.class);
        intent.putExtra(FROM_WHERE, fromWhere);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVerificationCodeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initViews();
        initPresenter();
        initListener();

    }

    private void initViews() {
    }

    private void initPresenter() {
        presenter = new VerificationPresenter(this, this);
    }

    private void initListener() {
        binding.otpView.setOtpCompletionListener(otp -> presenter.validationInputs(binding.otpView));
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