package ps.ns.just_click_and_eat.feature.mealsDetails.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.network.asp.model.meals.Ingredient;
import ps.ns.just_click_and_eat.network.asp.model.meals.IngredientData;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.ViewHolder> {
    Context context;
    List<IngredientData> list;
    final private ListItemClickListener mOnClickListener;

    public interface ListItemClickListener {
        void onListItemClicked(int position, int viewId, int id);
    }

    public IngredientAdapter(Context context, List<IngredientData> list, ListItemClickListener mOnClickListener) {
        this.context = context;
        this.list = list;
        this.mOnClickListener = mOnClickListener;
    }

    @NonNull
    @Override
    public IngredientAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ingredient_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientAdapter.ViewHolder holder, int position) {
        final IngredientData data = list.get(position);
            holder.rbIngredient.setText(data.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        RadioButton rbIngredient;
        TextView tvIngredient;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rbIngredient = itemView.findViewById(R.id.rb_ingredient);
            tvIngredient = itemView.findViewById(R.id.tv_ingredient);
            rbIngredient.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mOnClickListener.onListItemClicked(getAdapterPosition(), v.getId(), list.get(getAdapterPosition()).getId());
        }
    }
}
