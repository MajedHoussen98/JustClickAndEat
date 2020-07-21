package ps.ns.eatapp.adapter;

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

import ps.ns.eatapp.R;
import ps.ns.eatapp.model.MyCartModel;

public class MyCartAdapter extends RecyclerView.Adapter<MyCartAdapter.ViewHolder> {

    Context context;
    List<MyCartModel> list;
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

    public MyCartAdapter(Context context, List<MyCartModel> list, MyCartAdapter.ListItemClickListener mOnClickListener) {
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

        final MyCartModel data = list.get(position);
        //Glide.with(context).load(data.getMeal_pic()).into(holder.meal_pic);
        holder.meal_name.setText(data.getMeal_name());
        holder.meal_description.setText(data.getMeal_description());
        holder.meal_price.setText(data.getMeal_price());
        holder.meal_quantity.setText(String.valueOf(data.getMeal_quantity()));

        if (showHide){
            //TODO: INvisable
            holder.ll_add_item.setVisibility(View.GONE);
        }else{
            //TODO: visable
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

        @Override
        public void onClick(View v) {
            mOnClickListener.onListItemClicked(getAdapterPosition(), v.getId());
        }
    }
}
