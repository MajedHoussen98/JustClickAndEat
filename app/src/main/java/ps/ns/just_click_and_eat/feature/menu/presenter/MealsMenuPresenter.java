package ps.ns.just_click_and_eat.feature.menu.presenter;

import android.content.Intent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import ps.ns.just_click_and_eat.feature.menu.adapter.MenuAdapter;
import ps.ns.just_click_and_eat.feature.menu.view.MealsMenuView;
import ps.ns.just_click_and_eat.network.asp.feature.NetworkShared;
import ps.ns.just_click_and_eat.network.asp.model.meals.Meals;
import ps.ns.just_click_and_eat.network.utils.RequestListener;

public class MealsMenuPresenter {

    private MealsMenuView mView;
    private Fragment mFragment;

    public MealsMenuPresenter(MealsMenuView mView, Fragment mFragment) {
        this.mView = mView;
        this.mFragment = mFragment;
    }


    public void getMeals(String token, int id, RecyclerView recyclerView, ProgressBar progressBar){
        NetworkShared.getAsp().getGeneral().getMeals(token, id, new RequestListener<ArrayList<Meals>>() {
            @Override
            public void onSuccess(ArrayList<Meals> data) {
                progressBar.setVisibility(View.GONE);
                MenuAdapter adapter = new MenuAdapter(mFragment.getContext(), data, (MenuAdapter.ListItemClickListener)mFragment);
                recyclerView.setLayoutManager(new LinearLayoutManager(mFragment.getContext()));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFail(String message, int code) {
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}
