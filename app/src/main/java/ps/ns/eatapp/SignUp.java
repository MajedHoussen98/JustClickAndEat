package ps.ns.eatapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.sign_up_btn)
    Button signUpBtn;
    @BindView(R.id.back_sign_in)
    TextView backSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);

        viewListener();
    }

    private void viewListener() {
        signUpBtn.setOnClickListener(this);
        backSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.sign_up_btn) {
            startActivity(new Intent(SignUp.this, VerificationCode.class));
            finish();
        }else if (v.getId() == R.id.back_sign_in){
            startActivity(new Intent(SignUp.this, Signin.class));
        }
    }
}