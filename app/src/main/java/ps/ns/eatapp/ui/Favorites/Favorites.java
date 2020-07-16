package ps.ns.eatapp.ui.Favorites;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import ps.ns.eatapp.MainActivity;
import ps.ns.eatapp.R;
import ps.ns.eatapp.ui.Favorites.ui.main.SectionsPagerAdapter;
import ps.ns.eatapp.ui.home.HomeFragment;

public class Favorites extends AppCompatActivity implements View.OnClickListener{

    ImageView bac_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        initView();
        listView();

    }
    private void initView(){
        bac_home = findViewById(R.id.bac_home);
    }

    private void listView(){
        bac_home.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bac_home){
            startActivity(new Intent(Favorites.this, MainActivity.class));
            finish();
        }
    }
}