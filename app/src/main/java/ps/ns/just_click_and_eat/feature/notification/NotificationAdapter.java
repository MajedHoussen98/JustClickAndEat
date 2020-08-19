package ps.ns.just_click_and_eat.feature.notification;

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
import ps.ns.just_click_and_eat.dataBase.MyNotificationModel;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    Context context;
    List<MyNotificationModel> list;
    final private NotificationAdapter.ListItemClickListener mOnClickListener;

    public interface ListItemClickListener {
        void onListItemClicked(int position, int viewId);
    }

    public NotificationAdapter(Context context, List<MyNotificationModel> list, NotificationAdapter.ListItemClickListener mOnClickListener) {
        this.context = context;
        this.list = list;
        this.mOnClickListener = mOnClickListener;
    }


    @NonNull
    @Override
    public NotificationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.notification_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationAdapter.ViewHolder holder, int position) {

        final MyNotificationModel data = list.get(position);

        Glide.with(context).load(data.getNotificationPic()).into(holder.notificationPic);
        holder.notificationTitle.setText(data.getNotificationTitle());
        holder.notificationBody.setText(data.getNotificationBody());
        holder.notificationTime.setText(data.getNotificationTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView notificationPic, clickNotification;
        TextView notificationTitle, notificationBody, notificationTime;
        LinearLayout ll_notification;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            notificationPic = itemView.findViewById(R.id.iv_notification);
            clickNotification = itemView.findViewById(R.id.ic_notification_click);
            notificationTitle = itemView.findViewById(R.id.tv_notification_title);
            notificationBody = itemView.findViewById(R.id.tv_notification_body);
            notificationTime = itemView.findViewById(R.id.tv_notification_time);
            ll_notification = itemView.findViewById(R.id.ll_notification);

            ll_notification.setOnClickListener(this);
            clickNotification.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            mOnClickListener.onListItemClicked(getAdapterPosition(), v.getId());
        }
    }
}
