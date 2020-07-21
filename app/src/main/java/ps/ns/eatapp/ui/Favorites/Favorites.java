package ps.ns.eatapp.ui.Favorites;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;

import ps.ns.eatapp.MainActivity;
import ps.ns.eatapp.R;
import ps.ns.eatapp.databinding.ActivityFavoritesBinding;
import ps.ns.eatapp.ui.Favorites.ui.main.SectionsPagerAdapter;

public class Favorites extends AppCompatActivity implements View.OnClickListener{
    private View view;
    private ActivityFavoritesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFavoritesBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        setContentView(view);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        listenerView();

    }


    private void listenerView(){
        binding.ibBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ib_back){
            startActivity(new Intent(Favorites.this, MainActivity.class));
            finish();
        }
    }
}