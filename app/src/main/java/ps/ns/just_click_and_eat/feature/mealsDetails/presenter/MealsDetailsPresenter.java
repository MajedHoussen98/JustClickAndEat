package ps.ns.just_click_and_eat.feature.mealsDetails.presenter;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ps.ns.just_click_and_eat.feature.favorites.Favorites;
import ps.ns.just_click_and_eat.feature.mealsDetails.adapter.IngredientAdapter;
import ps.ns.just_click_and_eat.feature.mealsDetails.view.MealsDetailsActivity;
import ps.ns.just_click_and_eat.feature.mealsDetails.view.MealsDetailsView;
import ps.ns.just_click_and_eat.feature.menu.view.MenuActivity;
import ps.ns.just_click_and_eat.network.asp.feature.NetworkShared;
import ps.ns.just_click_and_eat.network.asp.model.meals.Ingredient;
import ps.ns.just_click_and_eat.network.utils.RequestListener;

public class MealsDetailsPresenter {

    private MealsDetailsActivity mActivity;
    private MealsDetailsView mView;

    public MealsDetailsPresenter(MealsDetailsActivity mActivity, MealsDetailsView mView) {
        this.mActivity = mActivity;
        this.mView = mView;
    }

    public void goToActivity(int CODE, int resId) {
        if (CODE == 0) {
            Intent intent = new Intent(mActivity, Favorites.class);
            intent.putExtra("CODE", CODE);
            mActivity.startActivity(intent);
            mActivity.finish();
        }else if (CODE == 1){
            Intent intent = new Intent(mActivity, MenuActivity.class);
            intent.putExtra("CODE", CODE);
            intent.putExtra("restaurant_id", resId);
            mActivity.startActivity(intent);
            mActivity.finish();
        }
    }

    public void getMealIngredients(int id, RecyclerView recyclerView, TextView tvIngredient) {
        NetworkShared.getAsp().getGeneral().getMealIngredients(id, new RequestListener<ArrayList<Ingredient>>() {
            @Override
            public void onSuccess(ArrayList<Ingredient> data) {
                if (data.size() != 0){
                    IngredientAdapter adapter = new IngredientAdapter(mActivity, data.get(0).getData(), (IngredientAdapter.ListItemClickListener) mActivity);
                    recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
                    recyclerView.setAdapter(adapter);
                }else {
                    tvIngredient.setVisibility(View.GONE);
                }

            }

            @Override
            public void onFail(String message, int code) {
            }
        });
    }
}
