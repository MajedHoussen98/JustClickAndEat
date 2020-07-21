package ps.ns.eatapp.ui;

import android.content.Intent;
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
import ps.ns.eatapp.adapter.HomeAdapter;
import ps.ns.eatapp.databinding.FragmentHomeBinding;
import ps.ns.eatapp.model.HomeModel;

public class HomeFragment extends Fragment implements HomeAdapter.ListItemClickListener{

    private HomeAdapter adapter;
    private ArrayList<HomeModel> list;
    private View view;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
        TextView titleBar = getActivity().findViewById(R.id.title_bar);
        titleBar.setText("Home");
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        initViews();
        return view;

    }

    private void initViews() {
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

        binding.rvHome.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new HomeAdapter(getActivity(), list, HomeFragment.this);
        binding.rvHome.setAdapter(adapter);
    }

    @Override
    public void onListItemClicked(int position, int viewId) {

        if (viewId == R.id.ll_home) {
            Intent intent = new Intent(getActivity(), ResturentDetailsActivity.class);
            startActivity(intent);
        }
    }
}