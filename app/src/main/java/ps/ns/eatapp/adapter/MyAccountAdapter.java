package ps.ns.eatapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import ps.ns.eatapp.R;
import ps.ns.eatapp.model.MyAccountModel;

public class MyAccountAdapter extends RecyclerView.Adapter<MyAccountAdapter.ViewHolder> {

     Context context;
     List<MyAccountModel> list;
     final private MyAccountAdapter.ListItemClickListener mOnClickListener;

     public interface ListItemClickListener{
         void onListItemClicked(int position, int viewId);
     }


    public MyAccountAdapter(Context context, List<MyAccountModel> list, MyAccountAdapter.ListItemClickListener mOnClickListener) {
        this.context = context;
        this.list = list;
        this.mOnClickListener = mOnClickListener;
    }

    @NonNull
    @Override
    public MyAccountAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.my_account_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAccountAdapter.ViewHolder holder, int position) {
        final MyAccountModel data = list.get(position);
        holder.titleEditAccount.setText(data.getTitleEditAccount());
        holder.bodyEditAccount.setText(data.getBodyEditAccount());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView titleEditAccount, bodyEditAccount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titleEditAccount = itemView.findViewById(R.id.title_edit_account);
            bodyEditAccount = itemView.findViewById(R.id.body_edit_account);
            LinearLayout llEditAccount = itemView.findViewById(R.id.ll_edit_account);
            llEditAccount.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            mOnClickListener.onListItemClicked(getAdapterPosition(), v.getId());
        }
    }
}
