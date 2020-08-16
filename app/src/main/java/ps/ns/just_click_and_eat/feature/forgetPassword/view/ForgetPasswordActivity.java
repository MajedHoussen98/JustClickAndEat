package ps.ns.just_click_and_eat.feature.forgetPassword.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ps.ns.just_click_and_eat.databinding.ActivityForgetPasswordBinding;
import ps.ns.just_click_and_eat.feature.forgetPassword.presenter.ForgetPasswordPresenter;
import ps.ns.just_click_and_eat.utils.BaseActivity;

import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_WHERE;

public class ForgetPasswordActivity extends BaseActivity implements ForgetPasswordView {

    private ActivityForgetPasswordBinding binding;
    private ForgetPasswordPresenter presenter;

    public static Intent newInstance(Activity mActivity, int fromWhere) {
        Intent intent = new Intent(mActivity, ForgetPasswordActivity.class);
        intent.putExtra(FROM_WHERE, fromWhere);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForgetPasswordBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initViews();
        initPresenter();
        initListener();

    }

    private void initViews() {
    }

    private void initPresenter() {
        presenter = new ForgetPasswordPresenter(this, this);
    }

    private void initListener() {
        binding.btnSend.setOnClickListener(v -> presenter.validationInputs(binding.etEmail));
    }

}