package ps.ns.just_click_and_eat.feature.editAccount.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;

import ps.ns.just_click_and_eat.databinding.ActivityEditAccountBinding;
import ps.ns.just_click_and_eat.feature.editAccount.presenter.EditAccountPresenter;
import ps.ns.just_click_and_eat.utils.AppSharedMethod;
import ps.ns.just_click_and_eat.utils.AppSharedData;

public class EditAccountActivity extends AppCompatActivity implements EditAccountView {

    private ActivityEditAccountBinding binding;
    private EditAccountPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditAccountBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initViews();
        initPresenter();
        initListener();
        AppSharedMethod.statusBarLight(this);

    }

    private void initViews() {
        Glide.with(this).load(AppSharedData.getProfileDataUser(EditAccountActivity.this).getString("profile_image", "profile_image")).into(binding.ivUser);
        binding.etName.setText(AppSharedData.getProfileDataUser(EditAccountActivity.this).getString("user_name", "user_name"));
    }


    private void initPresenter() {
        presenter = new EditAccountPresenter(this, this);
    }

    private void initListener() {
        binding.bntSave.setOnClickListener(v -> presenter.validationInput(String.valueOf(binding.ivUser), binding.etName));
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