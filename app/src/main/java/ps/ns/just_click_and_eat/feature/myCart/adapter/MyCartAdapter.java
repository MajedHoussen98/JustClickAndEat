package ps.ns.just_click_and_eat.feature.myCart.adapter;

import android.annotation.SuppressLint;
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
import ps.ns.just_click_and_eat.network.asp.model.cart.CartItem;
import ps.ns.just_click_and_eat.network.asp.model.cart.CartModel;

public class MyCartAdapter extends RecyclerView.Adapter<MyCartAdapter.ViewHolder> {

    Context context;
    List<CartItem> list;
    List<CartModel> cartModelList;
    final private MyCartAdapter.ListItemClickListener mOnClickListener;
    private boolean showHide;

    public boolean isShowHide() {
        return showHide;
    }

    public void setShowHide(boolean showHide) {
        this.showHide = showHide;
    }

    public interface ListItemClickListener {
        void onListItemClicked(int position, int viewId);
    }

    public MyCartAdapter(Context context, List<CartItem> list, MyCartAdapter.ListItemClickListener mOnClickListener) {
        this.context = context;
        this.list = list;
        this.mOnClickListener = mOnClickListener;
    }


    @NonNull
    @Override
    public MyCartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.my_cart_item, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyCartAdapter.ViewHolder holder, int position) {

        final CartItem data = list.get(position);
        Glide.with(context).load(data.getMeal().getImageUrl()).into(holder.meal_pic);
        holder.meal_name.setText(data.getMeal().getName());
        holder.meal_description.setText(data.getMeal().getDesc());
        holder.meal_price.setText("$ " +data.getMeal().getPrice());
        holder.meal_quantity.setText(String.valueOf(data.getQuantity()));

        if (showHide) {
            //TODO: INvisable
            holder.ll_add_item.setVisibility(View.GONE);
        } else {
            //TODO: viable
            holder.ll_add_item.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView meal_pic, ic_add, ic_clear;
        TextView meal_name, meal_description, meal_price, meal_quantity;
        LinearLayout ll_add_item;
        LinearLayout ll_cart_item;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            meal_pic = itemView.findViewById(R.id.iv_meal);
            ic_add = itemView.findViewById(R.id.ic_add);
            ic_clear = itemView.findViewById(R.id.ic_clear);
            meal_name = itemView.findViewById(R.id.tv_meal_name);
            meal_description = itemView.findViewById(R.id.meal_description);
            meal_price = itemView.findViewById(R.id.meal_price);
            meal_quantity = itemView.findViewById(R.id.quantity);
            ll_add_item = itemView.findViewById(R.id.ll_add_item);
            ll_cart_item = itemView.findViewById(R.id.ll_cart_item);
            ic_add.setOnClickListener(this);
            ic_clear.setOnClickListener(this);
            ll_cart_item.setOnClickListener(this);
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onClick(View v) {

            if (v.getId() == R.id.ic_add) {
                int quantity = Integer.parseInt(String.valueOf(meal_quantity.getText()));
                double price = Double.parseDouble(String.valueOf(list.get(getAdapterPosition()).getMeal().getPrice()));
                quantity++;
                meal_quantity.setText(String.valueOf(quantity));
                Double quantityPrice = price * quantity;
                meal_price.setText(quantityPrice + " $");

            } else if (v.getId() == R.id.ic_clear) {
                int quantity = Integer.parseInt(String.valueOf(meal_quantity.getText()));
                double price = Double.parseDouble(list.get(getAdapterPosition()).getMeal().getPrice().toString());
                if (quantity == 1) {
                    meal_quantity.setText("1");
                } else {
                    quantity--;
                    meal_quantity.setText(String.valueOf(quantity));
                    Double quantityPrice = price * quantity;
                    meal_price.setText(quantityPrice + " $");
                }

            }
        }
    }
}
