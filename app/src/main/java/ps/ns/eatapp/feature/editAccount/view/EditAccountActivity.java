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
        listenerViews();
    }

    private void initViews() {
    }

    private void initPresenter() {
        presenter = new EditAccountPresenter(this, this);
    }

    private void listenerViews() {
        binding.bntSave.setOnClickListener(v -> presenter.validationInput(String.valueOf(binding.ivUser), binding.etName, binding.etEmail));
        binding.ibBack.setOnClickListener(v -> {startActivity(new Intent(EditAccountActivity.this, MyAccountActivity.class));});
    }


    @Override
    public void formData(String image, String name, String email) {
        Log.e("EditAccount", "image: " + image  + "name: " + name + "email: " + email);
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