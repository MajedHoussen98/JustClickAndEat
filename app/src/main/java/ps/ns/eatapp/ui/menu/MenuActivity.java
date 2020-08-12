package ps.ns.eatapp.ui.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import ps.ns.eatapp.R;
import ps.ns.eatapp.databinding.ActivityMenuBinding;
import ps.ns.eatapp.ui.ResturentDetailsActivity;
import ps.ns.eatapp.ui.menu.ui.main.SectionsPagerAdapter;
import ps.ns.eatapp.utils.AppSharedMethod;

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