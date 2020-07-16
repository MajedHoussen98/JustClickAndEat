package ps.ns.eatapp.ui.cart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ps.ns.eatapp.R;
import ps.ns.eatapp.adapter.MyCartAdapter;
import ps.ns.eatapp.model.MyCartModel;

public class CartFragment extends Fragment implements  MyCartAdapter.ListItemClickListener {

    private RecyclerView recyclerView;
    private MyCartAdapter adapter;
    private ArrayList<MyCartModel> list;
    private View view;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TextView titleBar = getActivity().findViewById(R.id.title_bar);
        titleBar.setText("My Cart");
        view = inflater.inflate(R.layout.fragment_cart, container, false);
        initViews();
        return view;

    }

    private void initViews() {

        recyclerView = view.findViewById(R.id.recyclerMyCart);
        list = new ArrayList<>();
        getDataMyCart();
    }

    private void getDataMyCart() {

        list.add(new MyCartModel("R.drawable.meal2", "Braised Fish Head", "2x tuna sahimi, 3x vegetables ", "$4.90", 2));
        list.add(new MyCartModel("R.drawable.meal3", "Salad Fritters", "2x tuna sahimi, 3x vegetables ", "$15.00", 1));
        list.add(new MyCartModel("R.drawable.meal2", "Braised Fish Head", "2x tuna sahimi, 3x vegetables ", "$4.90", 2));
        list.add(new MyCartModel("R.drawable.meal3", "Salad Fritters", "2x tuna sahimi, 3x vegetables ", "$15.00", 1));
        list.add(new MyCartModel("R.drawable.meal2", "Braised Fish Head", "2x tuna sahimi, 3x vegetables ", "$4.90", 2));
        list.add(new MyCartModel("R.drawable.meal3", "Salad Fritters", "2x tuna sahimi, 3x vegetables ", "$15.00", 1));


        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MyCartAdapter(getActivity(), list, CartFragment.this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onListItemClicked(int position, int viewId) {

    }
}