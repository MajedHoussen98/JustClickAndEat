package ps.ns.eatapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import ps.ns.eatapp.R;
import ps.ns.eatapp.databinding.ActivitySigninBinding;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    private View view;
    private ActivitySigninBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySigninBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        setContentView(view);
        viewListener();

    }

    private void viewListener() {
        binding.tvSignUp.setOnClickListener(this);
        binding.tvForgetPassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_sign_up:
                startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
                finish();
                break;
            case R.id.tv_forget_password:
                startActivity(new Intent(SignInActivity.this, ForgetPasswordActivity.class));
                break;
        }
    }
}