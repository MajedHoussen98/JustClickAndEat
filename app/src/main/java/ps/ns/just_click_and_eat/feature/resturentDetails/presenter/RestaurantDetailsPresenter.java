package ps.ns.just_click_and_eat.feature.resturentDetails.presenter;

import android.app.Activity;

import java.util.ArrayList;

import ps.ns.just_click_and_eat.feature.mainHome.view.HomeFragment;
import ps.ns.just_click_and_eat.feature.menu.MenuActivity;
import ps.ns.just_click_and_eat.feature.resturentDetails.view.RestaurantView;
import ps.ns.just_click_and_eat.network.asp.feature.General;
import ps.ns.just_click_and_eat.network.asp.feature.NetworkShared;
import ps.ns.just_click_and_eat.network.asp.model.HomeModel;
import ps.ns.just_click_and_eat.network.utils.RequestListener;
import ps.ns.just_click_and_eat.utils.AppSharedData;


import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_LOGIN;

public class RestaurantDetailsPresenter {

    private RestaurantView mView;
    private Activity mActivity;

    public RestaurantDetailsPresenter(RestaurantView mView, Activity mActivity) {
        this.mView = mView;
        this.mActivity = mActivity;
    }

    public void goToMenu(){
        mActivity.startActivity(MenuActivity.newInstance(mActivity, FROM_LOGIN));
    }

    public void goToHome() {
        mActivity.startActivity(HomeFragment.newInstance(mActivity, FROM_LOGIN));
    }

    public void getRestaurantById( int id) {

        NetworkShared.getAsp().getRestaurant().restaurantResponseById(AppSharedData.getUserInfo().getTokenData().getAccessToken(), id, new RequestListener<ArrayList<HomeModel>>() {
            @Override
            public void onSuccess(ArrayList<HomeModel> data) {

            }

            @Override
            public void onFail(String message, int code) {

            }
        });

//        general.restaurantResponseById(id,new RequestListener<ArrayList<HomeModel>>() {
//            @Override
//            public void onSuccess(ArrayList<HomeModel> data) {
//                Log.e("datares", data.size() + "");
//                Toast.makeText(mActivity, "id" + id, Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onFail(String message, int code) {
//                Toast.makeText(mActivity, "error is: " + message, Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
