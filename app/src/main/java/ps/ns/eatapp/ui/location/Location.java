package ps.ns.eatapp.ui.location;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ps.ns.eatapp.AddLocationActivity;
import ps.ns.eatapp.R;
import ps.ns.eatapp.adapter.MyLocationAdapter;
import ps.ns.eatapp.databinding.FragmentLocationBinding;
import ps.ns.eatapp.databinding.FragmentMyAccountBinding;
import ps.ns.eatapp.model.MyLocationModel;

public class Location extends Fragment implements MyLocationAdapter.ListItemClickListener, View.OnClickListener{

    private MyLocationAdapter adapter;
    private ArrayList<MyLocationModel> list;
    private FragmentLocationBinding binding;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView titleBar = getActivity().findViewById(R.id.title_bar);
        titleBar.setText("My Location");
        binding = FragmentLocationBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        initViews();
        lisetnerViews();
        return view;
    }


    private void initViews() {
        list = new ArrayList<>();
        getLocationData();
    }

    private void lisetnerViews() {
        binding.btnAddAddress.setOnClickListener(this);
    }



    private void getLocationData() {
        list.add(new MyLocationModel("Home address", "Piata Unirii 2, Apartment 23…"));
        list.add(new MyLocationModel("Work address", "Piata Unirii 3, Apartment 26…"));


        binding.recyclerMyLocation.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new MyLocationAdapter(getActivity(), list, Location.this);
        binding.recyclerMyLocation.setAdapter(adapter);
    }

    @Override
    public void onListItemClicked(int position, int viewId) {

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_add_address){
            startActivity(new Intent(getContext(), AddLocationActivity.class));
        }
    }
}