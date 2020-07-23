package ps.ns.eatapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import ps.ns.eatapp.R;
import ps.ns.eatapp.databinding.ActivityForgetPasswordBinding;

public class ForgetPasswordActivity extends AppCompatActivity implements View.OnClickListener {

    private View view;
    private ActivityForgetPasswordBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForgetPasswordBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        setContentView(view);

        viewListener();

    }

    private void viewListener(){
        binding.ivBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.iv_back){
            startActivity(new Intent(ForgetPasswordActivity.this, SignInActivity.class));
        }
    }
}