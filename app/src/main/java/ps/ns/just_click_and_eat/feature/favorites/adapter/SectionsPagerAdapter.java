package ps.ns.just_click_and_eat.feature.favorites.adapter;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import ps.ns.just_click_and_eat.feature.favorites.mealsFavorites.view.MealsFavorites;
import ps.ns.just_click_and_eat.feature.favorites.restaurantsFavorites.view.RestaurantsFavorites;


public class SectionsPagerAdapter extends FragmentPagerAdapter {


    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new MealsFavorites();
                break;
            case 1:
                fragment = new RestaurantsFavorites();
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                return "Meals";
            case 1:
                return "Restaurants";
        }
        return null;
    }

    @Override
    public int getCount() {

        return 2;
    }
}