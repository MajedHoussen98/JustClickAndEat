package ps.ns.just_click_and_eat.feature.myCart.view;

import androidx.annotation.RequiresApi;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import ps.ns.just_click_and_eat.feature.myCart.adapter.MyCartAdapter;
import ps.ns.just_click_and_eat.databinding.ActivityMyCartBinding;
import ps.ns.just_click_and_eat.feature.cartDialogFragment.view.CartDialogFragment;
import ps.ns.just_click_and_eat.feature.myCart.presenter.MyCartPresenter;
import ps.ns.just_click_and_eat.network.asp.model.cart.CartModel;
import ps.ns.just_click_and_eat.utils.AppSharedData;
import ps.ns.just_click_and_eat.utils.AppSharedMethod;
import ps.ns.just_click_and_eat.utils.BaseActivity;

public class MyCartActivity extends BaseActivity implements MyCartAdapter.ListItemClickListener, MyCartView {

    private ActivityMyCartBinding binding;
    private MyCartPresenter presenter;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyCartBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initViews();
        listenerViews();
        AppSharedMethod.statusBarLight(this);
    }

    private void initViews() {
        binding.progressBar.setVisibility(View.VISIBLE);
        presenter = new MyCartPresenter(this, this);
        presenter.getCart(AppSharedData.getUserInfo().getTokenData().getAccessToken(), binding.rvCart, binding.progressBar);
    }

    private void listenerViews() {
        binding.btnNext.setOnClickListener(v -> openDialog());
        binding.ibBack.setOnClickListener(v -> presenter.goToHome());
    }


    private void openDialog() {
        CartDialogFragment dialog = new CartDialogFragment();
        dialog.show(getSupportFragmentManager(), "CartDialog");
    }

    @Override
    public void onListItemClicked(int position, int viewId) {

    }

}