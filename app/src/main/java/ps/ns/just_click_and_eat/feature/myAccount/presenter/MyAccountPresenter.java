package ps.ns.just_click_and_eat.feature.myAccount.presenter;


import android.app.Activity;

import ps.ns.just_click_and_eat.feature.editAccount.view.EditAccountActivity;
import ps.ns.just_click_and_eat.feature.editPassword.view.EditPasswordActivity;
import ps.ns.just_click_and_eat.feature.favorites.Favorites;
import ps.ns.just_click_and_eat.feature.mainHome.view.MainActivity;
import ps.ns.just_click_and_eat.feature.myAccount.view.MyAccountView;
import ps.ns.just_click_and_eat.feature.myLocation.view.MyLocationActivity;
import ps.ns.just_click_and_eat.feature.signUp.view.SignUpActivity;

import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_CHANGE_PASSWORD;
import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_EDIT_ACCOUNT;
import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_FAVORITES;
import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_HOME;
import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_LOCATION;
import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_LOGIN;
import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_WHERE;

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
        mActivity.startActivity(MyLocationActivity.newInstance(mActivity, FROM_LOCATION));
    }

    public void goToFavorites() {
        mActivity.startActivity(Favorites.newInstance(mActivity, FROM_FAVORITES));
    }

    public void goToHome() {
        mActivity.startActivity(MainActivity.newInstance(mActivity, FROM_HOME));
    }
}
