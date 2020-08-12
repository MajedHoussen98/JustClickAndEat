package ps.ns.eatapp.dialogs;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import org.florescu.android.rangeseekbar.RangeSeekBar;

import ps.ns.eatapp.R;
import ps.ns.eatapp.databinding.FragmentFilterDialogkBinding;
import ps.ns.eatapp.utils.AppSharedMethod;


public class FilterDialogFragment extends DialogFragment implements View.OnClickListener {

    private View view;
    private FragmentFilterDialogkBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFilterDialogkBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        listenerViews();
        seekBar();
        AppSharedMethod.statusBarHide(view);
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

        Window window = getDialog().getWindow();
        window.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams params = window.getAttributes();

        window.setAttributes(params);
    }

    private void seekBar() {
        RangeSeekBar<Integer> rangeSeekBar = new RangeSeekBar<>(view.getContext());
        // Set the range
        rangeSeekBar.setRangeValues(15, 90);
        rangeSeekBar.setSelectedMinValue(20);
        rangeSeekBar.setSelectedMaxValue(88);

        binding.seekBar.setTextAboveThumbsColorResource(android.R.color.holo_blue_bright);
        binding.seekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar bar, Number minValue, Number maxValue) {
                Log.e("SEEK", "" + minValue + "\t\t" + maxValue);
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
    private void listenerViews() {
        binding.btnClear.setOnClickListener(this);
        binding.ctvTopRated.setOnClickListener(this);
        binding.ctvNearestMe.setOnClickListener(this);
        binding.ctvMostPopular.setOnClickListener(this);
        binding.etSearchFilter.setOnClickListener(this);
        binding.ctvOpenNow.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.ctv_top_rated:
                if (binding.ctvTopRated.isChecked()) {
                    binding.ctvTopRated.setChecked(false);
                    binding.ctvTopRated.setCheckMarkDrawable(null);
                    binding.ctvTopRated.setTextColor(Color.parseColor("#000000"));

                } else {
                    binding.ctvTopRated.setChecked(true);
                    binding.ctvTopRated.setCheckMarkDrawable(R.drawable.icons_check);
                    binding.ctvTopRated.setTextColor(Color.parseColor("#2C32BE"));
                }
                break;
            case R.id.ctv_nearest_me:
                if (binding.ctvNearestMe.isChecked()) {
                    binding.ctvNearestMe.setChecked(false);
                    binding.ctvNearestMe.setCheckMarkDrawable(null);
                    binding.ctvNearestMe.setTextColor(Color.parseColor("#000000"));

                } else {
                    binding.ctvNearestMe.setChecked(true);
                    binding.ctvNearestMe.setCheckMarkDrawable(R.drawable.icons_check);
                    binding.ctvNearestMe.setTextColor(Color.parseColor("#2C32BE"));
                }
                break;

            case R.id.ctv_most_popular:
                if (binding.ctvMostPopular.isChecked()) {
                    binding.ctvMostPopular.setChecked(false);
                    binding.ctvMostPopular.setCheckMarkDrawable(null);
                    binding.ctvMostPopular.setTextColor(Color.parseColor("#000000"));

                } else {
                    binding.ctvMostPopular.setChecked(true);
                    binding.ctvMostPopular.setCheckMarkDrawable(R.drawable.icons_check);
                    binding.ctvMostPopular.setTextColor(Color.parseColor("#2C32BE"));
                }
                break;

            case R.id.ctv_open_now:
                if (binding.ctvOpenNow.isChecked()) {
                    binding.ctvOpenNow.setChecked(false);
                    binding.ctvOpenNow.setCheckMarkDrawable(null);
                    binding.ctvOpenNow.setTextColor(Color.parseColor("#000000"));

                } else {
                    binding.ctvOpenNow.setChecked(true);
                    binding.ctvOpenNow.setCheckMarkDrawable(R.drawable.icons_check);
                    binding.ctvOpenNow.setTextColor(Color.parseColor("#2C32BE"));
                }
                break;

        }
    }
}