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

        list.add(new MealsFavoritesModel("https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fimg1.cookinglight.timeinc.net%2Fsites%2Fdefault%2Ffiles%2F1530030147%2Fchicken-and-bulgur-salad-with-peaches-1808-p17.jpg","Braised Fish Head","2x tuna sahimi, 3x vegetables ","$15.00"));
        list.add(new MealsFavoritesModel("https://www.samaa.tv/wp-content/uploads/2017/09/meals.jpg","Salad Fritters","2x tuna sahimi, 3x vegetables","$4.90"));
        list.add(new MealsFavoritesModel("https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fimg1.cookinglight.timeinc.net%2Fsites%2Fdefault%2Ffiles%2F1530030147%2Fchicken-and-bulgur-salad-with-peaches-1808-p17.jpg","Braised Fish Head","2x tuna sahimi, 3x vegetables ","$15.00"));
        list.add(new MealsFavoritesModel("https://www.samaa.tv/wp-content/uploads/2017/09/meals.jpg","Salad Fritters","2x tuna sahimi, 3x vegetables","$4.90"));

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