package ps.ns.eatapp.dialogs;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ps.ns.eatapp.databinding.ActivityMyCartBinding;
import ps.ns.eatapp.ui.AddLocationActivity;
import ps.ns.eatapp.ui.OrderActivity;
import ps.ns.eatapp.R;
import ps.ns.eatapp.adapter.MyLocationAdapter;
import ps.ns.eatapp.model.MyLocationModel;

public class MyCartNextDialog extends AppCompatActivity implements MyLocationAdapter.ListItemClickListener, View.OnClickListener {

    private RecyclerView recycler_next_cart;
    private Button submit_order_btn, pickup_btn, delivery_btn, add_address_next_cart;
    TextView mobile_number;
    private MyLocationAdapter locationAdapter;
    private ArrayList<MyLocationModel> locationList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.cart_dialog);

        initView();
        getLocationData();
        viewListener();

    }


    private void initView() {
        pickup_btn = findViewById(R.id.btn_pickup);
        delivery_btn = findViewById(R.id.delivery_btn);
        add_address_next_cart = findViewById(R.id.add_address_next_cart);
        mobile_number = findViewById(R.id.tv_mobile_number);
        submit_order_btn = findViewById(R.id.btn_submit_order);
        recycler_next_cart = findViewById(R.id.rv_next_cart);
        locationList = new ArrayList<>();
    }

    private void viewListener() {
        pickup_btn.setOnClickListener(this);
        delivery_btn.setOnClickListener(this);
        submit_order_btn.setOnClickListener(this);
        add_address_next_cart.setOnClickListener(this);
    }

    private void getLocationData() {
        locationList.add(new MyLocationModel("Home address", "Piata Unirii 2, Apartment 23…"));
        locationList.add(new MyLocationModel("Work address", "Piata Unirii 3, Apartment 26…"));
        locationList.add(new MyLocationModel("Work address", "Piata Unirii 3, Apartment 26…"));
        locationList.add(new MyLocationModel("Work address", "Piata Unirii 3, Apartment 26…"));
        locationList.add(new MyLocationModel("Work address", "Piata Unirii 3, Apartment 26…"));
        recycler_next_cart.setLayoutManager(new LinearLayoutManager(this));
        locationAdapter = new MyLocationAdapter(MyCartNextDialog.this, locationList, MyCartNextDialog.this);
        locationAdapter.setShowHide(true);
        recycler_next_cart.setAdapter(locationAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_pickup:
                pickup_btn.setBackgroundResource(R.drawable.get_start);
                pickup_btn.setTextColor(Color.parseColor("#ffffff"));
                delivery_btn.setBackgroundResource(R.drawable.outline_button_cart);
                delivery_btn.setTextColor(Color.parseColor("#2C32BE"));
                add_address_next_cart.setVisibility(View.GONE);
                recycler_next_cart.setVisibility(View.GONE);
                break;

            case R.id.delivery_btn:
                delivery_btn.setBackgroundResource(R.drawable.get_start);
                delivery_btn.setTextColor(Color.parseColor("#ffffff"));
                pickup_btn.setBackgroundResource(R.drawable.outline_button_cart);
                pickup_btn.setTextColor(Color.parseColor("#2C32BE"));
                add_address_next_cart.setVisibility(View.VISIBLE);
                recycler_next_cart.setVisibility(View.VISIBLE);
                break;

            case R.id.btn_submit_order:

                Intent intent = new Intent(this, OrderActivity.class);
                intent.putExtra("showHide", false);
                startActivity(intent);
                break;

            case R.id.add_address_next_cart:
                startActivity(new Intent(MyCartNextDialog.this, AddLocationActivity.class));
                break;
        }
    }

    @Override
    public void onListItemClicked(int position, int viewId) {

    }
}
