package ps.ns.just_click_and_eat.feature.resturentDetails.presenter;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;
import java.util.List;

import ps.ns.just_click_and_eat.feature.mainHome.view.MainActivity;
import ps.ns.just_click_and_eat.feature.menu.view.MenuActivity;
import ps.ns.just_click_and_eat.feature.resturentDetails.view.RestaurantDetailsActivity;
import ps.ns.just_click_and_eat.feature.resturentDetails.view.RestaurantView;
import ps.ns.just_click_and_eat.network.asp.feature.NetworkShared;
import ps.ns.just_click_and_eat.network.asp.model.HomeActivity.Home;
import ps.ns.just_click_and_eat.network.utils.RequestListener;


import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_HOME;

public class RestaurantDetailsPresenter {

    private RestaurantView mView;
    private Activity mActivity;
    private RestaurantDetailsActivity activity = new RestaurantDetailsActivity();


    public RestaurantDetailsPresenter(RestaurantView mView, Activity mActivity) {
        this.mView = mView;
        this.mActivity = mActivity;
    }

    public void goToMenu(int restaurantId) {
        Intent intent = new Intent(mActivity, MenuActivity.class);
        intent.putExtra("restaurant_id", restaurantId);
        mActivity.startActivity(intent);
    }

    public void goToHome() {
        mActivity.startActivity(MainActivity.newInstance(mActivity, FROM_HOME));
    }

    public void getRestaurantById(int id,
                                  String token,
                                  TextView tvName,
                                  TextView tvAddress,
                                  RatingBar ratingBar,
                                  TextView rbTextView,
                                  TextView tvSubAddress,
                                  TextView tvMobileNumber,
                                  TextView tvStatus,
                                  TextView tvCategory,
                                  TextView tvHours,
                                  TextView tvFeatures,
                                  NestedScrollView nested,
                                  AppBarLayout appBarLayout,
                                  ProgressBar progressBar,
                                  List<SlideModel> list,
                                  ImageSlider imageSlider) {
        NetworkShared.getAsp().getGeneral().getRestaurantsById(id, token, new RequestListener<Home>() {
            @Override
            public void onSuccess(Home data) {
                tvName.setText(data.getName());
                tvAddress.setText(data.getAddress());
                ratingBar.setRating(data.getRating());
                rbTextView.setText(String.valueOf(data.getRating()));
                tvSubAddress.setText(data.getAddress());
                tvMobileNumber.setText(data.getMobile());
                tvStatus.setText(data.getStatus());
                tvCategory.setText(data.getCategory());
                tvHours.setText(data.getOpenTime());
                tvFeatures.setText(data.getFeature());
                nested.setVisibility(View.VISIBLE);
                appBarLayout.setVisibility(View.VISIBLE);


                String image;
                for (int i = 0; i <= data.getImages().size(); i++) {
                    image = data.getImages().get(i).getImageUrl();
                    list.add(new SlideModel(image, ScaleTypes.CENTER_CROP));
                    progressBar.setVisibility(View.GONE);
                    imageSlider.setImageList(list, ScaleTypes.CENTER_CROP);
                }
            }

            @Override
            public void onFail(String message, int code) {
                Log.e("response", "fail" + message);
            }
        });
    }

}

