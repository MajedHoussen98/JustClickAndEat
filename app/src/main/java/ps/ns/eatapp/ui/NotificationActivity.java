package ps.ns.eatapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import ps.ns.eatapp.MainActivity;
import ps.ns.eatapp.R;
import ps.ns.eatapp.adapter.NotificationAdapter;
import ps.ns.eatapp.databinding.ActivityNotificationBinding;
import ps.ns.eatapp.model.MyNotificationModel;

public class NotificationActivity extends AppCompatActivity implements NotificationAdapter.ListItemClickListener, View.OnClickListener {
    private View view;
    private ActivityNotificationBinding binding;
    private NotificationAdapter adapter;
    private ArrayList<MyNotificationModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNotificationBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        setContentView(view);

        initViews();
        listenerViews();

    }
    private void initViews() {
        list = new ArrayList<>();
        getNotificationData();
    }

    private void listenerViews() {
        binding.ibBack.setOnClickListener(this);
    }

    private void getNotificationData() {
        list.add(new MyNotificationModel("R.drawable.res2_image", "Oriental Bistro", "The restaurant made a new meal", "2 minutes ago"));
        list.add(new MyNotificationModel("R.drawable.res2_image", "Mountain Standard", "The restaurant made a new meal", "23 minutes ago"));
        list.add(new MyNotificationModel("R.drawable.res2_image", "Perry’s Steakhouse", "The restaurant made a new meal", "45 minutes ago"));

        binding.rvNotification.setLayoutManager(new LinearLayoutManager(NotificationActivity.this));
        adapter = new NotificationAdapter(NotificationActivity.this, list, NotificationActivity.this);
        binding.rvNotification.setAdapter(adapter);
    }

    @Override
    public void onListItemClicked(int position, int viewId) {

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ib_back){
            startActivity(new Intent(NotificationActivity.this, MainActivity.class));
            finish();
        }
    }
}