package ps.ns.just_click_and_eat.feature.menu.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.databinding.ActivityMenuBinding;
import ps.ns.just_click_and_eat.feature.mealsDetails.view.MealsDetailsActivity;
import ps.ns.just_click_and_eat.feature.menu.adapter.MenuAdapter;
import ps.ns.just_click_and_eat.feature.menu.presenter.MenuPresenter;
import ps.ns.just_click_and_eat.feature.menu.adapter.SectionsPagerAdapter;
import ps.ns.just_click_and_eat.network.asp.model.meals.Meals;
import ps.ns.just_click_and_eat.network.asp.model.menu.Menu;
import ps.ns.just_click_and_eat.utils.AppSharedMethod;
import ps.ns.just_click_and_eat.utils.BaseActivity;

import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_WHERE;

public class MenuActivity extends BaseActivity implements MenuView, MenuPresenter.Listener, MenuAdapter.ListItemClickListener {

    private MenuPresenter presenter;
    private ActivityMenuBinding binding;
    private int restaurantId;
    private RecyclerView recyclerView;

    public static Intent newInstance(Activity mActivity, int fromWhere) {
        Intent intent = new Intent(mActivity, MenuActivity.class);
        intent.putExtra(FROM_WHERE, fromWhere);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        AppSharedMethod.statusBarLight(this);
        initViews();
        viewListener();

    }

    private void initViews() {
        presenter = new MenuPresenter(this, this, this);
        recyclerView = findViewById(R.id.rv_meals_menu);
        restaurantId = Objects.requireNonNull(getIntent().getExtras()).getInt("restaurant_id");
    }

    private void viewListener() {
        presenter.getMenuList(restaurantId);
        binding.ibBack.setOnClickListener(v -> presenter.goToRestaurantDetails(restaurantId));
        binding.etSearchMenu.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!String.valueOf(s).isEmpty()) {
                    binding.viewPager.setVisibility(View.GONE);
                    binding.rvMealsSearch.setVisibility(View.VISIBLE);
                    presenter.searchMeals(String.valueOf(s), restaurantId, binding.rvMealsSearch);
                } else {
                    binding.rvMealsSearch.setVisibility(View.GONE);
                    binding.viewPager.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    @Override
    public void onMenuFetched(ArrayList<Menu> data) {
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager(), data);
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
    }

    @Override
    public void onListItemClicked(int position, int viewId, List<Meals> list) {
        if (viewId == R.id.ll_menu) {
            int id = list.get(position).getId();
            int re_id = list.get(position).getMenu().getRstId();
            int code = 1;
            String image = list.get(position).getImageUrl();
            String name = list.get(position).getName();
            String description = list.get(position).getDesc();

            Intent intent = new Intent(this, MealsDetailsActivity.class);
            intent.putExtra("image", image);
            intent.putExtra("meal_id", id);
            intent.putExtra("CODE", code);
            intent.putExtra("restaurant_id", re_id);
            intent.putExtra("name", name);
            intent.putExtra("description", description);
            startActivity(intent);
            finish();
        }
    }
}