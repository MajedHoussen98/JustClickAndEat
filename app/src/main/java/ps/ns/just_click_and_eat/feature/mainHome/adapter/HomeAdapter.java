package ps.ns.just_click_and_eat.feature.mainHome.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.feature.restaurantDetails.view.RestaurantDetailsActivity;
import ps.ns.just_click_and_eat.network.asp.model.HomeActivity.Home;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    Context context;
    List<Home> list;
    final private ListItemClickListener mOnClickListener;

    public interface ListItemClickListener {
        void onListItemClicked(int position, int viewId);
    }

    public HomeAdapter(Context context, List<Home> list, HomeAdapter.ListItemClickListener mOnClickListener) {
        this.context = context;
        this.list = list;
        this.mOnClickListener = mOnClickListener;
    }

    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_item, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder holder, int position) {
        Home data = list.get(position);
        Glide.with(context).load(data.getLogoUrl()).into(holder.restaurant_pic);
        holder.restaurant_name.setText(data.getName());
        holder.restaurant_status.setText(data.getStatus());
        holder.restaurant_address.setText(data.getAddress());
        holder.rating_number.setText(String.valueOf(data.getRating()));
        holder.restaurant_rating.setRating(data.getRating());

        if (data.getStatus().equals("Open")) {
            holder.restaurant_status.setTextColor(Color.parseColor("#74B743"));
        } else {
            holder.restaurant_status.setTextColor(Color.parseColor("#C11313"));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView restaurant_pic;
        TextView restaurant_name, restaurant_status, restaurant_address, rating_number;
        RatingBar restaurant_rating;
        private LinearLayout ll_home;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            restaurant_pic = itemView.findViewById(R.id.iv_resturant);
            restaurant_name = itemView.findViewById(R.id.tv_resturant_name);
            restaurant_status = itemView.findViewById(R.id.tv_restaurant_status);
            restaurant_address = itemView.findViewById(R.id.tv_resturant_address);
            restaurant_rating = itemView.findViewById(R.id.rb_resturant);
            rating_number = itemView.findViewById(R.id.tv_rating_value);
            ll_home = itemView.findViewById(R.id.ll_home);
            ll_home.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.ll_home) {
                int id = list.get(getAdapterPosition()).getId();
                Intent intent = new Intent(context, RestaurantDetailsActivity.class);
                intent.putExtra("restaurant_id", id);
                context.startActivity(intent);
//                ((Activity)context).finish();
            }
            mOnClickListener.onListItemClicked(getAdapterPosition(), v.getId());
        }
    }

}
