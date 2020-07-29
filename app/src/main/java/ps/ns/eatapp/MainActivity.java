package ps.ns.eatapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ps.ns.eatapp.databinding.ActivityMainBinding;
import ps.ns.eatapp.ui.Favorites.Favorites;
import ps.ns.eatapp.ui.HomeFragment;
import ps.ns.eatapp.ui.MyAccountActivity;
import ps.ns.eatapp.ui.MyCartActivity;
import ps.ns.eatapp.ui.MyLocationActivity;
import ps.ns.eatapp.ui.NotificationActivity;
import ps.ns.eatapp.ui.MyOrderActivity;

import static ps.ns.eatapp.utils.ConstantApp.FROM_WHERE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static Intent newInstance(Activity mActivity, int fromWhere) {
        Intent intent = new Intent(mActivity, MainActivity.class);
        intent.putExtra(FROM_WHERE, fromWhere);
        return intent;
    }

    private ActivityMainBinding binding;

    private ImageView iconsMenu;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        initViews();
        initListeners();

    }

    private void initViews() {
        iconsMenu = findViewById(R.id.icons_menu);
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navigationView, navController);
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
                    startActivity(new Intent(MainActivity.this, MyCartActivity.class));

                } else if (item.getItemId() == R.id.nav_account) {
                    startActivity(new Intent(MainActivity.this, MyAccountActivity.class));

                } else if (item.getItemId() == R.id.nav_order) {
                    startActivity(new Intent(MainActivity.this, MyOrderActivity.class));

                } else if (item.getItemId() == R.id.nav_location) {
                    startActivity(new Intent(MainActivity.this, MyLocationActivity.class));

                } else if (item.getItemId() == R.id.nav_notification) {
                    startActivity(new Intent(MainActivity.this, NotificationActivity.class));

                } else if (item.getItemId() == R.id.nav_favorites) {
                    startActivity(new Intent(MainActivity.this, Favorites.class));
                }
                drawer.closeDrawer(Gravity.LEFT);
                return true;
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.icons_menu) {
            drawer.openDrawer(Gravity.LEFT);
        }
    }
}