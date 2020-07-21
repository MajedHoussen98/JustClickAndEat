package ps.ns.eatapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import ps.ns.eatapp.MainActivity;
import ps.ns.eatapp.R;
import ps.ns.eatapp.adapter.MyOrderAdapter;
import ps.ns.eatapp.databinding.ActivityMyOrderBinding;
import ps.ns.eatapp.model.MyOrderModel;

public class MyOrderActivity extends AppCompatActivity implements MyOrderAdapter.ListItemClickListener, View.OnClickListener {
    private View view;
    private ActivityMyOrderBinding binding;
    private MyOrderAdapter adapter;
    private ArrayList<MyOrderModel> list;
    private MyOrderModel model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyOrderBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        setContentView(view);
        initViews();
        listenerViews();
    }


    private void initViews() {
        list = new ArrayList<>();
        getDataMyOrder();
    }


    private void listenerViews() {
        binding.ibBack.setOnClickListener(this);
    }

    private void getDataMyOrder() {
        model =  new MyOrderModel("Order #456123", "Irving PlaceHawk Point, MO 63349", "$52.25", "1 minutes ago", "Cancel");
        list.add(model);
        list.add(model);
        list.add(model);
        list.add(model);
        list.add(model);
        list.add(model);
        list.add(model);
        list.add(model);
        list.add(model);
        list.add(model);
        list.add(model);

        binding.rvOrder.setLayoutManager(new LinearLayoutManager(MyOrderActivity.this));
        adapter = new MyOrderAdapter(MyOrderActivity.this, list, MyOrderActivity.this);
        binding.rvOrder.setAdapter(adapter);
    }

    @Override
    public void onListItemClicked(int position, int viewId) {
        if (viewId == R.id.ll_order) {
            Intent intent = new Intent(MyOrderActivity.this, OrderActivity.class);
            intent.putExtra("showHide", true);
            startActivity(intent);
        }
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.ib_back) {
            startActivity(new Intent(MyOrderActivity.this, MainActivity.class));
            finish();
        }
    }
}