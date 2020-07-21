package ps.ns.eatapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ps.ns.eatapp.R;
import ps.ns.eatapp.databinding.ActivityEditPasswordBinding;

public class EditPasswordActivity extends AppCompatActivity implements View.OnClickListener {
    private View view;
    private ActivityEditPasswordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditPasswordBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        setContentView(view);

        listenerViews();
    }

    private void listenerViews() {
        binding.ibBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_back:
                startActivity(new Intent(EditPasswordActivity.this, MyAccountActivity.class));
                finish();
                break;
        }
    }
}