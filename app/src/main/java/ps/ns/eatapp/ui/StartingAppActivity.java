package ps.ns.eatapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import ps.ns.eatapp.MainActivity;
import ps.ns.eatapp.R;
import ps.ns.eatapp.adapter.StartingAdapter;
import ps.ns.eatapp.databinding.ActivityStartingAppBinding;
import ps.ns.eatapp.model.StartingData;

public class StartingAppActivity extends AppCompatActivity implements View.OnClickListener {

    private View view;
    private ActivityStartingAppBinding binding;

//    @BindView(R.id.start_btn)
//    Button getStarted;
//    @BindView(R.id.recyclerStarted)
//    RecyclerView recyclerView;
//    @BindView(R.id.sign_in_btn)
//    Button signIN_btn;
    private StartingAdapter adapter;
    private ArrayList<StartingData> data = new ArrayList<>();
    private RecyclerView.LayoutManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStartingAppBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        setContentView(view);
        viewListener();

        data.add(new StartingData(R.drawable.group1, "Select food items", "When you order Eatstreet, we'll" +"\n"+
                " hook you up with exclusive " +"\n"+
                "coupons, specials and rewards.", R.drawable.group01));

        data.add(new StartingData(R.drawable.group2, "Enter your address", "We make it simple to find the " +"\n"+
                "food you crave. Enter your " +"\n"+
                "address and let us do the rest.", R.drawable.group02));

        data.add(new StartingData(R.drawable.group3, "Delivery to your home", "We make food ordering" +"\n"+
                "fast, simple - no matter if" +"\n"+
                "you order online .", R.drawable.group03));

        manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        binding.rvStartingApp.setLayoutManager(new LinearLayoutManager(this));
        binding.rvStartingApp.setLayoutManager(manager);
        adapter = new StartingAdapter(this, data);
        binding.rvStartingApp.setAdapter(adapter);

    }

    private void viewListener() {
        binding.btnSignIn.setOnClickListener(this);
        binding.btnGetStarted.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_get_started) {
            startActivity(new Intent(StartingAppActivity.this, MainActivity.class));
            finish();
        }else if (v.getId() == R.id.btn_sign_in){
            startActivity(new Intent(StartingAppActivity.this, SignInActivity.class));
        }
    }
}