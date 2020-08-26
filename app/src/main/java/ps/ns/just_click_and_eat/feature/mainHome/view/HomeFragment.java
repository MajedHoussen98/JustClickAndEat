package ps.ns.just_click_and_eat.feature.mainHome.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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
import ps.ns.just_click_and_eat.feature.verfication.view.VerificationActivity;
import ps.ns.just_click_and_eat.network.asp.feature.General;
import ps.ns.just_click_and_eat.network.asp.model.HomeModel;
import ps.ns.just_click_and_eat.feature.resturentDetails.view.ResturentDetailsActivity;
import ps.ns.just_click_and_eat.network.utils.RequestListener;
import ps.ns.just_click_and_eat.utils.AppSharedMethod;
import ps.ns.just_click_and_eat.utils.BaseFragment;

import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_WHERE;

public class HomeFragment extends BaseFragment implements HomeAdapter.ListItemClickListener, HomeView {

    private FragmentHomeBinding binding;
    private HomePresenter presenter;

    public static Intent newInstance(Activity mActivity, int fromWhere) {
        Intent intent = new Intent(mActivity, VerificationActivity.class);
        intent.putExtra(FROM_WHERE, fromWhere);
        return intent;
    }

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
        }

    @Override
    public void showMessage(String msg) {
        super.showMessage(msg);
        snackErrorShow(binding.getRoot(), msg);
    }
}
