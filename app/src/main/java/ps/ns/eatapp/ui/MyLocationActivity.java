package ps.ns.eatapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import ps.ns.eatapp.MainActivity;
import ps.ns.eatapp.R;
import ps.ns.eatapp.adapter.MyLocationAdapter;
import ps.ns.eatapp.databinding.ActivityMyLocationBinding;
import ps.ns.eatapp.model.MyLocationModel;
import ps.ns.eatapp.utils.AppSharedMethod;

public class MyLocationActivity extends AppCompatActivity implements MyLocationAdapter.ListItemClickListener, View.OnClickListener {
    private View view;
    private ActivityMyLocationBinding binding;
    private MyLocationAdapter adapter;
    private ArrayList<MyLocationModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyLocationBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        setContentView(view);
        initViews();
        listenerViews();
        AppSharedMethod.statusBarLight(this);

    }
    private void initViews() {
        list = new ArrayList<>();
        getLocationData();
    }

    private void listenerViews() {
        binding.ibBack.setOnClickListener(this);
        binding.btnAddAddress.setOnClickListener(this);
    }

    private void getLocationData() {
        list.add(new MyLocationModel("Home address", "Piata Unirii 2, Apartment 23…"));
        list.add(new MyLocationModel("Work address", "Piata Unirii 3, Apartment 26…"));


        binding.rvLocation.setLayoutManager(new LinearLayoutManager(MyLocationActivity.this));
        adapter = new MyLocationAdapter(MyLocationActivity.this, list, MyLocationActivity.this);
        binding.rvLocation.setAdapter(adapter);
    }

    @Override
    public void onListItemClicked(int position, int viewId) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add_address:
                startActivity(new Intent(MyLocationActivity.this, AddLocationActivity.class));
                break;
            case R.id.ib_back:
                startActivity(new Intent(MyLocationActivity.this, MainActivity.class));
                finish();
                break;
        }
    }
}