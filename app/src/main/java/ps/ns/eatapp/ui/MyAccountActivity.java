package ps.ns.eatapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ps.ns.eatapp.MainActivity;
import ps.ns.eatapp.R;
import ps.ns.eatapp.databinding.ActivityMyAccountBinding;
import ps.ns.eatapp.feature.EditPassword.view.EditPasswordActivity;
import ps.ns.eatapp.feature.editAccount.view.EditAccountActivity;
import ps.ns.eatapp.ui.Favorites.Favorites;

public class MyAccountActivity extends AppCompatActivity implements View.OnClickListener {
    private View view;
    private ActivityMyAccountBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyAccountBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        setContentView(view);
        viewListener();
    }

    private void viewListener() {
        binding.ibBack.setOnClickListener(this);
        binding.llEditAccount.setOnClickListener(this);
        binding.llChangePassword.setOnClickListener(this);
        binding.llEditAddress.setOnClickListener(this);
        binding.llFavorites.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_edit_account:
                startActivity(new Intent(MyAccountActivity.this, EditAccountActivity.class));
                break;
            case R.id.ll_change_password:
                startActivity(new Intent(MyAccountActivity.this, EditPasswordActivity.class));
                break;
            case R.id.ll_edit_address:
                startActivity(new Intent(MyAccountActivity.this, MyLocationActivity.class));
                break;
            case R.id.ll_favorites:
                startActivity(new Intent(MyAccountActivity.this, Favorites.class));
                break;
            case R.id.ib_back:
                startActivity(new Intent(MyAccountActivity.this, MainActivity.class));
                finish();
        }
    }
}