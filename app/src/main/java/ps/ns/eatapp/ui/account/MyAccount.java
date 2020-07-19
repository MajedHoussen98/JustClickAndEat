package ps.ns.eatapp.ui.account;

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
import ps.ns.eatapp.adapter.MyAccountAdapter;
import ps.ns.eatapp.model.MyAccountModel;


public class MyAccount extends Fragment implements MyAccountAdapter.ListItemClickListener {
    private RecyclerView recyclerViewAccount;
    private MyAccountAdapter adapter;
    private ArrayList<MyAccountModel> list;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView titleBar = getActivity().findViewById(R.id.title_bar);
        titleBar.setText("My Account");
        view =  inflater.inflate(R.layout.fragment_my_account, container, false);

        initViews();
        return view;
    }

    private void initViews() {
        recyclerViewAccount = view.findViewById(R.id.rcyclerEditAccount);
        list = new ArrayList<>();
        getData();
    }

    private void getData() {

        list.add(new MyAccountModel("Edit Account", "Edit Name…"));
        list.add(new MyAccountModel("Change Password", "Modify your password"));
        list.add(new MyAccountModel("Address", "Add or remove a delivery address"));
        list.add(new MyAccountModel("Favorites", "See your favorite restaurants and meals"));

        recyclerViewAccount.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MyAccountAdapter(getContext(), list, MyAccount.this);
        recyclerViewAccount.setAdapter(adapter);
    }


    @Override
    public void onListItemClicked(int position, int viewId) {


    }
}