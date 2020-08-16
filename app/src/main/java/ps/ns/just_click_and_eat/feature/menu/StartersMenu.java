package ps.ns.just_click_and_eat.feature.menu;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ps.ns.just_click_and_eat.feature.mealsDetails.view.MealsDetailsActivity;
import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.adapter.MenuAdapter;
import ps.ns.just_click_and_eat.databinding.FragmentStartersMenuBinding;
import ps.ns.just_click_and_eat.model.MenuModel;


public class StartersMenu extends Fragment implements MenuAdapter.ListItemClickListener {

    private FragmentStartersMenuBinding binding;
    private MenuAdapter adapter;
    private ArrayList<MenuModel> list;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentStartersMenuBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        initViews();
        return view;
    }

    private void initViews() {
        list = new ArrayList<>();
        getStartersData();
    }

    private void getStartersData() {
        list.add(new MenuModel("https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fimg1.cookinglight.timeinc.net%2Fsites%2Fdefault%2Ffiles%2F1530030147%2Fchicken-and-bulgur-salad-with-peaches-1808-p17.jpg", "Braised Fish Head", "2x tuna sahimi, 3x vegetables ", "$15.00"));
        list.add(new MenuModel("https://www.samaa.tv/wp-content/uploads/2017/09/meals.jpg", "Salad Fritters", "2x tuna sahimi, 3x vegetables", "$4.90"));
        list.add(new MenuModel("https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fimg1.cookinglight.timeinc.net%2Fsites%2Fdefault%2Ffiles%2F1530030147%2Fchicken-and-bulgur-salad-with-peaches-1808-p17.jpg", "Braised Fish Head", "2x tuna sahimi, 3x vegetables ", "$15.00"));
        list.add(new MenuModel("https://www.samaa.tv/wp-content/uploads/2017/09/meals.jpg", "Salad Fritters", "2x tuna sahimi, 3x vegetables", "$4.90"));

        binding.rvStarters.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MenuAdapter(getContext(), list, this);
        binding.rvStarters.setAdapter(adapter);
    }

    @Override
    public void onListItemClicked(int position, int viewId) {
        switch (viewId) {
            case R.id.ll_menu:
                startActivity(new Intent(getActivity(), MealsDetailsActivity.class));
        }
    }
}