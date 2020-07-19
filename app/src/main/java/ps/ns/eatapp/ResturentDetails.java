package ps.ns.eatapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ps.ns.eatapp.ui.home.HomeFragment;

public class ResturentDetails extends AppCompatActivity implements View.OnClickListener {


    @BindView(R.id.image_slider)
    ImageSlider imageSlider;
    @BindView(R.id.bac_home)
    ImageView bacHome;
    @BindView(R.id.ic_fav)
    ImageView icFav;
    @BindView(R.id.ic_share)
    ImageView icShare;

    List<SlideModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resturent_details);
        ButterKnife.bind(this);

        addSilderImage();
        listenerViews();

    }

    private void addSilderImage() {

        list.add(new SlideModel(R.drawable.slideimage1, ScaleTypes.CENTER_CROP));
        list.add(new SlideModel(R.drawable.slideimage2, ScaleTypes.CENTER_CROP));
        imageSlider.setImageList(list,ScaleTypes.CENTER_CROP);
    }

    private void listenerViews() {
        bacHome.setOnClickListener(this);
        icFav.setOnClickListener(this);
        icShare.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bac_home:
                startActivity(new Intent(ResturentDetails.this, HomeFragment.class));
                finish();
                break;
        }
    }
}