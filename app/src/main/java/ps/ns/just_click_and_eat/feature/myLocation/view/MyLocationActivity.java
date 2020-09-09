package ps.ns.just_click_and_eat.feature.myLocation.view;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.feature.myLocation.adapter.MyLocationAdapter;
import ps.ns.just_click_and_eat.databinding.ActivityMyLocationBinding;
import ps.ns.just_click_and_eat.feature.myLocation.presenter.MyLocationPresenter;
import ps.ns.just_click_and_eat.network.asp.model.MyLocation;
import ps.ns.just_click_and_eat.utils.AppSharedData;
import ps.ns.just_click_and_eat.utils.AppSharedMethod;
import ps.ns.just_click_and_eat.utils.BaseActivity;

import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_WHERE;

public class MyLocationActivity extends BaseActivity implements MyLocationAdapter.ListItemClickListener, MyLocationView {
    private ActivityMyLocationBinding binding;
    private MyLocationPresenter presenter;
    private int CODE;

    public static Intent newInstance(Activity mActivity, int fromWhere) {
        Intent intent = new Intent(mActivity, MyLocationActivity.class);
        intent.putExtra(FROM_WHERE, fromWhere);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyLocationBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initViews();
        listenerViews();
        AppSharedMethod.statusBarLight(this);
    }

    private void initViews() {
        presenter = new MyLocationPresenter(this, this);
        presenter.getMyLocation(AppSharedData.getUserInfo().getTokenData().getAccessToken(), binding.rvLocation, binding.progressBar);
        CODE = getIntent().getExtras().getInt("CODE");
    }

    private void listenerViews() {
        if (CODE == 1){
            binding.ibBack.setOnClickListener(v -> presenter.goTOMyAccount());
        }else {
            binding.ibBack.setOnClickListener(v -> presenter.goTOHome());
        }
        binding.btnAddAddress.setOnClickListener(v -> presenter.goToAddLocation());
    }

    @Override
    public void onListItemClicked(int position, int viewId) {
    }


    @Override
    public void showMessage(String msg) {
        super.showMessage(msg);
        snackErrorShow(binding.getRoot(), msg);
    }
}