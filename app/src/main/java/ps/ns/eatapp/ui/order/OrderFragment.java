package ps.ns.eatapp.ui.order;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ps.ns.eatapp.OrderActivity;
import ps.ns.eatapp.R;
import ps.ns.eatapp.adapter.MyCartAdapter;
import ps.ns.eatapp.adapter.MyOrderAdapter;
import ps.ns.eatapp.model.MyCartModel;
import ps.ns.eatapp.model.MyOrderModel;

public class OrderFragment extends Fragment implements MyOrderAdapter.ListItemClickListener {

    private RecyclerView recyclerView;
    private MyOrderAdapter adapter;
    private ArrayList<MyOrderModel> list;
    private View view;
    MyOrderModel model;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TextView titleBar = getActivity().findViewById(R.id.title_bar);
        titleBar.setText("My Order");
        view = inflater.inflate(R.layout.fragment_order, container, false);

        initViews();
        return view;
    }

    private void initViews() {
        recyclerView = view.findViewById(R.id.recyclerMyOrder);
        list = new ArrayList<>();
        getDataMyOrder();
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


        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MyOrderAdapter(getActivity(), list, OrderFragment.this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onListItemClicked(int position, int viewId) {

        if (viewId == R.id.ll_order) {
            Intent intent = new Intent(getContext(), OrderActivity.class);
            intent.putExtra("showHide", true);
            startActivity(intent);
        }
    }
}