package ps.ns.just_click_and_eat.feature.mainHome.homePresenter;

import android.app.Activity;
import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ps.ns.just_click_and_eat.feature.mainHome.adapter.HomeAdapter;
import ps.ns.just_click_and_eat.feature.mainHome.view.HomeFragment;
import ps.ns.just_click_and_eat.feature.mainHome.view.HomeView;
import ps.ns.just_click_and_eat.feature.mainHome.view.MainActivity;
import ps.ns.just_click_and_eat.network.asp.feature.General;
import ps.ns.just_click_and_eat.network.asp.feature.NetworkShared;
import ps.ns.just_click_and_eat.network.asp.model.HomeModel;
import ps.ns.just_click_and_eat.network.utils.RequestListener;
import ps.ns.just_click_and_eat.utils.BaseActivity;

public class HomePresenter {

    private HomeView mView;
    private Activity mActivity;

    //private HomeView mView;
    HomeFragment mFragment;
Class<MainActivity> mainActivity;
// Context context;
    private BaseActivity activity = new BaseActivity();
    private General general = new General();
  //  private NetworkShared.ASP asp = new NetworkShared.ASP();

    public HomePresenter(HomeView mView, Activity mActivity, BaseActivity activity) {
        this.mView = mView;
        this.mActivity = mActivity;
        this.activity = activity;
    }

    public HomePresenter(HomeFragment mFragment, Class<MainActivity> mainActivity) {
        this.mFragment = mFragment;
        this.mainActivity = mainActivity;
    }


    public void getRestaurantData(RecyclerView recyclerView) {
        general.restaurantResponse(new RequestListener<ArrayList<HomeModel>>() {

            @Override
            public void onSuccess(ArrayList<HomeModel> data) {
                HomeAdapter adapter = new HomeAdapter(mActivity, data, (HomeAdapter.ListItemClickListener) mActivity);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFail(String message, int code) {

            }
        });

    }
}
