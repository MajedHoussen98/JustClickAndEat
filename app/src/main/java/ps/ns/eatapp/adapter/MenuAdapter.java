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

import com.squareup.picasso.Picasso;

import java.util.List;

import ps.ns.eatapp.R;
import ps.ns.eatapp.model.MenuModel;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    Context context;
    List<MenuModel> list;
    final private MenuAdapter.ListItemClickListener mOnClickListener;

    public interface ListItemClickListener {
        void onListItemClicked(int position, int viewId);
    }

    public MenuAdapter(Context context, List<MenuModel> list, ListItemClickListener mOnClickListener) {
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

        final MenuModel data = list.get(position);

     //   Picasso.with(context).load(data.getMealsPic()).into(holder.mealsPic);
        holder.mealsName.setText(data.getMealsName());
        holder.mealsBody.setText(data.getMealsBody());
        holder.mealsPrice.setText(data.getMealsPrice());
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

            mealsPic = itemView.findViewById(R.id.meal_pic);
            mealsName = itemView.findViewById(R.id.meal_name);
            mealsBody = itemView.findViewById(R.id.meal_body);
            mealsPrice = itemView.findViewById(R.id.meal_price);
            ll_menu = itemView.findViewById(R.id.ll_menu);

            ll_menu.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mOnClickListener.onListItemClicked(getAdapterPosition(), v.getId());
        }
    }
}
