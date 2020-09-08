package ps.ns.just_click_and_eat.feature.favorites.mealsFavorites.presenter;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ps.ns.just_click_and_eat.feature.favorites.adapter.MealsFavoritesAdapter;
import ps.ns.just_click_and_eat.feature.favorites.adapter.RestaurantsFavoritesAdapter;
import ps.ns.just_click_and_eat.feature.favorites.mealsFavorites.view.MealsFavorites;
import ps.ns.just_click_and_eat.feature.favorites.restaurantsFavorites.presenter.RestaurantsFavoritesPresenter;
import ps.ns.just_click_and_eat.network.asp.feature.NetworkShared;
import ps.ns.just_click_and_eat.network.asp.model.meals.Meals;
import ps.ns.just_click_and_eat.network.utils.RequestListener;

public class MealsFavoritesPresenter {

    private MealsFavorites mView;
    private Fragment mFragment;

    public MealsFavoritesPresenter(MealsFavorites mView, Fragment mFragment) {
        this.mView = mView;
        this.mFragment = mFragment;
    }

    public void getMealsFavorites(String token, String type, RecyclerView recyclerView, ProgressBar progressBar) {
        NetworkShared.getAsp().getFavorites().getMealsFavorite(token, type, new RequestListener<ArrayList<Meals>>() {
            @Override
            public void onSuccess(ArrayList<Meals> data) {
                progressBar.setVisibility(View.GONE);
                MealsFavoritesAdapter adapter = new MealsFavoritesAdapter(mFragment.getContext(), data, (MealsFavoritesAdapter.ListItemClickListener) mFragment);
                recyclerView.setLayoutManager(new LinearLayoutManager(mFragment.getContext()));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFail(String message, int code) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(mFragment.getContext(), message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void deleteMealsFavorites(String token, ArrayMap<String, Object> params) {
        NetworkShared.getAsp().getFavorites().deleteMealsFavorite(token, params, new RequestListener<ArrayList<Meals>>() {
            @Override
            public void onSuccess(ArrayList<Meals> data) {
                Toast.makeText(mFragment.getContext(), "The Favorite has been removed", Toast.LENGTH_SHORT).show();
                mFragment.getActivity().finish();
                mFragment.getActivity().startActivity(mFragment.getActivity().getIntent());
            }

            @Override
            public void onFail(String message, int code) {
                Toast.makeText(mFragment.getContext(), message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
