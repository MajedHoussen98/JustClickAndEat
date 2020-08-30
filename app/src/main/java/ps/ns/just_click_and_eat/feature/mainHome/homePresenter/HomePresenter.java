package ps.ns.just_click_and_eat.feature.mainHome.homePresenter;

import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.feature.mainHome.adapter.HomeAdapter;
import ps.ns.just_click_and_eat.feature.mainHome.view.HomeView;
import ps.ns.just_click_and_eat.network.asp.feature.NetworkShared;
import ps.ns.just_click_and_eat.network.asp.model.HomeActivity.Home;
import ps.ns.just_click_and_eat.network.utils.RequestListener;
import ps.ns.just_click_and_eat.utils.AppSharedMethod;

public class HomePresenter {
    private HomeView mView;
    private Fragment mFragment;


    public HomePresenter(HomeView mView, Fragment mFragment) {
        this.mView = mView;
        this.mFragment = mFragment;
    }

    public void getRestaurantData(RecyclerView recyclerView) {
        //   mView.showProgress();
        NetworkShared.getAsp().getGeneral().getRestaurants(new RequestListener<ArrayList<Home>>() {
            @Override
            public void onSuccess(ArrayList<Home> data) {
                //mView.hideProgress();
                HomeAdapter adapter = new HomeAdapter(mFragment.getContext(), data, (HomeAdapter.ListItemClickListener) mFragment);
                recyclerView.setLayoutManager(new LinearLayoutManager(mFragment.getContext()));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFail(String message, int code) {
                //     mView.hideProgress();
                mView.showMessage(message);
            }
        });
    }


    public void search(String keyword, RecyclerView recyclerView){
        NetworkShared.getAsp().getGeneral().search(keyword, new RequestListener<ArrayList<Home>>() {
            @Override
            public void onSuccess(ArrayList<Home> data) {
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
