package ps.ns.eatapp.ui.menu;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ps.ns.eatapp.ui.MealsDetailsActivity;
import ps.ns.eatapp.R;
import ps.ns.eatapp.adapter.MenuAdapter;
import ps.ns.eatapp.databinding.FragmentStartersMenuBinding;
import ps.ns.eatapp.model.MenuModel;


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
        list.add(new MenuModel("R.drawable.meal2","Crispy Chicken San","2x tuna sahimi, 3x vegetables","$29.50"));
        list.add(new MenuModel("R.drawable.meal2","Prawn & Chicken Roll","2x tuna sahimi, 3x vegetables","$9.50"));
        list.add(new MenuModel("R.drawable.meal2","Braised Fish Head","2x tuna sahimi, 3x vegetables ","$15.00"));
        list.add(new MenuModel("R.drawable.meal2","Salad Fritters","2x tuna sahimi, 3x vegetables","$4.90"));

        binding.rvStarters.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter= new MenuAdapter(getContext(), list, this);
        binding.rvStarters.setAdapter(adapter);
    }

    @Override
    public void onListItemClicked(int position, int viewId) {
            switch (viewId){
                case R.id.ll_menu:
                    startActivity(new Intent(getActivity(), MealsDetailsActivity.class));
            }
    }
}