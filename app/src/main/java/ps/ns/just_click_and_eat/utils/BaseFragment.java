package ps.ns.just_click_and_eat.utils;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.databinding.FragmentHomeBinding;

public class BaseFragment extends Fragment implements BaseView {

    FragmentHomeBinding binding;
    private ProgressDialog dialog;
    private Snackbar snackbar;


    @SuppressLint("SetTextI18n")
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView titleBar = getActivity().findViewById(R.id.title_bar);
        titleBar.setText("Home");
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        initViews();
        return view;
    }

    private void initViews() {
        dialog = new ProgressDialog(getContext());
        dialog.setMessage("Please wait...");
    }

    @Override
    public void showProgress() {
        dialog.show();
    }

    @Override
    public void hideProgress() {
        dialog.hide();
    }


    @Override
    public void showMessage(String msg) {
        Log.e("MESSAGE", msg);
    }

    public void snackErrorShow(View view, String text) {
        snackbar = Snackbar.make(view, text, Snackbar.LENGTH_LONG);
        snackbar.show();
    }
}
