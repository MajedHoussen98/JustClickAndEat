package ps.ns.just_click_and_eat.feature.myLocation.presenter;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ps.ns.just_click_and_eat.feature.addLocation.view.AddLocationActivity;
import ps.ns.just_click_and_eat.feature.mainHome.view.MainActivity;
import ps.ns.just_click_and_eat.feature.myAccount.view.MyAccountActivity;
import ps.ns.just_click_and_eat.feature.myLocation.adapter.MyLocationAdapter;
import ps.ns.just_click_and_eat.feature.myLocation.view.MyLocationView;
import ps.ns.just_click_and_eat.network.asp.feature.NetworkShared;
import ps.ns.just_click_and_eat.network.asp.model.MyLocation;
import ps.ns.just_click_and_eat.network.utils.RequestListener;
import ps.ns.just_click_and_eat.utils.AppSharedData;

import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_ADD_LOCATION;
import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_HOME;

public class MyLocationPresenter {

    private MyLocationView myLocationView;
    private Activity mActivity;

    public MyLocationPresenter(MyLocationView myLocationView, Activity mActivity) {
        this.myLocationView = myLocationView;
        this.mActivity = mActivity;
    }

    public void goTOHome() {
        mActivity.startActivity(MainActivity.newInstance(mActivity, FROM_HOME));
        mActivity.finish();
    }

    public void goTOMyAccount() {
        mActivity.startActivity(MyAccountActivity.newInstance(mActivity, FROM_HOME));
        mActivity.finish();
    }


    public void goToAddLocation() {
        Intent intent = new Intent(AddLocationActivity.newInstance(mActivity, FROM_ADD_LOCATION));
        intent.putExtra("icDelete", 0);
        mActivity.startActivity(intent);
        mActivity.finish();
    }

    public void getMyLocation(String token, RecyclerView recyclerView, ProgressBar progressBar) {
        NetworkShared.getAsp().getLocation().getMyLocation(token, new RequestListener<ArrayList<MyLocation>>() {
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
