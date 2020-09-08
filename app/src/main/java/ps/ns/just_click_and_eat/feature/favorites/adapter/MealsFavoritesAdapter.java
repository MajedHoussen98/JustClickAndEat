package ps.ns.just_click_and_eat.feature.favorites.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.feature.mealsDetails.view.MealsDetailsActivity;
import ps.ns.just_click_and_eat.feature.restaurantDetails.view.RestaurantDetailsActivity;
import ps.ns.just_click_and_eat.network.asp.model.meals.Meals;
import ps.ns.just_click_and_eat.network.asp.model.restaurants.Images;

public class MealsFavoritesAdapter extends RecyclerView.Adapter<MealsFavoritesAdapter.ViewHolder> {

    Context context;
    List<Meals> list;
    final private MealsFavoritesAdapter.ListItemClickListener mOnClickListener;

    public interface ListItemClickListener {
        void onListItemClicked(int position, int viewId, int id);
    }

    public MealsFavoritesAdapter(Context context, List<Meals> list, ListItemClickListener mOnClickListener) {
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

        final Meals data = list.get(position);

        Glide.with(context).load(data.getImageUrl()).into(holder.mealsPicFavorites);
        holder.mealsNameFavorites.setText(data.getName());
        holder.mealsBodyFavorites.setText(data.getName());
        holder.mealsPriceFavorites.setText(String.valueOf(data.getPrice()));
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
            favClick = itemView.findViewById(R.id.ic_fav_click_m);

            llMealSFavorites.setOnClickListener(this);
            favClick.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.ll_meal_fav) {
                int id = list.get(getAdapterPosition()).getId();
                int re_id = list.get(getAdapterPosition()).getMenu().getRstId();
                int code = 1;

                ArrayList<Images> images = (ArrayList<Images>) list.get(getAdapterPosition()).getImages();
                String name = list.get(getAdapterPosition()).getName();
                String description = list.get(getAdapterPosition()).getDesc();
                Intent intent = new Intent(context, MealsDetailsActivity.class);
                intent.putExtra("meal_id", id);
                intent.putExtra("code", code);
                intent.putExtra("restaurant_id", re_id);
                intent.putExtra("name", name);
                intent.putExtra("description", description);

                context.startActivity(intent);

            }
            mOnClickListener.onListItemClicked(getAdapterPosition(), v.getId(), list.get(getAdapterPosition()).getId());
        }
    }
}
