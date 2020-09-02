package ps.ns.just_click_and_eat.feature.cartDialogFragment.view;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.feature.cartDialogFragment.presenter.CartDialogPresenter;
import ps.ns.just_click_and_eat.feature.myLocation.adapter.MyLocationAdapter;
import ps.ns.just_click_and_eat.databinding.FragmentCartDialogBinding;
import ps.ns.just_click_and_eat.feature.myLocation.presenter.MyLocationPresenter;
import ps.ns.just_click_and_eat.feature.addLocation.view.AddLocationActivity;
import ps.ns.just_click_and_eat.feature.order.view.OrderActivity;
import ps.ns.just_click_and_eat.utils.AppSharedData;


public class CartDialogFragment extends DialogFragment implements MyLocationAdapter.ListItemClickListener, CartDialogView{
    private View view;
    private FragmentCartDialogBinding binding;

    private CartDialogPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCartDialogBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        initView();
        getLocationData();
        viewListener();
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        Window window = getDialog().getWindow();
        window.setGravity(Gravity.CENTER_HORIZONTAL);
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        WindowManager.LayoutParams params = window.getAttributes();
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        window.setAttributes(params);

    }

    private void initView() {
        presenter = new CartDialogPresenter(this, this);
        presenter.getMyLocation(AppSharedData.getUserInfo().getTokenData().getAccessToken(), binding.rvCatDialog, binding.progressBar);
    }

    private void viewListener() {
        binding.btnPickup.setOnClickListener(v -> presenter.clickedPickup(binding.btnPickup, binding.btnDelivery, binding.btnAddAddress, binding.rvCatDialog));
        binding.btnDelivery.setOnClickListener(v -> presenter.clickedDelivery(binding.btnPickup, binding.btnDelivery, binding.btnAddAddress, binding.rvCatDialog));
        binding.btnSubmitOrder.setOnClickListener(v -> presenter.goToSubmitOrder());
        binding.btnAddAddress.setOnClickListener(v -> presenter.goToAddAddress());
    }


    private void getLocationData() {

    }

    @Override
    public void onListItemClicked(int position, int viewId) {

    }

}