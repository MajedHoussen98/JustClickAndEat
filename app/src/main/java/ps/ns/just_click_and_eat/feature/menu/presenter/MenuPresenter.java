package ps.ns.just_click_and_eat.feature.menu.presenter;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ps.ns.just_click_and_eat.feature.menu.adapter.MenuAdapter;
import ps.ns.just_click_and_eat.feature.menu.view.MenuView;
import ps.ns.just_click_and_eat.feature.restaurantDetails.view.RestaurantDetailsActivity;
import ps.ns.just_click_and_eat.network.asp.feature.NetworkShared;
import ps.ns.just_click_and_eat.network.asp.model.meals.Meals;
import ps.ns.just_click_and_eat.network.asp.model.menu.Menu;
import ps.ns.just_click_and_eat.network.utils.RequestListener;


public class MenuPresenter {

    private MenuView mView;
    private Activity mActivity;
    private Listener listener;

    public interface Listener {
        void onMenuFetched(ArrayList<Menu> data);
    }

    public MenuPresenter() {
    }

    public MenuPresenter(MenuView mView, Activity mActivity, Listener listener) {
        this.mView = mView;
        this.mActivity = mActivity;
        this.listener = listener;
    }

    public void goToRestaurantDetails(int restaurant_id) {
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
                listener.onMenuFetched(data);
                Log.e("array", data.toString());
            }

            @Override
            public void onFail(String message, int code) {
                Log.d(TAGF, "onFailure: " + message);

            }
        });
    }

    public void searchMeals(String name, int id, RecyclerView recyclerView){
        NetworkShared.getAsp().getGeneral().searchMeals(name, id, new RequestListener<ArrayList<Meals>>() {
            @Override
            public void onSuccess(ArrayList<Meals> data) {
                Log.e("data", data.toString());
                MenuAdapter adapter = new MenuAdapter(mActivity, data, (MenuAdapter.ListItemClickListener) mActivity);
                recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
                recyclerView.setAdapter(adapter);
                Log.e("search", "success");
            }

            @Override
            public void onFail(String message, int code) {

            }
        });
    }


}
