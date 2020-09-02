package ps.ns.just_click_and_eat.feature.menu.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.databinding.ActivityMenuBinding;
import ps.ns.just_click_and_eat.feature.menu.presenter.MenuPresenter;
import ps.ns.just_click_and_eat.feature.menu.adapter.SectionsPagerAdapter;
import ps.ns.just_click_and_eat.utils.AppSharedMethod;
import ps.ns.just_click_and_eat.utils.BaseActivity;

import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_WHERE;

public class MenuActivity extends BaseActivity implements MenuView {

    private View view;
    private MenuPresenter presenter;
    private ActivityMenuBinding binding;
    private int restaurantId;

    public static Intent newInstance(Activity mActivity, int fromWhere) {
        Intent intent = new Intent(mActivity, MenuActivity.class);
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
        initViews();
        viewListener();

    }

    private void initViews() {
        presenter = new MenuPresenter(this, this);
        restaurantId = getIntent().getExtras().getInt("restaurant_id");
    }

    private void viewListener() {
        presenter.getMenuList(restaurantId);
        binding.ibBack.setOnClickListener(v -> presenter.goToRestaurantDetails(restaurantId));
    }

}