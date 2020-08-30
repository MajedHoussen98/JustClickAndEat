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
import ps.ns.just_click_and_eat.network.asp.model.HomeActivity.ImageRestaurant;
import ps.ns.just_click_and_eat.utils.BaseActivity;

import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_WHERE;

public class RestaurantDetailsActivity extends BaseActivity implements RestaurantView {

    private ActivityResturentDetailsBinding binding;
    List<SlideModel> list = new ArrayList<>();
    private RestaurantDetailsPresenter presenter;
    int restaurantId, rating_number;
    String restaurantName, address, mobile, status, category, hours, features;
  //  Serializable imageRestaurants;


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
        addSliderImage();
        listenerViews();
    }

    private void intViews() {
        presenter = new RestaurantDetailsPresenter(this, this);
        getDetailsRestaurant();

    }

    private void addSliderImage() {
        list.add(new SlideModel(R.drawable.slideimage1, ScaleTypes.CENTER_CROP));
        list.add(new SlideModel(R.drawable.slideimage2, ScaleTypes.CENTER_CROP));
        binding.imageSlider.setImageList(list, ScaleTypes.CENTER_CROP);
    }

    private void listenerViews() {
        binding.ibBack.setOnClickListener(v -> presenter.goToHome());
        binding.btnMenu.setOnClickListener(v -> presenter.goToMenu(restaurantId));
    }

    private void getDetailsRestaurant() {
        restaurantId = getIntent().getExtras().getInt("restaurant_id");
       // imageRestaurants = getIntent().getSerializableExtra("imageRestaurants");
        restaurantName = getIntent().getExtras().getString("restaurant_name");
        address = getIntent().getExtras().getString("address");
        rating_number = getIntent().getExtras().getInt("rating_number");
        mobile = getIntent().getExtras().getString("mobile");
        status = getIntent().getExtras().getString("status");
        category = getIntent().getExtras().getString("category");
        hours = getIntent().getExtras().getString("hours");
        features = getIntent().getExtras().getString("features");

     //   Log.e("imagesR", imageRestaurants.toString());

        binding.tvResturantName.setText(restaurantName);
        binding.tvAddress.setText(address);
        binding.ratingBar.setRating(rating_number);
        binding.tvRatingValue.setText(String.valueOf(rating_number));
        binding.tvResturantAddress.setText(address);
        binding.tvMobileNumber.setText(mobile);
        binding.tvResturantStatus.setText(status);
        binding.tvCategory.setText(category);
        binding.tvWorkTime.setText(hours);
        binding.tvFeatures.setText(features);

    }

}