package ps.ns.eatapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ps.ns.eatapp.R;
import ps.ns.eatapp.model.MyLocationModel;

public class MyLocationAdapter extends RecyclerView.Adapter<MyLocationAdapter.ViewHolder> {
    Context context;
    List<MyLocationModel> list;
    final private MyLocationAdapter.ListItemClickListener mOnClickListener;

    public interface ListItemClickListener{
        void onListItemClicked(int position, int viewId);
    }

    public MyLocationAdapter(Context context, List<MyLocationModel> list, ListItemClickListener mOnClickListener) {
        this.context = context;
        this.list = list;
        this.mOnClickListener = mOnClickListener;
    }

    @NonNull
    @Override
    public MyLocationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.my_location_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyLocationAdapter.ViewHolder holder, int position) {
        final MyLocationModel data = list.get(position);
        holder.addressName.setText(data.getAddressName());
        holder.addressDetails.setText(data.getDetailsAddress());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView addressName;
        RadioButton addressDetails;
        Button changeAddress;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            addressName = itemView.findViewById(R.id.addressName);
            addressDetails = itemView.findViewById(R.id.detailsAddress);
            changeAddress = itemView.findViewById(R.id.change_address);
            changeAddress.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mOnClickListener.onListItemClicked(getAdapterPosition(), v.getId());

        }
    }
}
