package ps.ns.just_click_and_eat.feature.addLocation.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.databinding.ActivityAddLocationBinding;
import ps.ns.just_click_and_eat.feature.myLocation.view.MyLocationActivity;
import ps.ns.just_click_and_eat.utils.AppSharedMethod;

import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_WHERE;

public class AddLocationActivity extends AppCompatActivity implements View.OnClickListener{

    private View view;
    private ActivityAddLocationBinding binding;

    public static Intent newInstance(Activity mActivity, int fromWhere) {
        Intent intent = new Intent(mActivity, AddLocationActivity.class);
        intent.putExtra(FROM_WHERE, fromWhere);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddLocationBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        setContentView(view);
        listenerViews();
        AppSharedMethod.statusBarLight(this);

    }

    private void listenerViews() {
        binding.ibBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_back:
                startActivity(new Intent(AddLocationActivity.this, MyLocationActivity.class));
                finish();
                break;
        }
    }
}