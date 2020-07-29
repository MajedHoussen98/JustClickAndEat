package ps.ns.eatapp.feature.editAccount.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import ps.ns.eatapp.R;
import ps.ns.eatapp.databinding.ActivityEditAccountBinding;
import ps.ns.eatapp.feature.editAccount.presenter.EditAccountPresenter;
import ps.ns.eatapp.ui.MyAccountActivity;

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
    }

    private void initViews() {
    }


    private void initPresenter() {
        presenter = new EditAccountPresenter(this, this);
    }

    private void initListener() {
        binding.bntSave.setOnClickListener(v -> presenter.validationInput(String.valueOf(binding.ivUser), binding.etName, binding.etEmail));
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