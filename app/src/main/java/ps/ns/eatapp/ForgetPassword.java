package ps.ns.eatapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ForgetPassword extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.back_icon)
    ImageView backIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        ButterKnife.bind(this);

        viewListener();

    }

    private void viewListener(){
        backIcon.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.back_icon){
            startActivity(new Intent(ForgetPassword.this, Signin.class));
        }
    }
}