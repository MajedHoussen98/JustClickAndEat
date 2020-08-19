package ps.ns.just_click_and_eat.feature.myAccount.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ps.ns.just_click_and_eat.feature.mainHome.view.MainActivity;
import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.databinding.ActivityMyAccountBinding;
import ps.ns.just_click_and_eat.feature.editPassword.view.EditPasswordActivity;
import ps.ns.just_click_and_eat.feature.editAccount.view.EditAccountActivity;
import ps.ns.just_click_and_eat.feature.favorites.Favorites;
import ps.ns.just_click_and_eat.feature.myLocation.view.MyLocationActivity;
import ps.ns.just_click_and_eat.utils.AppSharedMethod;

import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_WHERE;

public class MyAccountActivity extends AppCompatActivity implements View.OnClickListener {
    private View view;
    private ActivityMyAccountBinding binding;

    public static Intent newInstance(Activity mActivity, int fromWhere) {
        Intent intent = new Intent(mActivity, MyAccountActivity.class);
        intent.putExtra(FROM_WHERE, fromWhere);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyAccountBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        setContentView(view);
        viewListener();
        AppSharedMethod.statusBarLight(this);

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