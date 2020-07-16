package ps.ns.eatapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.icons_menu)
    ImageView iconsMenu;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private NavController navController;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navigationView, navController);

        initListeners();
    }

    private void initListeners() {
        iconsMenu.setOnClickListener(this);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("RtlHardcoded")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.nav_home) {
                    navController.navigate(R.id.nav_home);

                } else if (item.getItemId() == R.id.nav_cart) {
                    navController.navigate(R.id.nav_cart);

                }else if (item.getItemId() == R.id.nav_account){
                    navController.navigate(R.id.nav_account);

                }else if (item.getItemId() == R.id.nav_order){
                    navController.navigate(R.id.nav_order);

                }else if (item.getItemId() == R.id.nav_location){
                    navController.navigate(R.id.nav_location);

                }else if (item.getItemId() == R.id.nav_notification){
                    navController.navigate(R.id.nav_notification);

                }else if (item.getItemId() == R.id.nav_favorites){
                    navController.navigate(R.id.nav_favorites);
                }
                drawer.closeDrawer(Gravity.LEFT);
                return true;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.icons_menu:
                drawer.openDrawer(Gravity.LEFT);
                break;
        }
    }
}