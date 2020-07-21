package ps.ns.eatapp.adapter;

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
import ps.ns.eatapp.model.StartingData;

public class StartingAdapter extends RecyclerView.Adapter<StartingAdapter.ViewHolder> {

    Context context;
    List<StartingData> list;

    public StartingAdapter(Context context, List<StartingData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public StartingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.starting_item, parent, false);
        return new StartingAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StartingAdapter.ViewHolder holder, int position) {
        final StartingData data = list.get(position);
        holder.imageView.setImageResource(data.getImageStart());
        holder.textViewTitle.setText(data.getTitleStart());
        holder.textViewDescription.setText(data.getDescription());
        holder.imageViewCircle.setImageResource(data.getImageCircle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView, imageViewCircle;
        private TextView textViewTitle, textViewDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.iv_starting);
            imageViewCircle = itemView.findViewById(R.id.imageViewCircle);
            textViewTitle = itemView.findViewById(R.id.tv_title);
            textViewDescription = itemView.findViewById(R.id.tv_description);
        }
    }
}
