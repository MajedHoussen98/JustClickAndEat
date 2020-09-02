package ps.ns.just_click_and_eat.feature.myLocation.presenter;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ps.ns.just_click_and_eat.feature.addLocation.view.AddLocationActivity;
import ps.ns.just_click_and_eat.feature.mainHome.view.MainActivity;
import ps.ns.just_click_and_eat.feature.myLocation.adapter.MyLocationAdapter;
import ps.ns.just_click_and_eat.feature.myLocation.view.MyLocationView;
import ps.ns.just_click_and_eat.network.asp.feature.NetworkShared;
import ps.ns.just_click_and_eat.network.asp.model.MyLocation;
import ps.ns.just_click_and_eat.network.utils.RequestListener;

import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_ADD_LOCATION;
import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_HOME;

public class MyLocationPresenter {

    private MyLocationView myLocationView;
    private Activity mActivity;
    private Fragment mFragment;

    public MyLocationPresenter(MyLocationView myLocationView, Activity mActivity) {
        this.myLocationView = myLocationView;
        this.mActivity = mActivity;
    }

    public MyLocationPresenter(Activity mActivity, Fragment mFragment) {
        this.mActivity = mActivity;
        this.mFragment = mFragment;
    }

    public void goTOHome(){
        mActivity.startActivity(MainActivity.newInstance(mActivity, FROM_HOME));
        mActivity.finish();
    }

    public void goToAddLocation(){
        mActivity.startActivity(AddLocationActivity.newInstance(mActivity, FROM_ADD_LOCATION));
        mActivity.finish();
    }

    public void getMyLocation(String token, RecyclerView recyclerView, ProgressBar progressBar){
        NetworkShared.getAsp().getGeneral().getMyLocation(token, new RequestListener<ArrayList<MyLocation>>() {
            @Override
            public void onSuccess(ArrayList<MyLocation> data) {
                MyLocationAdapter adapter = new MyLocationAdapter(mActivity, data, (MyLocationAdapter.ListItemClickListener) mActivity);
                recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
                recyclerView.setAdapter(adapter);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFail(String message, int code) {
                myLocationView.showMessage(message);
                progressBar.setVisibility(View.GONE);
            }
        });
    }

}
