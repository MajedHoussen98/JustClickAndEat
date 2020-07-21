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
import ps.ns.eatapp.adapter.MyCartAdapter;
import ps.ns.eatapp.databinding.FragmentMealsFavoritesBinding;
import ps.ns.eatapp.model.MealsFavoritesModel;
import ps.ns.eatapp.model.MyCartModel;
import ps.ns.eatapp.ui.MealsDetailsActivity;


public class MealsFavorites extends Fragment implements MealsFavoritesAdapter.ListItemClickListener {
    private View view;
    private FragmentMealsFavoritesBinding binding;
    private MealsFavoritesAdapter adapter;
    private ArrayList<MealsFavoritesModel> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMealsFavoritesBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        initViews();
        return view;
    }

    private void initViews() {
        list = new ArrayList<>();
        getMealsFavoritesData();
    }

    private void getMealsFavoritesData() {

        list.add(new MealsFavoritesModel("R.drawable.meal2","Crispy Chicken San","2x tuna sahimi, 3x vegetables","$29.50"));
        list.add(new MealsFavoritesModel("R.drawable.meal2","Prawn & Chicken Roll","2x tuna sahimi, 3x vegetables","$9.50"));
        list.add(new MealsFavoritesModel("R.drawable.meal2","Braised Fish Head","2x tuna sahimi, 3x vegetables ","$15.00"));
        list.add(new MealsFavoritesModel("R.drawable.meal2","Salad Fritters","2x tuna sahimi, 3x vegetables","$4.90"));

        binding.rvMealsFavorites.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MealsFavoritesAdapter(getActivity(),list,this);
        binding.rvMealsFavorites.setAdapter(adapter);
    }

    @Override
    public void onListItemClicked(int position, int viewId) {
        switch (viewId){
            case R.id.ll_meal_fav:
                startActivity(new Intent(getContext(), MealsDetailsActivity.class));
                break;
        }
    }
}