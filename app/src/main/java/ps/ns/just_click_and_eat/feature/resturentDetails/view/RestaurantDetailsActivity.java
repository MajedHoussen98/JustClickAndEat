package ps.ns.just_click_and_eat.feature.resturentDetails.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.databinding.ActivityResturentDetailsBinding;
import ps.ns.just_click_and_eat.feature.mainHome.view.MainActivity;
import ps.ns.just_click_and_eat.feature.resturentDetails.presenter.RestaurantDetailsPresenter;
import ps.ns.just_click_and_eat.feature.verfication.view.VerificationActivity;
import ps.ns.just_click_and_eat.network.asp.model.HomeActivity.Home;
import ps.ns.just_click_and_eat.network.asp.model.HomeActivity.ImageRestaurant;
import ps.ns.just_click_and_eat.utils.AppSharedData;
import ps.ns.just_click_and_eat.utils.BaseActivity;

import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_WHERE;

public class RestaurantDetailsActivity extends BaseActivity implements RestaurantView {

    private ActivityResturentDetailsBinding binding;
    List<SlideModel> list = new ArrayList<>();
    private RestaurantDetailsPresenter presenter;
    int restaurantId;

    public static Intent newInstance(Activity mActivity, int fromWhere) {
        Intent intent = new Intent(mActivity, RestaurantDetailsActivity.class);
        intent.putExtra(FROM_WHERE, fromWhere);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResturentDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        intViews();
        listenerViews();
    }

    private void intViews() {
        presenter = new RestaurantDetailsPresenter(this, this);
        getDetailsRestaurant();

    }


    private void listenerViews() {
        binding.ibBack.setOnClickListener(v -> presenter.goToHome());
        binding.btnMenu.setOnClickListener(v -> presenter.goToMenu(restaurantId));
    }

    private void getDetailsRestaurant() {
        restaurantId = getIntent().getExtras().getInt("restaurant_id");
        presenter.getRestaurantById(restaurantId,
                AppSharedData.getUserInfo().getTokenData().getAccessToken(),
                binding.tvResturantName,
                binding.tvAddress,
                binding.ratingBar,
                binding.tvRatingValue,
                binding.tvResturantAddress,
                binding.tvMobileNumber,
                binding.tvStatus,
                binding.tvCategory,
                binding.tvWorkTime,
                binding.tvFeatures,
                binding.nested,
                binding.appbar,
                binding.progressBar,
                list,
                binding.imageSlider);
    }


}