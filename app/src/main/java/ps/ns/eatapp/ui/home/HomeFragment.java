package ps.ns.eatapp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ps.ns.eatapp.R;
import ps.ns.eatapp.ResturentDetails;
import ps.ns.eatapp.adapter.HomeAdapter;
import ps.ns.eatapp.model.HomeModel;

public class HomeFragment extends Fragment implements HomeAdapter.ListItemClickListener{

    private RecyclerView recyclerView;
    private HomeAdapter adapter;
    private ArrayList<HomeModel> list;
    private View view;

    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
        TextView titleBar = getActivity().findViewById(R.id.title_bar);
        titleBar.setText("Home");
        view =inflater.inflate(R.layout.fragment_home, container, false);
        initViews();
        return view;

    }

    private void initViews() {
        recyclerView = view.findViewById(R.id.recycler_home);
        list = new ArrayList<>();
        getDataHome();
    }

    private void getDataHome(){
        list.add(new HomeModel("R.drawable.resturant1", "Mountain Standard,", "Open", "193 Gore Creek Dr, Vail, CO 81657, USA", 3.5f, 3.5f));
        list.add(new HomeModel("R.drawable.res_image", "Mountain Standard,", "Close", "193 Gore Creek Dr, Vail, CO 81657, USA", 2.5f, 2.5f));
        list.add(new HomeModel("R.drawable.resturant1", "Mountain Standard,", "Open", "193 Gore Creek Dr, Vail, CO 81657, USA", 3.5f, 3.5f));
        list.add(new HomeModel("R.drawable.res_image", "Mountain Standard,", "Close", "193 Gore Creek Dr, Vail, CO 81657, USA", 2.5f, 2.5f));
        list.add(new HomeModel("R.drawable.resturant1", "Mountain Standard,", "Open", "193 Gore Creek Dr, Vail, CO 81657, USA", 3.5f, 3.5f));
        list.add(new HomeModel("R.drawable.res_image", "Mountain Standard,", "Close", "193 Gore Creek Dr, Vail, CO 81657, USA", 2.5f, 2.5f));
        list.add(new HomeModel("R.drawable.resturant1", "Mountain Standard,", "Open", "193 Gore Creek Dr, Vail, CO 81657, USA", 3.5f, 3.5f));
        list.add(new HomeModel("R.drawable.res_image", "Mountain Standard,", "Close", "193 Gore Creek Dr, Vail, CO 81657, USA", 2.5f, 2.5f));
        list.add(new HomeModel("R.drawable.resturant1", "Mountain Standard,", "Open", "193 Gore Creek Dr, Vail, CO 81657, USA", 3.5f, 3.5f));
        list.add(new HomeModel("R.drawable.res_image", "Mountain Standard,", "Close", "193 Gore Creek Dr, Vail, CO 81657, USA", 2.5f, 2.5f));
        list.add(new HomeModel("R.drawable.resturant1", "Mountain Standard,", "Open", "193 Gore Creek Dr, Vail, CO 81657, USA", 3.5f, 3.5f));
        list.add(new HomeModel("R.drawable.res_image", "Mountain Standard,", "Close", "193 Gore Creek Dr, Vail, CO 81657, USA", 2.5f, 2.5f));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new HomeAdapter(getActivity(), list, HomeFragment.this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onListItemClicked(int position, int viewId) {

        if (viewId == R.id.ll_home) {
            Intent intent = new Intent(getActivity(), ResturentDetails.class);
            startActivity(intent);
        }
    }
}