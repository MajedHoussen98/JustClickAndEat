package ps.ns.eatapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
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
import java.util.List;
import ps.ns.eatapp.R;
import ps.ns.eatapp.model.HomeModel;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    Context context;
    List<HomeModel> list;

    final private ListItemClickListener mOnClickListener;

    public interface ListItemClickListener {
        void onListItemClicked(int position, int viewId);
    }

    public HomeAdapter(Context context, List<HomeModel> list, HomeAdapter.ListItemClickListener mOnClickListener) {
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
        final HomeModel data = list.get(position);
        holder.resturant_pic.setImageResource(data.getResturant_pic());
        holder.resturant_name.setText(data.getResturant_name());
        holder.resturant_status.setText(data.getResturant_status());
        holder.resturant_address.setText(data.getResturant_address());
        holder.rating_number.setText(String.valueOf(data.getRating_number()));
        holder.resturant_rating.getNumStars();

        if (data.getResturant_status().equals("Open")){
            holder.resturant_status.setTextColor(Color.parseColor("#74B743"));
        }else {
            holder.resturant_status.setTextColor(Color.parseColor("#C11313"));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView resturant_pic;
        TextView resturant_name, resturant_status, resturant_address, rating_number;
        RatingBar resturant_rating;
        private LinearLayout ll_home;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            resturant_pic = itemView.findViewById(R.id.resturant_pic);
            resturant_name = itemView.findViewById(R.id.resturant_name);
            resturant_status = itemView.findViewById(R.id.resturant_status);
            resturant_address = itemView.findViewById(R.id.resturant_address);
            resturant_rating = itemView.findViewById(R.id.resturant_rating);
            rating_number = itemView.findViewById(R.id.rating_number);
            ll_home = itemView.findViewById(R.id.ll_home);
            ll_home.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mOnClickListener.onListItemClicked(getAdapterPosition(), v.getId());
        }
    }
}
