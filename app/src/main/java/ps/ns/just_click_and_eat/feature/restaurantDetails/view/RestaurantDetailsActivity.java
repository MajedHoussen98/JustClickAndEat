package ps.ns.just_click_and_eat.feature.restaurantDetails.view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.RequiresApi;
import androidx.collection.ArrayMap;

import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

import ps.ns.just_click_and_eat.databinding.ActivityResturentDetailsBinding;
import ps.ns.just_click_and_eat.feature.restaurantDetails.presenter.RestaurantDetailsPresenter;
import ps.ns.just_click_and_eat.utils.AppSharedData;
import ps.ns.just_click_and_eat.utils.AppSharedMethod;
import ps.ns.just_click_and_eat.utils.BaseActivity;

import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_WHERE;

public class RestaurantDetailsActivity extends BaseActivity implements RestaurantView {

    private ActivityResturentDetailsBinding binding;
    List<SlideModel> list = new ArrayList<>();
    private RestaurantDetailsPresenter presenter;
    int restaurantId;
    private ArrayMap<String, Object> params = new ArrayMap<>();

    public static Intent newInstance(Activity mActivity, int fromWhere) {
        Intent intent = new Intent(mActivity, RestaurantDetailsActivity.class);
        intent.putExtra(FROM_WHERE, fromWhere);
        return intent;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResturentDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        AppSharedMethod.statusTRANSPARENT(RestaurantDetailsActivity.this);
        intViews();
        listenerViews();
    }

    private void intViews() {
        presenter = new RestaurantDetailsPresenter(this, this);
        getDetailsRestaurant();
        params.put("item_id", restaurantId);
        params.put("type", "restaurant");
    }


    private void listenerViews() {
        binding.ibBack.setOnClickListener(v -> presenter.goToHome());
        binding.btnMenu.setOnClickListener(v -> presenter.goToMenu(restaurantId));
        binding.icFav.setOnClickListener(v -> presenter.addRestaurantToFavorite(AppSharedData.getUserInfo().getTokenData().getAccessToken(),params));
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
                binding.tvRestaurantStatus,
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