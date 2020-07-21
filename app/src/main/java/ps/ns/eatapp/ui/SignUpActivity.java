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
import ps.ns.eatapp.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private View view;
    private ActivitySignUpBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.bind(getCurrentFocus());
        view = binding.getRoot();
        setContentView(view);
        viewListener();
    }

    private void viewListener() {
        binding.btnSignUp.setOnClickListener(this);
        binding.tvBackSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_sign_up) {
            startActivity(new Intent(SignUpActivity.this, VerificationCodeActivity.class));
            finish();
        }else if (v.getId() == R.id.tv_back_sign_in){
            startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
        }
    }
}