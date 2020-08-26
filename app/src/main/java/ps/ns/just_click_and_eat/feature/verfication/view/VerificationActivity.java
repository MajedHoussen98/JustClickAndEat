package ps.ns.just_click_and_eat.feature.verfication.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.ArrayMap;

import ps.ns.just_click_and_eat.databinding.ActivityVerificationCodeBinding;
import ps.ns.just_click_and_eat.feature.verfication.verficationPresenter.VerificationPresenter;
import ps.ns.just_click_and_eat.utils.BaseActivity;

import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_WHERE;

public class VerificationActivity extends BaseActivity implements VerificationView {


    private ActivityVerificationCodeBinding binding;
    private VerificationPresenter presenter;
    private int userId;
    private String userEmail, userMobile;
    private ArrayMap<String, Object> paramsEmail;


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
        userId = getIntent().getExtras().getInt("user_id");
        userEmail = getIntent().getExtras().getString("email");
        userMobile = getIntent().getExtras().getString("mobile");

        binding.tvMobileNumber.setText(userMobile);

        paramsEmail = new ArrayMap<>();
        paramsEmail.put("user_id", userId);
        paramsEmail.put("email", userEmail);



    }

    private void initPresenter() {
        presenter = new VerificationPresenter(this, this);
    }

    private void initListener() {
        binding.otpView.setOtpCompletionListener(otp -> presenter.validationInputs(binding.otpView));
        binding.verificationByEmail.setOnClickListener(v -> {
            presenter.verificationRequest(paramsEmail);
        });
    }

//    private void verificationByEmail() {
//
//   }

    @Override
    public void showMessage(String msg) {
        super.showMessage(msg);
        snackErrorShow(binding.getRoot() , msg);
    }

}