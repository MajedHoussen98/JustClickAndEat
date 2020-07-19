package ps.ns.eatapp.ui.account;

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

import ps.ns.eatapp.EditAccountActivity;
import ps.ns.eatapp.EditPasswordActivity;
import ps.ns.eatapp.R;
import ps.ns.eatapp.databinding.FragmentMyAccountBinding;
import ps.ns.eatapp.ui.Favorites.Favorites;
import ps.ns.eatapp.ui.location.Location;


public class MyAccount extends Fragment implements View.OnClickListener{
    private View view;
    private FragmentMyAccountBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView titleBar = getActivity().findViewById(R.id.title_bar);
        titleBar.setText("My Account");
        binding =  FragmentMyAccountBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        viewListener();
        return view;
    }

    private void viewListener() {
        binding.llEditAccount.setOnClickListener(this);
        binding.llChangePassword.setOnClickListener(this);
        binding.llEditAddress.setOnClickListener(this);
        binding.llFavorites.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_edit_account:
                startActivity(new Intent(getContext(), EditAccountActivity.class));
                break;
            case R.id.ll_change_password:
                startActivity(new Intent(getContext(), EditPasswordActivity.class));
                break;
            case R.id.ll_edit_address:
               // startActivity(new Intent(getContext(), Location.class));
                break;
            case R.id.ll_favorites:
                startActivity(new Intent(getContext(), Favorites.class));
                break;
        }
    }
}