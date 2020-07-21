package ps.ns.eatapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ps.ns.eatapp.MainActivity;
import ps.ns.eatapp.R;
import ps.ns.eatapp.databinding.ActivityResturentDetailsBinding;
import ps.ns.eatapp.ui.menu.MenuActivity;

public class ResturentDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private View view;
    private ActivityResturentDetailsBinding binding;
    List<SlideModel> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResturentDetailsBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        setContentView(view);

        addSilderImage();
        listenerViews();

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