package ps.ns.just_click_and_eat.feature.mealsDetails.view;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.databinding.ActivityMealsDetailsBinding;
import ps.ns.just_click_and_eat.feature.favorites.Favorites;
import ps.ns.just_click_and_eat.feature.mealsDetails.adapter.IngredientAdapter;
import ps.ns.just_click_and_eat.feature.mealsDetails.presenter.MealsDetailsPresenter;
import ps.ns.just_click_and_eat.feature.menu.view.MenuActivity;
import ps.ns.just_click_and_eat.feature.restaurantDetails.view.RestaurantDetailsActivity;
import ps.ns.just_click_and_eat.network.asp.model.restaurants.Images;
import ps.ns.just_click_and_eat.utils.AppSharedMethod;
import ps.ns.just_click_and_eat.utils.BaseActivity;

public class MealsDetailsActivity extends BaseActivity implements IngredientAdapter.ListItemClickListener, MealsDetailsView {

    private ActivityMealsDetailsBinding binding;
    private List<SlideModel> list = new ArrayList<>();
    private MealsDetailsPresenter presenter;
    int mealsId, restaurant_id, code;
    String mealsName, mealsDescription, image;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMealsDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        AppSharedMethod.statusTRANSPARENT(MealsDetailsActivity.this);
        listenerViews();
        getMealDetails();
        addSliderImage();
    }

    private void getMealDetails() {
        mealsId = Objects.requireNonNull(getIntent().getExtras()).getInt("meal_id");
        restaurant_id = getIntent().getExtras().getInt("restaurant_id");
        code = getIntent().getExtras().getInt("CODE");
        image = getIntent().getExtras().getString("image");
        mealsName = getIntent().getExtras().getString("name");
        mealsDescription = getIntent().getExtras().getString("description");
        binding.tvMealsName.setText(mealsName);
        binding.tvDescriptionMeal.setText(mealsDescription);
        presenter.getMealIngredients(mealsId, binding.rvIngredient, binding.tvIngredient);
    }

    private void addSliderImage() {
        list.add(new SlideModel(image, ScaleTypes.CENTER_CROP));
        binding.imageSlider.setImageList(list, ScaleTypes.CENTER_CROP);
    }

    private void listenerViews() {
        presenter = new MealsDetailsPresenter(this, this);
        binding.ibBack.setOnClickListener(v -> presenter.goToActivity(code, restaurant_id));
    }

    @Override
    public void onListItemClicked(int position, int viewId, int id) {

    }
}