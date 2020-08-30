package ps.ns.just_click_and_eat.feature.mainHome.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ps.ns.just_click_and_eat.feature.mainHome.adapter.HomeAdapter;
import ps.ns.just_click_and_eat.databinding.FragmentHomeBinding;
import ps.ns.just_click_and_eat.feature.mainHome.homePresenter.HomePresenter;
import ps.ns.just_click_and_eat.feature.verfication.view.VerificationActivity;
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
        presenter.getRestaurantData(binding.rvHome);
    }

    private void listenerViews() {
        binding.icFilter.setOnClickListener(v -> AppSharedMethod.openFilterDialog());

        binding.icSearch.setOnClickListener(v -> presenter.search(AppSharedMethod.getTextFromEditText(binding.etSearchHome), binding.rvHome));
        binding.etSearchHome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (!String.valueOf(s).isEmpty()) {
                    binding.rvHome.setVisibility(View.VISIBLE);
                    presenter.search(String.valueOf(s), binding.rvHome);
                } else {
                    binding.rvHome.setVisibility(View.GONE);
                }

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
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
