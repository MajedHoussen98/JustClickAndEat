package ps.ns.just_click_and_eat.feature.editPassword.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import ps.ns.just_click_and_eat.databinding.ActivityEditPasswordBinding;
import ps.ns.just_click_and_eat.feature.editPassword.presenter.EditPasswordPresenter;
import ps.ns.just_click_and_eat.utils.AppSharedMethod;

public class EditPasswordActivity extends AppCompatActivity implements EditPasswordView {
    private EditPasswordPresenter presenter;
    private ActivityEditPasswordBinding binding;

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
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showMessage(String msg) {
    }
}