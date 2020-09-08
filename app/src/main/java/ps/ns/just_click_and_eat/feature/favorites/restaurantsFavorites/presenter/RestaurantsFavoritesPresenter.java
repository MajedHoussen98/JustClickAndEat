package ps.ns.just_click_and_eat.feature.favorites.restaurantsFavorites.presenter;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ps.ns.just_click_and_eat.feature.favorites.adapter.RestaurantsFavoritesAdapter;
import ps.ns.just_click_and_eat.feature.favorites.restaurantsFavorites.view.RestaurantsFavoritesView;
import ps.ns.just_click_and_eat.network.asp.feature.NetworkShared;
import ps.ns.just_click_and_eat.network.asp.model.restaurants.Restaurants;
import ps.ns.just_click_and_eat.network.utils.RequestListener;

public class RestaurantsFavoritesPresenter {

    private RestaurantsFavoritesView mView;
    private Fragment mFragment;


    public RestaurantsFavoritesPresenter(RestaurantsFavoritesView mView, Fragment mFragment) {
        this.mView = mView;
        this.mFragment = mFragment;
    }

    public void getRestaurantsFavorites(String token, String type, RecyclerView recyclerView, ProgressBar progressBar) {
        NetworkShared.getAsp().getFavorites().getRestaurantFavorite(token, type, new RequestListener<ArrayList<Restaurants>>() {
            @Override
            public void onSuccess(ArrayList<Restaurants> data) {
                progressBar.setVisibility(View.GONE);
                RestaurantsFavoritesAdapter adapter = new RestaurantsFavoritesAdapter(mFragment.getContext(),data, (RestaurantsFavoritesAdapter.ListItemClickListener) mFragment);
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

    public void deleteRestaurantsFavorites(String token, ArrayMap<String, Object> params) {
        NetworkShared.getAsp().getFavorites().deleteRestaurantFavorite(token, params, new RequestListener<ArrayList<Restaurants>>() {
            @Override
            public void onSuccess(ArrayList<Restaurants> data) {
                Toast.makeText(mFragment.getContext(), "The Favorite has been removed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFail(String message, int code) {
                Toast.makeText(mFragment.getContext(), message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
