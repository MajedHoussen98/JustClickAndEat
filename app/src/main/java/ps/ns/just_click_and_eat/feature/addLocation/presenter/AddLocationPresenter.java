package ps.ns.just_click_and_eat.feature.addLocation.presenter;

import android.app.Activity;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.collection.ArrayMap;

import java.util.ArrayList;

import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.feature.addLocation.view.AddLocationView;
import ps.ns.just_click_and_eat.feature.maps.view.MapsActivity;
import ps.ns.just_click_and_eat.feature.myLocation.view.MyLocationActivity;
import ps.ns.just_click_and_eat.network.asp.feature.NetworkShared;
import ps.ns.just_click_and_eat.network.asp.model.MyLocation;
import ps.ns.just_click_and_eat.network.utils.RequestListener;
import ps.ns.just_click_and_eat.utils.AppSharedData;
import ps.ns.just_click_and_eat.utils.AppSharedMethod;

import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_MY_LOCATION;
import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_Maps;

public class AddLocationPresenter {

    private AddLocationView mView;
    private Activity mActivity;

    public AddLocationPresenter(AddLocationView mView, Activity mActivity) {
        this.mView = mView;
        this.mActivity = mActivity;
    }

    public void goToMyLocation() {
        mActivity.startActivity(MyLocationActivity.newInstance(mActivity, FROM_MY_LOCATION));
        mActivity.finish();
    }

    public void goToMap() {
        mActivity.startActivity(MapsActivity.newInstance(mActivity, FROM_Maps));
    }

    public void validationInputs(EditText etAddressName) {

        if (AppSharedMethod.isEmptyEditText(etAddressName)) {
            AppSharedMethod.setErrorEditText(etAddressName, mActivity.getString(R.string.enter_address));
            return;
        }

        ArrayMap<String, Object> params = new ArrayMap<>();
        params.put("title", AppSharedMethod.getTextFromEditText(etAddressName));
        params.put("address", "Test");
        params.put("lat", AppSharedData.getLocation());
        Log.e("lat", AppSharedData.getLocation()+"");
        params.put("long", 34.4621056);
        params.put("is_default", 0);

        saveAddressRequest(AppSharedData.getUserInfo().getTokenData().getAccessToken(), params);
    }

    private void saveAddressRequest(String token, ArrayMap<String, Object> params) {
        NetworkShared.getAsp().getUser().addLocation(token, params, new RequestListener<ArrayList<MyLocation>>() {
            @Override
            public void onSuccess(ArrayList<MyLocation> data) {
                Toast.makeText(mActivity, "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFail(String message, int code) {
                Log.e("fail", message);
            }
        });
    }


}