package ps.ns.eatapp.ui.notification;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ps.ns.eatapp.R;


public class Notification extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView titleBar = getActivity().findViewById(R.id.title_bar);
        titleBar.setText("Notification");
        view =  inflater.inflate(R.layout.fragment_notification, container, false);
        return view;
    }
}