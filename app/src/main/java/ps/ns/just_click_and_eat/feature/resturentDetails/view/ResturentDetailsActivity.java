package ps.ns.just_click_and_eat.feature.resturentDetails.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.databinding.ActivityResturentDetailsBinding;
import ps.ns.just_click_and_eat.feature.resturentDetails.presenter.RestaurantDetailsPresenter;
import ps.ns.just_click_and_eat.feature.verfication.view.VerificationActivity;
import ps.ns.just_click_and_eat.utils.BaseActivity;

import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_WHERE;

public class ResturentDetailsActivity extends BaseActivity implements RestaurantView {

    private ActivityResturentDetailsBinding binding;
    List<SlideModel> list = new ArrayList<>();
    private RestaurantDetailsPresenter presenter;
    int restaurantId;


    public static Intent newInstance(Activity mActivity, int fromWhere) {
        Intent intent = new Intent(mActivity, VerificationActivity.class);
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

    private void intViews(){
        presenter = new RestaurantDetailsPresenter(this, this);
        restaurantId = getIntent().getExtras().getInt("restaurant_id");
       // presenter.getRestaurantById(restaurantId);
    }

    private void addSliderImage() {
        list.add(new SlideModel(R.drawable.slideimage1, ScaleTypes.CENTER_CROP));
        list.add(new SlideModel(R.drawable.slideimage2, ScaleTypes.CENTER_CROP));
        binding.imageSlider.setImageList(list, ScaleTypes.CENTER_CROP);
    }

    private void listenerViews() {
        binding.ibBack.setOnClickListener(v ->presenter.goToHome());
        binding.btnMenu.setOnClickListener(v -> presenter.goToMenu());
    }

}