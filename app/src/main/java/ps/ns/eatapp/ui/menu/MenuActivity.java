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
import ps.ns.eatapp.ResturentDetails;
import ps.ns.eatapp.ui.menu.ui.main.SectionsPagerAdapter;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.ib_back)
    ImageView bacHome;
    @BindView(R.id.editTextSearchMenu)
    EditText editTextSearchMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        viewListener();

    }

    private void viewListener() {
        bacHome.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bac_home:
                startActivity(new Intent(MenuActivity.this, ResturentDetails.class));
                finish();
                break;
        }
    }
}