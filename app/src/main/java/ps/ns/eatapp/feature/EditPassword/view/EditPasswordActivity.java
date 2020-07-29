package ps.ns.eatapp.feature.EditPassword.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import ps.ns.eatapp.R;
import ps.ns.eatapp.databinding.ActivityEditPasswordBinding;
import ps.ns.eatapp.feature.EditPassword.presenter.EditPasswordPresenter;
import ps.ns.eatapp.ui.MyAccountActivity;

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
    }

    private void initViews() {
    }

    private void initPresenter() {
        presenter = new EditPasswordPresenter(this, this);
    }


    private void listenerViews() {
        binding.bntSave.setOnClickListener(v -> presenter.validationInputs(binding.etCurrentPassword, binding.etNewPassword, binding.etRepeatPassword));
        binding.ibBack.setOnClickListener(v -> {
            startActivity(new Intent(EditPasswordActivity.this, MyAccountActivity.class));
        });
    }


    @Override
    public void formData(String currentPassword, String newPassword, String confirmPassword) {
        Log.e("changePassword", "current " + currentPassword + "new" + newPassword +"con" + confirmPassword);

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