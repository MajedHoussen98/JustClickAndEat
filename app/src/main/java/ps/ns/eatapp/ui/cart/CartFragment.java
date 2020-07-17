package ps.ns.eatapp.ui.cart;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import ps.ns.eatapp.R;
import ps.ns.eatapp.adapter.MyCartAdapter;
import ps.ns.eatapp.adapter.MyLocationAdapter;
import ps.ns.eatapp.dialogs.MyCartNextDialog;
import ps.ns.eatapp.model.MyCartModel;
import ps.ns.eatapp.model.MyLocationModel;

public class CartFragment extends Fragment implements MyCartAdapter.ListItemClickListener, View.OnClickListener{


    private RecyclerView recyclerView;
    private MyCartAdapter adapter;
    private ArrayList<MyCartModel> list;
    private View view;
    private Button cartNext;

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
        cartNext = view.findViewById(R.id.cart_next_btn);
        getDataMyCart();
        cartNext.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.cart_next_btn) {
           openDialog();
        }
    }

    private void openDialog() {
        MyCartNextDialog dialog = new MyCartNextDialog();
        dialog.show(getParentFragmentManager(), "SSSS");
    }

}

