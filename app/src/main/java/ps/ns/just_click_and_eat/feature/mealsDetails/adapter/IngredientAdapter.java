package ps.ns.just_click_and_eat.feature.mealsDetails.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.network.asp.model.meals.Ingredient;
import ps.ns.just_click_and_eat.network.asp.model.meals.IngredientData;
import ps.ns.just_click_and_eat.network.asp.model.meals.Meals;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.ViewHolder> {
    Context context;
    List<Meals> list;
    final private ListItemClickListener mOnClickListener;

    public interface ListItemClickListener {
        void onListItemClicked(int position, int viewId, int id);
    }

    public IngredientAdapter(Context context, List<Meals> list, ListItemClickListener mOnClickListener) {
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
       final Meals data = list.get(position);
        holder.rbIngredient.setText(data.getIngredients().get(position).getData().get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        RadioButton rbIngredient;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rbIngredient = itemView.findViewById(R.id.rb_ingredient);
            rbIngredient.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mOnClickListener.onListItemClicked(getAdapterPosition(), v.getId(), list.get(getAdapterPosition()).getIngredients().get(getAdapterPosition()).getData().get(getAdapterPosition()).getId());
        }
    }
}
