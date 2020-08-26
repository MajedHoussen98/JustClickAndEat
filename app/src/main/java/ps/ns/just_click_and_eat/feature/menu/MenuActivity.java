package ps.ns.just_click_and_eat.feature.menu;

import android.app.Activity;
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
import ps.ns.just_click_and_eat.feature.verfication.view.VerificationActivity;
import ps.ns.just_click_and_eat.utils.AppSharedMethod;

import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_WHERE;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    private View view;
    private ActivityMenuBinding binding;

    public static Intent newInstance(Activity mActivity, int fromWhere) {
        Intent intent = new Intent(mActivity, VerificationActivity.class);
        intent.putExtra(FROM_WHERE, fromWhere);
        return intent;
    }

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