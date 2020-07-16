package ps.ns.eatapp.ui.location;

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
import ps.ns.eatapp.adapter.MyLocationAdapter;
import ps.ns.eatapp.model.MyLocationModel;

public class Location extends Fragment implements MyLocationAdapter.ListItemClickListener {

    private RecyclerView recyclerView;
    private MyLocationAdapter adapter;
    private ArrayList<MyLocationModel> list;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView titleBar = getActivity().findViewById(R.id.title_bar);
        titleBar.setText("My Location");
        view = inflater.inflate(R.layout.fragment_location, container, false);
        initViews();
        return view;
    }

    private void initViews() {
        recyclerView = view.findViewById(R.id.recyclerMyLocation);
        list = new ArrayList<>();
        getLocationData();
    }

    private void getLocationData() {
        list.add(new MyLocationModel("Home address", "Piata Unirii 2, Apartment 23…"));
        list.add(new MyLocationModel("Work address", "Piata Unirii 3, Apartment 26…"));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MyLocationAdapter(getActivity(), list, Location.this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onListItemClicked(int position, int viewId) {

    }
}