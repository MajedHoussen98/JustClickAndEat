package ps.ns.eatapp.ui.Favorites;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ps.ns.eatapp.R;
import ps.ns.eatapp.adapter.MealsFavoritesAdapter;
import ps.ns.eatapp.adapter.RestaurantsFavoritesAdapter;
import ps.ns.eatapp.databinding.FragmentRestaurantsFavoritesBinding;
import ps.ns.eatapp.model.MealsFavoritesModel;
import ps.ns.eatapp.model.RestaurantsFavoritesModel;
import ps.ns.eatapp.ui.MealsDetailsActivity;
import ps.ns.eatapp.ui.ResturentDetailsActivity;


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
        list.add(new RestaurantsFavoritesModel("R.drawable.meal2","Jimmy’s Food Store,", "4901 Bryan St, Dallas, TX 75206, USA"));
        list.add(new RestaurantsFavoritesModel("R.drawable.meal2","Gogo Sushi,", "NW 10th St, Oklahoma City, OK 73103, "));
        list.add(new RestaurantsFavoritesModel("R.drawable.meal2","Jimmy’s Food Store,", "4901 Bryan St, Dallas, TX 75206, USA"));
        list.add(new RestaurantsFavoritesModel("R.drawable.meal2","Gogo Sushi,", "NW 10th St, Oklahoma City, OK 73103, "));
        list.add(new RestaurantsFavoritesModel("R.drawable.meal2","Jimmy’s Food Store,", "4901 Bryan St, Dallas, TX 75206, USA"));
        list.add(new RestaurantsFavoritesModel("R.drawable.meal2","Gogo Sushi,", "NW 10th St, Oklahoma City, OK 73103, "));

        binding.rvRestaurantsFavorites.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RestaurantsFavoritesAdapter(getActivity(), list, this);
        binding.rvRestaurantsFavorites.setAdapter(adapter);

    }

    @Override
    public void onListItemClicked(int position, int viewId) {
        switch (viewId){
            case R.id.ll_restaurants_fav:
                startActivity(new Intent(getContext(), ResturentDetailsActivity.class));
                break;
        }
    }
}