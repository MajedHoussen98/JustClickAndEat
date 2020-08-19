package ps.ns.just_click_and_eat.feature.mainHome.view;

import android.content.Intent;
import android.os.Bundle;
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
import ps.ns.just_click_and_eat.network.asp.model.HomeModel;
import ps.ns.just_click_and_eat.feature.resturentDetails.view.ResturentDetailsActivity;
import ps.ns.just_click_and_eat.utils.AppSharedMethod;

public class HomeFragment extends Fragment implements HomeAdapter.ListItemClickListener, View.OnClickListener {


    private HomeAdapter adapter;
    private ArrayList<HomeModel> list;
    private View view;
    private FragmentHomeBinding binding;
    private HomePresenter presenter;
    private MainActivity mainActivity;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView titleBar = getActivity().findViewById(R.id.title_bar);
        titleBar.setText("Home");
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
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
        list = new ArrayList<>();
       presenter = new HomePresenter(HomeFragment.this, MainActivity.class);
       getDataHome();
    }

    private void listenerViews() {
        binding.icFilter.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ic_filter:
                openDialog();
            //    AppSharedMethod.statusBarHide(view);
                break;
        }
    }

    private void openDialog() {
        FilterDialogFragment dialog = new FilterDialogFragment();
      //  dialog.setStyle(DialogFragment.STYLE_NORMAL,0);
        dialog.show(getChildFragmentManager(), "FilterDialog");
    }

}