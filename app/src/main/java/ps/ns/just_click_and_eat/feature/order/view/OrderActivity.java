package ps.ns.just_click_and_eat.feature.order.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.feature.myCart.adapter.MyCartAdapter;
import ps.ns.just_click_and_eat.databinding.ActivityOrderBinding;
import ps.ns.just_click_and_eat.feature.mealsDetails.view.MealsDetailsActivity;
import ps.ns.just_click_and_eat.feature.myCart.view.MyCartActivity;
import ps.ns.just_click_and_eat.network.asp.model.cart.CartItem;
import ps.ns.just_click_and_eat.utils.AppSharedMethod;

public class OrderActivity extends AppCompatActivity implements MyCartAdapter.ListItemClickListener, View.OnClickListener {
    private ActivityOrderBinding binding;
    private MyCartAdapter adapter;
    private List<CartItem> list = new ArrayList<>();
    private View view;
    static boolean showHide;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        AppSharedMethod.statusBarLight(this);

        showHide = getIntent().getExtras().getBoolean("showHide");

        if (showHide){
            binding.llOrderStatus.setVisibility(View.VISIBLE);
          //  binding.btnOk.setVisibility(View.GONE);
        }else {
            binding.llOrderStatus.setVisibility(View.GONE);
            binding.btnOk.setVisibility(View.VISIBLE);

        }
        listenarViews();
        getCartData();
        setContentView(view);
    }

    private void getCartData() {

//        list.add(new MyCartModel("https://www.samaa.tv/wp-content/uploads/2017/09/meals.jpg", "Braised Fish Head", "2x tuna sahimi, 3x vegetables ", "$4.90", "1"));
//        list.add(new MyCartModel("https://www.samaa.tv/wp-content/uploads/2017/09/meals.jpg", "Salad Fritters", "2x tuna sahimi, 3x vegetables ", "$15.00", "1"));
//        list.add(new MyCartModel("https://www.samaa.tv/wp-content/uploads/2017/09/meals.jpg", "Salad Fritters", "2x tuna sahimi, 3x vegetables ", "$15.00", "1"));

        binding.rvOrderMeals.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new MyCartAdapter(getApplicationContext(), list, this);
        adapter.setShowHide(true);
        binding.rvOrderMeals.setAdapter(adapter);
    }

    private void listenarViews() {
        binding.btnOk.setOnClickListener(this);
        binding.ibBack.setOnClickListener(this);
    }

    @Override
    public void onListItemClicked(int position, int viewId) {
        switch (viewId) {
            case R.id.ll_cart_item:
                startActivity(new Intent(OrderActivity.this, MealsDetailsActivity.class));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_back:
                startActivity(new Intent(OrderActivity.this, MyCartActivity.class));
                finish();
                break;
        }
    }
}