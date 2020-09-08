package ps.ns.just_click_and_eat.feature.mainHome.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;

import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.databinding.ActivityMainBinding;
import ps.ns.just_click_and_eat.feature.favorites.Favorites;
import ps.ns.just_click_and_eat.feature.login.view.LoginActivity;
import ps.ns.just_click_and_eat.feature.mainHome.homePresenter.MainPresenter;
import ps.ns.just_click_and_eat.feature.myAccount.view.MyAccountActivity;
import ps.ns.just_click_and_eat.feature.myCart.view.MyCartActivity;
import ps.ns.just_click_and_eat.feature.myLocation.view.MyLocationActivity;
import ps.ns.just_click_and_eat.feature.notification.view.NotificationActivity;
import ps.ns.just_click_and_eat.feature.myOrder.view.MyOrderActivity;
import ps.ns.just_click_and_eat.utils.AppSharedData;
import ps.ns.just_click_and_eat.utils.BaseActivity;

import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_WHERE;

public class MainActivity extends BaseActivity implements HomeView {

    public static Intent newInstance(Activity mActivity, int fromWhere) {
        Intent intent = new Intent(mActivity, MainActivity.class);
        intent.putExtra(FROM_WHERE, fromWhere);
        return intent;
    }

    private MainPresenter presenter;
    private HomeView view;

    private ImageView userImage;
    private TextView userName, userEmail;
    private ImageView iconsMenu;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private NavController navController;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ps.ns.just_click_and_eat.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initViews();
        initListeners();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadHeaderData();
    }

    private void initViews() {
        presenter = new MainPresenter(this, this);
        navigationView = findViewById(R.id.nav_view);
        View header = navigationView.getHeaderView(0);
        userImage = header.findViewById(R.id.iv_user);
        userEmail = header.findViewById(R.id.tv_user_email);
        userName = header.findViewById(R.id.tv_user_name);
        iconsMenu = findViewById(R.id.icons_menu);
        drawer = findViewById(R.id.drawer_layout);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navigationView, navController);
        loadHeaderData();
    }

    @SuppressLint("RtlHardcoded")
    private void initListeners() {

        iconsMenu.setOnClickListener(v -> drawer.openDrawer(Gravity.LEFT));

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("RtlHardcoded")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.nav_home) {
                    navController.navigate(R.id.nav_home);

                } else if (item.getItemId() == R.id.nav_cart) {
                    startActivity(new Intent(MainActivity.this, MyCartActivity.class));
                    finish();

                } else if (item.getItemId() == R.id.nav_account) {
                    startActivity(new Intent(MainActivity.this, MyAccountActivity.class));
                    finish();

                } else if (item.getItemId() == R.id.nav_order) {
                    startActivity(new Intent(MainActivity.this, MyOrderActivity.class));
                    finish();

                } else if (item.getItemId() == R.id.nav_location) {
                    startActivity(new Intent(MainActivity.this, MyLocationActivity.class));
                    finish();

                } else if (item.getItemId() == R.id.nav_notification) {
                    startActivity(new Intent(MainActivity.this, NotificationActivity.class));
                    finish();

                } else if (item.getItemId() == R.id.nav_favorites) {
                    startActivity(new Intent(MainActivity.this, Favorites.class));
                    finish();

                } else if (item.getItemId() == R.id.nav_log_out) {
                    if (AppSharedData.isUserLogin()) {
                        presenter.logout(AppSharedData.getUserInfo().getTokenData().getAccessToken());
                    } else {
                        startActivity(new Intent(MainActivity.this, LoginActivity.class));
                        finish();
                    }
                }
                drawer.closeDrawer(Gravity.LEFT);
                return true;
            }
        });
    }


    @Override
    public void showMessage(String msg) {
        super.showMessage(msg);
        snackErrorShow(this.navigationView, msg);
    }

    @SuppressLint("CheckResult")
    private void loadHeaderData() {


//        Glide.with(this).load(AppSharedData.getUserInfo().getUserData().getPhotoThumb()).into(userImage);

        if (AppSharedData.isUserLogin()) {
            userName.setText(AppSharedData.getUserInfo().getUserData().getName());
            userEmail.setText(AppSharedData.getUserInfo().getUserData().getEmail());
            Glide.with(this).load(AppSharedData.getUserInfo().getUserData().getPhotoThumb()).placeholder(R.drawable.useravatar).into(userImage);


        } else {
            userName.setText(R.string.default_name);
            userEmail.setText(R.string.default_email);
            userImage.setImageResource(R.drawable.useravatar);
        }

//        Log.e("emailH", AppSharedData.getUserEmail().getEmail());
    }

}