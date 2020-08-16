package ps.ns.just_click_and_eat.feature.notification.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import ps.ns.just_click_and_eat.feature.mainHome.view.MainActivity;
import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.adapter.NotificationAdapter;
import ps.ns.just_click_and_eat.databinding.ActivityNotificationBinding;
import ps.ns.just_click_and_eat.model.MyNotificationModel;
import ps.ns.just_click_and_eat.utils.AppSharedMethod;

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
        AppSharedMethod.statusBarLight(this);


    }
    private void initViews() {
        list = new ArrayList<>();
        getNotificationData();
    }

    private void listenerViews() {
        binding.ibBack.setOnClickListener(this);
    }

    private void getNotificationData() {
        list.add(new MyNotificationModel("https://www.samm-honfleur.com/gallery/20180315171008(1).jpg", "Oriental Bistro", "The restaurant made a new meal", "2 minutes ago"));
        list.add(new MyNotificationModel("https://media-cdn.tripadvisor.com/media/photo-s/11/4a/54/fe/essence-restaurant.jpg", "Mountain Standard", "The restaurant made a new meal", "23 minutes ago"));
        list.add(new MyNotificationModel("https://media-cdn.tripadvisor.com/media/photo-s/1a/08/56/10/le-restaurant-avec-sa.jpg", "Perry’s Steakhouse", "The restaurant made a new meal", "45 minutes ago"));

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