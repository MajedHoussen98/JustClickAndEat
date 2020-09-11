package ps.ns.just_click_and_eat.feature.mealsDetails.presenter;

import android.content.Intent;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ps.ns.just_click_and_eat.feature.favorites.Favorites;
import ps.ns.just_click_and_eat.feature.mealsDetails.adapter.IngredientAdapter;
import ps.ns.just_click_and_eat.feature.mealsDetails.view.MealsDetailsActivity;
import ps.ns.just_click_and_eat.feature.mealsDetails.view.MealsDetailsView;
import ps.ns.just_click_and_eat.network.asp.feature.NetworkShared;
import ps.ns.just_click_and_eat.network.asp.model.meals.Meals;
import ps.ns.just_click_and_eat.network.utils.RequestListener;

public class MealsDetailsPresenter {

    private MealsDetailsActivity mActivity;
    private MealsDetailsView mView;

    public MealsDetailsPresenter(MealsDetailsActivity mActivity, MealsDetailsView mView) {
        this.mActivity = mActivity;
        this.mView = mView;
    }

    public void goToFavoriteActivity(int CODE) {
        if (CODE == 0) {
            Intent intent = new Intent(mActivity, Favorites.class);
            intent.putExtra("CODE", CODE);
            mActivity.startActivity(intent);
            mActivity.finish();
        }
    }

    public void getMealIngredients(int id, RecyclerView recyclerView) {
        Log.e("ids", id + "");
        NetworkShared.getAsp().getGeneral().getMealIngredients(id, new RequestListener<ArrayList<Meals>>() {
            @Override
            public void onSuccess(ArrayList<Meals> data) {
                IngredientAdapter adapter = new IngredientAdapter(mActivity, data, (IngredientAdapter.ListItemClickListener) mActivity);
                recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFail(String message, int code) {
                Log.e("fail", message);
            }
        });
    }
}
