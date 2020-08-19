package ps.ns.just_click_and_eat.feature.resturentDetails.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

import ps.ns.just_click_and_eat.feature.mainHome.view.MainActivity;
import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.databinding.ActivityResturentDetailsBinding;
import ps.ns.just_click_and_eat.feature.menu.MenuActivity;

public class ResturentDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityResturentDetailsBinding binding;
    List<SlideModel> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResturentDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        addSliderImage();
        listenerViews();
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
        binding.btnMenu.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_back:
                startActivity(new Intent(ResturentDetailsActivity.this, MainActivity.class));
                finish();
                break;

            case R.id.btn_menu:
                startActivity(new Intent(ResturentDetailsActivity.this, MenuActivity.class));
                break;
        }
    }
}