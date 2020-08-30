package ps.ns.just_click_and_eat.feature.menu.presenter;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import ps.ns.just_click_and_eat.feature.menu.view.MenuView;
import ps.ns.just_click_and_eat.feature.resturentDetails.view.RestaurantDetailsActivity;
import ps.ns.just_click_and_eat.network.asp.feature.NetworkShared;
import ps.ns.just_click_and_eat.network.asp.model.menu.MenuList;
import ps.ns.just_click_and_eat.network.utils.RequestListener;
import ps.ns.just_click_and_eat.utils.AppSharedData;

import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_Restaurant_Details;


public class MenuPresenter {

    private MenuView mView;
    private Activity mActivity;

    public MenuPresenter(){

    }

    public MenuPresenter(MenuView mView, Activity mActivity) {
        this.mView = mView;
        this.mActivity = mActivity;
    }

    public void goToRestaurantDetails(){
        mActivity.startActivity(new Intent(RestaurantDetailsActivity.newInstance(mActivity, FROM_Restaurant_Details)));
    }

    private static final String TAGS = "MenuPresenterS";
    private static final String TAGF = "MenuPresenterF";

    public void getMenuList(int id) {
        NetworkShared.getAsp().getGeneral().getMenuList(id, new RequestListener<ArrayList<MenuList>>() {
            @Override
            public void onSuccess(ArrayList<MenuList> data) {

                AppSharedData.setMenuList(data);
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
