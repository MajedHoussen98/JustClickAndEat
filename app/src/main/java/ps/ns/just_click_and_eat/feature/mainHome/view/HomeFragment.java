package ps.ns.just_click_and_eat.feature.mainHome.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.feature.mainHome.adapter.HomeAdapter;
import ps.ns.just_click_and_eat.databinding.FragmentHomeBinding;
import ps.ns.just_click_and_eat.feature.dialogs.FilterDialogFragment;
import ps.ns.just_click_and_eat.feature.mainHome.homePresenter.HomePresenter;
import ps.ns.just_click_and_eat.feature.mainHome.view.HomeView;
import ps.ns.just_click_and_eat.feature.mainHome.view.MainActivity;
import ps.ns.just_click_and_eat.network.asp.feature.General;
import ps.ns.just_click_and_eat.network.asp.model.HomeModel;
import ps.ns.just_click_and_eat.feature.resturentDetails.view.ResturentDetailsActivity;
import ps.ns.just_click_and_eat.network.utils.RequestListener;
import ps.ns.just_click_and_eat.utils.AppSharedMethod;
import ps.ns.just_click_and_eat.utils.BaseFragment;

public class HomeFragment extends BaseFragment implements HomeAdapter.ListItemClickListener, HomeView {

    private FragmentHomeBinding binding;
    private HomePresenter presenter;

    @SuppressLint("SetTextI18n")
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        initViews();
        listenerViews();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        AppSharedMethod.statusBarShow(getActivity());
    }

    private void initViews() {
        presenter = new HomePresenter(this, this);
        getDataHome();
    }

    private void listenerViews() {
        binding.icFilter.setOnClickListener(v -> AppSharedMethod.openFilterDialog());
    }

    private void getDataHome() {
        presenter.getRestaurantData(binding.rvHome);
    }

    @Override
    public void onListItemClicked(int position, int viewId) {
        if (viewId == R.id.ll_home) {
            Intent intent = new Intent(getActivity(), ResturentDetailsActivity.class);
            startActivity(intent);
        }
    }

}