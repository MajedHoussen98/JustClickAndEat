package ps.ns.eatapp.adapter;

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
import com.squareup.picasso.Picasso;

import java.util.List;

import ps.ns.eatapp.R;
import ps.ns.eatapp.model.MealsFavoritesModel;
import ps.ns.eatapp.model.RestaurantsFavoritesModel;

public class RestaurantsFavoritesAdapter extends RecyclerView.Adapter<RestaurantsFavoritesAdapter.ViewHolder> {
    Context context;
    List<RestaurantsFavoritesModel> list;
    final private RestaurantsFavoritesAdapter.ListItemClickListener mOnClickListener;

    public interface ListItemClickListener {
        void onListItemClicked(int position, int viewId);
    }

    public RestaurantsFavoritesAdapter(Context context, List<RestaurantsFavoritesModel> list, ListItemClickListener mOnClickListener) {
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
        final RestaurantsFavoritesModel data = list.get(position);
       // Glide.with(context).load(data.getRestaurantsPicFavorites()).into(holder.restaurantsPicFavorites);
        holder.restaurantNameFavorites.setText(data.getRestaurantsNameFavorites());
        holder.restaurantBodyFavorites.setText(data.getRestaurantsBodyFavorites());
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
            favClick = itemView.findViewById(R.id.ic_fav_click);

            llRestaurantSFavorites.setOnClickListener(this);
         //   favClick.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mOnClickListener.onListItemClicked(getAdapterPosition(), v.getId());
        }
    }
}
