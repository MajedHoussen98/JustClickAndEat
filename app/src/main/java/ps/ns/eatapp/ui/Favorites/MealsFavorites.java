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
import ps.ns.eatapp.adapter.MyCartAdapter;
import ps.ns.eatapp.model.MealsFavoritesModel;
import ps.ns.eatapp.model.MyCartModel;


public class MealsFavorites extends Fragment implements MealsFavoritesAdapter.ListItemClickListener {

    private RecyclerView recyclerView;
    private MealsFavoritesAdapter adapter;
    private ArrayList<MealsFavoritesModel> list;
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_meals_favorites, container, false);
        initViews();
        return view;
    }

    private void initViews() {
        recyclerView = view.findViewById(R.id.recyclerMealsFavorites);
        list = new ArrayList<>();
        getMealsFavoritesData();
    }

    private void getMealsFavoritesData() {

        list.add(new MealsFavoritesModel("R.drawable.meal2","Crispy Chicken San","2x tuna sahimi, 3x vegetables","$29.50"));
        list.add(new MealsFavoritesModel("R.drawable.meal2","Prawn & Chicken Roll","2x tuna sahimi, 3x vegetables","$9.50"));
        list.add(new MealsFavoritesModel("R.drawable.meal2","Braised Fish Head","2x tuna sahimi, 3x vegetables ","$15.00"));
        list.add(new MealsFavoritesModel("R.drawable.meal2","Salad Fritters","2x tuna sahimi, 3x vegetables","$4.90"));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MealsFavoritesAdapter(getActivity(),list,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onListItemClicked(int position, int viewId) {

    }
}