package ps.ns.just_click_and_eat.feature.myAccount.presenter;


import android.app.Activity;
import android.content.Intent;

import ps.ns.just_click_and_eat.feature.editAccount.view.EditAccountActivity;
import ps.ns.just_click_and_eat.feature.editPassword.view.EditPasswordActivity;
import ps.ns.just_click_and_eat.feature.favorites.Favorites;
import ps.ns.just_click_and_eat.feature.mainHome.view.MainActivity;
import ps.ns.just_click_and_eat.feature.myAccount.view.MyAccountView;
import ps.ns.just_click_and_eat.feature.myLocation.view.MyLocationActivity;

import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_CHANGE_PASSWORD;
import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_EDIT_ACCOUNT;
import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_FAVORITES;
import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_HOME;
import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_LOCATION;

public class MyAccountPresenter {

    private MyAccountView mView;
    private Activity mActivity;

    public MyAccountPresenter(MyAccountView mView, Activity mActivity) {
        this.mView = mView;
        this.mActivity = mActivity;
    }

    public void goToEditAccount() {

        mActivity.startActivity(EditAccountActivity.newInstance(mActivity, FROM_EDIT_ACCOUNT));
    }

    public void goToChangePassword() {
        mActivity.startActivity(EditPasswordActivity.newInstance(mActivity, FROM_CHANGE_PASSWORD));
    }

    public void goToAddress() {
        Intent intent = new Intent(mActivity, MyLocationActivity.class);
        intent.putExtra("CODE", 1);
        mActivity.startActivity(intent);    }

    public void goToFavorites() {
        Intent intent = new Intent(mActivity, Favorites.class);
        intent.putExtra("CODE", 1);
        mActivity.startActivity(intent);
    }

    public void goToHome() {
        mActivity.startActivity(MainActivity.newInstance(mActivity, FROM_HOME));
    }

}
