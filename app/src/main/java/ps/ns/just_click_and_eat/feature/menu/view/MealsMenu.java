package ps.ns.just_click_and_eat.feature.menu.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ps.ns.just_click_and_eat.databinding.FragmentMealsMenuBinding;
import ps.ns.just_click_and_eat.feature.mealsDetails.view.MealsDetailsActivity;
import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.feature.menu.adapter.MenuAdapter;
import ps.ns.just_click_and_eat.feature.menu.presenter.MealsMenuPresenter;
import ps.ns.just_click_and_eat.network.asp.model.meals.Meals;
import ps.ns.just_click_and_eat.utils.AppSharedData;
import ps.ns.just_click_and_eat.utils.BaseFragment;


public class MealsMenu extends BaseFragment implements MenuAdapter.ListItemClickListener, MealsMenuView {

    private FragmentMealsMenuBinding binding;
    private int menuId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            menuId = getArguments().getInt("id", 0);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMealsMenuBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        initViews();
        return view;
    }

    private void initViews() {
        binding.progressBar.setVisibility(View.VISIBLE);
        MealsMenuPresenter presenter = new MealsMenuPresenter(this, this);
        presenter.getMeals(AppSharedData.getUserInfo().getTokenData().getAccessToken(), menuId, binding.rvMealsMenu, binding.progressBar);
    }


    @Override
    public void onListItemClicked(int position, int viewId, List<Meals> list) {
        if (viewId == R.id.ll_menu) {
            int id = list.get(position).getId();
                int re_id = list.get(position).getMenu().getRstId();
                int code = 1;
                String image = list.get(position).getImageUrl();
                String name = list.get(position).getName();
                String description = list.get(position).getDesc();

                Intent intent = new Intent(getContext(), MealsDetailsActivity.class);
                intent.putExtra("image", image);
                intent.putExtra("meal_id", id);
                intent.putExtra("CODE", code);
                intent.putExtra("restaurant_id", re_id);
                intent.putExtra("name", name);
                intent.putExtra("description", description);
                getActivity().startActivity(intent);
                getActivity().finish();
        }
    }
}