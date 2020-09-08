package ps.ns.just_click_and_eat.feature.favorites.mealsFavorites.view;

import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.collection.ArrayMap;

import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.databinding.FragmentMealsFavoritesBinding;
import ps.ns.just_click_and_eat.feature.favorites.adapter.MealsFavoritesAdapter;
import ps.ns.just_click_and_eat.feature.favorites.mealsFavorites.presenter.MealsFavoritesPresenter;
import ps.ns.just_click_and_eat.feature.mealsDetails.view.MealsDetailsActivity;
import ps.ns.just_click_and_eat.utils.AppSharedData;
import ps.ns.just_click_and_eat.utils.AppSharedMethod;
import ps.ns.just_click_and_eat.utils.BaseFragment;


public class MealsFavorites extends BaseFragment implements MealsFavoritesAdapter.ListItemClickListener, MealsFavoritesView {

    private FragmentMealsFavoritesBinding binding;
    private MealsFavoritesPresenter presenter;
    private String MEALS_TYPE = "meals";
    ArrayMap<String, Object> params = new ArrayMap<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMealsFavoritesBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        initViews();
        return view;
    }

    private void initViews() {
        binding.progressBar.setVisibility(View.VISIBLE);
        presenter = new MealsFavoritesPresenter(this, this);
        presenter.getMealsFavorites(AppSharedData.getUserInfo().getTokenData().getAccessToken(), MEALS_TYPE, binding.rvMealsFavorites, binding.progressBar);
    }


    @Override
    public void onListItemClicked(int position, int viewId, int id) {
        if (viewId == R.id.ic_fav_click_m) {
            params.put("item_id", id);
            params.put("type", "meal");
            presenter.deleteMealsFavorites(AppSharedData.getUserInfo().getTokenData().getAccessToken(), params);
            presenter.getMealsFavorites(AppSharedData.getUserInfo().getTokenData().getAccessToken(), MEALS_TYPE, binding.rvMealsFavorites, binding.progressBar);
        }
//        if (viewId == R.id.ll_meal_fav) {
//            startActivity(new Intent(getContext(), MealsDetailsActivity.class));
//        }
    }
}