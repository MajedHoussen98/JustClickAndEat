package ps.ns.just_click_and_eat.feature.addLocation.view;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.Objects;

import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.databinding.ActivityAddLocationBinding;
import ps.ns.just_click_and_eat.feature.addLocation.presenter.AddLocationPresenter;
import ps.ns.just_click_and_eat.utils.AppSharedData;
import ps.ns.just_click_and_eat.utils.AppSharedMethod;
import ps.ns.just_click_and_eat.utils.BaseActivity;

import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_WHERE;

public class AddLocationActivity extends BaseActivity implements AddLocationView {

    private ActivityAddLocationBinding binding;
    private AddLocationPresenter presenter;
    int LAUNCH_MAPS_ACTIVITY = 1;
    private Double lat, log;
    private int makeDefault = 0, icDelete, locationId;
    private String locationName, addressDetails;

    public static Intent newInstance(Activity mActivity, int fromWhere) {
        Intent intent = new Intent(mActivity, AddLocationActivity.class);
        intent.putExtra(FROM_WHERE, fromWhere);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddLocationBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initView();
        listenerViews();
        AppSharedMethod.statusBarLight(this);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == LAUNCH_MAPS_ACTIVITY) {
            if (resultCode == Activity.RESULT_OK) {
                assert data != null;
                lat = data.getDoubleExtra("lat", 0.1);
                log = data.getDoubleExtra("long", 0.1);
                addressDetails = data.getStringExtra("details");
            }
        }
    }


    private void initView() {
        presenter = new AddLocationPresenter(this, this);
        icDelete = getIntent().getExtras().getInt("icDelete");
        showIconDelete();
        getDataFromIntent();
        setDefaultLocation();
    }


    private void listenerViews() {
        binding.rgMakeDefault.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_make_default) {
                    makeDefault = 1;
                }
            }
        });
        binding.ibBack.setOnClickListener(v -> presenter.goToMyLocation());
        binding.btnUseMap.setOnClickListener(v -> presenter.goToMap(LAUNCH_MAPS_ACTIVITY, addressDetails));
        binding.btnSaveAddress.setOnClickListener(v -> presenter.validationInputs(locationId, icDelete, binding.etAddressName, addressDetails, lat, log, makeDefault));
        binding.btnDelete.setOnClickListener(v -> presenter.deleteLocation(AppSharedData.getUserInfo().getTokenData().getAccessToken(), locationId));
    }

    private void showIconDelete() {
        if (icDelete == 0) {
            binding.btnDelete.setVisibility(View.GONE);
        } else if (icDelete == 1) {
            binding.btnDelete.setVisibility(View.VISIBLE);
            binding.btnSaveAddress.setText(R.string.save_change);
        }
    }

    private void getDataFromIntent() {
        locationId = Objects.requireNonNull(getIntent().getExtras()).getInt("id");
        locationName = getIntent().getExtras().getString("locationName");
        addressDetails = getIntent().getExtras().getString("details");
        lat = getIntent().getExtras().getDouble("lat");
        log = getIntent().getExtras().getDouble("log");
    }

    private void setDefaultLocation() {
        makeDefault = Objects.requireNonNull(getIntent().getExtras()).getInt("isDefault");
        binding.etAddressName.setText(locationName);
        if (makeDefault == 1) {
            binding.rbMakeDefault.setChecked(true);
        } else {
            binding.rbMakeDefault.setChecked(false);
        }
    }
}