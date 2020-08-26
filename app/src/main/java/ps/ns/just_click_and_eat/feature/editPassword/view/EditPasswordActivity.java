package ps.ns.just_click_and_eat.feature.editPassword.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ps.ns.just_click_and_eat.databinding.ActivityEditPasswordBinding;
import ps.ns.just_click_and_eat.feature.editPassword.presenter.EditPasswordPresenter;
import ps.ns.just_click_and_eat.feature.signUp.view.SignUpActivity;
import ps.ns.just_click_and_eat.utils.AppSharedMethod;
import ps.ns.just_click_and_eat.utils.BaseActivity;

import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_WHERE;

public class EditPasswordActivity extends BaseActivity implements EditPasswordView {
    private EditPasswordPresenter presenter;
    private ActivityEditPasswordBinding binding;

    public static Intent newInstance(Activity mActivity, int fromWhere) {
        Intent intent = new Intent(mActivity, EditPasswordActivity.class);
        intent.putExtra(FROM_WHERE, fromWhere);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditPasswordBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initViews();
        initPresenter();
        listenerViews();
        AppSharedMethod.statusBarLight(this);

    }

    private void initViews() {
    }


    private void initPresenter() {
        presenter = new EditPasswordPresenter(this, this);
    }


    private void listenerViews() {
        binding.bntSave.setOnClickListener(v -> presenter.validationInputs(binding.etCurrentPassword, binding.etNewPassword, binding.etRepeatPassword));
        binding.ibBack.setOnClickListener(v -> presenter.goToMyAccount());
    }

    @Override
    public void showMessage(String msg) {
        super.showMessage(msg);
        snackErrorShow(binding.getRoot(), msg);
    }
}