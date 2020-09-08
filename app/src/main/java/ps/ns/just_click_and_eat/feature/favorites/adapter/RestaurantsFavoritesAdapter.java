package ps.ns.just_click_and_eat.feature.favorites.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.feature.restaurantDetails.view.RestaurantDetailsActivity;
import ps.ns.just_click_and_eat.network.asp.model.restaurants.Restaurants;

public class RestaurantsFavoritesAdapter extends RecyclerView.Adapter<RestaurantsFavoritesAdapter.ViewHolder> {
    Context context;
    List<Restaurants> list;
    final private RestaurantsFavoritesAdapter.ListItemClickListener mOnClickListener;

    public interface ListItemClickListener {
        void onListItemClicked(int position, int viewId, int id);
    }


    public RestaurantsFavoritesAdapter(Context context, List<Restaurants> list, ListItemClickListener mOnClickListener) {
        this.context = context;
        this.list = list;
        this.mOnClickListener = mOnClickListener;
    }

    @NonNull
    @Override
    public RestaurantsFavoritesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.restaurants_favorites_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantsFavoritesAdapter.ViewHolder holder, int position) {
        final Restaurants data = list.get(position);
        Glide.with(context).load(data.getLogoUrl()).into(holder.restaurantsPicFavorites);
        holder.restaurantNameFavorites.setText(data.getName());
        holder.restaurantBodyFavorites.setText(data.getAddress());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView restaurantsPicFavorites, favClick;
        TextView restaurantNameFavorites, restaurantBodyFavorites;
        LinearLayout llRestaurantSFavorites;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            restaurantsPicFavorites = itemView.findViewById(R.id.iv_restaurants_fav);
            restaurantNameFavorites = itemView.findViewById(R.id.tv_restaurants_name_fav);
            restaurantBodyFavorites = itemView.findViewById(R.id.tv_restaurants_body_fav);
            llRestaurantSFavorites = itemView.findViewById(R.id.ll_restaurants_fav);
            favClick = itemView.findViewById(R.id.iv_fav_click_r);

            llRestaurantSFavorites.setOnClickListener(this);
            favClick.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.ll_restaurants_fav) {
                int id = list.get(getAdapterPosition()).getId();
                Intent intent = new Intent(context, RestaurantDetailsActivity.class);
                intent.putExtra("restaurant_id", id);
                context.startActivity(intent);
            }
            mOnClickListener.onListItemClicked(getAdapterPosition(), v.getId(), list.get(getAdapterPosition()).getId());
        }
    }
}
