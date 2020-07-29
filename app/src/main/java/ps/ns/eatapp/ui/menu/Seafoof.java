package ps.ns.eatapp.ui.menu;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ps.ns.eatapp.databinding.FragmentSeafoofBinding;
import ps.ns.eatapp.ui.MealsDetailsActivity;
import ps.ns.eatapp.R;
import ps.ns.eatapp.adapter.MenuAdapter;
import ps.ns.eatapp.model.MenuModel;

public class Seafoof extends Fragment implements MenuAdapter.ListItemClickListener {
    private MenuAdapter adapter;
    private ArrayList<MenuModel> list;
    private View view;
    private FragmentSeafoofBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSeafoofBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        initViews();
        return view;
    }

    private void initViews() {
        list = new ArrayList<>();
        getSeafoofdata();
    }

    private void getSeafoofdata() {
        list.add(new MenuModel("https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fimg1.cookinglight.timeinc.net%2Fsites%2Fdefault%2Ffiles%2F1530030147%2Fchicken-and-bulgur-salad-with-peaches-1808-p17.jpg", "Braised Fish Head", "2x tuna sahimi, 3x vegetables ", "$15.00"));
        list.add(new MenuModel("https://www.samaa.tv/wp-content/uploads/2017/09/meals.jpg", "Salad Fritters", "2x tuna sahimi, 3x vegetables", "$4.90"));
        list.add(new MenuModel("https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fimg1.cookinglight.timeinc.net%2Fsites%2Fdefault%2Ffiles%2F1530030147%2Fchicken-and-bulgur-salad-with-peaches-1808-p17.jpg", "Braised Fish Head", "2x tuna sahimi, 3x vegetables ", "$15.00"));
        list.add(new MenuModel("https://www.samaa.tv/wp-content/uploads/2017/09/meals.jpg", "Salad Fritters", "2x tuna sahimi, 3x vegetables", "$4.90"));

        binding.rvSeafoof.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MenuAdapter(getContext(), list, this);
        binding.rvSeafoof.setAdapter(adapter);
    }

    @Override
    public void onListItemClicked(int position, int viewId) {
        switch (viewId) {
            case R.id.ll_menu:
                startActivity(new Intent(getActivity(), MealsDetailsActivity.class));
        }
    }
}