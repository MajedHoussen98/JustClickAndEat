package ps.ns.just_click_and_eat.feature.addLocation.presenter;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.EditText;
import android.widget.RadioGroup;
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

    public void goToMap(int LAUNCH_MAPS_ACTIVITY, String details) {
        Intent i = new Intent(mActivity, MapsActivity.class);
        i.putExtra("details", details);
        mActivity.startActivityForResult(i, LAUNCH_MAPS_ACTIVITY);
    }


    public void validationInputs(EditText etAddressName, String details, Double lat, Double log, int makeDefault) {
        if (AppSharedMethod.isEmptyEditText(etAddressName)) {
            AppSharedMethod.setErrorEditText(etAddressName, mActivity.getString(R.string.enter_address));
            return;
        }
        Log.e("det", details + "");
        ArrayMap<String, Object> params = new ArrayMap<>();
        params.put("title", AppSharedMethod.getTextFromEditText(etAddressName));
        params.put("address", details);
        params.put("lat", lat);
        params.put("long", log);
        params.put("is_default", makeDefault);

        saveAddressRequest(AppSharedData.getUserInfo().getTokenData().getAccessToken(), params);
    }

    private void saveAddressRequest(String token, ArrayMap<String, Object> params) {
        mView.showProgress();
        NetworkShared.getAsp().getLocation().addLocation(token, params, new RequestListener<ArrayList<MyLocation>>() {
            @Override
            public void onSuccess(ArrayList<MyLocation> data) {
                mView.hideProgress();
                mActivity.startActivity(new Intent(mActivity, MyLocationActivity.class));
                Toast.makeText(mActivity, "The location is added", Toast.LENGTH_SHORT).show();
                mActivity.finish();
            }

            @Override
            public void onFail(String message, int code) {
                Log.e("fail", message);
            }
        });
    }


    public void deleteLocation(String token, int id) {
        mView.showProgress();
        NetworkShared.getAsp().getLocation().removeLocation(token, id, new RequestListener<ArrayList<MyLocation>>() {
            @Override
            public void onSuccess(ArrayList<MyLocation> data) {
                mView.hideProgress();
                mActivity.startActivity(new Intent(mActivity, MyLocationActivity.class));
                Toast.makeText(mActivity, "The Location is Deleted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFail(String message, int code) {

            }
        });
    }


}