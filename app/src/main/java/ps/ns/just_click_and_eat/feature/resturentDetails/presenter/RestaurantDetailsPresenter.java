package ps.ns.just_click_and_eat.feature.resturentDetails.presenter;

import android.app.Activity;
import android.content.Intent;

import ps.ns.just_click_and_eat.feature.mainHome.view.MainActivity;
import ps.ns.just_click_and_eat.feature.menu.view.MenuActivity;
import ps.ns.just_click_and_eat.feature.resturentDetails.view.RestaurantView;


import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_HOME;

public class RestaurantDetailsPresenter {

    private RestaurantView mView;
    private Activity mActivity;

    public RestaurantDetailsPresenter(RestaurantView mView, Activity mActivity) {
        this.mView = mView;
        this.mActivity = mActivity;
    }

    public void goToMenu(int restaurantId){
        Intent intent = new Intent(mActivity, MenuActivity.class);
        intent.putExtra("restaurant_id", restaurantId );
        mActivity.startActivity(intent);
    }

    public void goToHome() {
        mActivity.startActivity(MainActivity.newInstance(mActivity, FROM_HOME));
    }

//    public void getRestaurantById( int id) {
//
//        NetworkShared.getAsp().getRestaurant().restaurantResponseById(AppSharedData.getUserInfo().getTokenData().getAccessToken(), id, new RequestListener<ArrayList<HomeModel>>() {
//            @Override
//            public void onSuccess(ArrayList<HomeModel> data) {
//
//            }
//
//            @Override
//            public void onFail(String message, int code) {
//
//            }
//        });

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

