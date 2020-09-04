package ps.ns.just_click_and_eat.feature.addLocation.view;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.databinding.ActivityAddLocationBinding;
import ps.ns.just_click_and_eat.feature.addLocation.presenter.AddLocationPresenter;
import ps.ns.just_click_and_eat.feature.myLocation.view.MyLocationActivity;
import ps.ns.just_click_and_eat.utils.AppSharedMethod;
import ps.ns.just_click_and_eat.utils.BaseActivity;
import ps.ns.just_click_and_eat.utils.BaseView;

import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_WHERE;

public class AddLocationActivity extends BaseActivity implements AddLocationView {

    private View view;
    private ActivityAddLocationBinding binding;
    private AddLocationPresenter presenter;

    public static Intent newInstance(Activity mActivity, int fromWhere) {
        Intent intent = new Intent(mActivity, AddLocationActivity.class);
        intent.putExtra(FROM_WHERE, fromWhere);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddLocationBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        setContentView(view);
        initView();
        listenerViews();
        AppSharedMethod.statusBarLight(this);

    }
    private void initView() {
        presenter = new AddLocationPresenter(this, this);
    }

    private void listenerViews() {
        binding.ibBack.setOnClickListener(v -> presenter.goToMyLocation());
        binding.btnUseMap.setOnClickListener(v -> presenter.goToMap());
        binding.btnSaveAddress.setOnClickListener(v -> presenter.validationInputs(binding.etAddressName));
    }

}