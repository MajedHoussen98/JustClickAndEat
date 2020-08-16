package ps.ns.just_click_and_eat.feature.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.databinding.ActivityMenuBinding;
import ps.ns.just_click_and_eat.feature.resturentDetails.view.ResturentDetailsActivity;
import ps.ns.just_click_and_eat.feature.menu.ui.main.SectionsPagerAdapter;
import ps.ns.just_click_and_eat.utils.AppSharedMethod;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    private View view;
    private ActivityMenuBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        setContentView(view);
        AppSharedMethod.statusBarLight(this);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        viewListener();

    }

    private void viewListener() {
        binding.ibBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_back:
                startActivity(new Intent(MenuActivity.this, ResturentDetailsActivity.class));
                finish();
                break;
        }
    }
}