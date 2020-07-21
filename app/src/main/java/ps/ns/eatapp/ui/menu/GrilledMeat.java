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

import ps.ns.eatapp.databinding.FragmentGrilledMeatBinding;
import ps.ns.eatapp.ui.MealsDetailsActivity;
import ps.ns.eatapp.R;
import ps.ns.eatapp.adapter.MenuAdapter;
import ps.ns.eatapp.model.MenuModel;


public class GrilledMeat extends Fragment implements MenuAdapter.ListItemClickListener {

    private MenuAdapter adapter;
    private ArrayList<MenuModel> list;
    private View view;
    private FragmentGrilledMeatBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGrilledMeatBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        initViews();
        return view;
    }

    private void initViews() {
        list = new ArrayList<>();
        getGrilledMeatData();
    }

    private void getGrilledMeatData() {

        list.add(new MenuModel("R.drawable.meal2","Crispy Chicken San","2x tuna sahimi, 3x vegetables","$29.50"));
        list.add(new MenuModel("R.drawable.meal2","Prawn & Chicken Roll","2x tuna sahimi, 3x vegetables","$9.50"));
        list.add(new MenuModel("R.drawable.meal2","Braised Fish Head","2x tuna sahimi, 3x vegetables ","$15.00"));
        list.add(new MenuModel("R.drawable.meal2","Salad Fritters","2x tuna sahimi, 3x vegetables","$4.90"));

        binding.rvGrilledMeat.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter= new MenuAdapter(getContext(), list, this);
        binding.rvGrilledMeat.setAdapter(adapter);
    }

    @Override
    public void onListItemClicked(int position, int viewId) {
        switch (viewId){
            case R.id.ll_menu:
                startActivity(new Intent(getActivity(), MealsDetailsActivity.class));
        }
    }
}