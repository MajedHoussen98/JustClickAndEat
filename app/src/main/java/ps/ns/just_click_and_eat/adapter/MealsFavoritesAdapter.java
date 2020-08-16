package ps.ns.just_click_and_eat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.model.MealsFavoritesModel;

public class MealsFavoritesAdapter extends RecyclerView.Adapter<MealsFavoritesAdapter.ViewHolder> {

    Context context;
    List<MealsFavoritesModel> list;
    final private MealsFavoritesAdapter.ListItemClickListener mOnClickListener;

    public interface ListItemClickListener {
        void onListItemClicked(int position, int viewId);
    }

    public MealsFavoritesAdapter(Context context, List<MealsFavoritesModel> list, ListItemClickListener mOnClickListener) {
        this.context = context;
        this.list = list;
        this.mOnClickListener = mOnClickListener;
    }

    @NonNull
    @Override
    public MealsFavoritesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.meals_favorites_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealsFavoritesAdapter.ViewHolder holder, int position) {

        final MealsFavoritesModel data = list.get(position);

        Glide.with(context).load(data.getMealsPicFavorites()).into(holder.mealsPicFavorites);
        holder.mealsNameFavorites.setText(data.getMealsNameFavorites());
        holder.mealsBodyFavorites.setText(data.getMealsBodyFavorites());
        holder.mealsPriceFavorites.setText(data.getMealsPriceFavorites());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView mealsPicFavorites, favClick;
        TextView mealsNameFavorites, mealsBodyFavorites, mealsPriceFavorites;
        LinearLayout llMealSFavorites;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mealsPicFavorites = itemView.findViewById(R.id.iv_meal_fav);
            mealsNameFavorites = itemView.findViewById(R.id.tv_meal_name_fav);
            mealsBodyFavorites = itemView.findViewById(R.id.tv_meal_body_fav);
            mealsPriceFavorites = itemView.findViewById(R.id.tv_meal_price_fav);
            llMealSFavorites = itemView.findViewById(R.id.ll_meal_fav);
            favClick = itemView.findViewById(R.id.ic_fav_click);

            llMealSFavorites.setOnClickListener(this);
            favClick.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mOnClickListener.onListItemClicked(getAdapterPosition(), v.getId());
        }
    }
}
