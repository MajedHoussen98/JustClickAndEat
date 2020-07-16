package ps.ns.eatapp.ui.Favorites;

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
import ps.ns.eatapp.model.MealsFavoritesModel;
import ps.ns.eatapp.model.RestaurantsFavoritesModel;


public class RestaurantsFavorites extends Fragment implements RestaurantsFavoritesAdapter.ListItemClickListener {

    private RecyclerView recyclerView;
    private RestaurantsFavoritesAdapter adapter;
    private ArrayList<RestaurantsFavoritesModel> list;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this
        view = inflater.inflate(R.layout.fragment_restaurants_favorites, container, false);
        initViews();

        return view;
    }

    private void initViews() {
        recyclerView = view.findViewById(R.id.recyclerRestaurantsFavorites);
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

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RestaurantsFavoritesAdapter(getActivity(), list, this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onListItemClicked(int position, int viewId) {

    }
}