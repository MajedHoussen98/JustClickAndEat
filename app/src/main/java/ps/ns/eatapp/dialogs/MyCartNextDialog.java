package ps.ns.eatapp.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ps.ns.eatapp.R;
import ps.ns.eatapp.adapter.MyLocationAdapter;
import ps.ns.eatapp.model.MyLocationModel;

public class MyCartNextDialog extends AppCompatDialogFragment implements MyLocationAdapter.ListItemClickListener, View.OnClickListener {

    private View view;
    private RecyclerView recycler_next_cart;
    private Button submit_order_btn, pickup_btn, delivery_btn, add_address_next_cart;
    TextView mobile_number;
    private MyLocationAdapter locationAdapter;
    private ArrayList<MyLocationModel> locationList;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        view = getLayoutInflater().inflate(R.layout.cart_dialog, null);

        initView();
        getLocationData();
        viewListener();
        builder.setView(view);

        return builder.create();


    }

    private void initView() {
        pickup_btn = view.findViewById(R.id.pickup_btn);
        delivery_btn = view.findViewById(R.id.delivery_btn);
        add_address_next_cart = view.findViewById(R.id.add_address_next_cart);
        mobile_number = view.findViewById(R.id.mobile_number);
        submit_order_btn = view.findViewById(R.id.submit_order_btn);
        recycler_next_cart = view.findViewById(R.id.recycler_next_cart);
        locationList = new ArrayList<>();
    }

    private void viewListener() {
        pickup_btn.setOnClickListener(this);
        delivery_btn.setOnClickListener(this);
        submit_order_btn.setOnClickListener(this);
    }

    private void getLocationData() {
        locationList.add(new MyLocationModel("Home address", "Piata Unirii 2, Apartment 23…"));
        locationList.add(new MyLocationModel("Work address", "Piata Unirii 3, Apartment 26…"));
        recycler_next_cart.setLayoutManager(new LinearLayoutManager(getContext()));
        locationAdapter = new MyLocationAdapter(getActivity(), locationList, MyCartNextDialog.this);
        recycler_next_cart.setAdapter(locationAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pickup_btn:
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

            case R.id.submit_order_btn:
                Toast.makeText(getContext(), "Submit", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onListItemClicked(int position, int viewId) {

    }
}
