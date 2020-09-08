package ps.ns.just_click_and_eat.feature.menu.presenter;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;

import ps.ns.just_click_and_eat.feature.menu.view.MenuView;
import ps.ns.just_click_and_eat.feature.restaurantDetails.view.RestaurantDetailsActivity;
import ps.ns.just_click_and_eat.network.asp.feature.NetworkShared;
import ps.ns.just_click_and_eat.network.asp.model.menu.Menu;
import ps.ns.just_click_and_eat.network.utils.RequestListener;


public class MenuPresenter {

    private MenuView mView;
    private Activity mActivity;
    private FragmentManager manager;


    public MenuPresenter(MenuView mView, Activity mActivity) {
        this.mView = mView;
        this.mActivity = mActivity;
    }

    public void goToRestaurantDetails(int restaurant_id){
        Intent intent = new Intent(mActivity, RestaurantDetailsActivity.class);
        intent.putExtra("restaurant_id", restaurant_id);
        mActivity.startActivity(intent);
        mActivity.finish();
    }

    private static final String TAGS = "MenuPresenterS";
    private static final String TAGF = "MenuPresenterF";

    public void getMenuList(int id) {
        NetworkShared.getAsp().getGeneral().getMenuList(id, new RequestListener<ArrayList<Menu>>() {
            @Override
            public void onSuccess(ArrayList<Menu> data) {
               // Toast.makeText(mActivity, "success", Toast.LENGTH_SHORT).show();
               // Toast.makeText(mActivity, data.get(1).getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFail(String message, int code) {
                Log.d(TAGF, "onFailure: " + message);

            }
        });
    }

}
