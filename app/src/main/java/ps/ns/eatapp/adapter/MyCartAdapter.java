package ps.ns.eatapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import ps.ns.eatapp.R;
import ps.ns.eatapp.model.MyCartModel;

public class MyCartAdapter extends RecyclerView.Adapter<MyCartAdapter.ViewHolder> {

    Context context;
    List<MyCartModel> list;
    final private MyCartAdapter.ListItemClickListener mOnClickListener;

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
      //  Picasso.with(context).load(data.getMeal_pic()).into(holder.meal_pic);
        holder.meal_name.setText(data.getMeal_name());
        holder.meal_description.setText(data.getMeal_description());
        holder.meal_price.setText(data.getMeal_price());
        holder.meal_quantity.setText(String.valueOf(data.getMeal_quantity()));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView meal_pic, ic_add, ic_clear;
        TextView meal_name, meal_description, meal_price, meal_quantity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            meal_pic = itemView.findViewById(R.id.meal_pic);
            ic_add = itemView.findViewById(R.id.ic_add);
            ic_clear = itemView.findViewById(R.id.ic_clear);
            meal_name = itemView.findViewById(R.id.meal_name);
            meal_description = itemView.findViewById(R.id.meal_description);
            meal_price = itemView.findViewById(R.id.meal_price);
            meal_quantity = itemView.findViewById(R.id.quantity);

            ic_add.setOnClickListener(this);
            ic_clear.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mOnClickListener.onListItemClicked(getAdapterPosition(), v.getId());
        }
    }
}
