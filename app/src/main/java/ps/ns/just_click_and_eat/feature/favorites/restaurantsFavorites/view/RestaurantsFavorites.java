package ps.ns.just_click_and_eat.feature.favorites.restaurantsFavorites.view;

import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.collection.ArrayMap;

import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.feature.favorites.adapter.RestaurantsFavoritesAdapter;
import ps.ns.just_click_and_eat.databinding.FragmentRestaurantsFavoritesBinding;
import ps.ns.just_click_and_eat.feature.favorites.restaurantsFavorites.presenter.RestaurantsFavoritesPresenter;
import ps.ns.just_click_and_eat.utils.AppSharedData;
import ps.ns.just_click_and_eat.utils.BaseFragment;


public class RestaurantsFavorites extends BaseFragment implements RestaurantsFavoritesAdapter.ListItemClickListener, RestaurantsFavoritesView {
    private FragmentRestaurantsFavoritesBinding binding;
    private RestaurantsFavoritesPresenter presenter;
    private String RESTAURANTS_TYPE = "restaurants";
    ArrayMap<String, Object> params = new ArrayMap<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRestaurantsFavoritesBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        initViews();
        return view;
    }

    private void initViews() {
        binding.progressBar.setVisibility(View.VISIBLE);
        presenter = new RestaurantsFavoritesPresenter(this, this);
        presenter.getRestaurantsFavorites(AppSharedData.getUserInfo().getTokenData().getAccessToken(), RESTAURANTS_TYPE, binding.rvRestaurantsFavorites, binding.progressBar);
    }


    @Override
    public void onListItemClicked(int position, int viewId, int id) {
        Log.e("id" , "" + id);
        if (viewId == R.id.iv_fav_click_r) {
            params.put("item_id", id);
            params.put("type", "restaurant");
            presenter.deleteRestaurantsFavorites(AppSharedData.getUserInfo().getTokenData().getAccessToken(), params);
            presenter.getRestaurantsFavorites(AppSharedData.getUserInfo().getTokenData().getAccessToken(), RESTAURANTS_TYPE, binding.rvRestaurantsFavorites, binding.progressBar);
        }

    }
}