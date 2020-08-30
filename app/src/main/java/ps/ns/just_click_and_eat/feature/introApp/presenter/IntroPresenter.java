package ps.ns.just_click_and_eat.feature.introApp.presenter;

import android.app.Activity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

import java.util.ArrayList;

import ps.ns.just_click_and_eat.feature.introApp.adapter.IntroAdapter;
import ps.ns.just_click_and_eat.feature.introApp.view.IntroView;
import ps.ns.just_click_and_eat.feature.login.view.LoginActivity;
import ps.ns.just_click_and_eat.feature.mainHome.view.MainActivity;
import ps.ns.just_click_and_eat.network.asp.feature.NetworkShared;
import ps.ns.just_click_and_eat.network.asp.model.IntroApp;
import ps.ns.just_click_and_eat.network.utils.RequestListener;

import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_HOME;
import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_LOGIN;

public class IntroPresenter {

    private IntroView mView;
    private Activity mActivity;

    public IntroPresenter(IntroView mView, Activity mActivity) {
        this.mView = mView;
        this.mActivity = mActivity;
    }

    public void goToHome() {
        mActivity.startActivity(MainActivity.newInstance(mActivity, FROM_HOME));
        mActivity.finish();
    }

    public void goToLogin() {
        mActivity.startActivity(LoginActivity.newInstance(mActivity, FROM_LOGIN));
    }

    public void getAppIntro(ViewPager viewPager, SpringDotsIndicator springDotsIndicator) {
        NetworkShared.getAsp().getGeneral().getAppInfo(new RequestListener<ArrayList<IntroApp>>() {
            @Override
            public void onSuccess(ArrayList<IntroApp> data) {
                IntroAdapter adapter = new IntroAdapter(mActivity, data);
                viewPager.setAdapter(adapter);
                springDotsIndicator.setViewPager(viewPager);
            }

            @Override
            public void onFail(String message, int code) {

            }
        });
    }
}
