package ps.ns.eatapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import ps.ns.eatapp.MainActivity;
import ps.ns.eatapp.R;
import ps.ns.eatapp.adapter.MyCartAdapter;
import ps.ns.eatapp.databinding.ActivityMyCartBinding;
import ps.ns.eatapp.dialogs.MyCartNextDialog;
import ps.ns.eatapp.model.MyCartModel;

public class MyCartActivity extends AppCompatActivity implements MyCartAdapter.ListItemClickListener, View.OnClickListener {

    private View view;
    private ActivityMyCartBinding binding;
    private MyCartAdapter adapter;
    private ArrayList<MyCartModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyCartBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        setContentView(view);

        initViews();
        listenerViews();
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
        list.add(new MyCartModel("R.drawable.meal2", "Braised Fish Head", "2x tuna sahimi, 3x vegetables ", "$4.90", 2));
        list.add(new MyCartModel("R.drawable.meal3", "Salad Fritters", "2x tuna sahimi, 3x vegetables ", "$15.00", 1));
        list.add(new MyCartModel("R.drawable.meal3", "Salad Fritters", "2x tuna sahimi, 3x vegetables ", "$15.00", 1));

        binding.rvCart.setLayoutManager(new LinearLayoutManager(MyCartActivity.this));
        adapter = new MyCartAdapter(MyCartActivity.this, list, MyCartActivity.this);
        adapter.setShowHide(false);
        binding.rvCart.setAdapter(adapter);
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

        // MyCartNextDialog dialog = new MyCartNextDialog();
        //dialog.show(getParentFragmentManager(), "SSSS");
        startActivity(new Intent(MyCartActivity.this, MyCartNextDialog.class));
    }


}