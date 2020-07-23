package ps.ns.eatapp.dialogs;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

import ps.ns.eatapp.R;
import ps.ns.eatapp.adapter.MyLocationAdapter;
import ps.ns.eatapp.databinding.FragmentCartDialogBinding;
import ps.ns.eatapp.model.MyLocationModel;
import ps.ns.eatapp.ui.AddLocationActivity;
import ps.ns.eatapp.ui.OrderActivity;


public class CartDialogFragment extends DialogFragment implements MyLocationAdapter.ListItemClickListener, View.OnClickListener{
    private View view;
    private FragmentCartDialogBinding binding;
    private MyLocationAdapter locationAdapter;
    private ArrayList<MyLocationModel> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCartDialogBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        initView();
        getLocationData();
        viewListener();
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        Window window = getDialog().getWindow();
        window.setGravity(Gravity.CENTER_HORIZONTAL);
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        WindowManager.LayoutParams params = window.getAttributes();
        params.x = 1;
        params.y = 1;
        window.setAttributes(params);

    }

    private void initView() {
        list = new ArrayList<>();
    }

    private void viewListener() {
        binding.btnPickup.setOnClickListener(this);
        binding.btnDelivery.setOnClickListener(this);
        binding.btnSubmitOrder.setOnClickListener(this);
        binding.btnAddAddress.setOnClickListener(this);
    }


    private void getLocationData() {
        list.add(new MyLocationModel("Home address", "Piata Unirii 2, Apartment 23…"));
        list.add(new MyLocationModel("Work address", "Piata Unirii 3, Apartment 26…"));
        list.add(new MyLocationModel("Work address", "Piata Unirii 3, Apartment 26…"));
        list.add(new MyLocationModel("Work address", "Piata Unirii 3, Apartment 26…"));
        list.add(new MyLocationModel("Work address", "Piata Unirii 3, Apartment 26…"));
        binding.rvCatDialog.setLayoutManager(new LinearLayoutManager(getActivity()));
        locationAdapter = new MyLocationAdapter(getActivity(), list, CartDialogFragment.this);
        locationAdapter.setShowHide(true);
        binding.rvCatDialog.setAdapter(locationAdapter);
    }

    @Override
    public void onListItemClicked(int position, int viewId) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_pickup:
                binding.btnPickup.setBackgroundResource(R.drawable.get_start);
                binding.btnPickup.setTextColor(Color.parseColor("#ffffff"));
                binding.btnDelivery.setBackgroundResource(R.drawable.outline_button_cart);
                binding.btnDelivery.setTextColor(Color.parseColor("#2C32BE"));
                binding.btnAddAddress.setVisibility(View.GONE);
                binding.rvCatDialog.setVisibility(View.GONE);
                break;
            case R.id.btn_delivery:
                binding.btnDelivery.setBackgroundResource(R.drawable.get_start);
                binding.btnDelivery.setTextColor(Color.parseColor("#ffffff"));
                binding.btnPickup.setBackgroundResource(R.drawable.outline_button_cart);
                binding.btnPickup.setTextColor(Color.parseColor("#2C32BE"));
                binding.btnAddAddress.setVisibility(View.VISIBLE);
                binding.rvCatDialog.setVisibility(View.VISIBLE);
                break;

            case R.id.btn_submit_order:
                Intent intent = new Intent(getContext(), OrderActivity.class);
                intent.putExtra("showHide", false);
                startActivity(intent);
                break;

            case R.id.btn_add_address:
                startActivity(new Intent(getContext(), AddLocationActivity.class));
                break;
        }
    }
}