package ps.ns.eatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

import ps.ns.eatapp.adapter.MenuAdapter;
import ps.ns.eatapp.databinding.ActivityMealsDetailsBinding;
import ps.ns.eatapp.ui.menu.MenuActivity;

public class MealsDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMealsDetailsBinding binding;
    private View view;
    private List<SlideModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMealsDetailsBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        addSilderImage();
        listenerViews();
        setContentView(view);
    }

    private void addSilderImage() {
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
        switch (v.getId()){
            case R.id.ib_back:
                startActivity(new Intent(MealsDetailsActivity.this, MenuActivity.class));
                finish();
                break;
        }
    }
}