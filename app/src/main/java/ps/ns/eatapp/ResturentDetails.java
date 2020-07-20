package ps.ns.eatapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ps.ns.eatapp.ui.home.HomeFragment;
import ps.ns.eatapp.ui.menu.MenuActivity;

public class ResturentDetails extends AppCompatActivity implements View.OnClickListener {


    @BindView(R.id.image_slider)
    ImageSlider imageSlider;
    @BindView(R.id.ib_back)
    ImageView ib_back;
    @BindView(R.id.ic_fav)
    ImageView icFav;
    @BindView(R.id.ic_share)
    ImageView icShare;

    List<SlideModel> list = new ArrayList<>();
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.btn_menu)
    Button viewMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_resturent_details);
        ButterKnife.bind(this);

        addSilderImage();
        listenerViews();

    }

    private void addSilderImage() {

        list.add(new SlideModel(R.drawable.slideimage1, ScaleTypes.CENTER_CROP));
        list.add(new SlideModel(R.drawable.slideimage2, ScaleTypes.CENTER_CROP));
        imageSlider.setImageList(list, ScaleTypes.CENTER_CROP);
    }

    private void listenerViews() {
        ib_back.setOnClickListener(this);
        icFav.setOnClickListener(this);
        icShare.setOnClickListener(this);
        viewMenu.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_back:
                startActivity(new Intent(ResturentDetails.this, MainActivity.class));
                finish();
                break;

            case R.id.btn_menu:
                startActivity(new Intent(ResturentDetails.this, MenuActivity.class));
                break;
        }
    }
}