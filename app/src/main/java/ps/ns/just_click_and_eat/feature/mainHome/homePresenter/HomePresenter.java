package ps.ns.just_click_and_eat.feature.mainHome.homePresenter;

import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ps.ns.just_click_and_eat.feature.mainHome.adapter.HomeAdapter;
import ps.ns.just_click_and_eat.feature.mainHome.view.HomeView;
import ps.ns.just_click_and_eat.network.asp.feature.General;
import ps.ns.just_click_and_eat.network.asp.feature.NetworkShared;
import ps.ns.just_click_and_eat.network.asp.model.HomeModel;
import ps.ns.just_click_and_eat.network.utils.RequestListener;
import ps.ns.just_click_and_eat.utils.BaseActivity;

public class HomePresenter {
    private HomeView mView;
    private Fragment mFragment;
    private General general = new General();
    // private NetworkShared.ASP asp = new NetworkShared.ASP();


    public HomePresenter(HomeView mView, Fragment mFragment) {
        this.mView = mView;
        this.mFragment = mFragment;
    }

    public void getRestaurantData(RecyclerView recyclerView) {
        general.restaurantResponse(new RequestListener<ArrayList<HomeModel>>() {
            @Override
            public void onSuccess(ArrayList<HomeModel> data) {
                HomeAdapter adapter = new HomeAdapter(mFragment.getContext(), data, (HomeAdapter.ListItemClickListener) mFragment);
                recyclerView.setLayoutManager(new LinearLayoutManager(mFragment.getContext()));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFail(String message, int code) {
                Toast.makeText(mFragment.getContext(), "error is: " + message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
