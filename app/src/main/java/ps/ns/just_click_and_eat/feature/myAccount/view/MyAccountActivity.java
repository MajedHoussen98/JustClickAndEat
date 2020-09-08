package ps.ns.just_click_and_eat.feature.myAccount.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ps.ns.just_click_and_eat.databinding.ActivityMyAccountBinding;
import ps.ns.just_click_and_eat.feature.myAccount.presenter.MyAccountPresenter;
import ps.ns.just_click_and_eat.utils.AppSharedMethod;
import ps.ns.just_click_and_eat.utils.BaseActivity;

import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_WHERE;

public class MyAccountActivity extends BaseActivity implements MyAccountView {

    private ActivityMyAccountBinding binding;
    private MyAccountPresenter presenter;

    public static Intent newInstance(Activity mActivity, int fromWhere) {
        Intent intent = new Intent(mActivity, MyAccountActivity.class);
        intent.putExtra(FROM_WHERE, fromWhere);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyAccountBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initPresenter();
        viewListener();
        AppSharedMethod.statusBarLight(this);

    }

    public void initPresenter(){
        presenter = new MyAccountPresenter(this, this);
    }

    private void viewListener() {
        binding.ibBack.setOnClickListener(v -> presenter.goToHome());
        binding.llEditAccount.setOnClickListener(v -> presenter.goToEditAccount());
        binding.llChangePassword.setOnClickListener(v -> presenter.goToChangePassword());
        binding.llEditAddress.setOnClickListener(v -> presenter.goToAddress());
        binding.llFavorites.setOnClickListener(v -> presenter.goToFavorites());
    }

}