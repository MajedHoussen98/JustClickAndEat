package ps.ns.eatapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Signin extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.sign_up_tv)
    TextView signUpTv;
    @BindView(R.id.button)
    Button sign_in_btn;
    @BindView(R.id.forget_password_tv)
    TextView forgetPasswordTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        ButterKnife.bind(this);

        viewListener();

    }

    private void viewListener() {
        signUpTv.setOnClickListener(this);
        forgetPasswordTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_up_tv:
                startActivity(new Intent(Signin.this, SignUp.class));
                finish();
                break;
            case R.id.forget_password_tv:
                startActivity(new Intent(Signin.this, ForgetPassword.class));
                break;
        }
    }
}