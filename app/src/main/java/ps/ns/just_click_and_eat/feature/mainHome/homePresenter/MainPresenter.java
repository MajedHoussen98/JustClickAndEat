package ps.ns.just_click_and_eat.feature.mainHome.homePresenter;

import android.app.Activity;
import android.content.Intent;

import ps.ns.just_click_and_eat.feature.login.view.LoginActivity;
import ps.ns.just_click_and_eat.feature.mainHome.view.HomeView;
import ps.ns.just_click_and_eat.network.asp.feature.NetworkShared;
import ps.ns.just_click_and_eat.network.utils.RequestListener;
import ps.ns.just_click_and_eat.utils.AppSharedData;

public class MainPresenter {

    private HomeView mView;
    private Activity mActivity;

    public MainPresenter(HomeView mView, Activity mActivity) {
        this.mView = mView;
        this.mActivity = mActivity;
    }

    public void logout(String token){
        mView.showProgress();
        NetworkShared.getAsp().getUser().logout(token, new RequestListener<Integer>() {
            @Override
            public void onSuccess(Integer data) {
                mView.hideProgress();
                mActivity.startActivity(new Intent(mActivity, LoginActivity.class));
                mActivity.finish();
                AppSharedData.setUserLogin(false);
            }

            @Override
            public void onFail(String message, int code) {
                mView.hideProgress();
                mView.showMessage(message);
            }
        });
    }
}
