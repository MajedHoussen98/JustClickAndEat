package ps.ns.just_click_and_eat.feature.cartDialogFragment.presenter;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_ADD_LOCATION;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.feature.addLocation.view.AddLocationActivity;
import ps.ns.just_click_and_eat.feature.cartDialogFragment.view.CartDialogView;
import ps.ns.just_click_and_eat.feature.myLocation.adapter.MyLocationAdapter;
import ps.ns.just_click_and_eat.feature.order.view.OrderActivity;
import ps.ns.just_click_and_eat.network.asp.feature.NetworkShared;
import ps.ns.just_click_and_eat.network.asp.model.MyLocation;
import ps.ns.just_click_and_eat.network.utils.RequestListener;

public class CartDialogPresenter {

    private CartDialogView mView;
    private Fragment mFragment;

    public CartDialogPresenter(CartDialogView mView, Fragment mFragment) {
        this.mView = mView;
        this.mFragment = mFragment;
    }

    public void clickedPickup(Button btnPickup, Button btnDelivery, Button btnAddAddress, RecyclerView rvCatDialog) {
        btnPickup.setBackgroundResource(R.drawable.btn_backgrount_selected);
        btnPickup.setTextColor(Color.parseColor("#ffffff"));
        btnDelivery.setBackgroundResource(R.drawable.btn_background_white);
        btnDelivery.setTextColor(Color.parseColor("#2C32BE"));
        btnAddAddress.setVisibility(View.GONE);
        rvCatDialog.setVisibility(View.GONE);
    }

    public void clickedDelivery(Button btnPickup, Button btnDelivery, Button btnAddAddress, RecyclerView rvCatDialog) {
        btnDelivery.setBackgroundResource(R.drawable.btn_backgrount_selected);
        btnDelivery.setTextColor(Color.parseColor("#ffffff"));
        btnPickup.setBackgroundResource(R.drawable.btn_background_white);
        btnPickup.setTextColor(Color.parseColor("#2C32BE"));
        btnAddAddress.setVisibility(View.VISIBLE);
        rvCatDialog.setVisibility(View.VISIBLE);
    }

    public void goToSubmitOrder() {
        Intent intent = new Intent(mFragment.getContext(), OrderActivity.class);
        intent.putExtra("showHide", false);
        mFragment.startActivity(intent);
    }

    public void goToAddAddress() {
        mFragment.startActivity(new Intent(AddLocationActivity.newInstance(mFragment.getActivity(), FROM_ADD_LOCATION)));
    }

    public void getMyLocation(String token, RecyclerView recyclerView, ProgressBar progressBar) {
        NetworkShared.getAsp().getGeneral().getMyLocation(token, new RequestListener<ArrayList<MyLocation>>() {
            @Override
            public void onSuccess(ArrayList<MyLocation> data) {
                MyLocationAdapter adapter = new MyLocationAdapter(mFragment.getContext(), data, (MyLocationAdapter.ListItemClickListener) mFragment);
                recyclerView.setLayoutManager(new LinearLayoutManager(mFragment.getContext()));
                recyclerView.setAdapter(adapter);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFail(String message, int code) {
                Log.e("fail", message);
                progressBar.setVisibility(View.GONE);

            }
        });
    }
}
