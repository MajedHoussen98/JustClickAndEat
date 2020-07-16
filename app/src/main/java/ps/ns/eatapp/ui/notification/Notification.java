package ps.ns.eatapp.ui.notification;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ps.ns.eatapp.R;
import ps.ns.eatapp.adapter.MyCartAdapter;
import ps.ns.eatapp.adapter.NotificationAdapter;
import ps.ns.eatapp.model.MyCartModel;
import ps.ns.eatapp.model.MyNotificationModel;


public class Notification extends Fragment implements NotificationAdapter.ListItemClickListener {

    private RecyclerView recyclerView;
    private NotificationAdapter adapter;
    private ArrayList<MyNotificationModel> list;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView titleBar = getActivity().findViewById(R.id.title_bar);
        titleBar.setText("Notification");
        view =  inflater.inflate(R.layout.fragment_notification, container, false);
        initViews();
        return view;
    }

    private void initViews() {
        recyclerView = view.findViewById(R.id.recyclerNotification);
        list = new ArrayList<>();
        getNotificationData();
    }

    private void getNotificationData() {

        list.add(new MyNotificationModel("R.drawable.res2_image", "Oriental Bistro", "The restaurant made a new meal", "2 minutes ago"));
        list.add(new MyNotificationModel("R.drawable.res2_image", "Mountain Standard", "The restaurant made a new meal", "23 minutes ago"));
        list.add(new MyNotificationModel("R.drawable.res2_image", "Perry’s Steakhouse", "The restaurant made a new meal", "45 minutes ago"));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new NotificationAdapter(getActivity(), list, Notification.this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onListItemClicked(int position, int viewId) {

    }
}