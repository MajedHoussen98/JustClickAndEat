package ps.ns.just_click_and_eat.feature.menu.adapter;

import android.content.Context;
import android.content.Intent;
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
import ps.ns.just_click_and_eat.feature.mealsDetails.view.MealsDetailsActivity;
import ps.ns.just_click_and_eat.network.asp.model.meals.Meals;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    Context context;
    List<Meals> list;
    final private MenuAdapter.ListItemClickListener mOnClickListener;

    public interface ListItemClickListener {
        void onListItemClicked(int position, int viewId, List<Meals> list);
    }

    public MenuAdapter(Context context, List<Meals> list, ListItemClickListener mOnClickListener) {
        this.context = context;
        this.list = list;
        this.mOnClickListener = mOnClickListener;
    }

    @NonNull
    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.menu_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.ViewHolder holder, int position) {

        final Meals data = list.get(position);

        Glide.with(context).load(data.getImageUrl()).into(holder.mealsPic);
        holder.mealsName.setText(data.getName());
        holder.mealsBody.setText(data.getName());
        holder.mealsPrice.setText(String.valueOf(data.getPrice()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView mealsPic;
        TextView mealsName, mealsBody, mealsPrice;
        LinearLayout ll_menu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mealsPic = itemView.findViewById(R.id.iv_meal);
            mealsName = itemView.findViewById(R.id.tv_meal_name);
            mealsBody = itemView.findViewById(R.id.tv_meal_body);
            mealsPrice = itemView.findViewById(R.id.tv_meal_price);
            ll_menu = itemView.findViewById(R.id.ll_menu);

            ll_menu.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mOnClickListener.onListItemClicked(getAdapterPosition(), v.getId(), list);
        }
    }
}
