package ps.ns.just_click_and_eat.feature.favorites;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.feature.favorites.adapter.RestaurantsFavoritesAdapter;
import ps.ns.just_click_and_eat.databinding.FragmentRestaurantsFavoritesBinding;
import ps.ns.just_click_and_eat.dataBase.RestaurantsFavoritesModel;
import ps.ns.just_click_and_eat.feature.restaurantDetails.view.RestaurantDetailsActivity;


public class RestaurantsFavorites extends Fragment implements RestaurantsFavoritesAdapter.ListItemClickListener {
    private View view;
    private FragmentRestaurantsFavoritesBinding binding;
    private RestaurantsFavoritesAdapter adapter;
    private ArrayList<RestaurantsFavoritesModel> list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRestaurantsFavoritesBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        initViews();

        return view;
    }

    private void initViews() {
        list = new ArrayList<>();
        getRestaurantsFavoritesData();
    }

    private void getRestaurantsFavoritesData() {
        list.add(new RestaurantsFavoritesModel("https://images.unsplash.com/photo-1555396273-367ea4eb4db5?ixlib=rb-1.2.1&auto=format&fit=crop&w=667&q=80","Jimmy’s Food Store,", "4901 Bryan St, Dallas, TX 75206, USA"));
        list.add(new RestaurantsFavoritesModel("https://media-cdn.tripadvisor.com/media/photo-s/11/4a/54/fe/essence-restaurant.jpg","Gogo Sushi,", "NW 10th St, Oklahoma City, OK 73103, "));
        list.add(new RestaurantsFavoritesModel("https://www.samm-honfleur.com/gallery/20180315171008(1).jpg","Jimmy’s Food Store,", "4901 Bryan St, Dallas, TX 75206, USA"));
        list.add(new RestaurantsFavoritesModel("https://www.wien.info/media/images/41993-das-loft-sofitel-so-vienna-3to2.jpeg/image_teaser-all","Gogo Sushi,", "NW 10th St, Oklahoma City, OK 73103, "));
        list.add(new RestaurantsFavoritesModel("https://restaurantengine.com/wp-content/uploads/2015/05/startup-restaurants-typically-overspend.jpg","Jimmy’s Food Store,", "4901 Bryan St, Dallas, TX 75206, USA"));
        list.add(new RestaurantsFavoritesModel("https://media-cdn.tripadvisor.com/media/photo-s/1a/08/56/10/le-restaurant-avec-sa.jpg","Gogo Sushi,", "NW 10th St, Oklahoma City, OK 73103, "));

        binding.rvRestaurantsFavorites.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RestaurantsFavoritesAdapter(getActivity(), list, this);
        binding.rvRestaurantsFavorites.setAdapter(adapter);

    }

    @Override
    public void onListItemClicked(int position, int viewId) {
        switch (viewId){
            case R.id.ll_restaurants_fav:
                startActivity(new Intent(getContext(), RestaurantDetailsActivity.class));
                break;
        }
    }
}