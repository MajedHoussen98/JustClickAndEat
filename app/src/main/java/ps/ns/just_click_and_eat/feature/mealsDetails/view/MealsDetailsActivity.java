package ps.ns.just_click_and_eat.feature.mealsDetails.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.databinding.ActivityMealsDetailsBinding;
import ps.ns.just_click_and_eat.feature.favorites.Favorites;
import ps.ns.just_click_and_eat.feature.menu.view.MenuActivity;
import ps.ns.just_click_and_eat.network.asp.model.restaurants.Images;

public class MealsDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMealsDetailsBinding binding;
    private View view;
    private List<SlideModel> list = new ArrayList<>();
    int mealsId, restaurant_id, code;
    ArrayList<Images> mealsList;
    String mealsName, mealsDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMealsDetailsBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        setContentView(view);
        addSliderImage();
        listenerViews();
        getMealDetails();
    }

    private void getMealDetails() {
        mealsId = getIntent().getExtras().getInt("meal_id");
        restaurant_id = getIntent().getExtras().getInt("restaurant_id");
        code = getIntent().getExtras().getInt("code");
        mealsList = (ArrayList<Images>) getIntent().getExtras().getSerializable("images");
        mealsName = getIntent().getExtras().getString("name");
        mealsDescription = getIntent().getExtras().getString("description");

        Log.e("idd", mealsId+"");
        binding.tvMealsName.setText(mealsName);
        binding.tvDescriptionMeal.setText(mealsDescription);
    }

    private void addSliderImage() {
        list.add(new SlideModel(R.drawable.slideimage1, ScaleTypes.CENTER_CROP));
        list.add(new SlideModel(R.drawable.slideimage2, ScaleTypes.CENTER_CROP));
        binding.imageSlider.setImageList(list, ScaleTypes.CENTER_CROP);
    }

    private void listenerViews() {
        binding.ibBack.setOnClickListener(this);
        binding.icFav.setOnClickListener(this);
        binding.icShare.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ib_back) {
            Log.e("code", code+"");
            if (code == 1){
                Intent intent = new Intent(MealsDetailsActivity.this, Favorites.class);
                startActivity(intent);
                finish();
            }
//            Intent intent = new Intent(MealsDetailsActivity.this, MenuActivity.class);
//            startActivity(intent);
//            finish();
        }
    }
}