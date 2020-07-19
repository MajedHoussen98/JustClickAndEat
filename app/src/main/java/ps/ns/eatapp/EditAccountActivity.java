package ps.ns.eatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ps.ns.eatapp.databinding.ActivityEditAccountBinding;
import ps.ns.eatapp.ui.account.MyAccount;

public class EditAccountActivity extends AppCompatActivity {

    private ActivityEditAccountBinding binding;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditAccountBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        setContentView(view);
        clickListener();

    }

    private void clickListener() {
        binding.ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*startActivity(new Intent(EditAccountActivity.this, MyAccount.class));
                finish();*/
            }
        });

    }
}