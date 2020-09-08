package ps.ns.just_click_and_eat.feature.mainHome.homePresenter;

import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ps.ns.just_click_and_eat.feature.mainHome.adapter.HomeAdapter;
import ps.ns.just_click_and_eat.feature.mainHome.view.HomeView;
import ps.ns.just_click_and_eat.network.asp.feature.NetworkShared;
import ps.ns.just_click_and_eat.network.asp.model.restaurants.Restaurants;
import ps.ns.just_click_and_eat.network.utils.RequestListener;

public class HomePresenter {
    private HomeView mView;
    private Fragment mFragment;
    private boolean isLoading = true;
    private int past, visible, total, previous = 0;
    private int view = 10;


    public HomePresenter(HomeView mView, Fragment mFragment) {
        this.mView = mView;
        this.mFragment = mFragment;
    }

    public void getRestaurantData(RecyclerView recyclerView, ProgressBar progressBar) {

        NetworkShared.getAsp().getGeneral().getRestaurants(new RequestListener<ArrayList<Restaurants>>() {
            @Override
            public void onSuccess(ArrayList<Restaurants> data) {
                HomeAdapter adapter = new HomeAdapter(mFragment.getContext(), data, (HomeAdapter.ListItemClickListener) mFragment);
                recyclerView.setLayoutManager(new LinearLayoutManager(mFragment.getContext()));
                recyclerView.setAdapter(adapter);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFail(String message, int code) {
                mView.showMessage(message);
                progressBar.setVisibility(View.GONE);

            }
        });
    }

    public void search(String keyword, RecyclerView recyclerView) {
        NetworkShared.getAsp().getGeneral().search(keyword, new RequestListener<ArrayList<Restaurants>>() {
            @Override
            public void onSuccess(ArrayList<Restaurants> data) {
                HomeAdapter adapter = new HomeAdapter(mFragment.getContext(), data, (HomeAdapter.ListItemClickListener) mFragment);
                recyclerView.setLayoutManager(new LinearLayoutManager(mFragment.getContext()));
                recyclerView.setAdapter(adapter);
                Log.e("search", "success");
            }

            @Override
            public void onFail(String message, int code) {
                mView.showMessage(message);
            }
        });
    }

}
