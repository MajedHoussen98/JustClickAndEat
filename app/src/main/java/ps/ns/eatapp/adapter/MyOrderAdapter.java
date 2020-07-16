package ps.ns.eatapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ps.ns.eatapp.R;
import ps.ns.eatapp.model.MyOrderModel;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.ViewHolder> {

    Context context;
    List<MyOrderModel> list;
    final private MyOrderAdapter.ListItemClickListener mOnClickListener;

    public interface ListItemClickListener{
        void onListItemClicked(int position, int viewId);
    }


    public MyOrderAdapter(Context context, List<MyOrderModel> list, ListItemClickListener mOnClickListener) {
        this.context = context;
        this.list = list;
        this.mOnClickListener = mOnClickListener;
    }



    @NonNull
    @Override
    public MyOrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.my_order_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyOrderAdapter.ViewHolder holder, int position) {

        final MyOrderModel data = list.get(position);
        holder.orderId.setText(data.getOrderId());
        holder.orderDescription.setText(data.getOrderDescription());
        holder.orderPrice.setText(data.getOrderPrice());
        holder.orderTime.setText(data.getOrderTime());

        if (data.getOrderStatus().equals("Cancel")){
            holder.statusBtn.setVisibility(View.VISIBLE);
        }else {
            holder.statusBtn.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView orderId, orderDescription, orderPrice, orderTime;
        Button statusBtn;
        LinearLayout ll_order;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            orderId = itemView.findViewById(R.id.order_id);
            orderDescription = itemView.findViewById(R.id.order_description);
            orderPrice = itemView.findViewById(R.id.order_price);
            orderTime = itemView.findViewById(R.id.order_time);
            ll_order = itemView.findViewById(R.id.ll_order);
            statusBtn = itemView.findViewById(R.id.status_btn);
            statusBtn.setOnClickListener(this);
            ll_order.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
