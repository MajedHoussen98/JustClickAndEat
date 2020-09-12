package ps.ns.just_click_and_eat.feature.myCart.view;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import ps.ns.just_click_and_eat.feature.mainHome.view.MainActivity;
import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.feature.myCart.adapter.MyCartAdapter;
import ps.ns.just_click_and_eat.databinding.ActivityMyCartBinding;
import ps.ns.just_click_and_eat.feature.cartDialogFragment.view.CartDialogFragment;
import ps.ns.just_click_and_eat.dataBase.MyCartModel;
import ps.ns.just_click_and_eat.utils.AppSharedMethod;

public class MyCartActivity extends AppCompatActivity implements MyCartAdapter.ListItemClickListener, View.OnClickListener {

    private View view;
    private ActivityMyCartBinding binding;
    private MyCartAdapter adapter;
    private ArrayList<MyCartModel> list;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyCartBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        setContentView(view);
        initViews();
        listenerViews();
        AppSharedMethod.statusBarLight(this);
    }

    private void initViews() {
        list = new ArrayList<>();
        getDataMyCart();
    }

    private void listenerViews() {
        binding.btnNext.setOnClickListener(this);
        binding.ibBack.setOnClickListener(this);
    }

    private void getDataMyCart() {
        list.add(new MyCartModel("https://www.samaa.tv/wp-content/uploads/2017/09/meals.jpg", "Braised Fish Head", "2x tuna sahimi, 3x vegetables ", "4", "1"));
        list.add(new MyCartModel("https://www.samaa.tv/wp-content/uploads/2017/09/meals.jpg", "Salad Fritters", "2x tuna sahimi, 3x vegetables ", "15", "1"));
        list.add(new MyCartModel("https://www.samaa.tv/wp-content/uploads/2017/09/meals.jpg", "Salad Fritters", "2x tuna sahimi, 3x vegetables ", "15", "1"));
        list.add(new MyCartModel("https://www.samaa.tv/wp-content/uploads/2017/09/meals.jpg", "Salad Fritters", "2x tuna sahimi, 3x vegetables ", "20", "1"));
        binding.rvCart.setLayoutManager(new LinearLayoutManager(MyCartActivity.this));
        adapter = new MyCartAdapter(MyCartActivity.this, list, MyCartActivity.this);
        adapter.setShowHide(false);
        binding.rvCart.setAdapter(adapter);
        binding.tvPriceOrder.setText(String.valueOf(adapter.totalPrice(list) + " $"));
    }


    @Override
    public void onListItemClicked(int position, int viewId) {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                openDialog();
                break;
            case R.id.ib_back:
                startActivity(new Intent(MyCartActivity.this, MainActivity.class));
                finish();
                break;
        }
    }

    private void openDialog() {
        CartDialogFragment dialog = new CartDialogFragment();
        dialog.show(getSupportFragmentManager(), "CartDialog");
    }


}