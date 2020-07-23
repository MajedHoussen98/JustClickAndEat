package ps.ns.eatapp.ui;

import android.content.Intent;
import android.graphics.Color;
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

import org.florescu.android.rangeseekbar.RangeSeekBar;

import java.util.ArrayList;

import ps.ns.eatapp.MainActivity;
import ps.ns.eatapp.R;
import ps.ns.eatapp.adapter.HomeAdapter;
import ps.ns.eatapp.databinding.FragmentHomeBinding;
import ps.ns.eatapp.model.HomeModel;

public class HomeFragment extends Fragment implements HomeAdapter.ListItemClickListener, View.OnClickListener {

    private HomeAdapter adapter;
    private ArrayList<HomeModel> list;
    private View view;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView titleBar = getActivity().findViewById(R.id.title_bar);
        titleBar.setText("Home");
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        initViews();
        seekBar();
        listenerViews();
        return view;

    }

    private void seekBar() {
        RangeSeekBar<Integer> rangeSeekBar = new RangeSeekBar<>(view.getContext());
        // Set the range
        rangeSeekBar.setRangeValues(15, 90);
        rangeSeekBar.setSelectedMinValue(20);
        rangeSeekBar.setSelectedMaxValue(88);

        binding.layoutFilter.seekBar.setTextAboveThumbsColorResource(android.R.color.holo_blue_bright);
        binding.layoutFilter.seekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar bar, Number minValue, Number maxValue) {
                Log.e("SEEK" , ""+minValue + "\t\t" + maxValue);
            }
        });

      /*  RangeSeekBar<Integer> rangeSeekBar = new RangeSeekBar<>(this);
        // Set the range
        rangeSeekBar.setRangeValues(15, 90);
        rangeSeekBar.setSelectedMinValue(20);
        rangeSeekBar.setSelectedMaxValue(88);

        RangeSeekBar rangeSeekBarTextColorWithCode = (RangeSeekBar) viewMain.findViewById(R.id.seekbar_placeholder);
        rangeSeekBarTextColorWithCode.setTextAboveThumbsColorResource(android.R.color.holo_blue_bright);*/
    }

    private void initViews() {
        list = new ArrayList<>();
        getDataHome();
    }

    private void listenerViews() {
        binding.icFilter.setOnClickListener(this);
        binding.layoutFilter.btnApply.setOnClickListener(this);
        binding.layoutFilter.view.setOnClickListener(this);
        binding.layoutFilter.ctvTopRated.setOnClickListener(this);
        binding.layoutFilter.ctvNearestMe.setOnClickListener(this);
        binding.layoutFilter.ctvMostPopular.setOnClickListener(this);
        binding.layoutFilter.ctvOpenNow.setOnClickListener(this);
    }

    private void getDataHome() {
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ic_filter:
                filterClicked();
                break;
            case R.id.btn_apply:
                Toast.makeText(getContext(), "ssss", Toast.LENGTH_SHORT).show();
                break;
            case R.id.view:
                binding.layoutFilter.getRoot().setVisibility(View.GONE);
                MainActivity.show();
                break;
            case R.id.ctv_top_rated:
                if (binding.layoutFilter.ctvTopRated.isChecked()) {
                    binding.layoutFilter.ctvTopRated.setChecked(false);
                    binding.layoutFilter.ctvTopRated.setCheckMarkDrawable(null);
                    binding.layoutFilter.ctvTopRated.setTextColor(Color.parseColor("#000000"));

                } else {
                    binding.layoutFilter.ctvTopRated.setChecked(true);
                    binding.layoutFilter.ctvTopRated.setCheckMarkDrawable(R.drawable.icons_check);
                    binding.layoutFilter.ctvTopRated.setTextColor(Color.parseColor("#2C32BE"));
                }
                break;
            case R.id.ctv_nearest_me:
                if (binding.layoutFilter.ctvNearestMe.isChecked()) {
                    binding.layoutFilter.ctvNearestMe.setChecked(false);
                    binding.layoutFilter.ctvNearestMe.setCheckMarkDrawable(null);
                    binding.layoutFilter.ctvNearestMe.setTextColor(Color.parseColor("#000000"));

                } else {
                    binding.layoutFilter.ctvNearestMe.setChecked(true);
                    binding.layoutFilter.ctvNearestMe.setCheckMarkDrawable(R.drawable.icons_check);
                    binding.layoutFilter.ctvNearestMe.setTextColor(Color.parseColor("#2C32BE"));
                }
                break;

            case R.id.ctv_most_popular:
                if (binding.layoutFilter.ctvMostPopular.isChecked()) {
                    binding.layoutFilter.ctvMostPopular.setChecked(false);
                    binding.layoutFilter.ctvMostPopular.setCheckMarkDrawable(null);
                    binding.layoutFilter.ctvMostPopular.setTextColor(Color.parseColor("#000000"));

                } else {
                    binding.layoutFilter.ctvMostPopular.setChecked(true);
                    binding.layoutFilter.ctvMostPopular.setCheckMarkDrawable(R.drawable.icons_check);
                    binding.layoutFilter.ctvMostPopular.setTextColor(Color.parseColor("#2C32BE"));
                }
                break;

            case R.id.ctv_open_now:
                if (binding.layoutFilter.ctvOpenNow.isChecked()) {
                    binding.layoutFilter.ctvOpenNow.setChecked(false);
                    binding.layoutFilter.ctvOpenNow.setCheckMarkDrawable(null);
                    binding.layoutFilter.ctvOpenNow.setTextColor(Color.parseColor("#000000"));

                } else {
                    binding.layoutFilter.ctvOpenNow.setChecked(true);
                    binding.layoutFilter.ctvOpenNow.setCheckMarkDrawable(R.drawable.icons_check);
                    binding.layoutFilter.ctvOpenNow.setTextColor(Color.parseColor("#2C32BE"));
                }
                break;

        }
    }

    private void filterClicked() {
        MainActivity.hide();
        binding.layoutFilter.getRoot().setVisibility(View.VISIBLE);
    }

}