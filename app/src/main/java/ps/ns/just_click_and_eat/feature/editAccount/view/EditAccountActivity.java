package ps.ns.just_click_and_eat.feature.editAccount.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import de.hdodenhof.circleimageview.CircleImageView;
import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.databinding.ActivityEditAccountBinding;
import ps.ns.just_click_and_eat.feature.editAccount.presenter.EditAccountPresenter;
import ps.ns.just_click_and_eat.feature.signUp.view.SignUpActivity;
import ps.ns.just_click_and_eat.utils.AppSharedMethod;
import ps.ns.just_click_and_eat.utils.AppSharedData;
import ps.ns.just_click_and_eat.utils.BaseActivity;

import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_WHERE;

public class EditAccountActivity extends BaseActivity implements EditAccountView {

    private ActivityEditAccountBinding binding;
    private EditAccountPresenter presenter;
    private int REQUEST_IMAGE = 100;

    public static Intent newInstance(Activity mActivity, int fromWhere) {
        Intent intent = new Intent(mActivity, EditAccountActivity.class);
        intent.putExtra(FROM_WHERE, fromWhere);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditAccountBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initViews();
        initPresenter();
        initListener();
        imageClicked();
        AppSharedMethod.statusBarLight(this);

    }

    @SuppressLint("CheckResult")
    private void initViews() {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.useravatar);
//        Glide.with(this).load(AppSharedData.getProfileDataUser(EditAccountActivity.this).getString("profile_image", "profile_image")).into(binding.ivUser);
        Glide.with(this).load(AppSharedData.getProfileUser()).into(binding.ivUser);
        binding.etName.setText(AppSharedData.getUserInfo().getUserData().getName());
    }


    private void initPresenter() {
        presenter = new EditAccountPresenter(this, this);
    }

    private void initListener() {
        //binding.ivUser.setOnClickListener(v -> presenter.selectImage());
      //  binding.bntSave.setOnClickListener(v -> presenter.validationInput(String.valueOf(binding.ivUser), binding.etName));
        binding.ibBack.setOnClickListener(v -> presenter.goToMyAccount());
    }

    private void imageClicked() {
        binding.ivUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT)
                        .setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "Select Image"), REQUEST_IMAGE);
            }
        });

    }

    private static final String TAG = "EditAccountActivity";
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE && resultCode == RESULT_OK) {
            if (data.getData() ==null){
                return;
            }
            Uri uri = data.getData();
            binding.ivUser.setImageURI(uri);

            Log.d(TAG, "onActivityResult: "+uri.getPath());
          //  presenter.selectImageToUpland(uri, auth , name);
        }else{

        }
    }
}