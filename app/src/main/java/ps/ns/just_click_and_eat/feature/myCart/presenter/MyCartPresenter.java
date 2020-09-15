package ps.ns.just_click_and_eat.feature.myCart.presenter;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import ps.ns.just_click_and_eat.feature.mainHome.view.MainActivity;
import ps.ns.just_click_and_eat.feature.myCart.adapter.MyCartAdapter;
import ps.ns.just_click_and_eat.feature.myCart.view.MyCartView;
import ps.ns.just_click_and_eat.network.asp.feature.NetworkShared;
import ps.ns.just_click_and_eat.network.asp.model.cart.CartItem;
import ps.ns.just_click_and_eat.network.utils.RequestListener;

import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_HOME;

public class MyCartPresenter {

    private MyCartView mView;
    private Activity mActivity;

    public MyCartPresenter(MyCartView mView, Activity mActivity) {
        this.mView = mView;
        this.mActivity = mActivity;
    }

    public void goToHome(){
        mActivity.startActivity(MainActivity.newInstance(mActivity, FROM_HOME));
        mActivity.finish();
    }

    public void getCart(String token, RecyclerView recyclerView, ProgressBar progressBar){
        NetworkShared.getAsp().getCart().getCart(token, new RequestListener<ArrayList<CartItem>>() {
            @Override
            public void onSuccess(ArrayList<CartItem> data) {
                progressBar.setVisibility(View.GONE);
                MyCartAdapter adapter = new MyCartAdapter(mActivity, data, (MyCartAdapter.ListItemClickListener) mActivity);
                recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
                adapter.setShowHide(false);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFail(String message, int code) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(mActivity, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
