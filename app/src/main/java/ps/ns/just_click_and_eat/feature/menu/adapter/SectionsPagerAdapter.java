package ps.ns.just_click_and_eat.feature.menu.adapter;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

import ps.ns.just_click_and_eat.feature.menu.presenter.MenuPresenter;
import ps.ns.just_click_and_eat.feature.menu.view.MealsMenu;
import ps.ns.just_click_and_eat.network.asp.model.menu.Menu;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    MenuPresenter presenter = new MenuPresenter();
    private ArrayList<Menu> data;

    public SectionsPagerAdapter(Context context, FragmentManager fm, ArrayList<Menu> data) {
        super(fm);
        this.data = data;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new MealsMenu();
        Bundle bundle = new Bundle();
        bundle.putInt("id" , data.get(position).getId());
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return data.get(position).getName();
    }

    @Override
    public int getCount() {
        return data.size();
    }
}